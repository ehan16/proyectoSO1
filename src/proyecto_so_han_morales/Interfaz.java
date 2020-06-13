package proyecto_so_han_morales;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    Gama gama;

    public Interfaz() throws FileNotFoundException, InterruptedException {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        gama = new Gama();
        gama.Start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAddShoppingCart = new javax.swing.JButton();
        btnDeleteShoppingCart = new javax.swing.JButton();
        btnAddCashier = new javax.swing.JButton();
        btnDeleteCashier = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnAddShelf = new javax.swing.JButton();
        txtClientsActive = new javax.swing.JTextField();
        txtClientsWaiting = new javax.swing.JTextField();
        txtShelf = new javax.swing.JTextField();
        txtShoppingCarts = new javax.swing.JTextField();
        txtCashier = new javax.swing.JTextField();
        txtEarnings = new javax.swing.JTextField();
        txtHours = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(175, 175, 175));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EG_Logo.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Estantes");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cajas registradoras");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Clientes en el sistema");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Clientes en espera");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Carritos disponibles");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Horas laborales cursadas");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Ganancias");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Sobre los clientes");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Sobre la sucursal");

        btnAddShoppingCart.setBackground(new java.awt.Color(102, 0, 0));
        btnAddShoppingCart.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnAddShoppingCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShoppingCart.setText("Agregar");
        btnAddShoppingCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShoppingCartActionPerformed(evt);
            }
        });

        btnDeleteShoppingCart.setBackground(new java.awt.Color(102, 0, 0));
        btnDeleteShoppingCart.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnDeleteShoppingCart.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteShoppingCart.setText("Eliminar");
        btnDeleteShoppingCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteShoppingCartActionPerformed(evt);
            }
        });

        btnAddCashier.setBackground(new java.awt.Color(102, 0, 0));
        btnAddCashier.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnAddCashier.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCashier.setText("Contratar");
        btnAddCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCashierActionPerformed(evt);
            }
        });

        btnDeleteCashier.setBackground(new java.awt.Color(102, 0, 0));
        btnDeleteCashier.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnDeleteCashier.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCashier.setText("Despedir");
        btnDeleteCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCashierActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Sobre las estadísticas");

        btnAddShelf.setBackground(new java.awt.Color(102, 0, 0));
        btnAddShelf.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnAddShelf.setForeground(new java.awt.Color(255, 255, 255));
        btnAddShelf.setText("Agregar");
        btnAddShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddShelfActionPerformed(evt);
            }
        });

        txtClientsActive.setBackground(new java.awt.Color(255, 255, 255));
        txtClientsActive.setForeground(new java.awt.Color(0, 0, 0));
        txtClientsActive.setText("0");
        txtClientsActive.setEnabled(false);
        txtClientsActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientsActiveActionPerformed(evt);
            }
        });

        txtClientsWaiting.setBackground(new java.awt.Color(255, 255, 255));
        txtClientsWaiting.setForeground(new java.awt.Color(0, 0, 0));
        txtClientsWaiting.setText("0");
        txtClientsWaiting.setEnabled(false);
        txtClientsWaiting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientsWaitingActionPerformed(evt);
            }
        });

        txtShelf.setBackground(new java.awt.Color(255, 255, 255));
        txtShelf.setForeground(new java.awt.Color(0, 0, 0));
        txtShelf.setText("0");
        txtShelf.setEnabled(false);
        txtShelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShelfActionPerformed(evt);
            }
        });

        txtShoppingCarts.setBackground(new java.awt.Color(255, 255, 255));
        txtShoppingCarts.setForeground(new java.awt.Color(0, 0, 0));
        txtShoppingCarts.setText("0");
        txtShoppingCarts.setEnabled(false);
        txtShoppingCarts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShoppingCartsActionPerformed(evt);
            }
        });

        txtCashier.setBackground(new java.awt.Color(255, 255, 255));
        txtCashier.setForeground(new java.awt.Color(0, 0, 0));
        txtCashier.setText("0");
        txtCashier.setEnabled(false);
        txtCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashierActionPerformed(evt);
            }
        });

        txtEarnings.setBackground(new java.awt.Color(255, 255, 255));
        txtEarnings.setForeground(new java.awt.Color(0, 0, 0));
        txtEarnings.setText("0");
        txtEarnings.setEnabled(false);
        txtEarnings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEarningsActionPerformed(evt);
            }
        });

        txtHours.setBackground(new java.awt.Color(255, 255, 255));
        txtHours.setForeground(new java.awt.Color(0, 0, 0));
        txtHours.setText("0");
        txtHours.setEnabled(false);
        txtHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShoppingCarts, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAddShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientsActive, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientsWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCashier, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEarnings, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCashier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddCashier)
                        .addComponent(btnDeleteCashier))
                    .addComponent(txtClientsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientsWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEarnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnAddShelf)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtShoppingCarts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddShoppingCart)
                            .addComponent(btnDeleteShoppingCart))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // GETTERS Y SETTERS
    public JButton getBtnAddCashier() {
        return btnAddCashier;
    }

    public JButton getBtnAddShelf() {
        return btnAddShelf;
    }

    public JButton getBtnAddShoppingCart() {
        return btnAddShoppingCart;
    }

    public JButton getBtnDeleteCashier() {
        return btnDeleteCashier;
    }

    public JButton getBtnDeleteShoppingCart() {
        return btnDeleteShoppingCart;
    }

    // METODOS DE LA INTERFAZ

    private void btnAddShoppingCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShoppingCartActionPerformed

        // Se revisa si ya se ha llegado a la cantidad maxima
        if (Gama.carritos < Gama.carritosMax) {

            gama.getSCC().release(); // Se aumenta un permiso al semaforo de carritos
            Gama.carritos++;
            Interfaz.txtShoppingCarts.setText(Integer.toString(Gama.carritos));

        } else {

            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de carritos", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAddShoppingCartActionPerformed

    private void btnDeleteShoppingCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteShoppingCartActionPerformed

        // Se revisa si ya se ha llegado a la cantidad minima
//        if (Gama.carritos == 1) {
//             
//            JOptionPane.showMessageDialog(null, "Ha alcanzado el mínimo de carritos", "ERROR", JOptionPane.ERROR_MESSAGE);
//             
//        } else {
        if (Gama.carritos == Gama.clientesActivos) {

            JOptionPane.showMessageDialog(null, "Ha alcanzado el mínimo de carritos que se pueden eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

//                if(Gama.carritos == Gama.clientesActivos){
//                    
//                    if(!Gama.deseoEliminarCarritoEnUso){//Si no hay carritos pendientes por eliminar
//                        
//                        Gama.deseoEliminarCarritoEnUso = true;
//                        JOptionPane.showMessageDialog(null, "Esta tratando de eliminar un carrito que esta en uso "
//                                + ", su acción será tomada en cuenta, pero debe esperar hasta que el cliente salga."
//                                + " Hasta entonces, la función eliminar estará suspendida.", "Error", JOptionPane.ERROR_MESSAGE);
////                        btnDeleteShoppingCart.setEnabled(false);
////                        try{
////                            Gama.sControlEliminaciones.acquire();
////                            Gama.carritos = Gama.carritos--;
////                            btnDeleteShoppingCart.setEnabled(true);
//                            //Gama.sControlEliminaciones.release();
////                        }catch(Exception ex){
////                            System.out.println("Error " + ex);
////                        }
//
//                    } else {
//                        
//                        JOptionPane.showMessageDialog(null, "Ya hay una eliminacion pendiente");
//                        
//                    }
//                } else {
                gama.getSCC().acquire();
                Gama.carritos--;
                Interfaz.txtShoppingCarts.setText(Integer.toString(Gama.carritos));

//                }
            } catch (InterruptedException ex) {

                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }//GEN-LAST:event_btnDeleteShoppingCartActionPerformed

    private void btnAddCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCashierActionPerformed

        // Se revisa si ya se ha llegado a la cantidad maxima
        if (Gama.cajeros < Gama.cajasMax) {

            Gama.cashiers[Gama.cajeros].setEstatus(true);
            System.out.println("Se ha añadido al cajero " + Gama.cajeros);
            Gama.cajeros++;
            gama.getSCCR().release();
            Interfaz.txtCashier.setText(Integer.toString(Gama.cajeros));

        } else {

            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de cajeros", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAddCashierActionPerformed

    private void btnDeleteCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCashierActionPerformed

        // Se revisa si ya se ha llegado a la cantidad minima
        if (Gama.cajeros == 1) {

            JOptionPane.showMessageDialog(null, "Ha alcanzado el minimo de cajeros", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {

            Gama.cajeros--;
            
            try {
            
                gama.getSCCR().acquire();
                
            } catch (InterruptedException ex) {
                
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            Gama.cashiers[Gama.cajeros].setEstatus(false);
            System.out.println("Se ha eliminado al cajero " + Gama.cajeros);
            Interfaz.txtCashier.setText(Integer.toString(Gama.cajeros));

        }

    }//GEN-LAST:event_btnDeleteCashierActionPerformed

    private void btnAddShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddShelfActionPerformed

        // Se revisa si ya se ha llegado a la cantidad maxima
        if (Gama.estantes < Gama.estantesMax) {

            // Buscamos la posicion de donde podemos colocar el nuevo estante y se crea
            int aux = Gama.estantes;
            Gama.estante[aux] = new Shelf(Gama.capacidadMax, aux + 1);
            System.out.println("Se ha añadido el estante " + (aux + 1));

            Gama.estantes++;
            Interfaz.txtShelf.setText(Integer.toString(Gama.estantes));
            // Ahora se crea el empleado que se hara cargo de ese estante
            // y se le asigna los semaforos de ese estante
            gama.crearHilo(0, aux);

        } else {

            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de estantes", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAddShelfActionPerformed

    private void txtClientsActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientsActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientsActiveActionPerformed

    private void txtClientsWaitingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientsWaitingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientsWaitingActionPerformed

    private void txtShelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShelfActionPerformed

    private void txtShoppingCartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShoppingCartsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShoppingCartsActionPerformed

    private void txtCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashierActionPerformed

    private void txtEarningsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEarningsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEarningsActionPerformed

    private void txtHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoursActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCashier;
    private javax.swing.JButton btnAddShelf;
    private javax.swing.JButton btnAddShoppingCart;
    private javax.swing.JButton btnDeleteCashier;
    private javax.swing.JButton btnDeleteShoppingCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txtCashier;
    public static javax.swing.JTextField txtClientsActive;
    public static javax.swing.JTextField txtClientsWaiting;
    public static javax.swing.JTextField txtEarnings;
    public static javax.swing.JTextField txtHours;
    public static javax.swing.JTextField txtShelf;
    public static javax.swing.JTextField txtShoppingCarts;
    // End of variables declaration//GEN-END:variables
}
