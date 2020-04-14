/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class clsConnectToDatabase {
    //A method that connects to the database then returns a connection
    public Connection mConnectToDatabaseTennisClub()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/tennisClubMembership";
    	String strDBUser = "root";
        String strDBPassword = "password";
        java.sql.Connection conMySQLConnectionString = null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
        }
        catch(SQLException eX)
        {
            JOptionPane.showMessageDialog(null, eX);
        }
        return conMySQLConnectionString;
    }
}