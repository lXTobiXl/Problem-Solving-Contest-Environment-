package problemsJSPSide;

import java.sql.*;
import java.util.*;

abstract public class DBConProblemsJSP {
    static Connection conn;
    public static void startConnection(){
        if(conn != null)
            return;

        String url = "jdbc:mysql://localhost/standings";
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("there is an error in connection");
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Problem> getAllProblems(){
        startConnection();
        String sql = "SELECT * FROM problems";
        ArrayList<Problem> allProblems = new ArrayList<>();
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                int t = rs.getInt("timelimit");
                String p = rs.getString("problem");
                allProblems.add(new Problem(t, p));
            }
            return allProblems;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}