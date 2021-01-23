/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extend;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author iuliu
 */
public class ouvrirPDF {
    public static void ouvrirDocPdf(String chemin) {
        try {

        File pdfFile = new File(chemin);
        if (pdfFile.exists()) {

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Awt Desktop is not supported!");
            }

        } else {
            System.out.println("File is not exists!");
        }

        System.out.println("Done");

      } catch (Exception ex) {
        ex.printStackTrace();
      }
        
        
    } 
}
