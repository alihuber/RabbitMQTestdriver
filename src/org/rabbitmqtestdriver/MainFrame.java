package org.rabbitmqtestdriver;

import java.awt.Color;

public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        mainTabPane = new javax.swing.JTabbedPane();
        settingsPanel = new javax.swing.JPanel();
        ipAddressLabel = new javax.swing.JLabel();
        ipAddressTextField = new javax.swing.JTextField();
        vHostNameTextField = new javax.swing.JTextField();
        vHostNameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        saveSettingsButton = new javax.swing.JButton();
        smokeTestPanel = new javax.swing.JPanel();
        smokeTestQueueNameLabel = new javax.swing.JLabel();
        smokeTestQueueNameTextField = new javax.swing.JTextField();
        smokeTestMessageTextLabel = new javax.swing.JLabel();
        smokeTestMessageTextTextField = new javax.swing.JTextField();
        smokeTestSendButton = new javax.swing.JButton();
        smokeTestFloodButton = new javax.swing.JButton();
        smokeTestFloodSpinner = new javax.swing.JSpinner();
        smokeTestSingleLabel = new javax.swing.JLabel();
        smokeTestFloodLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainTabPane.setName("SmokeTestTab"); // NOI18N

        ipAddressLabel.setText("Broker IP Address");

        ipAddressTextField.setName(""); // NOI18N

        vHostNameLabel.setText("VHost Name");

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        saveSettingsButton.setText("Save");
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipAddressLabel)
                            .addComponent(vHostNameLabel)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField)
                            .addComponent(vHostNameTextField)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(ipAddressTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveSettingsButton)))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipAddressLabel)
                    .addComponent(ipAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vHostNameLabel)
                    .addComponent(vHostNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addContainerGap())
        );

        mainTabPane.addTab("Settings", settingsPanel);

        smokeTestQueueNameLabel.setText("Queue Name");

        smokeTestMessageTextLabel.setText("Message Text");

        smokeTestSendButton.setText("Send");
        smokeTestSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokeTestSendButtonActionPerformed(evt);
            }
        });

        smokeTestFloodButton.setText("Flood");
        smokeTestFloodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smokeTestFloodButtonActionPerformed(evt);
            }
        });

        smokeTestFloodSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10000, 1));

        smokeTestSingleLabel.setText("Send single message");

        smokeTestFloodLabel.setText("Send # random messages");

        javax.swing.GroupLayout smokeTestPanelLayout = new javax.swing.GroupLayout(smokeTestPanel);
        smokeTestPanel.setLayout(smokeTestPanelLayout);
        smokeTestPanelLayout.setHorizontalGroup(
            smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smokeTestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smokeTestPanelLayout.createSequentialGroup()
                        .addComponent(smokeTestSendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(smokeTestFloodSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smokeTestFloodButton))
                    .addGroup(smokeTestPanelLayout.createSequentialGroup()
                        .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(smokeTestMessageTextLabel)
                            .addComponent(smokeTestQueueNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(smokeTestMessageTextTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(smokeTestQueueNameTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smokeTestPanelLayout.createSequentialGroup()
                        .addComponent(smokeTestSingleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(smokeTestFloodLabel)))
                .addContainerGap())
        );
        smokeTestPanelLayout.setVerticalGroup(
            smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smokeTestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smokeTestQueueNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smokeTestQueueNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smokeTestMessageTextLabel)
                    .addComponent(smokeTestMessageTextTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smokeTestFloodLabel)
                    .addComponent(smokeTestSingleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(smokeTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smokeTestFloodButton)
                    .addComponent(smokeTestFloodSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smokeTestSendButton))
                .addGap(5, 5, 5))
        );

        mainTabPane.addTab("Smoke Test", smokeTestPanel);

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void smokeTestSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokeTestSendButtonActionPerformed
        if("Send".equals(evt.getActionCommand())) {
            String queueName = smokeTestQueueNameTextField.getText();
            String message = smokeTestMessageTextTextField.getText();
            try {
                SmokeTest smokeTest = new SmokeTest(Main.brokerConnection, 
                        queueName, message);
                String returnMessage = smokeTest.sendSingleMessage();
                this.statusLabel.setText(returnMessage);
            } catch (Exception ex) {
                this.statusLabel.setForeground(Color.red);
                String errorMessage = ex.getMessage();
                String truncatedError = 
                        errorMessage.substring(0, Math.min(errorMessage.length(), 50));
                if(errorMessage.length() > 50) {
                     this.statusLabel.setText(truncatedError + "...");
                } else {
                    this.statusLabel.setText(errorMessage);
                }
            }
        }
    }//GEN-LAST:event_smokeTestSendButtonActionPerformed

    private void saveSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsButtonActionPerformed
        if(evt.getActionCommand().equals("Save")) {
            String hostname = this.ipAddressTextField.getText();
            String vhostName = this.vHostNameTextField.getText();
            String username = this.usernameTextField.getText();
            char[] password;
            password = this.passwordTextField.getPassword();
            Main.brokerConnection = new BrokerConnection(hostname, vhostName, username, password);
            this.statusLabel.setText("Set broker connection");
        }
    }//GEN-LAST:event_saveSettingsButtonActionPerformed

    private void smokeTestFloodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smokeTestFloodButtonActionPerformed
        if(evt.getActionCommand().equals("Flood")) {
            String queueName = this.smokeTestQueueNameTextField.getText();
            int amount;
            amount = (int) this.smokeTestFloodSpinner.getValue();
            SmokeTest smokeTest = new SmokeTest(Main.brokerConnection, queueName);
            boolean bulkReturn = smokeTest.sendBulkMessages(amount);
        }
    }//GEN-LAST:event_smokeTestFloodButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JTextField ipAddressTextField;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JButton saveSettingsButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JButton smokeTestFloodButton;
    private javax.swing.JLabel smokeTestFloodLabel;
    private javax.swing.JSpinner smokeTestFloodSpinner;
    private javax.swing.JLabel smokeTestMessageTextLabel;
    private javax.swing.JTextField smokeTestMessageTextTextField;
    private javax.swing.JPanel smokeTestPanel;
    private javax.swing.JLabel smokeTestQueueNameLabel;
    private javax.swing.JTextField smokeTestQueueNameTextField;
    private javax.swing.JButton smokeTestSendButton;
    private javax.swing.JLabel smokeTestSingleLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel vHostNameLabel;
    private javax.swing.JTextField vHostNameTextField;
    // End of variables declaration//GEN-END:variables
}
