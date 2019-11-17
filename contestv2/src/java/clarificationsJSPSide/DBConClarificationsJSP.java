package clarificationsJSPSide;
import java.sql.*;
import java.util.*;

abstract public class DBConClarificationsJSP {
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

    public static ArrayList<Clarification> getAllClarifications(){
        startConnection();
        String sql = "SELECT * FROM clarifications";
        ArrayList<Clarification> allClarifications = new ArrayList<>();
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            //delete HashMap<String, Team> hm = new HashMap<>();



            // loop through the result set
            while (rs.next()) {
                String q = rs.getString("question");
                String ans = rs.getString("answer");
                allClarifications.add(new Clarification(q, ans));
            }
            return allClarifications;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}