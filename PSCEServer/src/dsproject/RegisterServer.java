/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uchiha Tobi
 */
class RegisterServer extends Thread implements Runnable {
    ServerSocket ss;
    boolean running;
    public RegisterServer(int sid) throws IOException {
        ss = new ServerSocket(sid);
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
    @Override
    public void run() {
        try {
            Socket s = null;
            Client c = null;
            while(running)
            {
                s = ss.accept();
                c = new Client(s);
                PC2Server.ipToClient.put(s.getInetAddress().getHostAddress(), c);
                c.start();
            }

        } catch (Exception ex) {
            System.out.println("erorr");
        }
    }
    
}
