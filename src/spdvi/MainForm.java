/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package spdvi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
/**
 *
 * @author Alumne
 */
public class MainForm extends javax.swing.JFrame {
    /**
     * Creates new form MainForm
     */
    private static final java.lang.reflect.Type LIST_OF_OBRA_TYPE = new TypeToken<List<Obra>>() {}.getType();
    final String fileName = "\\AppData\\Local\\Documents\\obres.json";
    final String fileImage = "\\AppData\\Local\\OpusListResources\\images\\";
    Gson gson = new Gson();
    public static ArrayList<Obra> obres = new ArrayList<Obra>();
    InsertDialog insertDialog = new InsertDialog(this, true);
    boolean dataChanged = true;
    
    public JLabel getLblImage() {
        return lblImage;
    }

    public void setLblImage(JLabel lblImage) {
        this.lblImage = lblImage;
    }
    
    public JList getLstobres(){
        return lstObres;
    }
    
     public void setLstObres(JList lstObres){
        this.lstObres = lstObres;
    }
    public MainForm() {
        initComponents();
        scrObres.setViewportView(lstObres);/*
        lstObres.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt){
            //lstObresMouseClicked(evt);
        }    
        });*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrObres = new javax.swing.JScrollPane();
        lstObres = new javax.swing.JList<>();
        lblImage = new javax.swing.JLabel();
        mnuBar = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mniInserNewOpus = new javax.swing.JMenuItem();
        mniUpdateOpus = new javax.swing.JMenuItem();
        mniDeleteOpus = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lstObres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstObresMouseClicked(evt);
            }
        });
        lstObres.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstObresValueChanged(evt);
            }
        });
        scrObres.setViewportView(lstObres);

        mnuMenu.setText("Menu");

        mniInserNewOpus.setText("Insert New Opus");
        mniInserNewOpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInserNewOpusActionPerformed(evt);
            }
        });
        mnuMenu.add(mniInserNewOpus);

        mniUpdateOpus.setText("Update Opus");
        mniUpdateOpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateOpusActionPerformed(evt);
            }
        });
        mnuMenu.add(mniUpdateOpus);

        mniDeleteOpus.setText("Delete Opus");
        mniDeleteOpus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteOpusActionPerformed(evt);
            }
        });
        mnuMenu.add(mniDeleteOpus);

        mnuBar.add(mnuMenu);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrObres, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(scrObres, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try { 
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.home") + fileName));
            obres = gson.fromJson(reader, LIST_OF_OBRA_TYPE);
            DefaultListModel obrasList = new DefaultListModel();
            for (Obra o: obres ) {
              obrasList.addElement(o.toString());
            }
            lstObres.setModel(obrasList);
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

    }//GEN-LAST:event_formWindowOpened

    private void mniInserNewOpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInserNewOpusActionPerformed
        // TODO add your handling code here:
        insertDialog.setVisible(true);
        try {
        if (insertDialog.fileChooser.getSelectedFile() == null)
        {
            ErrorMessage aviso = new ErrorMessage(this, true);
            aviso.getLblError().setText("No tiene foto de perfil. Pulse OK para elegir una.");
            aviso.setVisible(true);
            if(aviso.error == true)
                insertDialog.fileChooser.showOpenDialog(this);
        }
        BufferedImage bufferedimage = ImageIO.read(new File(insertDialog.fileChooser.getSelectedFile().getAbsolutePath()));
        String outputImageAbsolutePath = System.getProperty("user.home")+  fileImage + insertDialog.fileChooser.getSelectedFile().getName();
        File outputImage = new File(outputImageAbsolutePath);
        ImageIO.write(bufferedimage, "jpg", outputImage);

        Obra obra = new Obra(insertDialog.registre, insertDialog.titol, Integer.parseInt(insertDialog.any), insertDialog.format, insertDialog.autor, insertDialog.imatge);

        obres.add(obra);
        UpdateObrasListView();
        saveJSON();
        } catch (IOException ex) {
           ErrorMessage encuesta = new ErrorMessage(this, true);
           encuesta.getLblError().setText(ex.getMessage());
           encuesta.setVisible(true);
        }
    }//GEN-LAST:event_mniInserNewOpusActionPerformed

    private void lstObresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstObresValueChanged
        // TODO add your handling code here:
        String selectedObra = lstObres.getSelectedValue();
        if (selectedObra != null) {
            int lastIndex = selectedObra.indexOf(":");
            String selectedObraReg = selectedObra.substring(0, lastIndex);
            for(Obra o : obres)
            {
                if(o.getRegistre().equals(selectedObraReg))
                {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(new File(System.getProperty("user.home") + fileImage + o.getImatge()));
                        ImageIcon icon = resizeImageIcon(bufferedImage, lblImage.getWidth(), lblImage.getHeight());
                        lblImage.setIcon(icon);
            
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
         }
    }//GEN-LAST:event_lstObresValueChanged

    private void mniUpdateOpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateOpusActionPerformed
        // TODO add your handling code here:
        UpdateDialog updateDialog = new UpdateDialog(this, true);
        updateDialog.setVisible(true);
        ErrorMessage aviso = new ErrorMessage(this, true);
        EditDialog updateData = new EditDialog(this, true);
        for (Obra o: obres) {
            if(o.getRegistre().equals(updateDialog.registre)) {
                updateDialog.isValid = true;
            }
        }
        if(updateDialog.isValid == false) 
        {
            aviso.getLblError().setText("No existe una obra con ese registro.") ;
            aviso.setVisible(true);
        } else {
            for (Obra o: obres)
            {
                if(o.getRegistre().equals(updateDialog.registre))
                {
                    updateData.setVisible(true);
                    o.setTitol(updateData.titol);
                    o.setAny(updateData.any);
                    o.setFormat(updateData.format);
                    o.setAutor(updateData.autor);
                    o.setImatge(updateData.imatge);
                }
            }
        }
        UpdateObrasListView();
        try
        {
          saveJSON();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mniUpdateOpusActionPerformed

    private void lstObresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstObresMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
        UpdateDialog updateDialog = new UpdateDialog(this, true);
        EditDialog updateData = new EditDialog(this, true);
        String selectedObra = lstObres.getSelectedValue();
        int lastIndex = selectedObra.indexOf(":");
        String selectedObraRegis = selectedObra.substring(0, lastIndex);
        try {
        updateDialog.getTxtRegistre().setText(selectedObraRegis);
        updateDialog.setVisible(true); 
        for (Obra o: obres)
            {
                if(o.getRegistre().equals(updateDialog.registre))
                {
                    updateData.setVisible(true);
                    o.setTitol(updateData.titol);
                    o.setAny(updateData.any);
                    o.setFormat(updateData.format);
                    o.setAutor(updateData.autor);
                    o.setImatge(updateData.imatge);
                }
            }
        UpdateObrasListView();

         saveJSON();
    } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_lstObresMouseClicked

    private void mniDeleteOpusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteOpusActionPerformed
        // TODO add your handling code here:
       DeleteDialog deleteDialog = new DeleteDialog(this, true);
        try {
        deleteDialog.setVisible(true);
        String selectedObra = deleteDialog.getCmbBorrar().getSelectedItem().toString();
        for(Obra o: obres) {
            if(o.getTitol().equals(selectedObra)) {
                obres.remove(o);
                break;
            }
        }
        DefaultListModel obraListModel = new DefaultListModel();
        for(Obra o: obres) {
            obraListModel.addElement(o.toString());
        }
        lstObres.setModel(obraListModel);

        UpdateObrasListView();
        saveJSON();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_mniDeleteOpusActionPerformed
  private ImageIcon resizeImageIcon(BufferedImage originalImage, int desiredWidth, int desiredHeight){
            int newHeight = 0;
            int newWidth = 0;
            
            float aspectRatio= (float)originalImage.getWidth() / originalImage.getHeight();
            if (originalImage.getWidth() > originalImage.getHeight())
            {
                newWidth = desiredWidth;
                newHeight = Math.round(desiredWidth / aspectRatio);
            }
            else
            {
                newHeight = desiredHeight;
                newWidth = Math.round(desiredHeight * aspectRatio);}
                 
            Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            BufferedImage outputImage = new BufferedImage(newWidth, newHeight,BufferedImage.TYPE_INT_RGB);
            outputImage.getGraphics().drawImage(resultingImage, 0, 0 ,null);
            ImageIcon imageIcon = new ImageIcon(outputImage);
            return imageIcon;    
    }
        
    private void UpdateObrasListView(){
            DefaultListModel obrasList = new DefaultListModel();
            for (Obra o: obres ) {
              obrasList.addElement(o.toString());
            }
            lstObres.setModel(obrasList);
        }
    
    public void saveJSON() throws IOException
    {
        JsonWriter writer = new JsonWriter(new FileWriter(System.getProperty("user.home") + fileName));
        writer.beginArray();
        for (Obra o: obres)
        {
            writeObrasJSON(writer, o);
        }
        writer.endArray();
        writer.close();
    }
    
    public void writeObrasJSON(JsonWriter writer, Obra obra) throws IOException {
     writer.beginObject();
     writer.name("registre").value(obra.getRegistre());
     writer.name("titol").value(obra.getTitol());
     writer.name("any").value(obra.getAny());
     writer.name("format").value(obra.getFormat());
     writer.name("autor").value(obra.getAutor());
     writer.name("imatge").value(obra.getImatge());
     writer.endObject();
   }
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImage;
    private javax.swing.JList<String> lstObres;
    private javax.swing.JMenuItem mniDeleteOpus;
    private javax.swing.JMenuItem mniInserNewOpus;
    private javax.swing.JMenuItem mniUpdateOpus;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuMenu;
    private javax.swing.JScrollPane scrObres;
    // End of variables declaration//GEN-END:variables
}
