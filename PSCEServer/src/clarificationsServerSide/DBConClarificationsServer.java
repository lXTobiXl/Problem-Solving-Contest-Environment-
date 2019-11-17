package clarificationsServerSide;

import java.sql.*;

abstract public class DBConClarificationsServer {
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
        String sql = "DROP TABLE IF EXISTS clarifications;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table clarifications droped succefully");
        } catch (SQLException e) {
            System.out.println("table clarifications not drobed");
            System.out.println(e.getMessage());
        }
    }

    private static void createNewTable() {
        startConnection();
        prepareTable();
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS clarifications (\n"
                + " question text NOT NULL,\n"
                + " answer text NOT NULL\n"
                + ");";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table clarifications created succefully");
        } catch (SQLException e) {
            System.out.println("table clarifications not created");
            System.out.println(e.getMessage());
        }
    }

    public static void addClarification(String question, String answer) {
        startConnection();
        try {
            String sql = "INSERT INTO clarifications(question, answer) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, question);
            pstmt.setString(2, answer);

            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("failed to insert clarification");
            e.printStackTrace();
        }
    }

}

