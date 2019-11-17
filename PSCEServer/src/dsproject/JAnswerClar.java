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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class JAnswerClar implements Initializable {
    String ip;
    Client c;
    @FXML
    private Font x1;
    @FXML
    private TextArea aQuestion;
    @FXML
    private TextArea aAnswer;
    @FXML
    private Button bBroadcast;
    @FXML
    private Button bRespond;
    @FXML
    private Font x2;
    /**
     * Initializes the controller class.
     */
    public void setip(String ip)
    {
        this.ip = ip;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       c = (Client) rb.getObject("");
       aQuestion.setText(c.clar);
       ip = c.ip;
    }    


    @FXML
    private void clickBroadcast(ActionEvent event) throws IOException {
        PC2Server.BroadcastAnswer(aQuestion.getText(), aAnswer.getText());
    }

    @FXML
    private void clickRespond(ActionEvent event) throws IOException {
       c.sendAnswer(aAnswer.getText());
    }
    
}
