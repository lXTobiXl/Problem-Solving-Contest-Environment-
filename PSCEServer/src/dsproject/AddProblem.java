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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class AddProblem implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private TextField tTime;
    @FXML
    private TextArea tProblem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DBConProblems.startConnection();
    }

    @FXML
    private void clickAdd(ActionEvent event) {       
        int timelimit = Integer.parseInt(tTime.getText());
        String problem = tProblem.getText();
        try {
            DBConProblems.addProblem(timelimit, problem);
        } catch (Exception e) {
            System.out.println("problem in inserting");
        }
        
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("JAddConfirmation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println("no one here");
        }
        
        tTime.setText("");
        tProblem.setText("");
                
    }

    @FXML
    private void clickCancel(ActionEvent event) {
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("no one here");
        }
    }

}
