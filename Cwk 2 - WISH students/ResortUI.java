import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (Coding Eman Aziz, Supervising Mohamed Shaheen) 
 * @version (12/04/2022)
 */
public class ResortUI
{
    private Scanner reader = new Scanner(System.in);
    private WISH wayward = new Resort("Wayward Asteroids");
    
    private void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllPlanets();}
            else if (choice == 2){listAllPermits();}
            else if (choice == 3){listOnePlanet();}
            else if (choice == 4){findPermitLocation();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){updateCredits();}
            else if (choice == 8){getPermitInfo();}
            else if (choice == 9){Rich_Guests();}
            else if (choice == 10){move_Home ();}
            else if (choice == 11){evacuate_All ();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all planet details");
       System.out.println("2. List all permits on each planet");
       System.out.println("3. List all permits on one planet");
       System.out.println("4. Find permit location");
       System.out.println("5. Say if permit can move by shuttle");
       System.out.println("6. Move a permit by shuttle");
       System.out.println("7. Top up credits");
       System.out.println("8. Get permit details");
       System.out.println("9. Get all rich guests details");
       System.out.println("10. Move permit to home");
       System.out.println("11. Evacuate all to Home");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllPlanets()
    {
        System.out.println(wayward.toString());
    }
    
    // provide the code here
    // this method lists all the permits on all planets by using getAllPermitsOnEachPlanet function and prints them
    private void listAllPermits()
    {
        System.out.println(wayward.getAllPermitsOnEachPlanet());
    }
   
    // This one has been done for you 
    private void listOnePlanet()
    {
        System.out.println("Enter name of planet");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(ww));
    }
    
    // provide the code here
    // this method gets the name of the planet on which the permit exists by calling getPermitLocation function 
    private void findPermitLocation()
    {
        System.out.println("Enter permit id");
        int tr = reader.nextInt();
        System.out.println(wayward.getPermitLocation(tr));
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    // this method allows a permit to travel from one planet to another by taking the permit id and the shuttle code
    // only if it passes all the checks
    private void travelNow()
    {
       System.out.println("Enter permit id");
       int trav = reader.nextInt();
       reader.nextLine();
       System.out.println("Enter shuttle code");
       String shuttle = reader.nextLine();
       System.out.println(wayward.travel(trav,shuttle));
    }
    
    // Provide the code here
    // this method updates the permi credits by taking permit id and the credit amount and displays the new credit amount 
    // for the user
    private void updateCredits()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        System.out.println("Enter credit amount");
        int cred = reader.nextInt();
        wayward.topUpCredits(trav,cred);
        System.out.println(wayward.getPermitDetails(trav));
    }
    
    // This one has been done for you  
    private void getPermitInfo()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        System.out.println(wayward.getPermitDetails(trav));
    }
    
    // this method prints out all the rich guests with luxury rating above 5
    private void Rich_Guests()
    {
        System.out.println(wayward.getRichGuests ());
    }
    
    // his method moves a permit to the home palnet
    private void move_Home ()
    {
        System.out.println("please enter permit ID");
        int permit_id = reader.nextInt();
        wayward.moveHome(permit_id);
        System.out.print("New ");
        System.out.println(wayward.getPermitLocation(permit_id));
    }
    
    // this method evacuates all permits to the home planet
    private void evacuate_All  ()
    {
        wayward.evacuateAll();
        System.out.println("Evacuation Successfull");
    }
   
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
