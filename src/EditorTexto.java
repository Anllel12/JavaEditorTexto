
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author angel
 */
public class EditorTexto extends javax.swing.JFrame {
    
    Boolean guardado = true;
    File fichero2;
    
    /**
     * Creates new form EditorTexto
     */
    public EditorTexto() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMNuevo = new javax.swing.JMenu();
        jMINuevo = new javax.swing.JMenuItem();
        jMIAbrir = new javax.swing.JMenuItem();
        jMIGuardar = new javax.swing.JMenuItem();
        jMIGuardarComo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMNuevo.setText("Archivo");

        jMINuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMINuevo.setText("Nuevo");
        jMINuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMINuevoActionPerformed(evt);
            }
        });
        jMNuevo.add(jMINuevo);

        jMIAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIAbrir.setText("Abrir");
        jMIAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAbrirActionPerformed(evt);
            }
        });
        jMNuevo.add(jMIAbrir);

        jMIGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIGuardar.setText("Guardar");
        jMIGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGuardarActionPerformed(evt);
            }
        });
        jMNuevo.add(jMIGuardar);

        jMIGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMIGuardarComo.setText("Guardar como");
        jMIGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGuardarComoActionPerformed(evt);
            }
        });
        jMNuevo.add(jMIGuardarComo);

        jMenuBar1.add(jMNuevo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMINuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMINuevoActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_jMINuevoActionPerformed

    private void jMIAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAbrirActionPerformed
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("arhivos de documentos xml", "xml"));//seleccionar un archivo
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("arhivos de documentos txt", "txt"));
        
        int seleccion = jFileChooser1.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = jFileChooser1.getSelectedFile();
            String nombre = fichero.getName();
            String extension = nombre.substring(nombre.lastIndexOf('.') + 1, nombre.length());
            
            if (extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("xml")) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fichero));//pongo fichero para que lea la ruta
                    
                    String valor = "";
                    String aux = "";
                    
                    while ((valor=br.readLine()) != null){
                        if(aux == ""){
                            aux = valor;//esto es para que no salga una primera linea en blanco al abrirlo
                        }else{
                            aux = aux + "\n" +valor;
                        }
                                        
                        jTextArea1.setText(aux);
                    }                   
                    br.close();
                }
                catch (FileNotFoundException ex) {
                    System.out.println("Fichero no encontrado");
                }
                catch (Exception ex) {
                    System.out.println("Error en la lectura del fichero");
                }
            }
        }
    }//GEN-LAST:event_jMIAbrirActionPerformed

    private void jMIGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGuardarActionPerformed
        if(guardado){
            int seleccion = jFileChooser1.showSaveDialog(this);
        
            if (seleccion == JFileChooser.APPROVE_OPTION) {//si entra aqui es porque han pulsado el boton guardar
                File fichero = jFileChooser1.getSelectedFile();
                fichero2 = fichero;
                try {
                    BufferedWriter bw=new BufferedWriter(new FileWriter(fichero));

                    bw.write(jTextArea1.getText());
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Error en la escritura");
                }
            }
            guardado = false;
        }
        else{
            System.out.println(fichero2);
            try {
                    BufferedWriter bw=new BufferedWriter(new FileWriter(fichero2));

                    bw.write(jTextArea1.getText());
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Error en la escritura");
                }
        }
    }//GEN-LAST:event_jMIGuardarActionPerformed

    private void jMIGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGuardarComoActionPerformed
        int seleccion = jFileChooser1.showSaveDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {//si entra aqui es porque han pulsado el boton guardar
            File fichero = jFileChooser1.getSelectedFile();
            
            try {
                BufferedWriter bw=new BufferedWriter(new FileWriter(fichero)); // creo el buffer para que lo guarde en el ficheero
                
                bw.write(jTextArea1.getText());
                bw.close();
            } catch (IOException e) {
                System.out.println("Error en la escritura");
            }
        }
    }//GEN-LAST:event_jMIGuardarComoActionPerformed
    
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
            java.util.logging.Logger.getLogger(EditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorTexto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenuItem jMIAbrir;
    private javax.swing.JMenuItem jMIGuardar;
    private javax.swing.JMenuItem jMIGuardarComo;
    private javax.swing.JMenuItem jMINuevo;
    private javax.swing.JMenu jMNuevo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
