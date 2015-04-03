/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DSA;

import DSA.ListHouse;
import java.io.*;
/**
 *
 * @author elan
 */
public class HouseFile {

    private static BufferedReader inFile;
    private static PrintWriter outFile;
    private static boolean inFileOpen = false;
    private static boolean outFileOpen = false;
    private static String inString = ""; // Holds "next" line from file
// Equals null if at end of file

    public static void reset() throws IOException // Reset file for reading
    {
        if (inFileOpen) {
            inFile.close();
        }
        if (outFileOpen) {
            outFile.close();
        }
        inFile = new BufferedReader(new FileReader("houses.dat"));
        inFileOpen = true;
        inString = inFile.readLine();
    }

    public static void rewrite() throws IOException // Reset file for writing
    {
        if (inFileOpen) {
            inFile.close();
        }
        if (outFileOpen) {
            outFile.close();
        }
        outFile = new PrintWriter(new FileWriter("houses.dat"));
        outFileOpen = true;
    }

    public static boolean moreHouses() // Returns true if file open for reading and there is still more house
    // information available in it
    {
        if (!inFileOpen || (inString == null)) {
            return false;
        } else {
            return true;
        }
    }

    public static ListHouse getNextHouse() throws IOException // Gets and returns house information from the house info file
    // Precondition: inFile is open and holds more house information
    {
        String lastName = "xxxxx";
        String firstName = "xxxxx";
        int lotNumber = 0;
        int price = 0;
        int squareFeet = 0;
        int bedRooms = 0;

        lastName = inString;
        firstName = inFile.readLine();
        lotNumber = Integer.parseInt(inFile.readLine());
        price = Integer.parseInt(inFile.readLine());
        squareFeet = Integer.parseInt(inFile.readLine());
        bedRooms = Integer.parseInt(inFile.readLine());
        inString = inFile.readLine();
        ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,
                squareFeet, bedRooms);
        return house;
    }

    public static void putToFile(ListHouse house) throws IOException // Puts parameter house information into the house info file
    // Precondition: outFile is open
    {
        outFile.println(house.lastName());
        outFile.println(house.firstName());
        outFile.println(house.lotNumber());
        outFile.println(house.price());
        outFile.println(house.squareFeet());
        outFile.println(house.bedRooms());
    }

    public static void close() throws IOException // Closes house info file
    {
        if (inFileOpen) {
            inFile.close();
        }
        if (outFileOpen) {
            outFile.close();
        }
        inFileOpen = false;
        outFileOpen = false;
    }
}

    

