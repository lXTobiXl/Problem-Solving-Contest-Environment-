/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import static dsproject.DSProject.judge;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.DSAGenParameterSpec;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SWait implements Initializable {

    @FXML
    private Button strtbtn;
    @FXML
    private TextField jtxt;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    


    @FXML
    private void connect(ActionEvent event) throws InterruptedException {
        try {
            DSProject.judgeIP = jtxt.getText();
            judge = new Judge(DSProject.judgeIP);
            judge.start();
            while(DSProject.pNum == 0)
            {
                Thread.sleep(1);
                System.out.println(DSProject.pNum);
            }
            
            Parent root;
            root = FXMLLoader.load(getClass().getResource("SMain.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            System.out.println(DSProject.judgeIP);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
           
            System.out.println("here " + DSProject.judgeIP);
        } catch (IOException ex) {
            Logger.getLogger(SWait.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void checkForConnection(MouseEvent event) {
    }

   
   


    
}
