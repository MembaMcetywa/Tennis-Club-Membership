/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Sanele
 */
public class clsReportHandling {
    // Declaring a variable of type File to be used for the docx
    // file and create a document using java.io class
    java.io.File Report;
    
    frmWeeklyPlans frmWP = new frmWeeklyPlans();
    clsConnectToDatabase clsConnect = new clsConnectToDatabase();
        
    private String mGetColumnFromTblMembers(String strQuery)
    {
        String colName = null;
        try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                ResultSet rs = stStatement.executeQuery(strQuery);
                ResultSetMetaData rsmt = rs.getMetaData();
                colName = rsmt.getColumnName(1);
                stStatement.close();
                rs.close();
            }
        }
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical Error, table cannot be displayed\n"+eX);
        }
        return colName;
    }
    
    private int mGetMembersCountInMembership(String strQuery)
    {
       int count = 0;
       try
        {
            try (Statement stStatement = clsConnect.mConnectToDatabaseTennisClub().prepareStatement(strQuery)) {
                stStatement.execute(strQuery);
                ResultSet rs = stStatement.getResultSet();
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
                stStatement.close();
                rs.close();
            }
	}
        catch(SQLException | NullPointerException eX){
            JOptionPane.showMessageDialog(null, "Technical error has been encounterd\n"+eX);
        }
       return count;
    }
    //A method that returns a query that counts members in the Beginner membership option
    private String mMembersInBeginnerMembership()
    {
        return "SELECT COUNT(*) AS Members_In_Beginner_Membership"
                + " FROM tblMembers WHERE membership = 'Beginner Membership'";
    }
    //A method that returns a query that counts members in the Junior membership option
    private String mMembersInJuniorMembership()
    {
        return "SELECT COUNT(*) AS Members_In_Junior_Membership"
                + " FROM tblMembers WHERE membership = 'Junior Membership'";
    }
    //A method that returns a query that counts members in the Advanced membership option
    private String mMembersInAdvancedMembership()
    {
        return "SELECT COUNT(*) AS Members_In_Advanced_Membership"
                + " FROM tblMembers WHERE membership = 'Advanced Membership'";
    }
    //A method that returns a query that counts members in the Professional membership option
    private String mMembersInProfessionalMembership()
    {
        return "SELECT COUNT(*) AS Members_In_Professional_Membership"
                + " FROM tblMembers WHERE membership = 'Professional Membership'";
    }
    //A method that returns a query that counts members registered with a trainer
    private String mMembersWithTrainers()
    {
        return "SELECT COUNT(*) AS Members_With_Trainers FROM tblMembers WHERE HasTrainer = 'Yes'";
    }
    //A method that returns a query that counts members registered without trainers
    private String mMembersWithoutTrainers()
    {
        return "SELECT COUNT(*) AS Members_Without_Trainers FROM tblMembers WHERE HasTrainer = 'No'";
    }
    
    // A method to create a new file
    private void mCreateReportFile()
    {
        Report = new java.io.File(frmWP.mTodayDate()+".docx");
        try
        {
            Report.createNewFile();
        }
        catch(IOException eX)
        {
            JOptionPane.showMessageDialog(null, "Technical error encountered\n"+eX);
        }
    }
    // Check if the contact exists
    private void mCheckReportExists()
    {
        Report = new java.io.File(frmWP.mTodayDate()+".docx");
        if(Report.exists())
        {
            Report.delete();
        }
    }
    //Write report details to the file
    private void mWriteReportDetailsToFile()
    {
        String report = frmWP.mTodayDate()+".docx";
        
        String[] getDetails = new String[6];
        
        getDetails[0] = mGetColumnFromTblMembers(mMembersInBeginnerMembership()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersInBeginnerMembership()));
        getDetails[1] = mGetColumnFromTblMembers(mMembersInJuniorMembership()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersInJuniorMembership()));
        getDetails[2] = mGetColumnFromTblMembers(mMembersInAdvancedMembership()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersInAdvancedMembership())); 
        getDetails[3] = mGetColumnFromTblMembers(mMembersInProfessionalMembership()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersInProfessionalMembership()));
        getDetails[4] = mGetColumnFromTblMembers(mMembersWithTrainers()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersWithTrainers()));
        getDetails[5] = mGetColumnFromTblMembers(mMembersWithoutTrainers()) +": "+
                String.valueOf(mGetMembersCountInMembership(mMembersWithoutTrainers()));

        for(int index = 0; index < getDetails.length; index++)
        {
            try
            {
                java.io.FileWriter fw = new java.io.FileWriter(report, true);
                fw.write(String.valueOf(getDetails[index]+System.getProperty("line.separator")));
                fw.close();
            }
            catch(IOException eX)
            {
                JOptionPane.showMessageDialog(null, eX);
            }
        }
    }
    private void mOpenReportFileWithOfficeApplication()
    {
        try
        {
            Runtime.getRuntime().exec("cmd.exe /c start soffice.exe \""+frmWP.mTodayDate()+".docx\"");
        }
        catch(IOException eX)
        {
            JOptionPane.showMessageDialog(null, eX);
        }
    }
    public void mPrepareWeeklyMembershipReportFile()
    {
        mCheckReportExists();
        mCreateReportFile();
        mWriteReportDetailsToFile();
        mOpenReportFileWithOfficeApplication();
    }
}   