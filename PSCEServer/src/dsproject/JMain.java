/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import JudgeSide.JudgeInterfaceStanding;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class JMain implements Initializable {
    @FXML
    private TextArea tMessage;
    @FXML
    private ComboBox<String> tProblem;
    @FXML
    private Font x1;
    @FXML
    private Font x11;
    @FXML
    private Label hourlbl;
    @FXML
    private Label minslbl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            JudgeInterfaceStanding.initStanding(PC2Server.pNum, System.currentTimeMillis());
            String items[] = new String [PC2Server.pNum];
            for (int i = 0; i < PC2Server.pNum; i++) {
                items[i] = "" + (char)(i + 65);
            }
            ObservableList<String> list = FXCollections.observableArrayList(items);
            tProblem.setItems(list);
            hourlbl.setText(PC2Server.hours);
            minslbl.setText(PC2Server.mins);
            RegisterServer rs = new RegisterServer(4321);
            rs.start();
        } catch (IOException ex) {
            Logger.getLogger(JMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


    @FXML
    private void clickSubmit(ActionEvent event) throws IOException {
        PC2Server.BroadcastAnswer(tProblem.getSelectionModel().getSelectedItem().toString(), tMessage.getText());
    }

    @FXML
    private void tProblem(ActionEvent event) {
    }

    
}
