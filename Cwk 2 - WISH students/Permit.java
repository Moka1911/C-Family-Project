 /**
 * A Permit has an id number, name, a luxury rating and number of credits.
 * 
 * @author (Coding Eman Aziz, Supervising Mohamed Shaheen) 
 * @version (09/04/2022)
 */
public class Permit 
{
    // permit id is used to determine who is the guest 
    private int permit_id;
    
    // name is used to store the guest name
    private String name;
    
    // luxury rating determines which planets can a guest visit
    private int luxury_rating;
    
    // credits are the total amount of credits the guest toped up 
    // to use resort facilties
    private int credits;
    
    // constructor for permit class to retrieve parameters
    public Permit(int permitID, String guestName, int luxuryRating, int Credits)
    {
        permit_id = permitID;
        name = guestName;
        luxury_rating = luxuryRating;
        credits = Credits;
    }
    
    // a method to return the permit id
    public int get_permitID()
    {
        return permit_id;
    }
    
    // a method to return the luxury rating for permit
    public int get_luxuryRating()
    {
        return luxury_rating;
    }
    
    // a method to return the total credits for permit
    public int get_credits()
    {
        return credits;
    }
    
    // a method to add credits to the permit
    public void add_credits(int topup_credits)
    {
        credits += topup_credits;
    }
    
    // a method to deduct credits from the permit 
    public void deduct_credits(int deducted_credits)
    {
        credits -= deducted_credits;
    }
    
    // a method to check if the permit has enough credits to board the shuttle
    // this method can also be used to check for any fee
    public boolean check_credit(int charges)
    {
        if(credits >= charges)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    // this method prints out and returns all the permit information
    public String to_String()
    {
        String information = "\n ##################";
        information += "\n Permit Information";
        information += "\n Permit ID: "+ permit_id;
        information += "\n Guest Name: " + name;
        information += "\n Luxury Rating: " + luxury_rating;
        information += "\n Credits: "+ credits;
        information += "\n ##################";
        return information;
    }
}

