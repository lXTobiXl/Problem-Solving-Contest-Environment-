/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Uchiha Tobi
 */
public class MessageAcceptor implements Runnable {

 String mes, ip;
    public MessageAcceptor(String mess, String ipp) {
        ip = ipp;
      mes = mess; 
    }

    @Override
    public void run() {
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(MessageAcceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
