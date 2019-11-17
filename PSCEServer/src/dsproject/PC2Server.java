/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import clarificationsServerSide.DBConClarificationsServer;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Uchiha Tobi
 */
public class PC2Server extends Application {
    static HashMap<String, Client> ipToClient;
    static String hours, mins;
    static int pNum;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ipToClient = new HashMap<>();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FileAcceptor.ansD = "C:\\Users\\Uchiha Tobi\\Documents\\NetBeansProjects\\PSCEServer\\Answers\\"; 
                FileAcceptor.codeD = "C:\\Users\\Uchiha Tobi\\Documents\\NetBeansProjects\\PSCEServer\\Codes\\"; 
                FileAcceptor.inD = "C:\\Users\\Uchiha Tobi\\Documents\\NetBeansProjects\\PSCEServer\\Input\\"; 
                FileAcceptor.outD = "C:\\Users\\Uchiha Tobi\\Documents\\NetBeansProjects\\PSCEServer\\Output\\";
                DBConClarificationsServer.startConnection();
         System.out.println("asdas");
        System.out.println("5 " + InetAddress.getLocalHost().getHostAddress());
        System.out.println("hena");
        Parent root = FXMLLoader.load(getClass().getResource("JWait.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    static void BroadcastAnswer(String p, String ans)
    {
        for (Client x : ipToClient.values()) {
            x.sendAnswer("InProblem " + p + " : " + ans);
        }
        DBConClarificationsServer.addClarification(p, ans);
    }
    
}
