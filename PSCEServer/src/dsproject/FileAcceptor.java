/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import JudgeSide.JudgeInterfaceStanding;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uchiha Tobi
 */
public class FileAcceptor extends Thread{
    String pid;
    Client c;
    static String codeD, inD, outD, ansD;
    public FileAcceptor(Client c, String pi) {
        this.c = c;
        pid = pi;  
        System.out.println(codeD + '\n' + inD + '\n');
    }
    
    @Override
    public void run() {
        System.out.println("in run");
        submissionJudge j = new submissionJudge(codeD, inD, outD, ansD);
        int v = j.run(c.name + "_" + pid + ".cpp", pid + ".txt", c.name + "_" + pid + ".txt", 2000);
        if(v == 1)
        {
            try {
                if(j.compareTwoFiles(pid + ".txt", c.name + "_" + pid +".txt") == false)
                    v = 4;
            } catch (Exception ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        JudgeInterfaceStanding.addSubmission(c.name, System.currentTimeMillis(), pid.charAt(0), (v == 1));
        c.sendVerdict(pid + "\n" + Integer.toString(v));
    }
    
}
