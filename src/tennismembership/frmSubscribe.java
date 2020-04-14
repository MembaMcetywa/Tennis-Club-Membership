/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class frmSubscribe extends javax.swing.JFrame {

    /**
     * Creates new form frmSubscribe
     */
    public frmSubscribe() {
        initComponents();
        txtSubName.requestFocusInWindow();
    }
    boolean boolSubscriptionExists = false; //Declaration of a boolean variable
    
    //Instantiation of the class clsConnectToDatabase to connect to database
    clsConnectToDatabase clsConnect = new clsConnectToDatabase();  
    
    //Instatiation of the class clsPasswordGenerator to generate subscriber passwords
    clsPasswordGenerator clsPasswordGen = new clsPasswordGenerator();
    
    /**Instantiation of the class frmGetTrainerChooseTime to allow the subscriber to
     * choose if they want to be registered with the trainer or not 
     * and choose training time
     */
    frmGetTrainerChooseTime frmGetTrainer = new frmGetTrainerChooseTime();
    
    //Declaration of static variables to hold subscriber input values
    static String strName, strContactNumber, strAddress, strDOB, strSex, strNextOfKin, strMembership, strPassword;
    
    //A method to get subscriber input values
    private void mGetValuesFromGUI()
    {
        strName = txtSubName.getText();
        strContactNumber = txtSubContactNumber.getText();
        strAddress = txtSubAddress.getText();
        strDOB = dcSubDOB.getSelection().toString().substring(1, 11);
        strSex = cboSubSex.getSelectedItem().toString();
        if(!txtSubNextOfKin.getText().equals(""))
        {
            strNextOfKin = txtSubNextOfKin.getText();
        }
        else
        {
            strNextOfKin = null;
        }
        strMembership = cboSubMembership.getSelectedItem().toString();
        strPassword = clsPasswordGen.mGetPassword().toString();
    }
    
    //A method to discard stored values in the variables
    private void mClearVariables()
    {
        strName = null;
        strContactNumber = null;
        strAddress = null;
        strDOB = null;
        strSex = null;
        strNextOfKin = null;
        strMembership = null;
        strPassword = null;
    }
    
    //A method to clear GUI text boxes 
    private void mClearGUITextBoxes()
    {
        txtSubName.setText("");
        txtSubAddress.setText("");
        txtSubNextOfKin.setText("");
        txtSubContactNumber.setText("");
    }
    
    //A method to check if a made subscription exists or not
    private void mCheckIfSubscriptionExists()
    {
        clsConnect.mConnectToDatabaseTennisClub();
        Statement stStatement = null;
        ResultSet rs = null;
        try
        {
            String strQuery = "SELECT * FROM tblSubscriptions WHERE Name='" + strName.toLowerCase()
                                    +"' AND contactnumber ='"+ strContactNumber.toLowerCase()+"'";
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            boolSubscriptionExists = rs.next();
            stStatement.close();
        }
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null,"Connection String not closed"+""+eX);
        }
    }
    
    //A method to insert subscription details to the database
    private void mSubscribe()
    {
        clsConnect.mConnectToDatabaseTennisClub();
        try
        {
            Statement myStatement;
            String sqlInsert = "INSERT INTO tblSubscriptions " + "(Name, ContactNumber, Address, DOB, Sex, NextOfKin, Membership,"
                    + " HasTrainer, TrainingTime, Password)" + 
                    "VALUES ('" + strName + "','" + strContactNumber+ "','" + strAddress + "','" + strDOB +"','"+
                    strSex+ "','" + strNextOfKin + "','"+ strMembership+"','"+frmGetTrainer.GetWantATrainerAnswer()+"','"
                    +frmGetTrainer.GetTrainingTime()+"','"+strPassword+"')";
            myStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(sqlInsert);
            myStatement.executeUpdate(sqlInsert);
            myStatement.close();
            JOptionPane.showMessageDialog(null, "You have successfully subscribed");
            JOptionPane.showMessageDialog(null, "Log in with this password when your membership has been approved:\n "+strPassword);
	}
        catch(HeadlessException | SQLException eX)
        {
            JOptionPane.showMessageDialog(null, "The subscription could not be made" +" "+eX);
        }
    }
    
    //A method to save subscription details to the database
    public void mSaveSubscriptionDetails()
    {
        mCheckIfSubscriptionExists();
        mSubscribe();
        mClearGUITextBoxes();
        mClearVariables();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskSubscription = new javax.swing.JDesktopPane();
        lblSubscription = new javax.swing.JLabel();
        lblSubName = new javax.swing.JLabel();
        txtSubName = new javax.swing.JTextField();
        lblSubContactNumber = new javax.swing.JLabel();
        txtSubContactNumber = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblSubDOB = new javax.swing.JLabel();
        dcSubDOB = new datechooser.beans.DateChooserCombo();
        lblSex = new javax.swing.JLabel();
        cboSubSex = new javax.swing.JComboBox<>();
        lblSubNextOfKin = new javax.swing.JLabel();
        txtSubNextOfKin = new javax.swing.JTextField();
        lblSubMembership = new javax.swing.JLabel();
        cboSubMembership = new javax.swing.JComboBox<>();
        btnSubRegister = new javax.swing.JButton();
        btnSubClear = new javax.swing.JButton();
        btnSubReturn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSubAddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dskSubscription.setBackground(new java.awt.Color(153, 255, 255));

        lblSubscription.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubscription.setText("Subscription");

        lblSubName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubName.setText("Name");

        lblSubContactNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubContactNumber.setText("Contact Number");

        lblAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAddress.setText("Address");

        lblSubDOB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubDOB.setText("Date Of Birth");

        dcSubDOB.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dcSubDOB.setNothingAllowed(false);
    dcSubDOB.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
    dcSubDOB.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

    lblSex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lblSex.setText("Sex");

    cboSubSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

    lblSubNextOfKin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lblSubNextOfKin.setText("Next Of Kin");

    lblSubMembership.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lblSubMembership.setText("Membership");

    cboSubMembership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner Membership", "Junior Membership", "Advanced Membership", "Professional Membership" }));

    btnSubRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btnSubRegister.setText("Register");
    btnSubRegister.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSubRegisterActionPerformed(evt);
        }
    });

    btnSubClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btnSubClear.setText("Clear");
    btnSubClear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSubClearActionPerformed(evt);
        }
    });

    btnSubReturn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btnSubReturn.setText("Return");
    btnSubReturn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSubReturnActionPerformed(evt);
        }
    });

    txtSubAddress.setColumns(20);
    txtSubAddress.setRows(5);
    jScrollPane1.setViewportView(txtSubAddress);

    dskSubscription.setLayer(lblSubscription, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSubName, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(txtSubName, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSubContactNumber, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(txtSubContactNumber, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSubDOB, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(dcSubDOB, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSex, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(cboSubSex, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSubNextOfKin, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(txtSubNextOfKin, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(lblSubMembership, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(cboSubMembership, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(btnSubRegister, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(btnSubClear, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(btnSubReturn, javax.swing.JLayeredPane.DEFAULT_LAYER);
    dskSubscription.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout dskSubscriptionLayout = new javax.swing.GroupLayout(dskSubscription);
    dskSubscription.setLayout(dskSubscriptionLayout);
    dskSubscriptionLayout.setHorizontalGroup(
        dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskSubscriptionLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblSubName)
                .addComponent(lblSubContactNumber)
                .addComponent(lblAddress)
                .addComponent(lblSubDOB)
                .addComponent(lblSex)
                .addComponent(lblSubNextOfKin)
                .addComponent(lblSubMembership))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(txtSubName)
                .addComponent(txtSubNextOfKin)
                .addComponent(cboSubSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dcSubDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(txtSubContactNumber)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(cboSubMembership, 0, 148, Short.MAX_VALUE))
            .addContainerGap())
        .addGroup(dskSubscriptionLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(lblSubscription)
                .addGroup(dskSubscriptionLayout.createSequentialGroup()
                    .addComponent(btnSubRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(62, 62, 62)
                    .addComponent(btnSubClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
            .addComponent(btnSubReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35))
    );
    dskSubscriptionLayout.setVerticalGroup(
        dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(dskSubscriptionLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblSubscription)
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSubName)
                .addComponent(txtSubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSubContactNumber)
                .addComponent(txtSubContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblAddress)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskSubscriptionLayout.createSequentialGroup()
                    .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblSubDOB)
                        .addComponent(dcSubDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(lblSex))
                .addComponent(cboSubSex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSubNextOfKin)
                .addComponent(txtSubNextOfKin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSubMembership)
                .addComponent(cboSubMembership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, Short.MAX_VALUE)
            .addGroup(dskSubscriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSubRegister)
                .addComponent(btnSubClear)
                .addComponent(btnSubReturn))
            .addGap(28, 28, 28))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(dskSubscription)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(dskSubscription)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubRegisterActionPerformed
        /**The code below check if subscription exists, if it does appropriate
         * message is shown to the user. If the subscription doesn't exist, the
         * code checks if mandatory input text boxes have been passed values, if
         * they have not been passed an appropriate notification is shown, else
         * Values are passed from the GUI input controls to the variables then
         * the instantiation of the class frmGetTrainerChooseTime is shown        * 
         */
        if(boolSubscriptionExists == true)
       	{
            boolSubscriptionExists = false;
            JOptionPane.showMessageDialog(null, "You have subscribed already.");
            mClearVariables();
      	}
        else if(boolSubscriptionExists == false)
        {
            if(txtSubName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Name field cannot be left empty");
                txtSubName.requestFocusInWindow();
            }
            else if(txtSubContactNumber.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The contact number field cannot be left empty");
                txtSubContactNumber.requestFocusInWindow();
            }
            else if(txtSubContactNumber.getText().length() != 10)
            {
               JOptionPane.showMessageDialog(null, "The contact number must be 10 digits");
               txtSubContactNumber.requestFocusInWindow(); 
            }
            else if(txtSubAddress.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The address field cannot be left empty");
                txtSubAddress.requestFocusInWindow();
            }
            else
            {
                mGetValuesFromGUI();
                dskSubscription.add(frmGetTrainer);
                frmGetTrainer.setTitle("Register With A Trainer");
                frmGetTrainer.setLocation(50, 50);
                frmGetTrainer.show();
            }
        }
    }//GEN-LAST:event_btnSubRegisterActionPerformed

    private void btnSubReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubReturnActionPerformed
        /**An instance of the frmLogin class is instantiated, set a title then shown
         * while this form is closed
         */
        
        frmLogin frmlogin = new frmLogin();
        frmlogin.setTitle("Tennis Club Login");
        frmlogin.setLocation(450, 200);
        frmlogin.show();
        this.hide();
    }//GEN-LAST:event_btnSubReturnActionPerformed

    private void btnSubClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubClearActionPerformed
        mClearGUITextBoxes(); //This line of code clears text boxes
    }//GEN-LAST:event_btnSubClearActionPerformed

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
            java.util.logging.Logger.getLogger(frmSubscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSubscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSubscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSubscribe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSubscribe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubClear;
    private javax.swing.JButton btnSubRegister;
    private javax.swing.JButton btnSubReturn;
    private javax.swing.JComboBox<String> cboSubMembership;
    private javax.swing.JComboBox<String> cboSubSex;
    private datechooser.beans.DateChooserCombo dcSubDOB;
    private javax.swing.JDesktopPane dskSubscription;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSubContactNumber;
    private javax.swing.JLabel lblSubDOB;
    private javax.swing.JLabel lblSubMembership;
    private javax.swing.JLabel lblSubName;
    private javax.swing.JLabel lblSubNextOfKin;
    private javax.swing.JLabel lblSubscription;
    private javax.swing.JTextArea txtSubAddress;
    private javax.swing.JTextField txtSubContactNumber;
    private javax.swing.JTextField txtSubName;
    private javax.swing.JTextField txtSubNextOfKin;
    // End of variables declaration//GEN-END:variables
}
