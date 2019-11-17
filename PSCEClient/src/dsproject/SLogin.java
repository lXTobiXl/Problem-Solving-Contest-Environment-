/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SLogin implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField tUsername;
    @FXML
    private Button bLogin;
    @FXML
    private Button bExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void clickLogin(ActionEvent event) throws IOException{
        Parent root = null;
  if(tUsername.getText().length() > 0){
        DSProject.userName= tUsername.getText();
        root = FXMLLoader.load(getClass().getResource("SWait.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
        }
       
    }

    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }
    
}
