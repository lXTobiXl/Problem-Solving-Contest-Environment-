/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plagiarism;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author VGA!Sys
 */
public class PMain implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button bSubmit;
    @FXML
    private Font x2;
    @FXML
    private Button bBrowse;
    @FXML
    private Label lPath;

    @FXML
    private Button bExit;

    static JFileChooser chooser;
    static String codeDir;
    String choosertitle;
    static ArrayList<String> cheated, probablyCheated;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickStart(ActionEvent event) throws IOException {
        plagiarism.CheatDetector cd = new plagiarism.CheatDetector(codeDir);
        cd.start();
        cheated = cd.getCheated();
        /*System.out.println("chetaers are : ");
        for(int i = 0; i < cheated.size(); ++i)
            System.out.println(cheated.get(i));
         */

        probablyCheated = cd.getProblalyCheated();
        /*System.out.println("probably cheaters are : ");
        for(int i = 0; i < probablyCheated.size(); ++i)
            System.out.println(probablyCheated.get(i));
         */

        Parent root;
        root = FXMLLoader.load(getClass().getResource("PResult.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void clickBrowse(ActionEvent event) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            codeDir = chooser.getSelectedFile().getAbsolutePath();
            lPath.setText(codeDir);
        }

    }

    @FXML
    private void clickExit(ActionEvent event) {
        System.exit(0);
    }

}
