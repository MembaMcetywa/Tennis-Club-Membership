/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

/**
 *
 * @author Sanele
 */
public class frmGetTrainerChooseTime extends javax.swing.JInternalFrame {

    /**
     * Creates new form jinternalGetTrainer
     */
    public frmGetTrainerChooseTime() {
        initComponents();
    }
    String strWantTrainer, strTrainingTime; //String variables to hold subscriber input
    //A method to get subscriber answer about being registered wit a trainer
    public String GetWantATrainerAnswer()
    {
        strWantTrainer = cboWantATrainer.getSelectedItem().toString();
        return strWantTrainer;
    }
    //A method to get subscriber answer about training time
    public String GetTrainingTime()
    {
        strTrainingTime = cboTainingTimes.getSelectedItem().toString();
        return strTrainingTime;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRequireATrainer = new javax.swing.JLabel();
        lblTrainingTimes = new javax.swing.JLabel();
        cboWantATrainer = new javax.swing.JComboBox<>();
        cboTainingTimes = new javax.swing.JComboBox<>();
        btnDone = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));
        setClosable(true);

        lblRequireATrainer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRequireATrainer.setText("Do you require a trainer ?");

        lblTrainingTimes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTrainingTimes.setText("Training Times");

        cboWantATrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        cboTainingTimes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "14:00 - 16:00", "16:00 - 18:00" }));

        btnDone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRequireATrainer)
                    .addComponent(lblTrainingTimes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboWantATrainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTainingTimes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDone)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRequireATrainer)
                    .addComponent(cboWantATrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrainingTimes)
                    .addComponent(cboTainingTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDone)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        /** An instantiation of the class frmSubscribe that
         * accesses the method mSaveSubscriptionDetails() and
         * save subscription details to the database
         */
        frmSubscribe frmSub = new frmSubscribe();
        frmSub.mSaveSubscriptionDetails();
        this.hide();
    }//GEN-LAST:event_btnDoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDone;
    private javax.swing.JComboBox<String> cboTainingTimes;
    private javax.swing.JComboBox<String> cboWantATrainer;
    private javax.swing.JLabel lblRequireATrainer;
    private javax.swing.JLabel lblTrainingTimes;
    // End of variables declaration//GEN-END:variables
}
