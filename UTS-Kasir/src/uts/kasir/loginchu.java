/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.kasir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Fay
 */
public class loginchu extends javax.swing.JFrame {
    /**
     * Creates new form loginchu
     */
    public loginchu() {
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

        jPanel1 = new javax.swing.JPanel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setLayout(null);
        jPanel1.add(tf1);
        tf1.setBounds(60, 40, 230, 29);
        jPanel1.add(tf2);
        tf2.setBounds(60, 110, 238, 30);

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 1, 24)); // NOI18N
        jLabel2.setText("Username");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 0, 140, 40);

        jLabel3.setFont(new java.awt.Font("Tekton Pro Cond", 1, 24)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 80, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 340, 160);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(null);

        b2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        b2.setText("SIGNUP");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel2.add(b2);
        b2.setBounds(20, 200, 100, 40);

        b3.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        b3.setText("EXIT");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel2.add(b3);
        b3.setBounds(140, 200, 90, 40);

        b1.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        b1.setText("LOGIN");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel2.add(b1);
        b1.setBounds(250, 200, 100, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 270);

        setSize(new java.awt.Dimension(412, 304));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        String username = tf1.getText();
        String password = tf2.getText();

        try {
            try (Statement statement = (Statement) connect.GetConnection().createStatement()){
                statement.executeUpdate("insert into admin(username, password) VALUES ('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null, "Congratulations! You have signed up Successfully!");
        } catch (Exception t){
            JOptionPane.showMessageDialog(null, "Please Try Again!");
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        dispose();
    }//GEN-LAST:event_b3ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        Connection connection;
        PreparedStatement ps;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uts-kasir?zeroDateTimeBehaviour=convertToNull",
                "root", "");
            ps = connection.prepareStatement("SELECT username, password FROM admin WHERE username=? AND password=?");
            ps.setString(1, tf1.getText());
            ps.setString(2, tf2.getText());
            ResultSet result = ps.executeQuery();
            if(result.next()) {
                new form().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Incorrect");
                tf2.setText("");
                tf2.requestFocus();
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Failed", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_b1ActionPerformed

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
            java.util.logging.Logger.getLogger(loginchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginchu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    // End of variables declaration//GEN-END:variables
}