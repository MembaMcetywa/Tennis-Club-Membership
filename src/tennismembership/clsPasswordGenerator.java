/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennismembership;

import java.util.Random;

/**
 *
 * @author Sanele
 */
public class clsPasswordGenerator {
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@$%&_+={}[]:";
    private static final String ALL_CHARS = CAPITAL_LETTERS + SMALL_LETTERS + DIGITS + SPECIAL_CHARS;

    private static Random rnd = new Random();
    //A static method to insert characters randomly
    private static void mInsertAtRandomPosition(StringBuilder password, char character)
    {
        int randomPosition = rnd.nextInt(password.length() + 1);
        password.insert(randomPosition, character);
    }
    //A static method that generates characters randomly
    private static char mGenerateChar(String availableChars)
    {
        int randomIndex = rnd.nextInt(availableChars.length());
        char randomChar = availableChars.charAt(randomIndex);
        return randomChar;
    }
    //A method that returns a password
    public StringBuilder mGetPassword()
    {
        StringBuilder password = new StringBuilder();

        //Generate four random capital letters
        for (int i = 1; i <= 4; i++)
        {
            char capitalLetters = mGenerateChar(CAPITAL_LETTERS);
            mInsertAtRandomPosition(password, capitalLetters);
        }

        //Generate four random small letters
        for (int i = 1; i <= 4; i++)
        {
            char smallLetter = mGenerateChar(SMALL_LETTERS);
            mInsertAtRandomPosition(password, smallLetter);
        }

        //generate one random digit
        char digit = mGenerateChar(DIGITS);
        mInsertAtRandomPosition(password, digit);

        //Generate four special characters
        for (int i = 1; i <= 4; i++)
        {
            char specialChar = mGenerateChar(SPECIAL_CHARS);
            mInsertAtRandomPosition(password, specialChar);
        }

        //Generate few random characters (between 0 and 7)
        int count = rnd.nextInt(8);
        for (int i = 1; i <= count; i++)
        {
            char specialChar = mGenerateChar(ALL_CHARS);
            mInsertAtRandomPosition(password, specialChar);
        }
        return password;
    }
}