/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Sanele
 */
public class frmWeeklyPlans extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmWeeklyPlans
     */
    public frmWeeklyPlans() {
        initComponents();
        mFrmWeeklyPlansDefaultGUIControls();
        mSetDefaultGUI();
    }
    
    private void mFrmWeeklyPlansDefaultGUIControls()
    {
        cboPlanList.setEnabled(false);
        txtEventName.setEnabled(false);
        cboTimePeriod.setEnabled(false);
        dcEventDatePicker.setEnabled(false);
        btnAddEvent.setEnabled(true);
        btnLoadEvents.setEnabled(true);
        btnViewEvents.setEnabled(true);
        btnUpdateEvent.setEnabled(false);
        btnDeleteEvent.setEnabled(false);
        btnSaveEvent.setEnabled(false);
        btnCancelEvent.setEnabled(false);
    }
    private void mFrmWeeklyPlansUpdateGUIControls()
    {
        cboPlanList.setEnabled(false);
        txtEventName.setEnabled(true);
        cboTimePeriod.setEnabled(true);
        dcEventDatePicker.setEnabled(false);
        btnUpdateEvent.setEnabled(false);
        btnLoadEvents.setEnabled(false);
        btnAddEvent.setEnabled(false);
        btnViewEvents.setEnabled(false);
        btnDeleteEvent.setEnabled(false);
        btnSaveEvent.setEnabled(true);
        btnCancelEvent.setEnabled(true);
    }
    private void mFrmWeeklyPlansLoadGUIControls()
    {
        cboPlanList.setEnabled(true);
        txtEventName.setEnabled(false);
        cboTimePeriod.setEnabled(false);
        dcEventDatePicker.setEnabled(false);
        btnUpdateEvent.setEnabled(true);
        btnLoadEvents.setEnabled(false);
        btnDeleteEvent.setEnabled(true);
        btnViewEvents.setEnabled(false);
        btnSaveEvent.setEnabled(false);
        btnCancelEvent.setEnabled(false);
    }
    private void mFrmWeeklyPlansCreateGUIControls()
    {
        mFrmWeeklyPlansUpdateGUIControls();
        dcEventDatePicker.setEnabled(true);
    }
    private void mFrmWeeklyPlansSaveGUIControls()
    {
        mFrmWeeklyPlansDefaultGUIControls();
    }
    private void mFrmWeeklyPlansDeleteGUIControls()
    {
        mFrmWeeklyPlansDefaultGUIControls();
    }
    
    String eventName, eventPeriod, eventDate;    
    int eventID;
    
    clsConnectToDatabase clsConnect = new clsConnectToDatabase();
    
    private void mGetEventDetailsFromGUI()
    {
        eventName = txtEventName.getText();
        eventDate = mFormatEventDate();
        eventPeriod = cboTimePeriod.getSelectedItem().toString();
    }
    
    private void mSetValuesToGUI()
    {
        txtEventName.setText(eventName);
        cboTimePeriod.setSelectedItem(eventPeriod);
    }
    private void mSetDefaultGUI()
    {
        lblEventDate.setVisible(false);
        txtEventDate.setVisible(false);
    }
    private void mSetEventDateUpdate()
    {
        lblEventDate.setVisible(true);
        txtEventDate.setVisible(true);
        txtEventDate.setText(eventDate);
    }
    
    private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboPlanList.setModel(model);
    }
    private void mClearGUIControls()
    {
        txtEventName.setText(null);
        mClearComboBox();
    }
    
    private String mFormatEventDate()
    {   
        Date dt = dcEventDatePicker.getSelectedDate().getTime();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        return sm.format(dt);
    }
    public String mTodayDate()
    {
        Date dt = new Date();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        return sm.format(dt);
    }
    private String mSevenDaysIntoTheFutureDate()
    {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, 7); // Adds 7 days
        Date dt = c.getTime();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        return sm.format(dt);
    }
    
    private String mLoadWeeklyEventsQuery()
    {
        return "SELECT EventName FROM tblWeeklyEvents WHERE MemberID='"+frmLogin.intUserID+
                "' AND EventDate BETWEEN '"+mTodayDate()+"' AND '"+mSevenDaysIntoTheFutureDate()+"'";
    }
    private void mLoadWeeklyEvents(String strQuery)
    {
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.execute(strQuery);
                try (ResultSet rs = stStatement.getResultSet()) {
                    while(rs.next())
                    {
                        cboPlanList.addItem(rs.getString(1));
                    }
                    stStatement.close();
                    rs.close();
                }
            }
        }
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null,"A technical error has been encountered\n"+eX);
        }
    }
    
    private String mUpdateWeeklyEventQuery()
    {
        return "UPDATE tblWeeklyEvents SET EventName ='"+txtEventName.getText()+"', EventDate='"+
                txtEventDate.getText()+"', EventTime='"+cboTimePeriod.getSelectedItem().toString()+"' WHERE EventID='"+eventID+"'";        
    }
    private void mUpdateWeeklyEvent(String strQuery)
    {
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.executeUpdate(strQuery);
                stStatement.close();
            }
            JOptionPane.showMessageDialog(null, "Event details have been updated");
        }
        catch(HeadlessException | SQLException | NullPointerException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, Event details could not be updated\n"+eX);
        }
    }
    
    private String mDeleteWeeklyEventQuery()
    {
        return "DELETE FROM tblWeeklyEvents WHERE EventID='"+eventID+
                "' AND EventDate BETWEEN '"+mTodayDate()+"' AND '"+mSevenDaysIntoTheFutureDate()+"'";
    }
    private void mDeleteWeeklyEvent(String strQuery)
    {
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.execute(strQuery);
                JOptionPane.showMessageDialog(null, "Event Details have been Deleted");
                stStatement.close();
            }
        }
        catch(HeadlessException | SQLException | NullPointerException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, Event Details could not be deleted\n"+eX);
        }
    }
    
    private String mFetchWeeklyEventDetailsQuery()
    {
        String  strQuery = "";
        try
        {
            strQuery = "SELECT * FROM tblWeeklyEvents WHERE EventName='"+cboPlanList.getSelectedItem().toString()+"'AND MemberID='"+frmLogin.intUserID
                    +"' AND EventDate BETWEEN '"+mTodayDate()+"' AND '"+mSevenDaysIntoTheFutureDate()+"'";
        }
        catch(NullPointerException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error, No Event Selected\n"+eX);
        }
        return strQuery;
    }
    private void mFetchWeeklyEventDetails(String strQuery)
    {
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.execute(strQuery);
                ResultSet rs = stStatement.getResultSet();
                while(rs.next())
                {
                    eventID = rs.getInt(1);
                    eventName = rs.getString("EventName");
                    eventDate = rs.getDate("EventDate").toString();
                    eventPeriod = rs.getString("EventTime");
                }
                stStatement.close();
                rs.close();
            }
	}
        catch(SQLException | NullPointerException eX){
            JOptionPane.showMessageDialog(null, "Technical error has been encounterd\n"+eX);
        }
    }
    private String mAddEventDetailsQuery()
    {
        return "INSERT INTO tblWeeklyEvents" + "(EventName, EventDate, EventTime, MemberID)"+
                "VALUES('"+ eventName + "','" + eventDate + "','" + eventPeriod + "','" + frmLogin.intUserID + "')";
    }
    //A method to approve membership thereby creating a new membership account
    private void mAddEventDetails(String strQuery)
    {
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.executeUpdate(strQuery);
                stStatement.close();
            }
            JOptionPane.showMessageDialog(null, "Event Created");
        }
        catch(HeadlessException | SQLException eX)
        {
            JOptionPane.showMessageDialog(null, "Event could not be created"+eX);
        }
    }
    
    private String mViewWeeklyEventsQuery()
    {
        return "SELECT EventName, EventDate, EventTime FROM tblWeeklyEvents WHERE MemberID='"+
                frmLogin.intUserID+"' AND EventDate BETWEEN '"+mTodayDate()+"' AND '"+mSevenDaysIntoTheFutureDate()+"'";
    }
    private void mViewWeeklyEvents(String strQuery)
    {
        try
        {
            try (Statement stSQLQuery = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                ResultSet rs = stSQLQuery.executeQuery(strQuery);
                ResultSetMetaData rsmt = rs.getMetaData();
                int intColumnCount = rsmt.getColumnCount();
                Vector vColumn = new Vector(intColumnCount);
                for(int i = 1; i <= intColumnCount; i++)
                {
                    vColumn.add(rsmt.getColumnName(i));
                }   Vector vData = new Vector();
                Vector vRow = new Vector();
                while(rs.next())
                {
                    vRow = new Vector(intColumnCount);
                    for(int i = 1; i <= intColumnCount; i++)
                    {
                        vRow.add(rs.getObject(i));
                    }
                    vData.add(vRow);
                }   JPanel pnlTable = new JPanel();
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
        }
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical Error, table cannot be displayed"+""+eX);
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

        cboPlanList = new javax.swing.JComboBox<>();
        lblEventName = new javax.swing.JLabel();
        dcEventDatePicker = new datechooser.beans.DateChooserPanel();
        txtEventName = new javax.swing.JTextField();
        lblTimePeriod = new javax.swing.JLabel();
        cboTimePeriod = new javax.swing.JComboBox<>();
        btnAddEvent = new javax.swing.JButton();
        btnViewEvents = new javax.swing.JButton();
        btnUpdateEvent = new javax.swing.JButton();
        btnDeleteEvent = new javax.swing.JButton();
        btnSaveEvent = new javax.swing.JButton();
        btnLoadEvents = new javax.swing.JButton();
        btnCancelEvent = new javax.swing.JButton();
        lblEventDate = new javax.swing.JLabel();
        txtEventDate = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 255));
        setClosable(true);

        lblEventName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEventName.setText("Event Name");

        dcEventDatePicker.setCalendarBackground(new java.awt.Color(153, 255, 255));
        dcEventDatePicker.setNavigateFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 11));

        lblTimePeriod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTimePeriod.setText("Time Period");

        cboTimePeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "14:00 - 16:00", "16:00 - 18:00" }));

        btnAddEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddEvent.setText("Add Event");
        btnAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEventActionPerformed(evt);
            }
        });

        btnViewEvents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnViewEvents.setText("View Events");
        btnViewEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEventsActionPerformed(evt);
            }
        });

        btnUpdateEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateEvent.setText("Update Event");
        btnUpdateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEventActionPerformed(evt);
            }
        });

        btnDeleteEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteEvent.setText("Delete Event");
        btnDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEventActionPerformed(evt);
            }
        });

        btnSaveEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveEvent.setText("Save Event");
        btnSaveEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEventActionPerformed(evt);
            }
        });

        btnLoadEvents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLoadEvents.setText("Load Events");
        btnLoadEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadEventsActionPerformed(evt);
            }
        });

        btnCancelEvent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelEvent.setText("Cancel Event");
        btnCancelEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEventActionPerformed(evt);
            }
        });

        lblEventDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEventDate.setText("Event Date");

        txtEventDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEventName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboPlanList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcEventDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLoadEvents, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(btnAddEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnViewEvents)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdateEvent))
                            .addComponent(btnDeleteEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTimePeriod)
                            .addComponent(lblEventDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEventDate)
                            .addComponent(cboTimePeriod, 0, 230, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboPlanList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEventName)
                    .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dcEventDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEventDate)
                    .addComponent(txtEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimePeriod)
                    .addComponent(cboTimePeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddEvent)
                    .addComponent(btnViewEvents)
                    .addComponent(btnUpdateEvent)
                    .addComponent(btnSaveEvent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteEvent)
                    .addComponent(btnLoadEvents)
                    .addComponent(btnCancelEvent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEventActionPerformed
        mFrmWeeklyPlansCreateGUIControls();
        txtEventName.requestFocusInWindow();
    }//GEN-LAST:event_btnAddEventActionPerformed

    private void btnViewEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEventsActionPerformed
        mViewWeeklyEvents(mViewWeeklyEventsQuery());
    }//GEN-LAST:event_btnViewEventsActionPerformed

    private void txtEventDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventDateActionPerformed

    private void btnUpdateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEventActionPerformed
        mFrmWeeklyPlansUpdateGUIControls();
        btnSaveEvent.setText("Save-Update");
        mFetchWeeklyEventDetails(mFetchWeeklyEventDetailsQuery());
        mSetEventDateUpdate();
        mSetValuesToGUI();
        txtEventName.requestFocusInWindow();
    }//GEN-LAST:event_btnUpdateEventActionPerformed

    private void btnLoadEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadEventsActionPerformed
        mFrmWeeklyPlansLoadGUIControls();
        mLoadWeeklyEvents(mLoadWeeklyEventsQuery());
    }//GEN-LAST:event_btnLoadEventsActionPerformed

    private void btnSaveEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEventActionPerformed
        mFrmWeeklyPlansSaveGUIControls();
        switch(btnSaveEvent.getText())
        {
            case "Save Event":
                mGetEventDetailsFromGUI();
                if(eventName.equals("") || eventDate.equals("")){
                    JOptionPane.showMessageDialog(null, "Both event name and date must be provided\n"
                            + " for the event to be created");
                }
                else
                {
                    mAddEventDetails(mAddEventDetailsQuery());
                    mClearGUIControls();
                }
                break;
            case "Save-Update":
                if(txtEventName.getText().equals("") || txtEventDate.getText().equals(""))
                {
                   JOptionPane.showMessageDialog(null, "Both event name and date must be provided\n"
                            + " for the event to be updated"); 
                }
                else
                {
                    mGetEventDetailsFromGUI();
                    mUpdateWeeklyEvent(mUpdateWeeklyEventQuery());
                    mClearGUIControls();
                    mSetDefaultGUI();
                }
                btnSaveEvent.setText("Save Event");
                break;
        }
    }//GEN-LAST:event_btnSaveEventActionPerformed

    private void btnDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEventActionPerformed
        mFrmWeeklyPlansDeleteGUIControls();
        mFetchWeeklyEventDetails(mFetchWeeklyEventDetailsQuery());
        mDeleteWeeklyEvent(mDeleteWeeklyEventQuery());
        mClearComboBox();
    }//GEN-LAST:event_btnDeleteEventActionPerformed

    private void btnCancelEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEventActionPerformed
        mClearGUIControls();
        mFrmWeeklyPlansDefaultGUIControls();
        mSetDefaultGUI();
        btnSaveEvent.setText("Save Event");
    }//GEN-LAST:event_btnCancelEventActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEvent;
    private javax.swing.JButton btnCancelEvent;
    private javax.swing.JButton btnDeleteEvent;
    private javax.swing.JButton btnLoadEvents;
    private javax.swing.JButton btnSaveEvent;
    private javax.swing.JButton btnUpdateEvent;
    private javax.swing.JButton btnViewEvents;
    private javax.swing.JComboBox<String> cboPlanList;
    private javax.swing.JComboBox<String> cboTimePeriod;
    private datechooser.beans.DateChooserPanel dcEventDatePicker;
    private javax.swing.JLabel lblEventDate;
    private javax.swing.JLabel lblEventName;
    private javax.swing.JLabel lblTimePeriod;
    private javax.swing.JTextField txtEventDate;
    private javax.swing.JTextField txtEventName;
    // End of variables declaration//GEN-END:variables
}
