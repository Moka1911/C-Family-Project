import java.util.*;
import java.util.ArrayList;
/**
 * An planet is part of a STAR resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(permits) who can be on the  
 * planet at any one time. Each planet must maintain a list of all people (permits)
 * currently on the planet. These lists are updated whenever permits enter or leave 
 * an planet,so that it is always possible to say how many people (permits) are on the planet 
 * and who they are.
 * 
 * @author (Coding Mohamed Shaheen, Supervising Eman Aziz) 
 * @version (11/04/2022)
 */

public class Planet 
{
    // declare a variable to store the unique reference number of the planet
    private int reference_no;
    
    // variable to store the planet's name
    private String planet_name;
    
    // variable to store the luxury rating required
    // by permits to go to the planet
    private int luxury_rating;
    
    // variable to store maximum number of people/permits
    // that can be on the planet at any one time
    private int capacity;
    
    // variable to store the list of permits currently available on the planet
    private ArrayList<Permit> permit_list = new ArrayList<Permit>();
    
    // constructor to create a planet using parameters given
    public Planet(int ref_no, String planetName, int luxury_Rating, int max_capacity)
    {
        reference_no = ref_no;
        planet_name = planetName;
        luxury_rating = luxury_Rating;
        capacity = max_capacity;
    }
    
    // this method returns the planet reference number
    public int get_planetno()
    {
        return reference_no;
    } 
    
    // this method returns the planet name
    public String get_planetname()
    {
        return planet_name;
    } 
    
    // this method returns the planet luxury rating
    public int get_planetRating()
    {
        return luxury_rating;
    } 
    
    // this method is used to enter the permit/person in the planet permits list
    public void enter(Permit permit)
    {
        if(!is_full_capacity()){
            permit_list.add(permit);
            capacity -= 1;
        }
    }
    
    // this method is used check whether a permit/person exists on a planet or not and return true or false
    public boolean permit_exist(Permit permit)
    {
        for(int index = 0; index < permit_list.size(); index++)
        {
             Permit list_permit = permit_list.get(index);
             if (permit == list_permit)
             {
                 return true;
             }
        }
        return false;
    } 
    
    // this method is used to remove a permit/person from planet permits list if exists
    public void leave(Permit permit)
    {
        boolean temp = permit_exist(permit);
        if (temp == true){
            permit_list.remove(permit);
            capacity += 1;
        }
    }
    
    // this method checks whether the capacity is full for the planet or there is enough space to add more permits/people
    public boolean is_full_capacity()
    {
        if (capacity <= permit_list.size())
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    // this method returns a string with the details of all permits/people found on planet
    public String get_permit_list()
    {
        String Permits = "";
        if (permit_list.size() > 0)
        {
            for(Permit permit: permit_list)
            {
                Permits += "\n" + permit.to_String();
            }
            return Permits;
        }
        else
        {
            return "\n No permits currently on planet";
        }
    }
    
    // this method returns a string with the details of a permit/person found on planet
    public String get_permit_details(Permit permit)
    {
        boolean temp = permit_exist(permit);
        if(temp == false){
            return "\n Permit not on planet";
        }
        else{
            return permit.to_String();
        }
        
    }
    
    // this method returns a string with the details of the planet and a list of all permits/people found on it.
    public String to_String()
    {
        return ("\nPlanet number: " + reference_no + "\n Planet Name: " + planet_name + "\n Luxury Rating: " + luxury_rating + "\ncapacity: " +
        capacity + "\n ******Permits******" + get_permit_list());
    }
    
}
