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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SResponseSubmit implements Initializable {

    @FXML
    public Label tProblem;
    @FXML
    private Button bOk;
    @FXML
    public Label tResponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
         tProblem.setText((String)rb.getObject("n"));
         String verd = (String) rb.getObject("v");
         if(verd.equals("0"))
         {
             tResponse.setText("Compilation Error");
             tResponse.setTextFill(Color.YELLOW);
         }else if(verd.equals("1"))
         {
             tResponse.setText("ACCEPTED");
             tResponse.setTextFill(Color.LIME);
         }else if(verd.equals("2"))
         {
             tResponse.setText("Runtime error");
             tResponse.setTextFill(Color.ORANGE);
         }else if(verd.equals("3"))
         {
             tResponse.setText("Time limit Exceeded");
             tResponse.setTextFill(Color.BLUE);
         }else 
         {
             tResponse.setText("Wrong Answer");
             tResponse.setTextFill(Color.RED);
         }
    }    

    @FXML
    private void clickOk(ActionEvent event) {
         ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
