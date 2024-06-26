/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import controladores.ProductosJpaController;
import entidades.Productos;
import entidades.TiposProductos;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author vickyfg
 */
public class CrearNuevoProducto extends javax.swing.JDialog {

    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DawFoodVicky_jar_1.0-SNAPSHOTPU");
    private static final ProductosJpaController proJpa = new controladores.ProductosJpaController(emf);
    
    /**
     * Creates new form CrearNuevoProducto
     */
    public CrearNuevoProducto(Gestion parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    //Método para incluir un producto en la lista
    public static void incluirProducto(Productos nuevoProducto) throws Exception {
        proJpa.create(nuevoProducto);
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
        jTextFieldPrecio = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jComboBoxIva = new javax.swing.JComboBox<>();
        jComboBoxTipoPro = new javax.swing.JComboBox<>();
        jBotonAtras = new javax.swing.JButton();
        jBotonGuardar = new javax.swing.JButton();
        jSpinnerStock = new javax.swing.JSpinner();
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

        jTextFieldPrecio.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, -1));

        jTextFieldDescripcion.setBackground(new java.awt.Color(255, 153, 153));
        jTextFieldDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextFieldDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 190, -1));

        jComboBoxIva.setBackground(new java.awt.Color(255, 153, 153));
        jComboBoxIva.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "21" }));
        jPanel1.add(jComboBoxIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 190, -1));

        jComboBoxTipoPro.setBackground(new java.awt.Color(255, 153, 153));
        jComboBoxTipoPro.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxTipoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patatas fritas", "Hamburguesa", "Ensaladas", "Postre Caseros", "Azucaradas", "SinAzucar", "Cervezas", "Agua", "Helados", "Complementos" }));
        jPanel1.add(jComboBoxTipoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, -1));

        jBotonAtras.setBackground(new java.awt.Color(115, 172, 178));
        jBotonAtras.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jBotonAtras.setForeground(new java.awt.Color(246, 235, 198));
        jBotonAtras.setText("Atrás");
        jBotonAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 169, 171)));
        jBotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonAtrasActionPerformedGestion(evt);
            }
        });
        jPanel1.add(jBotonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 130, -1));

        jBotonGuardar.setBackground(new java.awt.Color(115, 172, 178));
        jBotonGuardar.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jBotonGuardar.setForeground(new java.awt.Color(246, 235, 198));
        jBotonGuardar.setText("Guardar");
        jBotonGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 169, 171)));
        jBotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonGuardarActionPerformedGestion(evt);
            }
        });
        jPanel1.add(jBotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 120, -1));
        jPanel1.add(jSpinnerStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 370, 480));

        jLabel1.setBackground(new java.awt.Color(246, 235, 198));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 490, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonAtrasActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonAtrasActionPerformedGestion
        this.dispose();
    }//GEN-LAST:event_jBotonAtrasActionPerformedGestion

    private void jBotonGuardarActionPerformedGestion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonGuardarActionPerformedGestion
        try {
            Productos p = new Productos();

            String ivaSt = jComboBoxIva.getSelectedItem().toString();  
            int iva = Integer.parseInt(ivaSt);
            p.setIvaProducto(iva);

            String nombre = jTextFieldNombre.getText();
            if (nombre.isEmpty()) {
                throw new IllegalArgumentException("El campo Nombre no puede estar vacio");
            }
            p.setNombreProducto(nombre);

            int stock = (int) jSpinnerStock.getValue();
            if (stock <= 0) {
                throw new IllegalArgumentException("El campo Stock no puede ser cero");
            }
            p.setStockProducto(stock);

            String tipoProducto = jComboBoxTipoPro.getSelectedItem().toString();
            if (tipoProducto.isEmpty()) {
                throw new IllegalArgumentException("Debe seleccionar un Tipo de Producto");
            }
            
            String descripcion = jTextFieldDescripcion.getText();
            p.setDescripcionProducto(descripcion);

            switch (tipoProducto) {
                case "Patatas fritas" ->
                    p.setIdTipo(new TiposProductos(600));
                case "Hamburguesa" ->
                    p.setIdTipo(new TiposProductos(602));
                case "Ensaladas" ->
                    p.setIdTipo(new TiposProductos(603));
                case "Postre Caseros" ->
                    p.setIdTipo(new TiposProductos(605));
                case "Azucaradas" ->
                    p.setIdTipo(new TiposProductos(607));
                case "SinAzucar" ->
                    p.setIdTipo(new TiposProductos(608));
                case "Cervezas" ->
                    p.setIdTipo(new TiposProductos(609));
                case "Agua" ->
                    p.setIdTipo(new TiposProductos(610));
                case "Helados" ->
                    p.setIdTipo(new TiposProductos(612));
                case "Complementos" ->
                    p.setIdTipo(new TiposProductos(620));

            }

            //El precio primero como string y luego parseamos a double
            String precioS = jTextFieldPrecio.getText();
            if (precioS.isEmpty()) {
                throw new IllegalArgumentException("El campo Precio no puede estar vacio");
            }
            double precio = Double.parseDouble(precioS);
            if (precio < 0) {
                throw new IllegalArgumentException("El precio debe ser un número positivo");
            }
            p.setPrecioProducto(precio);

            // Incluir el producto en la bbdd con metodo NamedQuery
            incluirProducto(p);
            this.dispose();

        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null,
                    "Error. El precio debe ser un número válido!", "DawFood", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(null,
                    i.getMessage(), "DawFood", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al incluir el producto: " + e.getMessage(), "DawFood", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBotonGuardarActionPerformedGestion


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonAtras;
    private javax.swing.JButton jBotonGuardar;
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
    private javax.swing.JSpinner jSpinnerStock;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    // End of variables declaration//GEN-END:variables
}
