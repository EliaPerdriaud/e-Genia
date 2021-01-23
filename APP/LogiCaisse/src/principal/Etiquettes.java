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
import extend.UserListCellRenderer;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;

/**
 *
 * @author etien
 */
public class Etiquettes extends javax.swing.JFrame {

    private static Connection conn = Bdd.coBdd(); //Instanciation de la variable de connexion à la base de données

    private static int NbColoneTArticle = 7;
    private static Object[][] Article = new Object[countArticle()][NbColoneTArticle];
    private static String[] nomCloArticle = {"Statut", "Code Barre", "Désignation", "Prix de vente", "Stock", "Derniere vente", "idArticle"};

    private static int idArticleSelect = 0;
    private static int idLigneSelect;


    private JPanel page = new JPanel(new FlowLayout());

    /**
     * Creates new form FichierArticle
     */
    public Etiquettes() {
        initComponents();
        URL iconURL = getClass().getResource(Données.getUrl_Logo());
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());


        setExtendedState(JFrame.MAXIMIZED_BOTH); // ouverture de la fenetre en full screen
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        NomLogiciel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        ErreurLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(Données.getNomLogiciel() + " | Etiquettes ");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        UserListCellRenderer cellRenderer = new UserListCellRenderer();
        jTable1.setDefaultRenderer(Object.class, cellRenderer);
        jTable1.setDefaultRenderer(Double.class, cellRenderer);
        jTable1.setDefaultRenderer(Integer.class, cellRenderer);
        jTable1.setDefaultRenderer(Float.class, cellRenderer);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            Article,
            nomCloArticle) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(180);
        }

        jPanel3.setBackground(new java.awt.Color(Données.getCouleurPrincipale1(), Données.getCouleurPrincipale2(), Données.getCouleurPrincipale3()));

        NomLogiciel.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        NomLogiciel.setForeground(new java.awt.Color(255, 255, 255));
        NomLogiciel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NomLogiciel.setText(Données.getNomLogiciel());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(NomLogiciel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NomLogiciel)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Édition étiquettes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Étiquette de l'article selectionné :");

        jPanel8.setBackground(new java.awt.Color(220, 220, 220));
        jPanel8.setPreferredSize(new java.awt.Dimension(226, 75));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nombre d'étiquettes :");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Imprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1403, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );

        ErreurLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ErreurLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1886, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ErreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        ErreurLabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // s'execute à chaque fois qu'on clique sur un article du tableau
        String idArticleSelect_s = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString(); // 6 pour idArticle
        idArticleSelect = Integer.parseInt(idArticleSelect_s);
//        System.err.println(idArticleSelect);
        idLigneSelect = jTable1.getSelectedRow();

        page.setBackground(new java.awt.Color(255, 255, 255));
        page.removeAll();
        // on règle le jPanel de prévisualisation des étiquettes en flowlayout
        FlowLayout layout = new FlowLayout();
        jPanel8.setLayout(layout);
        //supprime tous les éléments du jpanel de preview des étiquettes
        jPanel8.removeAll();
        //création de l'objet code barre vide
        Barcode barcode = null;
        
        try {
            //création du code barres correspondant au numéro d'article
            barcode = BarcodeFactory.createCode128B(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        } catch (BarcodeException ex) {
            Logger.getLogger(Etiquettes.class.getName()).log(Level.SEVERE, null, ex);
        }
        barcode.setBarHeight(20);
        barcode.setBarWidth(1);
        barcode.setDrawingQuietSection(false);
        barcode.setDrawingText(false);
        //chemin d'accès vers le fichier image du code-barres
        String path = "/temp/" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + ".jpg";
        System.out.println(path);
        File imgFile = new File("temp/" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + ".jpg");
        barcode.setVisible(true);
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel8.add(barcode);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(jTable1.getEditorComponent());
        

        //création de l'objet code barre vide
        Barcode barcode = null;
        try {
            //création du code barres correspondant au numéro d'article
            barcode = BarcodeFactory.createCode128B(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        } catch (BarcodeException ex) {
            Logger.getLogger(Etiquettes.class.getName()).log(Level.SEVERE, null, ex);
        }

        barcode.setBarHeight(20);
        barcode.setBarWidth(1);
        barcode.setDrawingQuietSection(false);
        barcode.setDrawingText(false);

        final int nbEti = Integer.parseInt(jTextField1.getText());

        int nbPages = (nbEti / 33)+1;
        System.out.println(nbPages);
        int compteur = 0;

        page.setSize(1190, 1684);

        //affichage du barcode dans le jPanel8
        int Xbase = 23;
        int Ybase = 14;
        PDFDocument pdfDoc = new PDFDocument();
        
        
        for(int n=0;n<nbPages;n++) {
            System.out.println("compteur avant "+compteur);
        
        for (int j = 0; j < 11; j++) {
            for (int i = 0; i < 3; i++) {

                if (compteur < nbEti) {
                    Border blackline = BorderFactory.createLineBorder(new java.awt.Color(127, 127, 127));
                    JPanel container = new javax.swing.JPanel();
                    container.setBorder(blackline);
                    container.setBackground(new java.awt.Color(255, 255, 255));
                    container.setSize(340, 136);
                    container.setVisible(true);

                    Barcode cb = null;
                    try {
                        cb = BarcodeFactory.createCode128B(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    } catch (BarcodeException ex) {
                        Logger.getLogger(Etiquettes.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JPanel cb_container = new javax.swing.JPanel();

                    cb_container.setSize(200, 30);
                    cb_container.setVisible(true);
                    cb_container.setLocation(15, 15);

                    cb.setBarHeight(5);
                    cb.setBarWidth(1);

                    //barcode.setPreferredSize(new Dimension(100,40));
                    cb.setDrawingQuietSection(false);
                    cb.setDrawingText(false);

                    

                    cb_container.add(cb);
                    cb_container.revalidate();
                    cb_container.repaint();

                    container.add(cb_container);
                    container.revalidate();
                    container.repaint();

                    JLabel img = new javax.swing.JLabel();
                    img.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

                    img.setVisible(true);
                    img.setSize(320, 10);
                    img.setLocation(15, 47);
                    img.setFont(img.getFont().deriveFont(10.0f));

                    container.add(img);
                    container.revalidate();
                    container.repaint();

                    JLabel name = new javax.swing.JLabel();
                    name.setText("<html>" + jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() + "</html>");

                    name.setVisible(true);
                    name.setSize(320, 50);
                    name.setLocation(15, 60);
                    name.setFont(name.getFont().deriveFont(12.0f));

                    container.add(name);
                    container.revalidate();
                    container.repaint();

                    JLabel prix = new javax.swing.JLabel();
                    prix.setText("<html>" + jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() + "€ TTC</html>");

                    prix.setVisible(true);
                    prix.setSize(100, 50);
                    prix.setLocation(250, 15);
                    prix.setFont(prix.getFont().deriveFont(16.0f));

                    container.add(prix);
                    container.revalidate();
                    container.repaint();

                    JLabel logo = new javax.swing.JLabel();
                    //logo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Images/logo_e-GENIA.png")).getImage().getScaledInstance(50, 27, Image.SCALE_DEFAULT)));
                    logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/etiquette50.png")));

                    logo.setVisible(true);
                    logo.setSize(50, 27);
                    logo.setLocation(275, 94);
                    logo.setFont(logo.getFont().deriveFont(18.0f));

                    container.add(logo);
                    container.revalidate();
                    container.repaint();

                    container.setLocation(Xbase + 380 * i, Ybase + 148 * j);

                    barcode.setVisible(true);
                    jPanel2.revalidate();
                    jPanel2.repaint();
                    //jPanel8.add(barcode);

                    page.setVisible(true);

                    page.add(container);
                    container = null;
                    img = null;
                    name = null;
                    cb = null;
                    prix = null;
                    logo = null;
                    compteur += 1;
                }
            }
        }
        
        Paper p = new Paper();
        p.setSize(8.25 * 72, 11.75 * 72);
        p.setImageableArea(0, 0, 8.25 * 72, 11.75 * 72);
        PageFormat pf = new PageFormat();
        pf.setPaper(p);
        // Create page
        PDFPage pagePDF = pdfDoc.createPage(pf);

        // Add page to document
        pdfDoc.addPage(pagePDF);
        // get graphics object from the page
        Graphics2D g2d = pagePDF.createGraphics();
        g2d.scale(0.5, 0.5);
        // myComponent being a JComponent showing on the screen
        page.print(g2d);
        p=null;
        pf=null;
        pagePDF=null;
        g2d=null;
        System.out.println("compteur apres "+compteur);
        page.removeAll();
        }

        

        

        // get an output file name
        File outFile = new File("temp/test.pdf");

        // save document
        try {
            pdfDoc.saveDocument(outFile.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Etiquettes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        extend.ouvrirPDF.ouvrirDocPdf("temp/test.pdf");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        if (!((JTextField) evt.getComponent()).getText().matches("[0-9]*")) {
            JOptionPane.showMessageDialog(null, "Merci de ne taper que des chiffres.", "Erreur !", JOptionPane.ERROR_MESSAGE);
            ((JTextField) evt.getComponent()).setText("");
        }
    }//GEN-LAST:event_jTextField1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (Données.getDUA_FichierArticle() == 1) {

            recupArticle();

            deleteDirectory("temp");
            System.out.println("Fichiers temporaires supprimés");

            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Etiquettes().setVisible(true);
                }
            });

        } else {
            ViolationDroit.main(null);
        }
    }

    private static int countArticle() {
        int i = 0;
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT COUNT(*) FROM Article");

            while (result.next()) {
                i = result.getInt("COUNT(*)");
            }
            result.close();
            state.close();
        } catch (CommunicationsException e) {
            Bdd.lostCO(e);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    private static void recupArticle() {
        try {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("SELECT A_statut, A_EAN, A_Designation, A_PrixDeVente, A_Stock, A_DerniereVente, idArticle FROM Article ORDER BY `A_EAN` ASC");

            int i = 0;
            while (result.next()) {
                int j = 0;
                Article[i][j++] = result.getInt("A_statut");
                Article[i][j++] = result.getString("A_EAN");
                Article[i][j++] = result.getString("A_Designation");
                Article[i][j++] = result.getFloat("A_PrixDeVente");
                Article[i][j++] = result.getInt("A_Stock");
                Article[i][j++] = result.getDate("A_DerniereVente");
                Article[i][j++] = result.getInt("idArticle");
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


    private void printRecord(JPanel panel) {
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D) graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX() + 10, pageFormat.getImageableY() + 10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.5, 0.5);

                // Now paint panel as graphics2D
                panel.paint(graphics2D);

                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if (returningResult) {
            // Use try catch exeption for failure
            try {
                // Now call print method inside printerJob to print
                printerJob.print();
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }

    static public void deleteDirectory(String emplacement) {
        File path = new File(emplacement);
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(path + "\\" + files[i]);
                }
                files[i].delete();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErreurLabel;
    private javax.swing.JLabel NomLogiciel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
