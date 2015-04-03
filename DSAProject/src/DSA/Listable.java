/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DSA;

/**
 *
 * @author user
 */
public interface Listable {
  
public abstract int compareTo(Listable other);
//Compares this Listable object to"other".if they are equal,0is
//returned
//If this is less than the argument,a negative value is returned
//If this is more than the argument, a positive valu is retuned

public abstract Listable copy();
//Returns a new object with the same contents as this Listable object

    
}
