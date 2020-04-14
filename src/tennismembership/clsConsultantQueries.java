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
public class clsConsultantQueries {
    static String strName, strContactNumber, strAddress, strDOB, strSex, strNextOfKin, strMembership,
            strHasTrainer, strTrainingTime, strPassword, strComboSelectedName;
    static int intMemberID;
    
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
        strHasTrainer = null;
        strTrainingTime = null;
        strComboSelectedName = null;
        intMemberID = 0;
    }
    /**A constructor of the class clsConsultantQueries that 
     * assign passed values to the class variables
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
     * @param CboSelect
     * @param ID 
     */
    public clsConsultantQueries(String name, String No, String address, String dOB, String sex, 
                                String nxtKin, String membership, String hasTrainer, String time,
                                String password, String CboSelect, int ID)
    {
        mClearVariables();
        clsConsultantQueries.strName = name;
        clsConsultantQueries.strContactNumber = No;
        clsConsultantQueries.strAddress = address;
        clsConsultantQueries.strDOB = dOB;
        clsConsultantQueries.strSex = sex;
        clsConsultantQueries.strNextOfKin = nxtKin;
        clsConsultantQueries.strMembership = membership;
        clsConsultantQueries.strHasTrainer = hasTrainer;
        clsConsultantQueries.strTrainingTime = time;
        clsConsultantQueries.strPassword = password;
        clsConsultantQueries.strComboSelectedName = CboSelect;
        clsConsultantQueries.intMemberID = ID;
    }
    /**A constructor of the class clsConsultantQueries 
     * that assigns a passed value to the class variable
     * @param cboSelect 
     */
    public clsConsultantQueries(String cboSelect)
    {
        mClearVariables();
        clsConsultantQueries.strComboSelectedName = cboSelect;
    }
    //A method that returns a query to load names of the members
    public static String mLoadNamesOfMembers()
    {
        return "SELECT Name FROM tblMembers";
    }
    /**A method that returns a query to fetch details
     * of a member selected on the combo box displaying names of members
     * @return 
     */
    public static String mFetchMemberDetails()
    {
        return "SELECT MemberID, Name, ContactNumber, Address,"
                + "DOB, Sex, Password, NextOfKin, Membership, HasTrainer, TrainingTime,"
                + "SubscriptionID, ConsultantID FROM tblMembers WHERE Name ='"+strComboSelectedName+"'";
    }
    //A method that returns a query to update membership details
    public static String mUpdateMemberDetails()
    {
        return "UPDATE tblMembers SET Name ='"+strName+"', ContactNumber = '"+ strContactNumber+
                "', Address = '"+strAddress+"', DOB = '"+strDOB+"', Password = '"+strPassword+"', Sex = '"+strSex+
                "', NextofKin = '"+ strNextOfKin+"', Membership = '"+strMembership+"', HasTrainer = '"+strHasTrainer+
                "', TrainingTime = '"+strTrainingTime+"'WHERE MemberID ="+ intMemberID;
    }
    //A method that returns a query to delete membership details
    public static String mDeleteMemberDetails()
    {
        return "DELETE FROM tblMembers WHERE MemberID ='"+ intMemberID+"'";
    }
    //A method that returns a query to load names of subscribers
    public static String mLoadSubscribersNames()
    {
        return "SELECT Name FROM tblSubscriptions";
    }
    //A method that returns a query to fetch details of subscribers
    public String mFetchSubscribers()
    {
        return "SELECT SubscriptionID, Name, ContactNumber, Address,"
                + "DOB, Sex, NextOfKin, Membership, HasTrainer, TrainingTime,"
                + "Password FROM tblSubscriptions WHERE name ='"+strComboSelectedName+"'";
    }
    //A method that returns a query to view all membership details
    public static String mViewMembers()
    {
        return "SELECT MemberID, Name, ContactNumber, Address,"
                + "DOB, Sex, Password, NextOfKin, Membership, HasTrainer, TrainingTime,"
                + "SubscriptionID, ConsultantID FROM tblMembers";
    }
    //A method that returns a query to approve subscriptions
    public static String mApproveSubscription()
    {
        return "INSERT INTO tblMembers " + "(Name, ContactNumber, Address, DOB, Sex, NextOfKin, Membership, HasTrainer,"
                + " TrainingTime, Password, SubscriptionID, ConsultantID)" + 
                    "VALUES ('"+strName + "','" + strContactNumber+ "','" + strAddress + "','" + strDOB +"','"+
                    strSex+ "','" + strNextOfKin + "','"+ strMembership+"','"+strHasTrainer+"','"+strTrainingTime
                    +"','"+strPassword+"','"+intMemberID+"','"+frmLogin.intUserID+"')";
    }
    //A method that returns a query to decline a subscription
    public static String mDeclineSubscription()
    {
        return "DELETE FROM tblSubscriptions WHERE Name ='"+ strComboSelectedName+"'";
    }
}
