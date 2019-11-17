/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

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
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class AddConfirmation implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Label bText;
    @FXML
    private Button bOk;
    @FXML
    private Font x2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bText.setText("There are " + DBConProblems.countProblem()+ " Problems inserted");
    }    

    @FXML
    private void clickOk(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("no one here");
        }
    }
    
}
