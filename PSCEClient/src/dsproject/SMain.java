/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class SMain implements Initializable {
    FileChooser chooser ;
    static File returnVal;
    static String probName, codePath;
    @FXML
    private Font x1;
    @FXML
    private Label tPath;
    @FXML
    private Button bBrowse;
    @FXML
    private Button bSubmit;
    @FXML
    private Button bExit;
    @FXML
    private ComboBox<String> tProblem;
    @FXML
    private TextArea aClar;
    @FXML
    private Button bSumbitClar;
    @FXML
    private ComboBox<String> tProblem2;
    @FXML
    private Font x2;
    @FXML
    private Label hourlbl;
    @FXML
    private Label minslbl;
    @FXML
    private Label hlbl;
    @FXML
    private Label mlbl;
    @FXML
    private Label namelbl;
    @FXML
    private Label namelbl1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namelbl.setText(DSProject.userName);
        namelbl1.setText(DSProject.userName);
                hourlbl.setText(DSProject.hours);
               minslbl.setText(DSProject.mins);
               hlbl.setText(DSProject.hours);
               mlbl.setText(DSProject.mins);
               String items[] = new String [DSProject.pNum];
            for (int i = 0; i < DSProject.pNum; i++) {
                items[i] = "" + (char)(i + 65);
            }
            ObservableList<String> list = FXCollections.observableArrayList(items);
            tProblem.setItems(list);
            tProblem2.setItems(list);
/*               ObservableList<String> obs = new ObservableList<String>() {
                    
                };
               for (int i = 0; i < DSProject.pNum; i++) {
                   char t[] = new char[1];
                   t[0] = (char)((int)'A' + i);
               obs.add(t.toString());
               }
               tProblem.setItems(obs);*/
    }    

    @FXML
    private void clickBrowse(ActionEvent event) {
        chooser = new FileChooser();
        ExtensionFilter filter = new ExtensionFilter(
                "C++ Source File", "cpp");
        chooser.setSelectedExtensionFilter(filter);
        returnVal = chooser.showOpenDialog(null);
        if(returnVal != null) {
            tPath.setText(returnVal.getAbsolutePath());
//chooser.getSelectedFile().getName();
        }
    }

    @FXML
    private void clickSubmit(ActionEvent event) throws IOException {
        probName = tProblem.getSelectionModel().getSelectedItem().toString();
        codePath = tPath.getText();
            Parent root;
        root = FXMLLoader.load(getClass().getResource("SConfirmSubmit.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void selectTab1(Event event) {
    }

    @FXML
    private void closeTab1(Event event) {
    }


    @FXML
    private void clickSubmitClar(ActionEvent event) throws IOException {
        DSProject.judge.sendClar("in problem " + tProblem2.getSelectionModel().getSelectedItem().toString() + "  : " + aClar.getText());
    }

    @FXML
    private void selectTab3(Event event) {
    
    }

    @FXML
    private void closeTab3(Event event) {
    }
    
}
