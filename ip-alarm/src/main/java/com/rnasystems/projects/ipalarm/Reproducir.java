/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.ipalarm;

/**
 *
 * @author ext_synps03
 */
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

import javax.swing.JApplet;

/**
 *
 * @author Richard Leon Ingaruca
 */
public class Reproducir {

    public static void playAudio(String pathFileSound) throws Exception {

        try {
            
            //archivo de audio
            File f = new File(pathFileSound);
            //Bueno de la AudioClip no se puede instancias por eso esto
            AudioClip sonido = JApplet.newAudioClip(new URL(pathFileSound));            
            //para que suene
            sonido.loop();
            //como el programa se ejecuta muy rapido el audio no se alcanza a escuchar
            Thread.currentThread().sleep(5000);
            //si fuese una ventana no fuese necesario esa linea
        } catch (Exception ex) {
            throw new Exception("Error when try to play sound["+pathFileSound+"]",ex);
        }

    }
}
