package UI;

import BO.Product;
import BO.Sale;
import BO.Shop;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Anas
 */
public class SellUI extends javax.swing.JFrame {

    /**
     * Creates new form SellUI
     */
    public SellUI() {
        initComponents();
        populateProductListComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
        editor.setEditable(false);
        jLabel5 = new javax.swing.JLabel();

        setTitle("Sales");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Product Sale to Customer"));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Bill Amount");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 260, -1, -1));

        jTextField1.setBackground(new java.awt.Color(153, 144, 136));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 257, 561, -1));

        jTextField3.setBackground(new java.awt.Color(153, 144, 136));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 189, 256, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Product");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 155, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sale Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 192, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 226, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 144, 136));
        jButton1.setText("Sell");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 297, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(153, 144, 136));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 152, 561, -1));

        jDateChooser1.setDate(new Date());
        jDateChooser1.setDateFormatString("d MMM, yyyy");
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 223, 256, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Background.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -8, -1, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Sale aSale = new Sale();
        aSale.setProduct((Product) jComboBox1.getSelectedItem());

        try {
            int transactionQuantity = Integer.parseInt(jTextField3.getText());
            double totalAmount = Double.parseDouble(jTextField1.getText());

            if (transactionQuantity <= 0) {
                throw new MyException("Sale Quantity can't be less than or equal to 0");
            } else if (totalAmount <= 0) {
                throw new MyException("Total bill can't be less than or equal to 0");
            }

            aSale.setTransactionQuantity(transactionQuantity);
            aSale.setTotalAmount(totalAmount);
        } catch (MyException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "FAILED!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter data in right format.",
                    "ERROR!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        aSale.setOperationDate(jDateChooser1);

        if (aSale.getProduct() != null) {
            String msg = Shop.getShop().addSale(aSale);
            populateProductListComboBox();
            JOptionPane.showMessageDialog(null,
                    msg,
                    "BINGO!",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Please select the product.",
                    "ERROR!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public void populateProductListComboBox() {
        for (Product aProduct : Shop.getShop().getProductList()) {
            jComboBox1.addItem(aProduct);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Product> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
