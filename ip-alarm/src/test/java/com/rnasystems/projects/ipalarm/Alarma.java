/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.ipalarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ext_synps03
 */
public class Alarma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//TLL=128
        Pattern pattern= Pattern.compile("[Tt][Tt][Ll]=\\d+");
        Matcher matcher = null;
        
        String cmd = "ping 10.10.10.10 -t";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader s = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String x = s.readLine();

            while (x != null) {
                System.out.println(x);
                matcher = pattern.matcher(x);
                if(matcher.find()){
                    p.destroy();
                    break;
                }
                x = s.readLine();
            }

          //Reproducir.playAudio(Alarma.class.getResource("/sounds/alarm.wav").getPath());
            
        } catch (IOException ex) {
            Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
