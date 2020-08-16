/*
Title: Assignment 2 Family class
Author: Min Han Tint
Date: 27/07/2019
Filename: Family.java
Purpose: this class has methods to set and get the root member of the family and add members to the family and also can be used as an instance in other classes
Assumption: The instance of the member class will be stored and used by methods in this class and put the members in correct relationship
*/

package assignment2;
import java.util.*;
import java.io.Serializable;

public class Family implements Serializable //serialization is used to convert data into byte stream in order to store into file
{
    Member rootMember; //declare object from Member class
    ArrayList<Member> familyList; 
    
    //default constructor
    public Family()
    {
        rootMember = new Member();
        familyList = new ArrayList<Member>();
    }
   
    //constructor with 1 argument to set root member
    public Family(Member rootMember)
    {
        familyList = new ArrayList<>();
        setRootMember(rootMember);
    }
    
    //Method to set root member of the family
    public void setRootMember(Member p)
    {
        this.rootMember=p;
        if(familyList.size()>0) //if family exists
        {
            familyList.set(0,rootMember); //overwrite the existing family
        }
        else
        {
            familyList.add(rootMember);
        }
    }
    
    //method to get root member
    public Member getRootMember()
    {
        return rootMember;
    }

    //method to add members directly to the root person family with 2 arguments    
    public void addRootMember(Member nm, String type)
    {
        if(type.equals("Father")) // if it is father
        {
            rootMember.setFather(nm);
        }
        else if(type.equals("Mother")) //if it is mother
        {
            rootMember.setMother(nm);
        }
        else if(type.equals("Spouse")) //if it is spouse
        {
            rootMember.setSpouse(nm);
        }
        else if(type.equals("Child")) //if it is child
        {
            rootMember.addChild(nm);
        }
        familyList.add(nm); //add new member to family list
    }

    //metohd to add new member with 3 arguments
    public void addNewMember(Member nm, String type, String s)
    {
        int i =0;
        for(int j=0; j<familyList.size();j++)
        {
            String tempSearch = familyList.get(j).getFName()+" "+familyList.get(j).getSName();
            if(tempSearch.equals(s))
            {
                i = i;
            } 
        }
        
        if(type.equals("Father"))
        {
            familyList.get(i).setFather(nm);
        }
        else if(type.equals("Mother"))
        {
            familyList.get(i).setMother(nm); 
        }
        else if(type.equals("Spouse")) 
        {
            familyList.get(i).setSpouse(nm);
        }
        if(type.equals("Child")) //if new member is a child of the person
        {
            familyList.get(i).addChild(nm); 
        }
        familyList.add(nm);
    }
    
    //method to get list of family
    public ArrayList<Member> getFamily()
    {
        return familyList;
    }
}