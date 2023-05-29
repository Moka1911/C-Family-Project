/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 * 
 * @author (Coding Eman Aziz, Supervising Mohamed Shaheen) 
 * @version (11/04/2022)
 */
public class Shuttle
{
    // defining a variable to store the shuttle number
    private String Shuttle_No;
    
    // dfining a variable to store the source planet object
    private Planet from_planet;
    
    // dfining a variable to store the source planet object
    private Planet to_planet;
    
    // constructor to set shuttle basic parameters
    public Shuttle(String ShuttleNo, Planet fromPlanet, Planet toPlanet)
    {
        Shuttle_No = ShuttleNo;
        from_planet = fromPlanet;
        to_planet = toPlanet;
    }
    
    // this method returns the shuttle number
    public String get_shuttleNo()
    {
        return Shuttle_No;
    } 
    
    // this method returns the start planet object
    public Planet get_startPlanet()
    {
        return from_planet;
    } 
    
    // this method returns the destination planet object
    public Planet get_dest_planet()
    {
        return to_planet;
    } 
    
    // this method checks if the permit is allowed entry on the shuttle or not
    public boolean check_entry(Permit permit)
    {
        if (to_planet.get_planetRating() <= permit.get_luxuryRating() 
        && !to_planet.is_full_capacity() && permit.get_credits() >= 3 
        && from_planet.permit_exist(permit))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // this method process a permit and moves the permit to destination planet 
    public String move_planet(Permit permit)
    {
        if (to_planet.get_planetRating() > permit.get_luxuryRating())
        {
            return "Permit's luxury rating is lower than the rating of the destination planet ";
        }
        else if (to_planet.is_full_capacity())
        {
            return "Maximun capacity of the destination planet has been reached";
        }
        else if (permit.get_credits() < 3)
        {
            return "Permit doesn't have enough credits";
        }
        else if (!from_planet.permit_exist(permit))
        {
            return "Permit is not listed in the source planet";
        }
        else
        {
            from_planet.leave(permit);
            to_planet.enter(permit);
            permit.deduct_credits(3);
            return "\nSuccessful entry";
        }
    }
        
    // this method returns the shuttle information and all the 
    // source and destination planet information
    public String toString()
    {
        String info = "\nShuttle No: " + Shuttle_No 
        +"\nSource Planet: " + from_planet.get_planetname()
        +"\nSource Planet Number: " + from_planet.get_planetno()
        +"\nDestination Planet: " + to_planet.get_planetname()
        +"\nnDestination Planet Number: " + to_planet.get_planetno();
        return info;
    }
}
