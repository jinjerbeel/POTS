/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrator;

import SalesManager.SM_dashboard;
import PurchaseManager.ItemFrame;
import InventoryManager.ItemsFrame;
import FinanceManager.FinanceMenu;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.util.Base64;


public class LoginForm extends javax.swing.JFrame {

    private final UserService userService;
    
    public LoginForm() {
        initComponents();
        userService = new UserService();
        // Clear default password text
        passwordField.setText("");
        // Center the form on screen
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

        SignInBtn = new javax.swing.JButton();
        userNameTxt = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SignInBtn.setText("Sign In");
        SignInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInBtnActionPerformed(evt);
            }
        });

        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });

        passwordField.setText("jPasswordField1");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(SignInBtn))
                            .addComponent(passwordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SignInBtn)
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInBtnActionPerformed
        String username = userNameTxt.getText().trim();
        String password = new String(passwordField.getPassword());
        
        
        try {
            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Username and password cannot be empty",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Verify credentials using UserService
            if (userService.verifyPassword(username, password)) {
                User user = userService.findUserByUsername(username);
                if (user != null) {
                    // Update last login time
                    user.updateLastLogin();
                    userService.saveUsers();
                    
                    // Show success message
                    JOptionPane.showMessageDialog(this,
                        "Welcome " + user.getFullName(),
                        "Login Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    if (user.getRoles().contains(Role.ADMIN)) {
                        
                    }
                    else if (user.getRoles().contains(Role.SALES_MANAGER)) {
                        UserSession.getInstance().startSession(user);
                        new SalesManager.SM_dashboard().setVisible(true);
                        this.dispose();
                    }
                    else if (user.getRoles().contains(Role.PURCHASE_MANAGER)) {
                        UserSession.getInstance().startSession(user);
                        new PurchaseManager.ItemFrame().setVisible(true);
                        this.dispose();
                    }
                    else if (user.getRoles().contains(Role.INVENTORY_MANAGER)) {
                        UserSession.getInstance().startSession(user);
                        new InventoryManager.ItemsFrame().setVisible(true);
                        this.dispose();
                    }
                    else if (user.getRoles().contains(Role.FINANCE_MANAGER)) {
                        UserSession.getInstance().startSession(user);
                        new FinanceManager.FinanceMenu().setVisible(true);
                        this.dispose();
                    }
        else {
            JOptionPane.showMessageDialog(this,
                "No dashboard available for assigned role",
                "Access Error",
                JOptionPane.ERROR_MESSAGE);
        }
                    // Close login form
                    this.dispose();
                    
                } else {
                    throw new RuntimeException("User not found after verification");
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Invalid username or password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
                passwordField.setText(""); // Clear password field
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "An error occurred during login: " + e.getMessage(),
                "System Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_SignInBtnActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
        passwordField.requestFocusInWindow();
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
        SignInBtn.doClick();
    }//GEN-LAST:event_passwordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignInBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
