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
public class clsMemberQueries {
    
    static String strName, strContactNumber, strAddress, strDOB, strSex, strNextOfKin, strMembership, strHasTrainer, strTrainingTime, strPassword;
    /**A constructor of the class clsMemberQueries that 
     * assigns passed values to the class variables
     * @param name
     * @param No
     * @param address
     * @param dOB
     * @param sex
     * @param nxtKin
     * @param membership
     * @param hasTrainer
     * @param time
     * @param password 
     */
    public clsMemberQueries(String name, String No, String address, String dOB, String sex, String nxtKin, String membership,
                            String hasTrainer, String time, String password)
    {
        clsMemberQueries.strName = name;
        clsMemberQueries.strContactNumber = No;
        clsMemberQueries.strAddress = address;
        clsMemberQueries.strDOB = dOB;
        clsMemberQueries.strSex = sex;
        clsMemberQueries.strNextOfKin = nxtKin;
        clsMemberQueries.strMembership = membership;
        clsMemberQueries.strHasTrainer = hasTrainer;
        clsMemberQueries.strTrainingTime = time;
        clsMemberQueries.strPassword = password;
    }
    //A static method that returns a member query that updates their membership details
    public static String mUpdateMemberDetails()
    {
        return "UPDATE tblMembers SET Name ='"+strName+"', ContactNumber = '"+ strContactNumber+
                "', Address = '"+strAddress+"', DOB = '"+strDOB+"', Password = '"+strPassword+"', Sex = '"+strSex+
                "', NextofKin = '"+ strNextOfKin+"', Membership = '"+strMembership+"', HasTrainer = '"+strHasTrainer+
                "', TrainingTime = '"+strTrainingTime+"'WHERE MemberID ="+ frmLogin.intUserID;
    }
    //A static method that returns a member query that deletes their membership details
    public static String mDeleteMemberDetails()
    {
        return "DELETE FROM tblMembers WHERE MemberID ='"+frmLogin.intUserID+"'";
    }
    /**A static method that returns a member query that fetches their membership
     * details from the database 
     * @return 
     */
    public static String mFetchMemberDetails()
    {
        return "SELECT * FROM tblMembers WHERE MemberID ='"+ frmLogin.intUserID+"'";
    }
    //A static method that returns a member query thatis used to view their membership details
    public static String mViewMembers()
    {
        return "SELECT MemberID, Name, ContactNumber, Address,"
                + "DOB, Sex, Password, NextOfKin, Membership, HasTrainer, TrainingTime,"
                + "SubscriptionID, ConsultantID FROM tblMembers WHERE MemberID ='"+frmLogin.intUserID+"'";
    }
}