/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

/**
 *
 * @author vickyfg
 */
public class CrearNuevoProducto extends javax.swing.JDialog {

    /**
     * Creates new form CrearNuevoProducto
     */
    public CrearNuevoProducto(Administrador parent, boolean modal) {
        super(parent, modal);
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
        jLabel3 = new javax.swing.JLabel();
        jLabe = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jTextFieldStock = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jComboBoxIva = new javax.swing.JComboBox<>();
        jComboBoxTipoPro = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Descripición:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, 20));

        jLabe.setBackground(new java.awt.Color(153, 153, 153));
        jLabe.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabe.setForeground(new java.awt.Color(255, 102, 102));
        jLabe.setText("Nombre:");
        jPanel1.add(jLabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("Precio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 102));
        jLabel6.setText("Iva:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 20));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("Stock:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 20));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("Tipo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 80, 20));

        jTextFieldNombre.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 190, -1));

        jTextFieldCantidad.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldCantidad.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, -1));

        jTextFieldStock.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldStock.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, -1));

        jTextFieldDescripcion.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 190, -1));

        jComboBoxIva.setBackground(new java.awt.Color(255, 153, 153));
        jComboBoxIva.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "10", "21" }));
        jPanel1.add(jComboBoxIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        jComboBoxTipoPro.setBackground(new java.awt.Color(255, 153, 153));
        jComboBoxTipoPro.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxTipoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comida", "Bebida", "Postre" }));
        jPanel1.add(jComboBoxTipoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        jButton6.setBackground(new java.awt.Color(115, 172, 178));
        jButton6.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(246, 235, 198));
        jButton6.setText("Atrás");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 169, 171)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformedGestion(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 130, -1));

        jButton7.setBackground(new java.awt.Color(115, 172, 178));
        jButton7.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(246, 235, 198));
        jButton7.setText("Guardar");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 169, 171)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformedGestion(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 370, 480));

        jLabel1.setBackground(new java.awt.Color(246, 235, 198));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 490, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformedGestion
        Principal p = new Principal();
        this.setVisible(false);
        p.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformedGestion

    private void jButton7ActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformedGestion
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformedGestion

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CrearNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CrearNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CrearNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CrearNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CrearNuevoProducto dialog = new CrearNuevoProducto(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxIva;
    private javax.swing.JComboBox<String> jComboBoxTipoPro;
    private javax.swing.JLabel jLabe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldStock;
    // End of variables declaration//GEN-END:variables
}
