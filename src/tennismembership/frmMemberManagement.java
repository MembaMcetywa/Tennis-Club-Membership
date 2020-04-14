/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



/**
 *
 * @author Sanele
 */
public class frmMemberManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form jinternalMemberManagement
     */
    public frmMemberManagement() {
        initComponents();
        if(frmLogin.strUserIdendifier.equals("Member"))
        {
            cboMemberName.setVisible(false);
        }
    }
    clsMemberQueries clsMemberQ; //Declaration of a variable of the class clsMemberQueries
    clsConsultantQueries clsConsultantQ; //Declaration of a variable of the class clsConsultantQueries
    
    public void mFrmMemberManagementDefaultGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnLoad.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);
    }
    private void mFrmMemberManagementUpdateGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(true);
        txtMemberContactNumber.setEnabled(true);
        txtMemberAddress.setEnabled(true);
        txtMemberDOB.setEnabled(true);
        txtPassword.setEnabled(true);
        cboMemberSex.setEnabled(true);
        txtMemberNextOfKin.setEnabled(true);
        cboMemberMembership.setEnabled(true);
        cboMemberPersonalTrainer.setEnabled(true);
        cboMemberTrainingTime.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(true);
    }
    
    private void mFrmMemberManagementLoadGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnLoad.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }
    
    private void mFrmMemberManagementSaveGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnLoad.setEnabled(true);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);        
    }
    
    private void mFrmMemberManagementDeleteGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnLoad.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);
    }
    
    public void mFrmApproveMembershipDefaultGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnLoad.setEnabled(true);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
    private void mFrmApproveMembershipLoadGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnLoad.setEnabled(false);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
    private void mFrmApproveMembershipDetailsGUIControls()
    {
        cboMemberName.setEnabled(false);
        txtMemberName.setEnabled(true);
        txtMemberContactNumber.setEnabled(true);
        txtMemberAddress.setEnabled(true);
        txtMemberDOB.setEnabled(true);
        txtPassword.setEnabled(true);
        cboMemberSex.setEnabled(true);
        txtMemberNextOfKin.setEnabled(true);
        cboMemberMembership.setEnabled(true);
        cboMemberPersonalTrainer.setEnabled(true);
        cboMemberTrainingTime.setEnabled(true);
        btnLoad.setEnabled(false);
        btnCancel.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
    }
    private void mFrmApproveMembershipApproveGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnLoad.setEnabled(true);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
    private void mFrmApproveMembershipDeclineGUIControls()
    {
        cboMemberName.setEnabled(true);
        txtMemberName.setEnabled(false);
        txtMemberContactNumber.setEnabled(false);
        txtMemberAddress.setEnabled(false);
        txtMemberDOB.setEnabled(false);
        txtPassword.setEnabled(false);
        cboMemberSex.setEnabled(false);
        txtMemberNextOfKin.setEnabled(false);
        cboMemberMembership.setEnabled(false);
        cboMemberPersonalTrainer.setEnabled(false);
        cboMemberTrainingTime.setEnabled(false);
        btnLoad.setEnabled(true);
        btnCancel.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
    private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboMemberName.setModel(model);
    }
    
    private void mClearGUITextBoxes()
    {
        txtMemberName.setText("");
        txtMemberAddress.setText("");
        txtMemberNextOfKin.setText("");
        txtPassword.setText("");
        txtMemberDOB.setText("");
        txtMemberContactNumber.setText("");
    }
    String strName, strContactNumber, strAddress, strDOB, strSex, strNextOfKin, strMembership,
            strHasTrainer, strTrainingTime, strPassword, strComboSelectedName;
    int intID;
    clsConnectToDatabase clsConnect = new clsConnectToDatabase();
    
    //A method that populates GUI input controls with values
    private void mSetValuesToGUI()
    {
        txtMemberName.setText(strName);
        txtMemberContactNumber.setText(strContactNumber);
        txtMemberAddress.setText(strAddress);
        txtMemberDOB.setText(strDOB);
        cboMemberSex.setSelectedItem(strSex);
        if(strNextOfKin.equals("null"))
        {
            txtMemberNextOfKin.setText("");
        }
        else{
            txtMemberNextOfKin.setText(strNextOfKin);
        }
        cboMemberMembership.setSelectedItem(strMembership);
        cboMemberPersonalTrainer.setSelectedItem(strHasTrainer);
        cboMemberTrainingTime.setSelectedItem(strTrainingTime);
        txtPassword.setText(strPassword);
    }
    private void mGetValuesFromGUI()
    {
        strName = txtMemberName.getText();
        strContactNumber = txtMemberContactNumber.getText();
        strAddress = txtMemberAddress.getText();
        strDOB = txtMemberDOB.getText();
        strSex = cboMemberSex.getSelectedItem().toString();
        strNextOfKin = txtMemberNextOfKin.getText();
        strMembership = cboMemberMembership.getSelectedItem().toString();
        strPassword = txtPassword.getText();
        strHasTrainer = cboMemberPersonalTrainer.getSelectedItem().toString();
        strTrainingTime = cboMemberTrainingTime.getSelectedItem().toString();
    }
    
    private void mLoadNamesOfMembers(String strQuery)
    {
        Statement stStatement = null;
        ResultSet rs = null;
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            while(rs.next())
            {
                cboMemberName.addItem(rs.getString(1));
            }
            stStatement.close();
            rs.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null,"A technical error has been encountered"+""+eX);
        }
    }
    private void mUpdateMemberDetails(String strQuery)
    {
        Statement stStatement = null;
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.executeUpdate(strQuery);
            stStatement.close();
            JOptionPane.showMessageDialog(null, "Membership details have been updated");
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, membership details could not be updated\n"+eX);
        }
    }

    private void mDeleteMemberDetails(String strQuery)
    {
        Statement stStatement = null;
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
    	    stStatement.execute(strQuery);
    	    JOptionPane.showMessageDialog(null, "Details have been Deleted");
            stStatement.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, Details could not be deleted\n"+eX);
        }
    }
    
    private void mFetchMemberDetails(String strQuery)
    {
        Statement stStatement = null;
        ResultSet rs = null;
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            while(rs.next())
            {
                intID = rs.getInt(1);
                strName = rs.getString("Name");
                strContactNumber = rs.getString("ContactNumber");
                strAddress = rs.getString("Address");
                strDOB = rs.getString("DOB");
                strSex = rs.getString("Sex");
                strPassword = rs.getString("Password");
                strNextOfKin = rs.getString("NextOfKin");
                strMembership = rs.getString("Membership");
                strHasTrainer = rs.getString("HasTrainer");
                strTrainingTime = rs.getString("TrainingTime");
            }
            stStatement.close();
            rs.close();
	}
        catch(SQLException eX){
            JOptionPane.showMessageDialog(null, "Technical error has been encounterd\n"+eX);
        }
    }
    //A method to approve membership thereby creating a new membership account
    private void mApproveMembership(String strQuery)
    {
        try
        {
            Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.executeUpdate(strQuery);
            stStatement.close();
            JOptionPane.showMessageDialog(null, "Membership Approved");
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Membership could not be approved"+eX);
        }
    }
    //A method to set the GUI of the Approve Membership form
    public void mSetApproveMembershipGUI()
    {
        btnUpdate.setText("Approve");
        btnDelete.setText("Decline");
        btnSave.setText("Details");
    }
    //A method to set what information is displayed on the View Membership form
    public void mSetViewMembersForm()
    {
        if(frmLogin.strUserIdendifier.equals("Consultant"))
        {
            mViewMemberDetails(clsConsultantQueries.mViewMembers());
        }
        else if(frmLogin.strUserIdendifier.equals("Member"))
        {
            mViewMemberDetails(clsMemberQueries.mViewMembers());
        }
    }
    private void mViewMemberDetails(String strQuery)
    {
        Statement stSQLQuery = null;
        ResultSet rs = null;
        
        try
        {
            stSQLQuery = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            rs = stSQLQuery.executeQuery(strQuery);
            ResultSetMetaData rsmt = rs.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            for(int i = 1; i <= intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            Vector vData = new Vector();
            Vector vRow = new Vector();
            while(rs.next())
            {
                vRow = new Vector(intColumnCount);
                for(int i = 1; i <= intColumnCount; i++)
                {
                    vRow.add(rs.getObject(i));
                }
                vData.add(vRow);
            }
            JPanel pnlTable = new JPanel();
            JTable tblMembers = new JTable(vData, vColumn);
            tblMembers.setFillsViewportHeight(true);
            JScrollPane jspMemberPane = new JScrollPane(tblMembers);
            tblMembers.setVisible(true);
            tblMembers.validate();
            pnlTable.setLayout(new GridLayout(1,0));
            pnlTable.add(jspMemberPane);
            this.setResizable(true);
            this.setContentPane(pnlTable);
            
            stSQLQuery.close();
            rs.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Technical Error, table cannot be displayed\n"+eX);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMemberName = new javax.swing.JTextField();
        lblMemberName = new javax.swing.JLabel();
        lblMemberContactNumber = new javax.swing.JLabel();
        txtMemberContactNumber = new javax.swing.JTextField();
        lblMemberAddress = new javax.swing.JLabel();
        lblMemberDateOfBirth = new javax.swing.JLabel();
        lblMemberSex = new javax.swing.JLabel();
        cboMemberSex = new javax.swing.JComboBox<>();
        lblMemberNextOfKin = new javax.swing.JLabel();
        txtMemberNextOfKin = new javax.swing.JTextField();
        lblMemberPersonalTrainer = new javax.swing.JLabel();
        lblMemberTrainingTime = new javax.swing.JLabel();
        cboMemberTrainingTime = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblMemberMembership = new javax.swing.JLabel();
        cboMemberMembership = new javax.swing.JComboBox<>();
        spAddress = new javax.swing.JScrollPane();
        txtMemberAddress = new javax.swing.JTextArea();
        cboMemberPersonalTrainer = new javax.swing.JComboBox<>();
        lblMemberPassword = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        cboMemberName = new javax.swing.JComboBox<>();
        txtMemberDOB = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 255));
        setClosable(true);

        lblMemberName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberName.setText("Name");

        lblMemberContactNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberContactNumber.setText("Contact Number");

        txtMemberContactNumber.setToolTipText("");

        lblMemberAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberAddress.setText("Address");

        lblMemberDateOfBirth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberDateOfBirth.setText("Date of Birth");

        lblMemberSex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberSex.setText("Sex");

        cboMemberSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        lblMemberNextOfKin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberNextOfKin.setText("Next Of Kin");

        lblMemberPersonalTrainer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberPersonalTrainer.setText("Has personal trainer ?");

        lblMemberTrainingTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberTrainingTime.setText("Training Time");

        cboMemberTrainingTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "14:00 - 16:00", "16:00 - 18:00" }));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblMemberMembership.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberMembership.setText("Membership");

        cboMemberMembership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner Membership", "Junior Membership", "Advanced Membership", "Professional Membership" }));

        txtMemberAddress.setColumns(20);
        txtMemberAddress.setRows(5);
        spAddress.setViewportView(txtMemberAddress);

        cboMemberPersonalTrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        lblMemberPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMemberPassword.setText("Password");

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMemberMembership)
                            .addComponent(lblMemberNextOfKin)
                            .addComponent(lblMemberPersonalTrainer)
                            .addComponent(lblMemberTrainingTime)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboMemberPersonalTrainer, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMemberMembership, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMemberNextOfKin)
                                    .addComponent(cboMemberTrainingTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(cboMemberName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMemberContactNumber)
                            .addComponent(lblMemberName))
                        .addGap(269, 269, 269)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMemberContactNumber)
                            .addComponent(txtMemberName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMemberAddress)
                            .addComponent(lblMemberDateOfBirth)
                            .addComponent(lblMemberPassword)
                            .addComponent(lblMemberSex))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spAddress)
                            .addComponent(txtMemberDOB)
                            .addComponent(txtPassword)
                            .addComponent(cboMemberSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberName)
                    .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMemberContactNumber)
                    .addComponent(txtMemberContactNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMemberAddress)
                    .addComponent(spAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberDateOfBirth)
                    .addComponent(txtMemberDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberSex)
                    .addComponent(cboMemberSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMemberNextOfKin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMemberNextOfKin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMemberMembership, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboMemberMembership, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberPersonalTrainer)
                    .addComponent(cboMemberPersonalTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMemberTrainingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMemberTrainingTime))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnLoad)
                    .addComponent(btnCancel))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(btnUpdate.getText().equals("Update"))
        {
            mFrmMemberManagementUpdateGUIControls();
            if(frmLogin.strUserIdendifier.equals("Consultant"))
            {
                clsConsultantQ = new clsConsultantQueries(cboMemberName.getSelectedItem().toString());
                mFetchMemberDetails(clsConsultantQueries.mFetchMemberDetails());
                mSetValuesToGUI();
                txtMemberName.requestFocusInWindow();
            }
        }
        else if(btnUpdate.getText().equals("Approve"))
        {
            mFrmApproveMembershipApproveGUIControls();
            mGetValuesFromGUI();
            clsConsultantQ = new clsConsultantQueries(strName, strContactNumber,
                            strAddress, strDOB, strSex, strNextOfKin, strMembership,
                            strHasTrainer, strTrainingTime, strPassword, strComboSelectedName, intID);
            mApproveMembership(clsConsultantQueries.mApproveSubscription());
            mClearGUITextBoxes();
            mClearComboBox();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        switch(btnSave.getText())
        {
            case "Details":
                mFrmApproveMembershipDetailsGUIControls();
                clsConsultantQ = new clsConsultantQueries(cboMemberName.getSelectedItem().toString());
                mFetchMemberDetails(clsConsultantQ.mFetchSubscribers());
                mSetValuesToGUI();
                break;
            case "Save":
                mFrmMemberManagementSaveGUIControls();
                switch(frmLogin.strUserIdendifier)
                {
                    case "Member":
                        mGetValuesFromGUI();
                        clsMemberQ = new clsMemberQueries(strName, strContactNumber,
                            strAddress, strDOB, strSex, strNextOfKin, strMembership,
                            strHasTrainer, strTrainingTime, strPassword);
                        mUpdateMemberDetails(clsMemberQueries.mUpdateMemberDetails());
                        mClearGUITextBoxes();
                        break;
                    case "Consultant":
                        mGetValuesFromGUI();
                        clsConsultantQ = new clsConsultantQueries(strName, strContactNumber,
                            strAddress, strDOB, strSex, strNextOfKin, strMembership,
                            strHasTrainer, strTrainingTime, strPassword, strComboSelectedName, intID);
                        mUpdateMemberDetails(clsConsultantQueries.mUpdateMemberDetails());
                        mClearComboBox();
                        mClearGUITextBoxes();
                        break;
                    default:
                        break;
                }
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        if(btnUpdate.getText().equals("Update"))
        {
            mFrmMemberManagementLoadGUIControls();
            switch(frmLogin.strUserIdendifier)
            {
                case "Member":
                    mFetchMemberDetails(clsMemberQueries.mFetchMemberDetails());
                    mSetValuesToGUI();
                    txtMemberName.requestFocusInWindow();
                    break;
                case "Consultant":
                    mLoadNamesOfMembers(clsConsultantQueries.mLoadNamesOfMembers());
                    break;
                default:
                    break;
            }
                    
        }
        else if(btnUpdate.getText().equals("Approve"))
        {
            mFrmApproveMembershipLoadGUIControls();
            mClearComboBox();
            mLoadNamesOfMembers(clsConsultantQueries.mLoadSubscribersNames());
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        switch(btnUpdate.getText())
        {
            case "Update":
                mFrmMemberManagementDefaultGUIControls();
                mClearGUITextBoxes();
                if(frmLogin.strUserIdendifier.equals("Consultant"))
                {
                   mClearComboBox();
                }
            break;
            case "Approve":
                mFrmApproveMembershipDefaultGUIControls();
                mClearGUITextBoxes();
                mClearComboBox();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(btnDelete.getText().equals("Delete"))
        {
            mFrmMemberManagementDeleteGUIControls();
            switch(frmLogin.strUserIdendifier)
            {
                case "Member":
                    mDeleteMemberDetails(clsMemberQueries.mDeleteMemberDetails());
                    mClearGUITextBoxes();
                    this.hide();
                    this.getTopLevelAncestor().hide();
                    frmLogin frmlogin = new frmLogin();
                    frmlogin.setLocation(450, 200);
                    frmlogin.show();
                    break;
                case "Consultant":
                    clsConsultantQ = new clsConsultantQueries(cboMemberName.getSelectedItem().toString());
                    mFetchMemberDetails(clsConsultantQueries.mFetchMemberDetails());
                    clsConsultantQ = new clsConsultantQueries(strName, strContactNumber,
                            strAddress, strDOB, strSex, strNextOfKin, strMembership,
                            strHasTrainer, strTrainingTime, strPassword, strComboSelectedName, intID);
                    mDeleteMemberDetails(clsConsultantQueries.mDeleteMemberDetails());
                    mClearGUITextBoxes();
                    mClearComboBox();
                    break;
                default:
                    break;
            }
                    
        }
        else if(btnDelete.getText().equals("Decline"))
        {
            mFrmApproveMembershipDeclineGUIControls();
            mDeleteMemberDetails(clsConsultantQueries.mDeclineSubscription());
            mClearComboBox();
            mClearGUITextBoxes();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboMemberMembership;
    private javax.swing.JComboBox<String> cboMemberName;
    private javax.swing.JComboBox<String> cboMemberPersonalTrainer;
    private javax.swing.JComboBox<String> cboMemberSex;
    private javax.swing.JComboBox<String> cboMemberTrainingTime;
    private javax.swing.JLabel lblMemberAddress;
    private javax.swing.JLabel lblMemberContactNumber;
    private javax.swing.JLabel lblMemberDateOfBirth;
    private javax.swing.JLabel lblMemberMembership;
    private javax.swing.JLabel lblMemberName;
    private javax.swing.JLabel lblMemberNextOfKin;
    private javax.swing.JLabel lblMemberPassword;
    private javax.swing.JLabel lblMemberPersonalTrainer;
    private javax.swing.JLabel lblMemberSex;
    private javax.swing.JLabel lblMemberTrainingTime;
    private javax.swing.JScrollPane spAddress;
    private javax.swing.JTextArea txtMemberAddress;
    private javax.swing.JTextField txtMemberContactNumber;
    private javax.swing.JTextField txtMemberDOB;
    private javax.swing.JTextField txtMemberName;
    private javax.swing.JTextField txtMemberNextOfKin;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
