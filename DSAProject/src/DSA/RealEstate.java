/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DSA;

import java.awt.*;  
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;


/**
 *
 * @author nuts
 */

public class RealEstate { 
// The list of house information 
private static SortedList list = new SortedList();

// Text fields
private static JTextField lotText;             // Lot number field 
private static JTextField firstText;            // First name field
private static JTextField lastText;             // Last name field
private static JTextField priceText;            // Price field
private static JTextField feetText;             // Square feet field
private static JTextField bedText;             // Number of bedrooms field

// Status Label
 private static JLabel statusLabel;              // Label for status info
// Display information about parameter house on screen 
private static void showHouse(ListHouse)
{
 lotText.setText(Integer.toString(house.lotNumber);
firstText.setText(house.firstName());              
lastText.setText(house.lastName());            
 priceText.setText(Integer.toString(house.price()));          
 feetText.setText(Integer.toString(house.squareFeet()));
 bedText.setText(Integer.toString(house.bedRooms())); 
}

// Returns current screen information as a ListHouse 
private static ListHouse getHouse() 
{
 String lastName;
 String firstName;
 int lotNumber; 
int price;
 int squareFeet;
 int bedRooms;

lotNumber = Integer.parseInt(lotText.getText());
 firstName = firstText.getText(); 
  lastName = lastText.getText(); 
  price = Integer.parseInt(priceText.getText());
 squareFeet = Integer.parseInt(feetText.getText());
 bedRooms = Integer.parseInt(bedText.getText());
ListHouse house = new ListHouse(lastName, firstName, lotNumber, price, squareFeet, bedRooms);
 return house;
}

// Clears house information from screen 
private static void clearHouse() 
{
 lotText.setText("");
 firstText.setText("");
lastText.setText(""); 
priceText.setText("");                   
feetText.setText("");
bedText.setText("");
}

// Define a button listener
 private static class ActionHandler implements ActionListener 
{
 public void actionPerformed(ActionEvent event) 
// Listener for the button events
 {
 ListHouse house;
if (event.getActionCommand().equals("Reset"))
 {
 // Handles Reset event
 list.reset();
 if (list.lengthIs() == 0)
 clearHouse();
 else
 { 
house = (ListHouse)list.getNextItem(); 
showHouse(house);
}
 statusLabel.setText("List reset"); 
} 
else if (event.getActionCommand().equals("Next"))
 {
 // Handles Next event
 if (list.lengthIs() == 0)
 statusLabel.setText("list is empty!"); 
else
 {
 house = (ListHouse)list.getNextItem();
 showHouse(house);
 statusLabel.setText("Next house displayed");
 }
 }
 else 
house = (ListHouse)list.getNextItem();
 showHouse(house);
 statusLabel.setText("Next house displayed");
}
}
 else if (event.getActionCommand().equals("Add"))
 { 
// Handles Add event
 try
{
 house = getHouse();
if (list.isThere(house))
 statusLabel.setText("Lot number already in use"); 
else { list.insert(house);
 statusLabel.setText("House added to list");
 }
}
 catch (NumberFormatException badHouseData)
 {
 // Text field info incorrectly formated 
statusLabel.setText("Number? " + badHouseData.getMessage());
 } 
}
 else if (event.getActionCommand().equals("Delete"))
 {
 // Handles Delete event
 try
 {
 house = getHouse(); 
if (list.isThere(house))
 {
 list.delete(house); 
statusLabel.setText("House deleted");
 }
 else 
statusLabel.setText("Lot number not on list");
 }
 catch (NumberFormatException badHouseData)
 {
 // Text field info incorrectly formated
 statusLabel.setText("Number? " + badHouseData.getMessage());
 }
 }
 else if (event.getActionCommand().equals("Clear"))
 { 
// Handles Clear event
 clearHouse();
 statusLabel.setText(list.lengthIs() + " houses on list"); 
}
 else if (event.getActionCommand().equals
{
 // Handles Find event int lotNumber; 
try
    {
lotNumber = Integer.parseInt(lotText.getText());
 house = new ListHouse("", "", lotNumber, 0, 0, 0);
 if (list.isThere(house))
 {
 house = (ListHouse)list.retrieve(house); 
showHouse(house); 
statusLabel.setText("House found");
 }
 else 
statusLabel.setText("House not found");
} 
catch (NumberFormatException badHouseData)
 {
 // Text field info incorrectly formated
 statusLabel.setText("Number? " + badHouseData.getMessage());
 } 
}



public static void main(String args[]) throws IOException
{
ListHouse house;
 char command; 
int length;
JLabel blankLabel;        // To use up one frame slot
JLabel lotLabel;         // Labels for input fields JLabel firstLabel;
 JLabel lastLabel; 
JLabel priceLabel; 
JLabel feetLabel;
 JLabel bedLabel;
JButton reset;             // Reset button
 JButton next;         // Next button
 JButton add;              // Add button 
JButton delete;            // Delete button
 JButton clear;             // Clear button
 JButton find;              // Find button
 ActionHandler action;      // Declare listener

 // Declare/Instantiate/Initialize display frame
 JFrame displayFrame = new JFrame(); 
displayFrame.setTitle("Real Estate Program");
 displayFrame.setSize(350,400);
 displayFrame.addWindowListener(new WindowAdapter()  // handle window
 //   closing
 {
public void windowClosing(WindowEvent event)
 {
 ListHouse house; 
displayFrame.dispose();           
  // Close window 
try
 {
 // Store info from list into house file 
HouseFile.rewrite(); 
list.reset();
 int length = list.lengthIs();
 for (int counter = 1; counter <= length; counter++)
 {
 house = (ListHouse)list.getNextItem();
 HouseFile.putToFile(house);
 }
 HouseFile.close();
}
 catch (IOException fileCloseProblem)
 {
 System.out.println("Exception raised concerning the house info file " + "upon program termination");
 }
 System.exit(0);                          // Quit the program
}
 }
);
// Instantiate content pane and information panel
 Container contentPane = displayFrame.getContentPane();
 JPanel infoPanel = new JPanel();
// Instantiate/initialize labels, and text fields 
statusLabel = new JLabel("", JLabel.CENTER); 
statusLabel.setBorder(new LineBorder(Color.red));
 blankLabel = new JLabel("");
    lotLabel = new JLabel("Lot Number:  ", JLabel.RIGHT);
 lotText = new JTextField("", 15); 
firstLabel = new JLabel("First Name:  ", JLabel.RIGHT);
 firstText = new JTextField("", 15);
lastLabel = new JLabel("Last Name:  ", JLabel.RIGHT);
 lastText = new JTextField("", 15);
 priceLabel = new JLabel("Price:  ", JLabel.RIGHT);
 priceText = new JTextField("", 15); 
feetLabel = new JLabel("Square Feet:  ", JLabel.RIGHT);
 feetText = new JTextField("", 15);
 bedLabel = new JLabel("Number of Bedrooms:  ", JLabel.RIGHT);
 bedText = new JTextField("", 15);
// Instantiate/register buttons
 reset = new JButton("Reset");
 next = new JButton("Next");
 add = new JButton("Add");
 delete = new JButton("Delete");
 clear = new JButton("Clear"); 
find = new JButton("Find");
// Instantiate/register button listeners
 action = new ActionHandler();
 reset.addActionListener(action);
 next.addActionListener(action);
 add.addActionListener(action);
 delete.addActionListener(action); 
clear.addActionListener(action);
 find.addActionListener(action);
// Load info from house file into list
 HouseFile.reset();
 while (HouseFile.moreHouses()) 
{
 house = HouseFile.getNextHouse();
 list.insert(house);
 }
// If possible insert info about first house into text fields
 list.reset();
 if (list.lengthIs() != 0)
 {
 house = (ListHouse)list.getNextItem();
 showHouse(house);
 }
// Update status 
statusLabel.setText(list.lengthIs() + " houses on list   
// Add components to frame 
infoPanel.setLayout(new GridLayout(10,2));
 infoPanel.add(statusLabel);
 infoPanel.add(blankLabel);
 infoPanel.add(lotLabel);
 infoPanel.add(lotText);
 infoPanel.add(firstLabel);
 infoPanel.add(firstText); 
infoPanel.add(lastLabel); 
infoPanel.add(lastText);
 infoPanel.add(priceLabel);
 infoPanel.add(priceText);
 infoPanel.add(feetLabel) infoPanel.add(feetText) ;
infoPanel.add(bedLabel);
 infoPanel.add(bedText);
 infoPanel.add(reset);
 infoPanel.add(next);
 infoPanel.add(add);
 infoPanel.add(delete); 
infoPanel.add(clear);
 infoPanel.add(find);
// Set up and show the frame
 contentPane.add(infoPanel);   
   displayFrame.show();      
}
}


        



    

