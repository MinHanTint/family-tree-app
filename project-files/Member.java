/*
Title: Assignment 2 Member class
Author: Min Han Tint
Date: 27/07/2019
Filename: Member.java
Purpose: This class contains variables for a member and set and get methods for member infomation and can be used as an instance to other class
Assumption: The user inputs for member details will be stored and used by the methods in the class and the relationship for a member will be stepped up correctly
*/
package assignment2;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author stone
 */
public class Member implements Serializable //serialization is used to convert data into byte stream in order to store into file
{
    //declare variables
    private String fName;
    private String sName;
    private String aftSName;
    private String gender;
    private String lifeDesc;        
    private Address address;
    
    
    private Member father;
    private Member mother;
    private Member spouse;
    private ArrayList<Member> childrenList = new ArrayList<Member>();
    
    //default constructor
    public Member() 
    {
        fName = "";
        sName = "";
        aftSName = "";
        gender = "";
        lifeDesc = "";
        address = new Address();
    }
    
    //constructor with arguments 
    public Member(String fn, String sn, String aftsn, String g,String l, Address add)
    {
        fName = fn;
        sName = sn;
        aftSName = aftsn;
        gender = g;
        lifeDesc = l;
        address = add;
        
    }
    
    //list of setters with sutiable arguments
    public void setFName(String fn)
    {
        fName = fn;
    }
    
    public void setSName(String sn)
    {
        sName = sn;
    }
    
    public void setAftSName(String aftsn)
    {
        aftSName = aftsn;
    }
    
    public void setGender(String g)
    {
        if (g.equals("Male") || g.equals("Female"))
        {
            gender = g;
        }
        else
        {
            gender = "Male";
        }
    }
    
    public void setAddress(Address add)
    {
        address = add;
    }
    
    public void setLifeDesc(String l)
    {
        lifeDesc = l;
    }
    
    public void setFather(Member f)
    {
        if(getMother()!=null) //if mother exist
        {
            f.spouse = getMother(); //set that mother as spouse 
            getMother().spouse = f; 
            f.childrenList = this.getMother().getChildren(); //get children from the mother
        }
        else
        {
            f.addChild(this); //set this person as child to the father
        }
        this.father = f;
    }
    
    public void setMother(Member m)
    {
        if(getFather()!=null) // if father exists
        {
            m.spouse = getFather(); //set that father as spouse
            getFather().spouse = m;
            m.childrenList = this.getFather().getChildren(); //get list of children
        }
        else
        {
            m.addChild(this); //set this person as child to the mother
            
        }
        this.mother = m;
    }
    
    public void setSpouse(Member s)
    {
        for(int i = 0; i<getChildren().size(); i++) //loop through the list of children for this person
        {
            if(getChildren().get(i).getFather()!=null) //if father exists
            {
                getChildren().get(i).setMother(s); //set spouse as mother
            }
            else
            {
                getChildren().get(i).setFather(s); //set spouse as father
            }
        }    
        s.childrenList = getChildren(); //the spouse has list of children
        s.spouse = this; //set spouse to this person
        this.spouse = s;
    }
    
    public void addChild(Member c)
    {
        if(this.gender == "Male") //if it is male
        {
            c.father = this; //set this person as father
            if(this.getSpouse()!=null) //if spouse exists
            {
                c.mother = this.getSpouse(); //set spouse as mother
            }
        }
        else
        {
            c.mother = this; //set this person as mother
            if(this.getSpouse() != null) 
            {
                c.father = this.getSpouse();
            }
        }
        childrenList.add(c); //add to list of children
        if(this.getSpouse()!=null) //if spouse exist
        {
            this.getSpouse().childrenList = this.getChildren(); //the spouse has lsit of children
        }
    }
    
    
    //list of getters
    public String getFName()
    {
        return fName;
    }
    
    public String getSName()
    {
        return sName;
    }
    
    public String getAftSName()
    {
        return aftSName;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public String getLifeDesc()
    {
        return lifeDesc;
    }
    
    public Member getFather()
    {
        return father;
    }
    
    public Member getMother()
    {
        return mother;
    }
    
    public Member getSpouse()
    {
        return spouse;
    }
    
    public ArrayList<Member> getChildren()
    {
        return childrenList;
    }
}
