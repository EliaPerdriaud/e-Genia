/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;



/**
 *
 * @author etien
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        if (Bdd.coBdd() != null){// Si on résussit à se connecter à la base de données , on lance la fenetre de connexion
            ConnexionApp.main(args);
            
            
        }
    }
    
}
