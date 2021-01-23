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
public class Données {
    
    private final static String nomLogiciel = "e-GENIA";
    private final static String version = "1.2 (BETA) ";
    
    private final static int couleurPrincipale1 = 58;
    private final static int couleurPrincipale2 = 142;
    private final static int couleurPrincipale3 = 204;
   
    private final static int couleur2_1 = 58;
    private final static int couleur2_2 = 142;
    private final static int couleur2_3 = 204;
    
    private final static String url_Logo = "/Images/icon.png";

    
    
    // VARIABLES USER --> import BDD lors de la CO
    private static String UA_Identifiant;
    private static String DUA_Type;
    private static int DUA_FichierClient;
    private static int DUA_FichierArticle;
    private static int DUA_AchatVente;
    private static int DUA_Encaissement;
    private static int DUA_Admin;
    private static int DUA_Id;
    
    
    
    
   //get et set ::-----------------> 
    public static String getNomLogiciel() {
        return nomLogiciel;
    }
    public static String getVersion() {
        return version;
    }
    public static int getCouleurPrincipale1() {
        return couleurPrincipale1;
    }
    public static int getCouleurPrincipale2() {
        return couleurPrincipale2;
    }
    public static int getCouleurPrincipale3() {
        return couleurPrincipale3;
    }
    public static int getCouleur2_1() {
        return couleur2_1;
    }
    public static int getCouleur2_2() {
        return couleur2_2;
    }
    public static int getCouleur2_3() {
        return couleur2_3;
    }
     public static String getUrl_Logo() {
        return url_Logo;
    }
    
    
    
    
    
    // GET SET --> Vartiable User

    public static String getUA_Identifiant() {
        return UA_Identifiant;
    }
    public static void setUA_Identifiant(String UA_Identifiant) {
        Données.UA_Identifiant = UA_Identifiant;
    }
    public static String getDUA_Type() {
        return DUA_Type;
    }
    public static void setDUA_Type(String DUA_Type) {
        Données.DUA_Type = DUA_Type;
    }
    public static int getDUA_FichierClient() {
        return DUA_FichierClient;
    }
    public static void setDUA_FichierClient(int DUA_FichierClient) {
        Données.DUA_FichierClient = DUA_FichierClient;
    }
    public static int getDUA_FichierArticle() {
        return DUA_FichierArticle;
    }
    public static void setDUA_FichierArticle(int DUA_FichierArticle) {
        Données.DUA_FichierArticle = DUA_FichierArticle;
    }
    public static int getDUA_AchatVente() {
        return DUA_AchatVente;
    }
    public static void setDUA_AchatVente(int DUA_AchatVente) {
        Données.DUA_AchatVente = DUA_AchatVente;
    }
    public static int getDUA_Encaissement() {
        return DUA_Encaissement;
    }
    public static void setDUA_Encaissement(int DUA_Encaissement) {
        Données.DUA_Encaissement = DUA_Encaissement;
    }
    public static int getDUA_Admin() {
        return DUA_Admin;
    }
    public static void setDUA_Admin(int DUA_Admin) {
        Données.DUA_Admin = DUA_Admin;
    }

    public static int getDUA_Id() {
        return DUA_Id;
    }

    public static void setDUA_Id(int DUA_Id) {
        Données.DUA_Id = DUA_Id;
    }
    
    
    
    
}


