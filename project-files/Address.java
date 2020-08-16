/*
Title: Assignment 2 Address class
Author: Min Han Tint
Date: 27/07/2019
Filename: Address.java
Purpose: This class contains the variables regarding wtih the address and can be used to create an instance in other classes.
Assumption: The address details inputed by the users will be used by various set and get methods in this class
*/
package assignment2;
import java.io.Serializable;
import java.util.*;

public class Address implements Serializable //serialization is used to convert data into byte stream in order to store into file
{
    //declare variables
    private String stNumber;
    private String stName;
    private String suburb;
    private String postcode;
    
    //default constructor
    public Address() 
    {
        stNumber = "";
        stName = "";
        suburb = "";
        postcode = "";
    }
    
    //constructor with 4 arguments
    public Address(String num, String n, String sub, String pc)
    {
        stNumber = num;
        stName = n;
        suburb = sub;
        postcode = pc;
    }
    
    //list of methods of getters and setters
    public void setStNumber(String num)
    {
        stNumber = num;
    }
    
    public void setStName(String n)
    {
        stName = n;
    }
    
    public void setSuburb(String sub)
    {
        suburb = sub;
    }
    
    public void setPostcode(String pc)
    {
        postcode = pc;
    }
    
    public String getStNumber()
    {
        return stNumber;
    }
    
    public String getStName()
    {
        return stName;
    }
    
    public String getSuburb()
    {
        return suburb;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
}