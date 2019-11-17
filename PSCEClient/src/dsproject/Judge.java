/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//class prief and usage 
package dsproject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class Judge extends Thread{
    Socket s;
    DataInputStream in;
    DataOutputStream out;
    boolean running;
    String inj, inj2;
    PrintWriter os;
    Scanner scf;
    BufferedReader sc;
    Judge(String ip)
    {
        try {
            s = new Socket(ip, 4321);
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
            os = new PrintWriter(out);
            sc = new BufferedReader(new InputStreamReader(s.getInputStream()));
            register(DSProject.userName);
            doRun();
        } catch (IOException ex) {
            Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      void doRun()
    {
        running = true;
    }
    void stopRun()
    {
        running = false;
    }

    void handleInput(String input)
    {
        System.out.println(input);
        if(input.equals("ans"))
        {
            try {
                StringBuffer sb = new StringBuffer();
                System.out.println("st");
                while(sc.ready())
                    sb.append(sc.readLine());
                System.out.println("en");
                inj = sb.toString();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ResourceBundle rb = new ResourceBundle() {
                                @Override
                                protected Object handleGetObject(String key) {
                                    return inj;
                                }
                                
                                @Override
                                public Enumeration<String> getKeys() {
                                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                }
                            };
                            
                            Parent root = FXMLLoader.load(getClass().getResource("SResponseClar.fxml"), rb);
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                );
            } catch (IOException ex) {
                Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        }else if(input.equals("verd"))
        {
            try {
                inj = sc.readLine();
                inj2 = sc.readLine();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            
                            String vName = inj, v = inj2;
                            ResourceBundle rb = new ResourceBundle() {
                                @Override
                                protected Object handleGetObject(String key) {
                                    if (key == "n") {
                                        return  vName;
                                    }else if (key == "v")
                                        return v;
                                    else
                                        return null;
                                }
                                
                                @Override
                                public Enumeration<String> getKeys() {
                                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                }
                            };
                            Parent root = FXMLLoader.load(getClass().getResource("SResponseSubmit.fxml"), rb);
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else if(input.equals("info"))
        {
           
            try {
                DSProject.pNum = Integer.parseInt(sc.readLine());
                String mess[] = sc.readLine().split(":");
                DSProject.hours = mess[0];
                DSProject.mins = mess[1];
            } catch (IOException ex) {
                Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        void sendFile(File fts, String pid) throws FileNotFoundException, IOException
    {
        scf = new Scanner(fts);
        StringBuffer sb = new StringBuffer();
           while(scf.hasNext())
           {
               sb.append(scf.nextLine());
               sb.append("\n");
           }
           scf.close();
           sendFile(sb.toString(), pid);
    }
           void sendClar(String ans)
    {
        ans = "clar\n".concat(ans);
        sendMessage(ans);
    }
    void sendFile(String file, String pid)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("file\n");
        sb.append(pid+"\n");
        sb.append(file);
        sendMessage(sb.toString());
    }
      
    void register(String name)
    {
        String reg = "reg\n".concat(name);
        sendMessage(reg);
    }
    void sendMessage(String mes)
    {
        os.println(mes);
        os.flush();
    }
    @Override
    public void run()
    {
        while(running)
        {
            try {
                while(in.available() == 0)
                {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               System.out.println("receieed judge");
                handleInput(sc.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
