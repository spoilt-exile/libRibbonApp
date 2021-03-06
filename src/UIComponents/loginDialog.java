/**
 * This file is part of libRibbonApp library (check README).
 * Copyright (C) 2013 Stanislav Nepochatov
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
**/

package UIComponents;

/**
 * Login dialog class;
 * @author Stanislav Nepochatov <spoilt.exile@gmail.com>
 * @deprecated dialog withot parent had been have strange
 * behavior on Windows OS. Use LoginWindow class instead;
 * @see UIComponents.LoginWindow
 */
public class loginDialog extends javax.swing.JDialog {
    
    /**
     * Parent thread lock;
     */
    private Object LOCK;
    
    /**
     * Link to application object
     */
    private AppComponents.RibbonApplication currApp;

    /**
     * Creates new form loginDialog
     */
    public loginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /**
     * Creates new form loginDialog (with lock and app)
     */
    public loginDialog(java.awt.Frame parent, boolean modal, Object givenLock, AppComponents.RibbonApplication givenApp) {
        super(parent, modal);
        initComponents();
        LOCK = givenLock;
        currApp = givenApp;
        this.errorDisplay.setText("");
        initConnection();
    }
    
    /**
     * Init connection and set window state
     */
    public void initConnection() {
        try {
            currApp.appWorker.start();
            String conResp = currApp.appWorker.sendCommandWithReturn("RIBBON_NCTL_INIT:CLIENT,a2," + System.getProperty("file.encoding"));
            if (conResp.startsWith("OK:")) {
                this.loginButton.setEnabled(true);
                this.loginField.setEditable(true);
                this.passField.setEditable(true);
            } else {
                this.setError(Generic.CsvFormat.parseDoubleStruct(conResp)[1]);
            }
        } catch (NullPointerException ex) {
            this.setError("НЕМАЄ ЗВ'ЯЗКУ!");
        }
    }
    
    /**
     * Set error message.
     * @param errMesg message to display;
     */
    private void setError(String errMesg) {
        this.errorDisplay.setVisible(true);
        this.errorDisplay.setText(errMesg);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        errorDisplay = new javax.swing.JLabel();
        settingsBut = new javax.swing.JButton();
        sessionSwitch = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Увійти до \"Стрічки\"");
        setResizable(false);

        jLabel1.setText("І'мя користувача");

        loginField.setEditable(false);
        loginField.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        passField.setEditable(false);
        passField.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel2.setText("Пароль");

        cancelButton.setText("Відміна");

        loginButton.setText("Увійти");
        loginButton.setEnabled(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        errorDisplay.setForeground(new java.awt.Color(102, 0, 0));
        errorDisplay.setText("error");

        settingsBut.setText("Налаштування");
        settingsBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButActionPerformed(evt);
            }
        });

        sessionSwitch.setText("Запомнить сессию");
        sessionSwitch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sessionSwitchStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passField)
                    .addComponent(loginField)
                    .addComponent(errorDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(settingsBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(sessionSwitch))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sessionSwitch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(loginButton)
                    .addComponent(settingsBut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settingsButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButActionPerformed
        UIComponents.settingsDialog ConfigWindow = new UIComponents.settingsDialog(new javax.swing.JFrame(), true, this.currApp.ApplicationProperties);
        ConfigWindow.setVisible(true);
        setError("");
        this.currApp.SERVER_IP = this.currApp.ApplicationProperties.getProperty("server_address");
        this.currApp.SERVER_PORT = Integer.parseInt(this.currApp.ApplicationProperties.getProperty("server_port"));
        this.currApp.updateProperties();
        try {
            this.currApp.appWorker = currApp.appWorkerClass.getConstructor(AppComponents.RibbonApplication.class).newInstance(currApp);
        } catch (Exception ex) {
            currApp.log(0, "помилка опрацювання класу: " + currApp.appWorkerClass.getName());
            ex.printStackTrace();
            System.exit(7);
        }
        this.initConnection();
    }//GEN-LAST:event_settingsButActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String hashed = this.currApp.getHash(new String(this.passField.getPassword()));
            this.currApp.log(2, hashed);
            String respond = this.currApp.appWorker.sendCommandWithReturn("RIBBON_NCTL_LOGIN:{" + this.loginField.getText()
                    + "}," + hashed);
            if (respond.startsWith("OK:")) {
                if (this.sessionSwitch.isEnabled()) {
                    this.currApp.ApplicationProperties.setProperty("session_id", Generic.CsvFormat.parseDoubleStruct(respond)[1]);
                    this.currApp.updateProperties();
                }
                this.dispose();
            } else {
                this.currApp.log(2, respond);
                setError(respond);
            }
        } catch (NullPointerException ex) {
            this.setError("НЕМАЄ ЗВ'ЯЗКУ!");
        }
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void sessionSwitchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sessionSwitchStateChanged
        if (this.sessionSwitch.isEnabled()) {
            this.currApp.ApplicationProperties.setProperty("remember_session", "1");
        } else {
            this.currApp.ApplicationProperties.setProperty("remember_session", "0");
        }
        this.currApp.updateProperties();
    }//GEN-LAST:event_sessionSwitchStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                loginDialog dialog = new loginDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel errorDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField loginField;
    private javax.swing.JPasswordField passField;
    private javax.swing.JCheckBox sessionSwitch;
    private javax.swing.JButton settingsBut;
    // End of variables declaration//GEN-END:variables
}
