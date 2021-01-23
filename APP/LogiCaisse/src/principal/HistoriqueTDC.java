/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author etien
 */
public class HistoriqueTDC extends javax.swing.JFrame {
    
    String idtdc;
    String date;
    String heure;
    String client;
    String prixttc;
    DefaultTableModel tableModel;
    JTable table;
    
     private static Connection conn = Bdd.coBdd(); //Instanciation de la variable de connexion à la base de données

    private static int NbColonneTclient = 6;
    private static Object[][] TDC = new Object[50][NbColonneTclient]; //afichage que des 50 dernier TDC
    private static String [] nomColClient = { "Numéro TDC", "Client", "Date", "Heure", "Utilisateur", "Montant"};
    
    private static int idTDC = 0;
    private JPanel page = new JPanel(new FlowLayout());
    /**
     * Creates new form HistoriqueTDC
     */
    public HistoriqueTDC() {
        initComponents();
        URL iconURL = getClass().getResource(Données.getUrl_Logo());
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NomLogiciel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Données.getNomLogiciel() + " | Historique Tickets de caisse ");
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(Données.getCouleurPrincipale1(), Données.getCouleurPrincipale2(), Données.getCouleurPrincipale3()));

        NomLogiciel.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        NomLogiciel.setForeground(new java.awt.Color(255, 255, 255));
        NomLogiciel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NomLogiciel.setText(Données.getNomLogiciel());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NomLogiciel, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NomLogiciel)
                .addContainerGap())
        );

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            TDC,
            nomColClient) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            boolean[] canEdit = new boolean [] {
                false,false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(130, 244, 15));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Duplicata");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Recherche Avancée");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jScrollPane1)
                    .addGap(17, 17, 17)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1765, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(905, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(950, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String idClientSelect_s = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString(); // 1 pour idClient
        idTDC = Integer.parseInt(idClientSelect_s);
        System.err.println(idTDC);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        page.removeAll();
        tableModel=null;
        table=null;
        idtdc=null;
        date=null;
        heure=null;
        client=null;
        prixttc=null;
        
        String sql;
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("Code barres");//0
        tableModel.addColumn("Nom Article");//1
        tableModel.addColumn("Quantité");//2
        tableModel.addColumn("Prix");//3
        tableModel.addColumn("Réduction %");//4
        tableModel.addColumn("Total ligne");//5
        
        
        idtdc= jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
        date = jTable1.getValueAt(jTable1.getSelectedRow(),2).toString();
        heure = jTable1.getValueAt(jTable1.getSelectedRow(),3).toString();
        client = jTable1.getValueAt(jTable1.getSelectedRow(),1).toString();
        prixttc = jTable1.getValueAt(jTable1.getSelectedRow(),5).toString();
        
        sql="select Article_idArticle from LigneTDC where TicketDeCaisse_idTicketDeCaisse = ?";

        try (PreparedStatement state = conn.prepareStatement(sql)) {
            state.setString(1, idtdc);
            ResultSet listeIdsArticles = state.executeQuery();
            int i=0;
            while (listeIdsArticles.next()) {
                sql="select A_Designation,A_EAN,A_PrixDeVente from Article where idArticle = ?";
                PreparedStatement state2 = conn.prepareStatement(sql);
                state2.setString(1, listeIdsArticles.getString("Article_idArticle"));
                ResultSet resultArticle = state2.executeQuery();
                resultArticle.next();
                String nomArticle = resultArticle.getString("A_Designation");
                String codeBarresArticle = resultArticle.getString("A_EAN");
                String prixVenteArticle = resultArticle.getString("A_PrixDeVente");
                
                sql="select LTDC_Quantite, LTDC_RemiseLigne from LigneTDC where TicketDeCaisse_idTicketDeCaisse = ? and Article_idArticle = ?";
                PreparedStatement state3 = conn.prepareStatement(sql);
                state3.setString(1, idtdc);
                state3.setString(2, listeIdsArticles.getString("Article_idArticle"));
                ResultSet resultQteArticle = state3.executeQuery();
                resultQteArticle.next();
                String qteArticle = resultQteArticle.getString("LTDC_Quantite");
                String reducArticle = resultQteArticle.getString("LTDC_RemiseLigne");
                
                double totalligne = Double.valueOf(qteArticle) * Double.valueOf(prixVenteArticle) * (1-Double.valueOf(reducArticle));
             
                tableModel.insertRow(i,new Object[]{codeBarresArticle,nomArticle,qteArticle,prixVenteArticle,reducArticle,totalligne});
                i++;
            }
  
        } catch (SQLException ex) {
             Logger.getLogger(HistoriqueTDC.class.getName()).log(Level.SEVERE, null, ex);
         }

        

        page.setSize(1703, 2420);
        page.setVisible(true);
        page.setBackground(new java.awt.Color(255, 255, 255));

        JLabel label = new JLabel("Ticket de caisse n°"+idtdc, SwingConstants.CENTER);
        label.setFont (label.getFont ().deriveFont (36.0f));
        label.setVisible(true);
        label.setSize(1703, 50);
        label.setLocation(15, 47);
        
        JLabel label2 = new JLabel("Client : "+client, SwingConstants.CENTER);
        label2.setFont (label.getFont ().deriveFont (36.0f));
        label2.setVisible(true);
        label2.setSize(1703, 50);
        label2.setLocation(15, 100);

        JLabel label3 = new JLabel("Date : "+date, SwingConstants.CENTER);
        label3.setFont (label.getFont ().deriveFont (36.0f));
        label3.setVisible(true);
        label3.setSize(1703, 50);
        label3.setLocation(15, 150);
        
        JLabel label4 = new JLabel("Prix TTC : "+prixttc, SwingConstants.CENTER);
        label4.setFont (label.getFont ().deriveFont (36.0f));
        label4.setVisible(true);
        label4.setSize(1703, 50);
        label4.setLocation(15, 210);
        String MDP="";
        sql = "select MDP_Type from MoyenDePaiment join TicketDeCaisse on  MoyenDePaiment.idMoyenDePaiment=TicketDeCaisse.MoyenDePaiment_idMoyenDePaiment where idTicketDeCaisse = ?";
        try(PreparedStatement state5 = conn.prepareStatement(sql)) {
                state5.setString(1, idtdc);
                ResultSet resultMDP = state5.executeQuery();
                resultMDP.next();
                 MDP= "Moyen de paiement : "+resultMDP;
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueTDC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JLabel label5 = new JLabel(MDP, SwingConstants.CENTER);
        label5.setFont (label.getFont ().deriveFont (36.0f));
        label5.setVisible(true);
        label5.setSize(1703, 50);
        label5.setLocation(15, 270);
                
        JLabel logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_recap.png")));
        logo.setVisible(true);
        logo.setSize(274, 164);
        logo.setLocation(20, 20);
        logo.setFont(logo.getFont().deriveFont(36.0f));
        
        
        table.setLocation(50, 520);
        table.setFont(new Font("Arial", Font.PLAIN, 24));
        table.setSize(2000,2120);
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(new java.awt.Color(190, 190, 190));
        

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0; i<6; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(i).setWidth(320);
        }
        table.setRowHeight(60);

        table.getColumnModel().getColumn(2).setMaxWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setMaxWidth(200);
        table.getColumnModel().getColumn(3).setMinWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setMaxWidth(200);
        table.getColumnModel().getColumn(4).setMinWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setMaxWidth(350);
        table.getColumnModel().getColumn(5).setMinWidth(350);
        table.getColumnModel().getColumn(5).setPreferredWidth(350);

        page.add(table);
        
        JTableHeader header = table.getTableHeader();
        header.setLocation(50, 400);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setSize(2000,110);
        
        page.add(header);

        
        page.add(logo);
        page.add(label);
        page.add(label2);
        page.add(label3);
        page.add(label4);
            
            
        Paper p = new Paper();
        p.setSize(8.25 * 72, 11.75 * 72);
        p.setImageableArea(0, 0, 8.25 * 72, 11.75 * 72);
        PageFormat pf = new PageFormat();
        pf.setPaper(p);
        PDFDocument pdfDoc = new PDFDocument();
        // Create page
        PDFPage pagePDF = pdfDoc.createPage(pf);

        // Add page to document
        pdfDoc.addPage(pagePDF);
        // get graphics object from the page
        Graphics2D g2d = pagePDF.createGraphics();
        g2d.scale(0.35, 0.35);
        // myComponent being a JComponent showing on the screen
        page.print(g2d);


        File outFile = new File("temp/histoticketdecaisse.pdf");

        // save document
        try {
            pdfDoc.saveDocument(outFile.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Etiquettes.class.getName()).log(Level.SEVERE, null, ex);
        };
        extend.ouvrirPDF.ouvrirDocPdf("temp/histoticketdecaisse.pdf");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    if(Données.getDUA_Encaissement() == 1){ //Verifie si l'utilisateur qui s'est connecté a les droits sur l'encaissement
            recupTDC();
            
            try {
                UIManager.setLookAndFeel( new FlatLightLaf() );
            } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HistoriqueTDC().setVisible(true);
                }
            });
        }else{
            ViolationDroit.main(null);
        }
    }
    
    private static void recupTDC(){
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT idTicketDeCaisse, TDC_Date, TDC_Heure, Client.C_Nom, Client.C_Prenom, UserApp.UA_Identifiant FROM TicketDeCaisse JOIN Client ON TicketDeCaisse.Client_idClient = Client.idClient JOIN UserApp ON TicketDeCaisse.UserApp_iduser_app = UserApp.iduser_app ORDER BY idTicketDeCaisse DESC LIMIT 50");
            
            int i = 0;
            while(result.next()){
                int j=0;
                TDC[i][j++] = result.getInt("idTicketDeCaisse");
                TDC[i][j++] = result.getString("Client.C_Nom") +" "+ result.getString("Client.C_Prenom");
                TDC[i][j++] = result.getString("TDC_Date");
                TDC[i][j++] = result.getString("TDC_Heure");
                TDC[i][j++] = result.getString("UserApp.UA_Identifiant");
                
                try {
                    String sql = "SELECT LigneTDC.LTDC_Quantite, LigneTDC.LTDC_RemiseLigne, Article.A_PrixDeVente FROM LigneTDC JOIN Article ON LigneTDC.Article_idArticle = Article.idArticle WHERE LigneTDC.TicketDeCaisse_idTicketDeCaisse = ?";
                        PreparedStatement TotalTDC = conn.prepareStatement(sql);
                        TotalTDC.setInt(1, result.getInt("idTicketDeCaisse"));
                        ResultSet result2 = TotalTDC.executeQuery();
                        
                        double MontantTotalTDC = 0.0;
                        
                        while(result2.next()){
                            MontantTotalTDC += (result2.getDouble("Article.A_PrixDeVente") - (result2.getDouble("Article.A_PrixDeVente") * (result2.getDouble("LigneTDC.LTDC_RemiseLigne")/100)))* result2.getDouble("LigneTDC.LTDC_Quantite");
                        }
                        
                        TDC[i][j++] = MontantTotalTDC;
                        
                        TotalTDC.execute();
                        TotalTDC.close();
                } catch (CommunicationsException e) {
                    Bdd.lostCO(e);
                } catch (SQLException ex) {
                    Logger.getLogger(ConnexionApp.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            
            result.close();
            state.close();
        } catch (CommunicationsException e) {
            Bdd.lostCO(e);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private static void setJlabel(JLabel label, int offsetx, int offsety,float fontSize, JPanel container){      
        label.setVisible(true);
        label.setSize(1000, 50);
        label.setLocation(offsetx, offsety);
        label.setFont(label.getFont().deriveFont(fontSize));
        container.add(label);
        container.revalidate();
        container.repaint();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NomLogiciel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
