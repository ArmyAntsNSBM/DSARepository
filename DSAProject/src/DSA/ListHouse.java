/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DSA;
package DSA.*model;

import DSA Listable

/**
 *
 * @author costa
 */

public class ListHouse implements Listable {
// House information

    private String lastName;
    private String firstName;
    private int lotNumber;
    private int price;
    private int squareFeet;
    private int bedRooms;

    public ListHouse(String lastName, String firstName, int lotNumber,
            int price, int squareFeet, int bedRooms) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.lotNumber = lotNumber;
        this.price = price;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    public Listable copy() // Returns a copy of this ListHouse
    {
        ListHouse result = new ListHouse(lastName, firstName, lotNumber, price,
                squareFeet, bedRooms);
        return result;
    }

    public int compareTo(Listable otherListHouse) // Houses are compared based on their lot numbers
    {
        ListHouse other = (ListHouse) otherListHouse;
        return (this.lotNumber - other.lotNumber);
    }
// Observers

    public String lastName() {
        return lastName;
    }

    public String firstName() {
        return firstName;
    }

    public int lotNumber() {
        return lotNumber;
    }

    public int price() {
        return price;
    }

    public int squareFeet() {
        return squareFeet;
    }

    public int bedRooms() {
        return bedRooms;
    }
}


