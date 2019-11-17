package JSPSide;
import java.sql.*;
import java.util.*;

abstract public class DBConnectionJSPSide {
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

    public static int getProblemsCount(){
        startConnection();
        String sql = "SELECT * FROM problemsCount";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            int ret = -1;
            // loop through the result set
            while (rs.next()) {
                ret = rs.getInt("problemsCount");
            }
            return ret;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public static ArrayList<Team> getAll(){
        startConnection();
        String sql = "SELECT * FROM submission";
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            HashMap<String, Team> hm = new HashMap<>();

            // loop through the result set
            while (rs.next()) {
                if(hm.containsKey(rs.getString("teamName"))){
                    hm.get(rs.getString("teamName")).addProblem(
                            rs.getString("problemId").charAt(0),
                            rs.getInt("status") == 1? true : false,
                            rs.getInt("time"));
                }else {
                    Team temp = new Team(rs.getString("teamName"));
                    temp.addProblem(
                            rs.getString("problemId").charAt(0),
                            rs.getInt("status") == 1? true : false,
                            rs.getInt("time"));
                    hm.put(rs.getString("teamName"), temp);
                }
            }
            ArrayList<Team> allTeams = new ArrayList<>();

            Set<Map.Entry<String, Team>> hshUni = hm.entrySet();
            Iterator<Map.Entry<String, Team>> HMIterator = hshUni.iterator();
            while (HMIterator.hasNext()) {
                Map.Entry<String, Team> entry = HMIterator.next();
                allTeams.add(entry.getValue());
            }
            return allTeams;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}