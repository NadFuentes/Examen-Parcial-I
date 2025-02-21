/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_parcial_i;

/**
 *
 * @author Nadiesda Fuentes
 */
import java.io.PrintStream;


public class ViewProfile extends javax.swing.JFrame {

   
    
    public ViewProfile() {
        initComponents();
          setLocationRelativeTo(null);
           System.setOut(new PrintStream(new TextAreaOutputStream(perfil)));   
    }

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea perfil;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
