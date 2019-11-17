/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plagiarism;

import static Plagiarism.PMain.cheated;
import static Plagiarism.PMain.probablyCheated;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class PResult implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private Button bExit;
    @FXML
    private ListView<String> list1;
    @FXML
    private ListView<String> list2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(int i = 0; i < cheated.size(); ++i)
            list1.getItems().add(i, cheated.get(i));
        
        for(int i = 0; i < probablyCheated.size(); ++i)
            list2.getItems().add(i, probablyCheated.get(i));
        
        list1.setEditable(false);
        list2.setEditable(false);
        
    }    

    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }
    
}
