/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class JWait implements Initializable {
    @FXML
    private Button bStart;
    @FXML
    private Button bExit;
    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private Button bProblem;
    @FXML
    private TextField contestHour;
    @FXML
    private TextField contestMin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void clickStart(ActionEvent event) {
        try {
            PC2Server.hours = contestHour.getText() ;
            PC2Server.mins =  contestMin.getText(); 
            PC2Server.pNum = DBConProblems.countProblem();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("JMain.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
         catch (Exception e) {
            System.out.println("no one here");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void clickProblem(ActionEvent event){
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("JAddProblem.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println("no one here");
        }
    }
    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }
    
}
