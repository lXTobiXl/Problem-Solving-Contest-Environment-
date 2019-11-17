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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SResponseClar implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button bOk;
    @FXML
    private TextArea aAnswer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       aAnswer.setText((String) rb.getObject("m"));
    }    

    @FXML
    private void clickOk(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
