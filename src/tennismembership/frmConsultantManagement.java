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
public class frmConsultantManagement extends javax.swing.JInternalFrame {

    /**
     * Creates new form jinternalReports
     */
    public frmConsultantManagement() {
        initComponents();
        /**If the logged in user is a Junior consultant
         * button create and the consultant rank combo box
         * are deactivated
         */
        if(frmMainWindow.strUserStatus.equals("JUNIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(false);
            btnCreate.setEnabled(false);
        }
        mDefaultGUIControls();
    }
    
    clsConnectToDatabase clsConnect = new clsConnectToDatabase();
    boolean boolAccountExists = false;
    Boolean boolUpdate = false;
    Boolean boolCreate = false;
    int intConsultantID;
    frmMainWindow frmMain = new frmMainWindow();
    
    //A method to load to the form default GUI controls
    private void mDefaultGUIControls()
    {
        txtName.setEnabled(false);
        txtPassword.setEnabled(false);
        cboConsultantName.setEnabled(true);
        if(frmMainWindow.strUserStatus.equals("SENIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(false);
            btnCreate.setEnabled(true);
        }
        btnLoad.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    //A method to load the button Load GUI controls when the button is clicked
    private void mLoadGUIControls()
    {
        txtName.setEnabled(false);
        txtPassword.setEnabled(false);
        cboConsultantName.setEnabled(true);
        if(frmMainWindow.strUserStatus.equals("SENIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(false);
            btnCreate.setEnabled(true);
        }
        btnLoad.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(true);
    }
    //A method to load the button Update GUI controls when the button is clicked
    private void mUpdateGUIControls()
    {
        txtName.setEnabled(true);
        txtPassword.setEnabled(true);
        cboConsultantName.setEnabled(false);
        if(frmMainWindow.strUserStatus.equals("SENIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(true);
            btnCreate.setEnabled(false);
        }
        btnLoad.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    //A method to load the button Save GUI controls when the button is clicked
    private void mSaveGUIControls()
    {
        txtName.setEnabled(false);
        txtPassword.setEnabled(false);
        cboConsultantName.setEnabled(false);
        if(frmMainWindow.strUserStatus.equals("SENIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(false);
            btnCreate.setEnabled(true);
        }
        btnLoad.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    //A method to load the button Create GUI controls when the button is clicked
    private void mCreateGUIControls()
    {
        txtName.setEnabled(true);
        txtPassword.setEnabled(true);
        cboConsultantRank.setEnabled(true);
        cboConsultantName.setEnabled(false);
        btnCreate.setEnabled(false);
        btnLoad.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    //A method to load the button Delete GUI controls when the button is clicked
    private void mDeleteGUIControls()
    {
        txtName.setEnabled(false);
        txtPassword.setEnabled(false);
        cboConsultantName.setEnabled(false);
        if(frmMainWindow.strUserStatus.equals("SENIOR CONSULTANT"))
        {
            cboConsultantRank.setEnabled(false);
            btnCreate.setEnabled(true);
        }
        btnLoad.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    //A method to clear a combo box 
    private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboConsultantName .setModel(model);
    }
       
    //A method that returns senior consultant query that gets details of a selected consultant
    private String mSnrConsultantQueryGetAccountDetails()
    {
        String strQuery = "SELECT * FROM tblConsultants WHERE Name='" + 
                cboConsultantName.getSelectedItem().toString()+"'";
        return strQuery;
    }
    //A method that returns senior consultant query that fetch names of all consultants
    private String mSnrLoadConsultantNames()
    {
        String strQuery = "SELECT Name FROM tblConsultants";
        return strQuery;
    }
    //A method that returns junior consultant query that loads their name to the combo box
    private String mJnrLoadConsultantName()
    {
        String strQuery = "SELECT Name FROM tblConsultants WHERE ConsultantID ='"+frmLogin.intUserID+"'";
        return strQuery;
    }
    //A method that returns junior consultant query that fetches their details from the database
    private String mJnrConsultantQueryGetAccountDetails()
    {
        String strQuery = "SELECT * FROM tblConsultants WHERE ConsultantID='" + 
                frmLogin.intUserID+"'";
        return strQuery;
    }
    //A method that returns junior consultant query that updates their consultant account details
    private String mJnrConsultantUpdateQuery()
    {
        String strQuery = "UPDATE tblConsultants SET Name ='"+txtName.getText() +"', Password = '"+ txtPassword.getText()+
                   "'WHERE ConsultantID ="+frmLogin.intUserID;
        return strQuery;
   }
    //A method that returns senior consultant query that updates consultant account details
    private String mSnrConsultantUpdateQuery()
    {
        String strQuery = "UPDATE tblConsultants SET Name ='"+txtName.getText()+"', Password = '"+ txtPassword.getText()+
                    "', Rank ='" + cboConsultantRank.getSelectedItem().toString()+
                "'WHERE ConsultantID ="+intConsultantID;
        return strQuery;
    }
    //A method that returns junior consultant query that deletes their consultant account details
    private String mJnrConsultantDeleteQuery()
    {
        String strQuery ="DELETE FROM tblConsultants WHERE ConsultantID ='"+ frmLogin.intUserID+"'";
        return strQuery;
    }
    //A method that returns senior consultant query that deletes consultant account details
    private String mSnrConsultantDeleteQuery()
    {
        String strQuery = "DELETE FROM tblConsultants WHERE ConsultantID ='"+intConsultantID+"'";
        return strQuery;
    }
    //A static method that returns senior consultant query that views all consultant accounts 
    public static String mSnrConsultantViewQuery()
    {
        String strQuery ="SELECT ConsultantID, Name, Rank, Password  FROM tblConsultants";
        return strQuery;
    }
    //A static method that returns junior consultant query that views their consultant account details
    public static String mJnrConsultantViewQuery()
    {
        String strQuery ="SELECT * FROM tblConsultants WHERE ConsultantID ='"+frmLogin.intUserID+"'";
        return strQuery;
    }
    //A method that clears text boxes
    private void mClearGUITextBoxes()
    {
        txtName.setText("");
        txtPassword.setText("");
    }
    //A method that checks if a consultant account exists
    private void mCheckIfAccountExists()
    {
        clsConnect.mConnectToDatabaseTennisClub();
        Statement stStatement = null;
        ResultSet rs = null;
        try
        {
            String strQuery = "SELECT * FROM tblConsultants WHERE Name='" + txtName.getText()
                                    +"'AND Password ='"+ txtPassword.getText()+"'AND Rank ='"+
                                    cboConsultantRank.getSelectedItem().toString()+"'";
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            boolAccountExists = rs.next();
            stStatement.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null,"Connection String not closed"+""+eX);
        }
    }
    //A method that create a consultant account
    private void mAddConsultantAccount()
    {
        clsConnect.mConnectToDatabaseTennisClub();
        try
        {
            Statement myStatement;
            String sqlInsert = "INSERT INTO tblConsultants " + "(Name, Password, Rank)" + 
                    "VALUES ('" + txtName.getText() + "','" +txtPassword.getText()+ "','" + 
                    cboConsultantRank.getSelectedItem().toString()+"')";
            myStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(sqlInsert);
            myStatement.executeUpdate(sqlInsert);
            myStatement.close();
            JOptionPane.showMessageDialog(null, "Account has been created");
	}
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "The account could not be created" +" "+eX);
        }
    }
    /**A method that checks if an account exist, in the event that it doesn't, 
     * saves to the database the created consultant account 
     */
    public void mSaveAccountDetails()
    {
        mCheckIfAccountExists();
        mAddConsultantAccount();
    }
    //A method that fetches account details and store them in variables
    private void mFetchConsultantAccountDetails(String strQuery)
    {
        Statement stStatement = null;
        ResultSet rs = null;
        clsConnect.mConnectToDatabaseTennisClub();
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            while(rs.next())
            {
                intConsultantID = rs.getInt("ConsultantID");
                txtName.setText(rs.getString("Name"));
                txtPassword.setText(rs.getString("Password"));
                cboConsultantRank.setSelectedItem(rs.getString("Rank"));
            }
            stStatement.close();
	}
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error has been encounterd"+""+eX);
        }
    }
    /**A method that loads consultant name(s) and populate
     * the cboConsultantName with returned name(s)
     */
    private void mLoadNamesOfConsultant(String strQuery)
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
                cboConsultantName.addItem(rs.getString(1));
            }
            stStatement.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null,"A technical error has been encountered"+""+eX);
        }
    }
    //A method that updates consultant account
    private void mUpdateConsultantAccount(String strQuery)
    {
        clsConnect.mConnectToDatabaseTennisClub();
        Statement stStatement = null;
        try
        {
            stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery);
            stStatement.executeUpdate(strQuery);
            stStatement.close();
            JOptionPane.showMessageDialog(null, "Consultant details have been updated");
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, consultant details could not be updated"+""+eX);
        }
    }
    private void mDeleteConsultantAccount(String strQuery)
    {
        clsConnect.mConnectToDatabaseTennisClub();
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
            JOptionPane.showMessageDialog(null, "Technical error, Details could not be deleted"+eX);
        }
    }
    //A method that views consultant details in a tabular format
    public void mViewConsultantAccountDetails(String strQuery)
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
            mTable(vData, vColumn);
            stSQLQuery.close();
            rs.close();
        }
        catch(Exception eX)
        {
            JOptionPane.showMessageDialog(null, "Technical Error, table cannot be displayed"+""+eX);
        }
    }
    //A method that create a table and populate it with data from the database
    private void mTable(Vector vData, Vector vColumn)
    {
        
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboConsultantName = new javax.swing.JComboBox<>();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblRank = new javax.swing.JLabel();
        cboConsultantRank = new javax.swing.JComboBox<>();
        btnLoad = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));
        setClosable(true);

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Name");

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPassword.setText("Password");

        lblRank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRank.setText("Rank");

        cboConsultantRank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Junior Consultant", "Senior Consultant" }));

        btnLoad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboConsultantName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRank, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addGap(108, 108, 108)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboConsultantRank, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboConsultantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRank)
                    .addComponent(cboConsultantRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnCreate)
                .addGap(18, 18, 18)
                .addComponent(btnLoad)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateGUIControls();
        mClearGUITextBoxes();
        txtName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate = true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        mLoadGUIControls();
        switch(frmMainWindow.strUserStatus)
        {
            case "JUNIOR CONSULTANT":
                mLoadNamesOfConsultant(mJnrLoadConsultantName());
                mFetchConsultantAccountDetails(mJnrConsultantQueryGetAccountDetails());
                break;
            case "SENIOR CONSULTANT":
                mLoadNamesOfConsultant(mSnrLoadConsultantNames());
                break;
        }  
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateGUIControls();
        switch(frmMainWindow.strUserStatus)
        {
            case "SENIOR CONSULTANT":
                mFetchConsultantAccountDetails(mSnrConsultantQueryGetAccountDetails());
                txtName.requestFocusInWindow();
                btnDelete.setText("Cancel");btnDelete.setText("Cancel");
                boolUpdate = true;
                break;
            case "JUNIOR CONSULTANT":
                mFetchConsultantAccountDetails(mJnrConsultantQueryGetAccountDetails());
                txtName.requestFocusInWindow();
                btnDelete.setText("Cancel");btnDelete.setText("Cancel");
                boolUpdate = true;
                break;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        mSaveGUIControls();
        if(boolCreate == true)
        {
            if(txtName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Name field cannot be left empty");
                txtName.requestFocusInWindow();
            }
            else if(txtPassword.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The Password field cannot be left empty");
                txtPassword.requestFocusInWindow();
            }
            else if(!txtName.getText().equals("") && !txtPassword.getText().equals(""))
            {        
                mCheckIfAccountExists();
                if(boolAccountExists == true)
                {
                    boolAccountExists = false;
                    JOptionPane.showMessageDialog(null, "Account already exists.");
                }
                else if(boolAccountExists== false)
                {
                    boolCreate = false;
                    mAddConsultantAccount();
                    mClearGUITextBoxes();
                    mClearComboBox();
                }
            }
        }
        else if(boolUpdate == true)
        {
            boolUpdate = false;
            switch(frmMainWindow.strUserStatus)
            {
                case "JUNIOR CONSULTANT":
                    mUpdateConsultantAccount(mJnrConsultantUpdateQuery());
                    mClearGUITextBoxes();
                    mClearComboBox();
                    break;
                case "SENIOR CONSULTANT":
                    mUpdateConsultantAccount(mSnrConsultantUpdateQuery());
                    mClearGUITextBoxes();
                    mClearComboBox();
                    break;
            }
        }
        btnDelete.setText("Delete");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        mDeleteGUIControls();
        if("Delete".equals(btnDelete.getText()))
        {
            switch(frmMainWindow.strUserStatus)
            {
                case "JUNIOR CONSULTANT":
                    mFetchConsultantAccountDetails(mJnrConsultantQueryGetAccountDetails());
                    mDeleteConsultantAccount(mJnrConsultantDeleteQuery());
                    mClearComboBox();
                    mClearGUITextBoxes();
                    break;
                case "SENIOR CONSULTANT":
                    mFetchConsultantAccountDetails(mSnrConsultantQueryGetAccountDetails());
                    mDeleteConsultantAccount(mSnrConsultantDeleteQuery());
                    mClearComboBox();
                    mClearGUITextBoxes();
                    break;
            }
        }
        else if("Cancel".equals(btnDelete.getText()))
        {
            switch(frmMainWindow.strUserStatus)
            {
                case "JUNIOR CONSULTANT":
                    mClearGUITextBoxes();
                    mClearComboBox();
                    btnDelete.setText("Delete");
                    break;
                case "SENIOR CONSULTANT":
                    mClearGUITextBoxes();
                    mClearComboBox();
                    btnDelete.setText("Delete");
                    break;
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboConsultantName;
    private javax.swing.JComboBox<String> cboConsultantRank;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRank;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
