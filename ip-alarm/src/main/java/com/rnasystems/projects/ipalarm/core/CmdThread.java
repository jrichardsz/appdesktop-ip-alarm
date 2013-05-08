/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.ipalarm.core;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rnasystems.projects.ipalarm.Reproducir;
/**
 *
 * @author Richard Leon Ingaruca
 */
public class CmdThread extends Thread{

    
    @Override
    public void run(){
            
        //TLL=128
        Pattern pattern= Pattern.compile("[Tt][Tt][Ll]=\\d+");
        Matcher matcher = null;
        
        String cmd = "ping "+ip+" -t";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader s = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String x = s.readLine();

            while (x != null) {
                matcher = pattern.matcher(x);
                if(matcher.find()){
                    p.destroy();
                    break;
                }
                x = s.readLine();
            }
                   
          Reproducir.playAudio("alarm.wav");
            
        } catch (Exception e) {
        	throw new RuntimeException("Error when try to detect ip or play sound.",e);
		} 
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    private String ip = "";
    
    
}
