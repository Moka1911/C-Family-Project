
/**
 * Write a description of class PermitTester here.
 *
 * @author (Coding Eman Aziz, Supervising Mohamed Shaheen)
 * @version (04/09/2022)
 */
public class PermitTester
{
    public static void main(String[] args)
    {
        //declare two permit objects
        Permit Guest1 = new Permit(1,"Guest1",3,0);
        Permit Guest2 = new Permit(2,"Guest2",7,40);
        
        //retrieves the permit id of the guests
        System.out.println("\nPermit ID for Guest1: " + Guest1.get_permitID() + " - expected 1" );
        System.out.println("Permit ID for Guest2: " + Guest2.get_permitID() + " - expected 2" );
        
        //retrieves the luxury ratings of the guests
        System.out.println("\nLuxury Ratings for Guest1: " + Guest1.get_luxuryRating() + " - expected 3" );
        System.out.println("Luxury Ratings for Guest2: " + Guest2.get_luxuryRating() + " - expected 7" );
        
        //retrieves the credits of the guests
        System.out.println("\nCredits for Guest1: " + Guest1.get_credits() + " - expected 0" );
        System.out.println("Credits for Guest2: " + Guest2.get_credits() + " - expected 40" );
        
        //adding credits for Guest1 and then checking the total credits
        Guest1.add_credits(50);
        System.out.println("\nAdding 50 Credits for Guest1, Current total credits: " + Guest1.get_credits() + " - expected 50" );
       
        //deducting credits for Guest2 and then checking the total credits
        Guest2.deduct_credits(38);
        System.out.println("\nDeducting 38 Credits for Guest2, Current total credits: " + Guest2.get_credits() + " - expected 2" );
        
        //checking if credits are enough for the shuttle
        System.out.println("\nShuttle Fee is 3 credits");
        System.out.println("Trying to check if Guest2 have enough credits to board the shuttle: " + Guest2.check_credit(3) + " - expected false");
        System.out.println("Trying to check if Guest1 have enough credits to board the shuttle: " + Guest1.check_credit(3) + " - expected true");
    
        //printing out and returning the full information of Guest1 permit
        System.out.println("\nPrinting out the full information of Guest1 permit");
        System.out.println(Guest1.to_String());
        System.out.println("Expected Information - Permit ID: 1, Name: Guest1, Luxury Rating: 3, Credits: 50");

    }
}
