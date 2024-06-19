/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import dawfood.PasarelaDePago;

/**
 *
 * @author vickyfg
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(227, 122, 110));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Gestión");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 122, 110)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformedGestion(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, 70));

        jButton2.setBackground(new java.awt.Color(227, 122, 110));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Cliente");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(227, 122, 110), 1, true));
        jButton2.setInheritsPopupMenu(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformedCliente(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 170, 70));

        jButton3.setBackground(new java.awt.Color(227, 122, 110));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Salir");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 122, 110)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformedTickets(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, 100, 60));

        jButton4.setBackground(new java.awt.Color(227, 122, 110));
        jButton4.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Tickets");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227, 122, 110)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformedTickets(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 170, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carteldawfood (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -10, 540, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformedGestion
        // TODO add your handling code here:
        new Gestion(this, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformedGestion

    private void jButton2ActionPerformedCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformedCliente
        new Cliente(this, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformedCliente

    private void jButton3ActionPerformedTickets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformedTickets
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformedTickets

    private void jButton4ActionPerformedTickets(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformedTickets
        new MostrarTickets(this, true).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformedTickets

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                PasarelaDePago pasarela = new PasarelaDePago();
                System.out.println(pasarela.toString());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
