/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SConfirmSubmit implements Initializable {
    
    @FXML
    private Font x1;
    @FXML
    private Label tProblem;
    @FXML
    private Font x2;
    @FXML
    private Button bYes;
    @FXML
    private Button bNo;
    @FXML
    private Label tPath;
    @FXML
    private Font x3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tProblem.setText(SMain.probName);
        tPath.setText(SMain.codePath);
    }    

    @FXML
    private void clickYes(ActionEvent event) throws IOException {
        File fts = SMain.returnVal;
        DSProject.judge.sendFile(fts, tProblem.getText());
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void clickNo(ActionEvent event) {
         ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
