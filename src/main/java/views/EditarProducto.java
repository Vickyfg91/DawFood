/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import entidades.Productos;
import entidades.TiposProductos;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Victoria
 */
public class EditarProducto extends javax.swing.JDialog {

    private Administrador admin;
    private Productos producto;

    /**
     * Creates new form EditarProducto
     */
    public EditarProducto(Administrador parent, boolean modal) {
        super(parent, modal);
        admin = parent;
        initComponents();
        mostrarDatosEditar();
    }

    // Este método privado permite cargar los datos en los componentes
    // de este jdialog del registro seleccionado en el jtable de la ventana
    private void mostrarDatosEditar() {
        try {
            // Obtengo la fila seleccionada y luego el id de esa fila
            int fila = filaSeleccionadaJTable(admin.getJTable());

            // Verifico que haya una fila seleccionada
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Para editar un producto debe seleccionar un producto de la lista", "DawFood", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtengo los valores de la fila seleccionada
            int idProducto = (int) admin.getJTable().getValueAt(fila, 0);
            String nombreProducto = (String) admin.getJTable().getValueAt(fila, 1);
            Double precio = (Double) admin.getJTable().getValueAt(fila, 2);
            int ivaProducto = (int) admin.getJTable().getValueAt(fila, 3);
            int stockProducto = (int) admin.getJTable().getValueAt(fila, 4);
            String idTipo = (String) admin.getJTable().getValueAt(fila, 5);
            String descripcionProducto = (String) admin.getJTable().getValueAt(fila, 6);

            // Guarda producto seleccionado
            //Aqui se usa buscarporid que es un metodo NamedQuery
            this.producto = Administrador.buscarPordId(idProducto);

            // Muestra datos del producto que se seleccionó en el jtable en los jtextfield
            jTextFieldId.setText(Integer.toString(this.producto.getIdProducto()));
            // Requisitos del proyecto id no editable
            jTextFieldId.setEditable(false);

            jTextFieldNombre.setText(nombreProducto);

            // Aqui se controla de valores positivos
            try {
                if (precio < 0) {
                    throw new IllegalArgumentException("El precio debe ser positivo");
                }
                jTextFieldPrecio.setText(String.valueOf(precio));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debes introducir un numero correcto ",
                        "DawFood - Error", JOptionPane.ERROR_MESSAGE);
            }

            jTextFieldPrecio.setText(precio.toString());

            jComboBoxIva.setSelectedItem(Integer.toString(ivaProducto));

            try {
                if (stockProducto < 0) {
                    throw new IllegalArgumentException("El stock debe ser positivo.");
                } else {
                    jSpinnerStock.setValue(stockProducto);
                }
            } catch (NumberFormatException ae) {
                JOptionPane.showMessageDialog(this, "Debes introducir un numero correcto ",
                        "DawFood - Error", JOptionPane.ERROR_MESSAGE);
            }

            jTextFieldDescripcion.setText(this.producto.getDescripcionProducto());

            String tipoProductos = this.producto.getIdTipo().getCategoria();
            jComboBoxTipoPro.setSelectedItem(tipoProductos);
            System.out.println(tipoProductos);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos", "DawFood - Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int filaSeleccionadaJTable(JTable jTable1) {
        int fila = jTable1.getSelectedRow();
        return fila;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabe = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxIva = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxTipoPro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabe1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabe2 = new javax.swing.JLabel();
        jSpinnerStock = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, 120, -1));

        jPanel1.setBackground(new java.awt.Color(123, 169, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabe.setBackground(new java.awt.Color(153, 153, 153));
        jLabe.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabe.setForeground(new java.awt.Color(102, 102, 102));
        jLabe.setText("Editar producto ");
        jPanel1.add(jLabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 150, -1));

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(251, 234, 198));
        jTextFieldId.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, -1));

        jTextFieldPrecio.setBackground(new java.awt.Color(251, 234, 198));
        jTextFieldPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, -1));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(251, 234, 198));
        jLabel5.setText("Precio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 20));

        jComboBoxIva.setBackground(new java.awt.Color(251, 234, 198));
        jComboBoxIva.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "10", "21" }));
        jPanel1.add(jComboBoxIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 190, -1));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(251, 234, 198));
        jLabel6.setText("Iva:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 80, 20));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(251, 234, 198));
        jLabel7.setText("Stock:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 20));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(251, 234, 198));
        jLabel8.setText("Tipo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, 20));

        jComboBoxTipoPro.setBackground(new java.awt.Color(251, 234, 198));
        jComboBoxTipoPro.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxTipoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patatas fritas", "Hamburguesa", "Ensaladas", "Postre Caseros", "Azucaradas", "SinAzucar", "Cervezas", "Agua", "Helados", "Complementos" }));
        jPanel1.add(jComboBoxTipoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 190, -1));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(251, 234, 198));
        jLabel3.setText("Descripición:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 140, 20));

        jTextFieldDescripcion.setBackground(new java.awt.Color(251, 234, 198));
        jTextFieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 190, -1));

        jLabe1.setBackground(new java.awt.Color(153, 153, 153));
        jLabe1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabe1.setForeground(new java.awt.Color(251, 234, 198));
        jLabe1.setText("Id:");
        jPanel1.add(jLabe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, -1));

        jTextFieldNombre.setBackground(new java.awt.Color(251, 234, 198));
        jTextFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, -1));

        jLabe2.setBackground(new java.awt.Color(153, 153, 153));
        jLabe2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabe2.setForeground(new java.awt.Color(251, 234, 198));
        jLabe2.setText("Nombre:");
        jPanel1.add(jLabe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 80, -1));

        jSpinnerStock.setName(""); // NOI18N
        jSpinnerStock.setNextFocusableComponent(jComboBoxIva);
        jSpinnerStock.setOpaque(true);
        jPanel1.add(jSpinnerStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 390, 460));

        jButton1.setBackground(new java.awt.Color(246, 235, 198));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 640, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 490, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformedGestion
        // Guardo en producto seleccionada los cambios de los jtextfield
        this.producto.setNombreProducto(jTextFieldNombre.getText());
        this.producto.setPrecioProducto(Double.parseDouble(jTextFieldPrecio.getText()));
        this.producto.setIvaProducto(Integer.parseInt(jComboBoxIva.getSelectedItem().toString()));
        this.producto.setStockProducto((int) jSpinnerStock.getValue());

        String nombreTipoProducto = jComboBoxTipoPro.getSelectedItem().toString();

        // Aquí debes buscar el objeto TiposProductos correspondiente al nombre seleccionado
        // por ejemplo, podrías tener un método en tu clase Administrador que haga esto
//        TiposProductos tipoProducto = entidades.findByCategoria(nombreTipoProducto);
//
//        // Luego, asignas el ID del tipo de producto al objeto producto
//        this.producto.setIdTipo(tipoProducto.getIdTipo());
//
//        this.producto.setIdTipo(jComboBoxTipoPro.getSelectedItem().toString());
        this.producto.setDescripcionProducto(jTextFieldDescripcion.getText());

        // En este punto también se podrían guardar los cambios en un 
        // fichero o en una BD
        // Cierro el dialogo
        this.dispose();
        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");

    }//GEN-LAST:event_jButton7ActionPerformedGestion

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal p = new Principal();
        this.setVisible(false);
        p.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxIva;
    private javax.swing.JComboBox<String> jComboBoxTipoPro;
    private javax.swing.JLabel jLabe;
    private javax.swing.JLabel jLabe1;
    private javax.swing.JLabel jLabe2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerStock;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
