/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.sql.*;

abstract public class DBConProblems {
    
    static Connection conn;
    public static void startConnection(){
        if(conn != null)
            return;

        String url = "jdbc:mysql://localhost/standings";
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
            createNewTable();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("there is an error in connection");
            System.out.println(e.getMessage());
        }

    }

    public static void prepareTable(){
        startConnection();
        // SQL statement for creating a new table
        String sql = "DROP TABLE IF EXISTS problems;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table problems droped succefully");
        } catch (SQLException e) {
            System.out.println("table problems not drobed");
            System.out.println(e.getMessage());
        }
    }


    private static void createNewTable() {
        startConnection();
        prepareTable();
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS problems (\n"
                + " timelimit integer NOT NULL,\n"
                + " problem text NOT NULL\n"
                + ");";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table problems created succefully");
        } catch (SQLException e) {
            System.out.println("table problems not created");
            System.out.println(e.getMessage());
        }
    }

    public static void addProblem(int timelimit, String problem) {
        startConnection();
        try {
            String sql = "INSERT INTO problems(timelimit, problem) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, timelimit);
            pstmt.setString(2, problem);

            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("failed to insert problem");
            e.printStackTrace();
        }
                
    }
    
    public static int countProblem(){
        int count = 0;
        startConnection();
        try {
            String sql = "SELECT COUNT(*) AS total FROM problems";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count = rs.getInt("total");
            }
            
        }catch(SQLException ex){
            System.out.println("error counting");
        }
        return count;
    }
}

