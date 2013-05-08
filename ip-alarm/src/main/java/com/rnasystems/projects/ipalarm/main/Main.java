package com.rnasystems.projects.ipalarm.main;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import com.linet.api.swing.lookandfeel.WindowUtilities;
import com.rnasystems.projects.ipalarm.view.JFramePrincipal;

public class Main {

	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					WindowUtilities.setNativeLookAndFeel();
					new JFramePrincipal().setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
					StringWriter errors = new StringWriter();
					ex.printStackTrace(new PrintWriter(errors));
					JOptionPane.showMessageDialog(null, "Error when launch app.\n"+errors.toString());
					System.exit(0);
				}
                
            }
        });
    }

}
