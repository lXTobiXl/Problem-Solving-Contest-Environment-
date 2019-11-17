/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author VGA!Sys
 */
public class DSProject extends Application {
    static String judgeIP, userName; 
    static Judge judge;
    static int pNum;
    static String hours, mins; 
    Label lh, lm;
    @Override
    public void start(Stage stage) {
        hours = "sad";
        mins = "we rab el 3ebad";
           judgeIP = "192.168.1.2";
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        } catch (IOException ex) {
            System.out.println("oops");
        }
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        judgeIP = null;

        
        launch(args);
    }
    
}
