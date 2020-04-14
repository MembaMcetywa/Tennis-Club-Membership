/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class frmMainWindow extends javax.swing.JFrame {

    /**
     * Creates new form frmMainWindow
     */
    public frmMainWindow() {
        initComponents();
    }
         
    public static String strUserStatus; //A static variable to hold the user atatus
    
    //A method to grant users priviledges inside the application
    public void mSetStatusRights()
    {
        switch(strUserStatus)
        {
            case "JUNIOR MEMBERSHIP":               
                mnuMenuFile.setEnabled(true);
                miMenuItemViewMembers.setEnabled(true);
                miMenuItemUpdateAndDeleteMemberRecord.setEnabled(true);
                miMenuItemApproveSubscriptions.setVisible(false);
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setEnabled(true);
                mnuMenuConsultantAccountManagement.setVisible(false);
                mnuMenuReports.setVisible(false);
                break;
                case "BEGINNER MEMBERSHIP":               
                mnuMenuFile.setEnabled(true);
                miMenuItemViewMembers.setEnabled(true);
                miMenuItemUpdateAndDeleteMemberRecord.setEnabled(true);
                miMenuItemApproveSubscriptions.setVisible(false);
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setEnabled(true);
                mnuMenuConsultantAccountManagement.setVisible(false);
                mnuMenuReports.setVisible(false);
                break;
                case "ADVANCED MEMBERSHIP":               
                mnuMenuFile.setEnabled(true);
                miMenuItemViewMembers.setEnabled(true);
                miMenuItemUpdateAndDeleteMemberRecord.setEnabled(true);
                miMenuItemApproveSubscriptions.setVisible(false);
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setEnabled(true);
                mnuMenuConsultantAccountManagement.setVisible(false);
                mnuMenuReports.setVisible(false);
                break;
                case "PROFESSIONAL MEMBERSHIP":               
                mnuMenuFile.setEnabled(true);
                miMenuItemViewMembers.setEnabled(true);
                miMenuItemUpdateAndDeleteMemberRecord.setEnabled(true);
                miMenuItemApproveSubscriptions.setVisible(false);
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setEnabled(true);
                mnuMenuConsultantAccountManagement.setVisible(false);
                mnuMenuReports.setVisible(false);
                break;
            case "JUNIOR CONSULTANT":
                mnuMenuFile.setEnabled(true);
                miMenuItemViewMembers.setEnabled(true);
                miMenuItemUpdateAndDeleteMemberRecord.setEnabled(true);
                miMenuItemApproveSubscriptions.setVisible(false);
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setVisible(false);
                mnuMenuConsultantAccountManagement.setEnabled(true);
                mnuMenuReports.setEnabled(true);
                break;
            case "SENIOR CONSULTANT":
                mnuMenuFile.setEnabled(true);
                mnuMenuMembershipAccountManagement.setEnabled(true);
                if(frmLogin.intUserID == 0)
                {
                    miMenuItemApproveSubscriptions.setEnabled(false);
                }
                mnuMenuClubWebsite.setEnabled(true);
                mnuMenuWeeklyPlans.setVisible(false);
                mnuMenuConsultantAccountManagement.setEnabled(true);
                mnuMenuReports.setEnabled(true);
                break;
                default:
                   break;
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

        dskMainWindow = new javax.swing.JDesktopPane();
        lblIcon = new javax.swing.JLabel();
        mbTennisMenuBar = new javax.swing.JMenuBar();
        mnuMenuFile = new javax.swing.JMenu();
        miMenuItemExit = new javax.swing.JMenuItem();
        miMenuItemLogOut = new javax.swing.JMenuItem();
        mnuMenuMembershipAccountManagement = new javax.swing.JMenu();
        miMenuItemApproveSubscriptions = new javax.swing.JMenuItem();
        miMenuItemViewMembers = new javax.swing.JMenuItem();
        miMenuItemUpdateAndDeleteMemberRecord = new javax.swing.JMenuItem();
        mnuMenuWeeklyPlans = new javax.swing.JMenu();
        miMenuItemPlanYourWeek = new javax.swing.JMenuItem();
        mnuMenuConsultantAccountManagement = new javax.swing.JMenu();
        miMenuItemConsultantAccountManagement = new javax.swing.JMenuItem();
        miMenuItemConsultantAccountView = new javax.swing.JMenuItem();
        mnuMenuReports = new javax.swing.JMenu();
        miMenuItemMembershipWeeklyReport = new javax.swing.JMenuItem();
        mnuMenuClubWebsite = new javax.swing.JMenu();
        miMenuItemOpenWebsite = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tennis Club");
        setBackground(new java.awt.Color(153, 255, 255));
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        dskMainWindow.setBackground(new java.awt.Color(153, 255, 255));

        lblIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sanele\\Documents\\Systems Development\\Y3\\Semester B\\HPRXS3B\\FA1\\Screenshot (363).png")); // NOI18N
        dskMainWindow.add(lblIcon);
        lblIcon.setBounds(450, 200, 360, 280);

        getContentPane().add(dskMainWindow);
        dskMainWindow.setBounds(0, -10, 1360, 730);

        mnuMenuFile.setText("File");

        miMenuItemExit.setText("Exit");
        miMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemExitActionPerformed(evt);
            }
        });
        mnuMenuFile.add(miMenuItemExit);

        miMenuItemLogOut.setText("Log Out");
        miMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemLogOutActionPerformed(evt);
            }
        });
        mnuMenuFile.add(miMenuItemLogOut);

        mbTennisMenuBar.add(mnuMenuFile);

        mnuMenuMembershipAccountManagement.setText("Membership Account Management");

        miMenuItemApproveSubscriptions.setText("Approve Subscriptions");
        miMenuItemApproveSubscriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemApproveSubscriptionsActionPerformed(evt);
            }
        });
        mnuMenuMembershipAccountManagement.add(miMenuItemApproveSubscriptions);

        miMenuItemViewMembers.setText("View Membership Details");
        miMenuItemViewMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemViewMembersActionPerformed(evt);
            }
        });
        mnuMenuMembershipAccountManagement.add(miMenuItemViewMembers);

        miMenuItemUpdateAndDeleteMemberRecord.setText("Update and Delete Member Details");
        miMenuItemUpdateAndDeleteMemberRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemUpdateAndDeleteMemberRecordActionPerformed(evt);
            }
        });
        mnuMenuMembershipAccountManagement.add(miMenuItemUpdateAndDeleteMemberRecord);

        mbTennisMenuBar.add(mnuMenuMembershipAccountManagement);

        mnuMenuWeeklyPlans.setText("Weekly Plans");

        miMenuItemPlanYourWeek.setText("Plan Your Week");
        miMenuItemPlanYourWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemPlanYourWeekActionPerformed(evt);
            }
        });
        mnuMenuWeeklyPlans.add(miMenuItemPlanYourWeek);

        mbTennisMenuBar.add(mnuMenuWeeklyPlans);

        mnuMenuConsultantAccountManagement.setText("Consultant Account Management");

        miMenuItemConsultantAccountManagement.setText("Consultant Account Management");
        miMenuItemConsultantAccountManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemConsultantAccountManagementActionPerformed(evt);
            }
        });
        mnuMenuConsultantAccountManagement.add(miMenuItemConsultantAccountManagement);

        miMenuItemConsultantAccountView.setText("View Consultant Accounts");
        miMenuItemConsultantAccountView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemConsultantAccountViewActionPerformed(evt);
            }
        });
        mnuMenuConsultantAccountManagement.add(miMenuItemConsultantAccountView);

        mbTennisMenuBar.add(mnuMenuConsultantAccountManagement);

        mnuMenuReports.setText("Reports");

        miMenuItemMembershipWeeklyReport.setText("Membership Weekly Report");
        miMenuItemMembershipWeeklyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemMembershipWeeklyReportActionPerformed(evt);
            }
        });
        mnuMenuReports.add(miMenuItemMembershipWeeklyReport);

        mbTennisMenuBar.add(mnuMenuReports);

        mnuMenuClubWebsite.setText("Club Website");

        miMenuItemOpenWebsite.setText("Open Website");
        miMenuItemOpenWebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMenuItemOpenWebsiteActionPerformed(evt);
            }
        });
        mnuMenuClubWebsite.add(miMenuItemOpenWebsite);

        mbTennisMenuBar.add(mnuMenuClubWebsite);

        setJMenuBar(mbTennisMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemExitActionPerformed
        System.exit(0); //A line of code to exit the application
    }//GEN-LAST:event_miMenuItemExitActionPerformed

    private void miMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemLogOutActionPerformed
        //Lines of code to open the login form and close this one
        frmLogin frmlogin = new frmLogin();
        frmlogin.setTitle("Tennis Club Login");
        frmlogin.setLocation(450, 200);
        frmlogin.show();
        this.hide();
    }//GEN-LAST:event_miMenuItemLogOutActionPerformed

    private void miMenuItemViewMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemViewMembersActionPerformed
        //Lines of code to show an internal form that displays membership details
        frmMemberManagement jinternalViewMembers = new frmMemberManagement();
        jinternalViewMembers.mSetViewMembersForm();
        jinternalViewMembers.setTitle("Member Details");
        dskMainWindow.add(jinternalViewMembers);
        jinternalViewMembers.setLocation(380, 50);
        jinternalViewMembers.show();
    }//GEN-LAST:event_miMenuItemViewMembersActionPerformed

    private void miMenuItemUpdateAndDeleteMemberRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemUpdateAndDeleteMemberRecordActionPerformed
        //Lines of code to show an internal form that allows updating and deletion of membership details
        frmMemberManagement jinternalUpdateDelete = new frmMemberManagement();
        jinternalUpdateDelete.setTitle("Update and Delete Member Details");
        jinternalUpdateDelete.mFrmMemberManagementDefaultGUIControls();
        dskMainWindow.add(jinternalUpdateDelete);
        jinternalUpdateDelete.setLocation(380, 50);;
        jinternalUpdateDelete.show();
    }//GEN-LAST:event_miMenuItemUpdateAndDeleteMemberRecordActionPerformed

    private void miMenuItemApproveSubscriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemApproveSubscriptionsActionPerformed
        /**Lines of code to show an internal form that allows senior consultants to approve 
         * or decline membership subscription
         */ 
        frmMemberManagement jiApproveMembership = new frmMemberManagement();
        jiApproveMembership.mSetApproveMembershipGUI();
        jiApproveMembership.setTitle("Approve and Decline Membership Subscription");
        jiApproveMembership.mFrmApproveMembershipDefaultGUIControls();
        dskMainWindow.add(jiApproveMembership);
        jiApproveMembership.setLocation(380, 50);
        jiApproveMembership.show();
    }//GEN-LAST:event_miMenuItemApproveSubscriptionsActionPerformed

    private void miMenuItemConsultantAccountManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemConsultantAccountManagementActionPerformed
        /**Lines of code to show an internal form that allows creation, updating and deleting
         * of consultant accounts
         */
        frmConsultantManagement frmConsultantMgmt = new frmConsultantManagement();
        frmConsultantMgmt.setTitle("Consultant Account Management");
        dskMainWindow.add(frmConsultantMgmt);
        frmConsultantMgmt.setLocation(450, 100);
        frmConsultantMgmt.show();
    }//GEN-LAST:event_miMenuItemConsultantAccountManagementActionPerformed

    private void miMenuItemConsultantAccountViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemConsultantAccountViewActionPerformed
        //Lines of code to view cosultant account details
        frmConsultantManagement frmViewAccounts = new frmConsultantManagement();
        switch(strUserStatus)
        {
            case "JUNIOR CONSULTANT":
                frmViewAccounts.mViewConsultantAccountDetails(frmConsultantManagement.mJnrConsultantViewQuery());
                break;
            case "SENIOR CONSULTANT":
                frmViewAccounts.mViewConsultantAccountDetails(frmConsultantManagement.mSnrConsultantViewQuery());
                break;
        }
        dskMainWindow.add(frmViewAccounts);
        frmViewAccounts.setTitle("Consultant Details");
        frmViewAccounts.setLocation(450, 100);
        frmViewAccounts.show();
    }//GEN-LAST:event_miMenuItemConsultantAccountViewActionPerformed

    private void miMenuItemOpenWebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemOpenWebsiteActionPerformed
        String url = "http://localhost/TennisMembership/index.php";
        if(Desktop.isDesktopSupported() &&
                Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
            Desktop desktop = Desktop.getDesktop();
            try{
                desktop.browse(new URI(url));
            }catch(IOException | URISyntaxException eX){
                JOptionPane.showMessageDialog(null,"A technical error has been encountered\n"+ eX);
            }
        }
        else{
            Runtime runtime = Runtime.getRuntime();
            try{
                runtime.exec("xdg-open " + url);
            }catch(IOException eX){
                JOptionPane.showMessageDialog(null,"A technical error has been encountered\n"+ eX);
            }
        }
    }//GEN-LAST:event_miMenuItemOpenWebsiteActionPerformed

    private void miMenuItemPlanYourWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemPlanYourWeekActionPerformed
        frmWeeklyPlans frmWP = new frmWeeklyPlans();
        frmWP.setTitle("Plan Your Week");
        dskMainWindow.add(frmWP);
        frmWP.setLocation(380, 50);
        frmWP.show();
    }//GEN-LAST:event_miMenuItemPlanYourWeekActionPerformed

    private void miMenuItemMembershipWeeklyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMenuItemMembershipWeeklyReportActionPerformed
        clsReportHandling clsRH = new clsReportHandling();
        clsRH.mPrepareWeeklyMembershipReportFile();
    }//GEN-LAST:event_miMenuItemMembershipWeeklyReportActionPerformed

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
            java.util.logging.Logger.getLogger(frmMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskMainWindow;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JMenuBar mbTennisMenuBar;
    private javax.swing.JMenuItem miMenuItemApproveSubscriptions;
    private javax.swing.JMenuItem miMenuItemConsultantAccountManagement;
    private javax.swing.JMenuItem miMenuItemConsultantAccountView;
    private javax.swing.JMenuItem miMenuItemExit;
    private javax.swing.JMenuItem miMenuItemLogOut;
    private javax.swing.JMenuItem miMenuItemMembershipWeeklyReport;
    private javax.swing.JMenuItem miMenuItemOpenWebsite;
    private javax.swing.JMenuItem miMenuItemPlanYourWeek;
    private javax.swing.JMenuItem miMenuItemUpdateAndDeleteMemberRecord;
    private javax.swing.JMenuItem miMenuItemViewMembers;
    private javax.swing.JMenu mnuMenuClubWebsite;
    private javax.swing.JMenu mnuMenuConsultantAccountManagement;
    private javax.swing.JMenu mnuMenuFile;
    private javax.swing.JMenu mnuMenuMembershipAccountManagement;
    private javax.swing.JMenu mnuMenuReports;
    private javax.swing.JMenu mnuMenuWeeklyPlans;
    // End of variables declaration//GEN-END:variables
}
