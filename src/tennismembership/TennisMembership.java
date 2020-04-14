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
public class TennisMembership {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*These lines of code create an object of type frmLogin
          The instance of class frmLogin is then set a title 
          and shown to the user
        */
        frmLogin frmlogin = new frmLogin();
        frmlogin.setTitle("Tennis Club Login");
        frmlogin.setLocation(450, 200);
        frmlogin.show();
    }
    
}
