/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import javax.swing.JOptionPane;

/**
 *
 * @author Uchiha Tobi
 */
class Client extends Thread implements Runnable {
    String name;
    Socket sock;
    boolean running;
    DataInputStream in;
    DataOutputStream out;
    Client me;
    String ip, clar;
    PrintWriter os, of;
    BufferedReader sc;
    public Client(Socket s) throws IOException {
        
        sock = s;
        ip = s.getInetAddress().getHostAddress();
        me = this;
        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
        os = new PrintWriter(out);
        sc = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        doRun();
    }
    void doRun()
    {
        running = true;
    }
    void stopRun()
    {
        running = false;
    }
    void handleInput(String input) throws IOException
    {
        System.out.println(input);
        if(input.equals("clar"))
        {
            try {
                StringBuffer sb = new StringBuffer();
                System.out.println("st");
                String tmp;
                while(sc.ready())
                    sb.append(sc.readLine());
                System.out.println("en");
                clar = sb.toString();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Pair<Client, String> p = new Pair(this, sock.getInetAddress().getHostAddress());
                        ResourceBundle rb = new ResourceBundle() {
                            @Override
                            protected Object handleGetObject(String key) {
                                return me;
                            }
                            
                            @Override
                            public Enumeration<String> getKeys() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        };
                        Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("JAnswerClar.fxml"), rb);
                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.setResizable(false);
                            stage.show();
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }else if(input.equals("file"))
        {
            
            
            try {
                String probId = sc.readLine();
              
         
                System.out.println(name);
                System.out.println(name + "_");
                System.out.println(name.length());
                String fname = (name.concat("_")).concat(probId);
                File f1 = new File(FileAcceptor.codeD + fname + ".cpp");
                if(f1.exists())f1.delete();
                File f = new File(FileAcceptor.codeD + fname + ".cpp");
                System.out.println("fname is " + fname);
                of = new PrintWriter(f);
                String ss;
                while(sc.ready())
                {
                    ss = sc.readLine();
                    of.println(ss);
                }
                of.close();
          
                
                System.out.println("written");
                Thread t2 = new Thread(new FileAcceptor(this , probId));
                t2.start();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(input.equals("reg"))
        {
            name = sc.readLine();
            System.out.println("Name is " + name);
            sendInfo();
        }
    }
  void sendInfo()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("info\n");
        sb.append(PC2Server.pNum);
        sb.append('\n');
        sb.append(PC2Server.hours);
        sb.append(":");
        sb.append(PC2Server.mins);
        sendMessage(sb.toString());
    }
    void sendAnswer(String ans)
    {
        ans = "ans\n".concat(ans);
        sendMessage(ans);
    }
    void sendVerdict(String verd)
    {
        verd = "verd\n".concat(verd);
        sendMessage(verd);
    }
    void sendMessage(String mes)
    {
        os.println(mes);
        os.flush();
    }
    @Override
    public void run() {
        System.out.println("Client listener");
       while(running)
       {
           
           try {
               while(in.available() == 0)
               {
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               
               
                handleInput(sc.readLine());
           } catch (IOException ex) {
               Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
