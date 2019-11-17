package JudgeSide;

import java.sql.*;

abstract public class DBConnectionJudgeSide {
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
        String sql = "DROP TABLE IF EXISTS submission;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table submission droped succefully");
        } catch (SQLException e) {
            System.out.println("table submission not drobed");
            System.out.println(e.getMessage());
        }
    }
    private static void createNewTable() {
        startConnection();
        prepareTable();
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS submission (\n"
                + " teamName text NOT NULL,\n"
                + " time integer NOT NULL,\n"
                + " problemId text NOT NULL,\n"
                + " status integer NOT NULL\n"
                + ");";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table submission created succefully");
        } catch (SQLException e) {
            System.out.println("table submission not created");
            System.out.println(e.getMessage());
        }
    }
    public static void createTableForNumberOfProblems(int pc) {
        startConnection();
        String sql = "DROP TABLE IF EXISTS problemsCount;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table problems count droped succefully");
        } catch (SQLException e) {
            System.out.println("table problemsCount not drobed");
            System.out.println(e.getMessage());
        }
        // SQL statement for creating a new table
        sql = "CREATE TABLE IF NOT EXISTS problemsCount (\n"
                + " problemsCount integer NOT NULL\n"
                + ");";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("table problemsCount created succefully");
        } catch (SQLException e) {
            System.out.println("table problemsCount not created");
            System.out.println(e.getMessage());
        }
        try {
            sql = "INSERT INTO problemsCount(problemsCount) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pc);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("failed to insert problems Count");
            e.printStackTrace();
        }
    }

    public static void addSubmission(String teamName, long time, char problemId, boolean status) {
        startConnection();
        try {
            String sql = "INSERT INTO submission(teamName, time, problemId, status) VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teamName);
            pstmt.setLong(2, time);
            pstmt.setString(3,"" + problemId);
            pstmt.setInt(4, status ? 1 : 0);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("failed to insert submission");
            e.printStackTrace();
        }
    }

    public static void showAll(){
        startConnection();
        //this method for testing if inserting working correctly

        String sql = "SELECT * FROM submission";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("teamName") +  "\t" +
                        rs.getInt("time") + "\t" +
                        rs.getString("problemId") + "\t" +
                        rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

