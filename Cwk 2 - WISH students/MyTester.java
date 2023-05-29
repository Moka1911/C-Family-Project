import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author (Coding Mohamed Shaheen, Supervising Eman Aziz) 
 * @version (12/04/2022)
 */

// while testing through terminal window make sure to  
// select unlimited buffering from the options
// in order to display all the tests

public class MyTester 
{   
    private void doTest()
    {
        // declare and create the Resort object
        Resort wayward = new Resort("Wayward Asteroids");
       
        // write your tests here by invoking Resort methods on the Resort object called wayward
        
        // Testing if all permits have been inserted succesfully
        System.out.println("\n**********All Permits**********");
        System.out.println(wayward.getAllPermitsOnEachPlanet());
        System.out.println("Expected permits to appear: 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008");
        
        // Testing if all planets have been inserted succesfully
        System.out.println("\n**********All Planets**********");
        System.out.println("Planet Number: " + wayward.getPlanetNumber("Home") + " - Expected: 0");
        System.out.println("Planet Number: " + wayward.getPlanetNumber("Sprite") + " - Expected: 1");
        System.out.println("Planet Number: " + wayward.getPlanetNumber("Tropicana") + " - Expected: 2");
        System.out.println("Planet Number: " + wayward.getPlanetNumber("Fantasia") + " - Expected: 3");
        System.out.println("Planet Number: " + wayward.getPlanetNumber("Solo") + " - Expected: 4");
        
        // Testing if all the permits have been inserted successfully in planet home initially
        System.out.println("\n**********All Planet's permits**********");
        System.out.println(wayward.toString());
        System.out.println("\nExpected: All permits are found on planet Home and rest of the planets have no permits");
        
        // Testing the permit details of a permit using permit id
        System.out.println("\n**********Getting details of permit number 1000**********");
        System.out.println(wayward.getPermitDetails(1000));
        System.out.println("Expected: Permit id: 1000, Guest name: Lynn, Luxury rating: 5, Credits: 10");
        
        // Testing the permit details of a permit id that doesn't exist
        System.out.println("\n**********Getting details of permit number 1009 (Doesn't Exist)**********");
        System.out.print(wayward.getPermitDetails(1009));
        System.out.println(" - Expected: No such permit");
        
        // Testing the planet number using planet name 
        System.out.println("\n**********Getting Solo's planet number**********");
        System.out.print(wayward.getPlanetNumber("Solo"));
        System.out.println(" - Expected: 4");
        
        // Testing the planet number using planet name that doesn't exist
        System.out.println("\n**********Getting Pepsi's planet number (Doesn't Exist)**********");
        System.out.print(wayward.getPlanetNumber("Pepsi"));
        System.out.println(" - Expected: -1 (Planet doesn't exist))");
        
        // Finding a location of a permit 
        System.out.println("\n**********Getting permit 1005 location**********");
        System.out.print(wayward.getPermitLocation(1005));
        System.out.println(" - Expected: Home");
        
        // Finding a location of a permit that doesn't exist
        System.out.println("\n**********Getting permit 1009 location (Doesn't exist)**********");
        System.out.print(wayward.getPermitLocation(1009));
        System.out.println(" - Expected: null (Permit doesn't exist)");
        
        // Topping up credits for permit 1008
        System.out.println("\n**********Getting permit 1008 before topping up**********");
        System.out.print(wayward.getPermitDetails(1008));
        wayward.topUpCredits(1008,50);
        System.out.println("\nGetting permit 1008 after topping up");
        System.out.print(wayward.getPermitDetails(1008));
        System.out.println(" - Expected credits: 74)");
        
        // Testing whether some permits can travel to another planet
        System.out.println("\n**********Testing whether permit 1004 can transfer from Home to Sprite**********");
        System.out.print(wayward.canTravel(1004,"ABC1"));
        System.out.println(" - Expected return: true");
        System.out.println("\n**********Testing whether permit 1006 can transfer from Home to Sprite**********");
        System.out.print(wayward.canTravel(1006,"ABC1"));
        System.out.println(" - Expected return: true");
        
        // Making some permits travel to another planet
        System.out.println("\n**********Testing the transfer of permit 1004 from Home to Sprite**********");
        System.out.println(wayward.getPermitDetails(1004));
        System.out.print(wayward.getPermitLocation(1004));
        System.out.println(" - Expected current location of permit: Home & Current credits: 3");
        System.out.println(wayward.travel(1004,"ABC1"));
        System.out.println(wayward.getPermitDetails(1004));
        System.out.print(wayward.getPermitLocation(1004));
        System.out.println(" - Expected location of permit after travelling: Sprite & Expected credits: 0");
        
        // Testing the transfer of permit to a planet where credits are not enough for the transfer
        System.out.println("\n**********Testing the transfer of permit 1004 from Sprite to Tropicana with not enough credits**********");
        System.out.print(wayward.travel(1004,"CDE3"));
        System.out.println(" - Expected: Permit doesn't have enough credits");
        
        // Testing the transfer of permit to a planet with a pemit that doesn't exist
        System.out.println("\n**********Testing the transfer of permit 1022 (doesn't exist)**********");
        System.out.print(wayward.travel(1022,"CDE3"));
        System.out.println(" - Expected: Permit doesn't exist");
        
        // Testing the transfer of permit to a planet through a shuttle that doesn't exist
        System.out.println("\n**********Testing the transfer of permit 1004 with shuttle VYX4 (shuttle doesn't exist)**********");
        System.out.print(wayward.travel(1004,"VYX4"));
        System.out.println(" - Expected: Shuttle doesn't exist");
        
        // Testing the transfer of permit's luxury rating to a planet lower than the rating of the destination planet
        System.out.println("\n**********Testing the transfer of permit 1003 from Home to Sprite and then from Sprite to Tropicana (permit luxury rating is lower than Tropicanna's)**********");
        System.out.print(wayward.travel(1003,"ABC1"));
        System.out.println(" - Expected: Successful entry");
        System.out.print(wayward.travel(1003,"CDE3"));
        System.out.println(" - Expected: Permit's luxury rating is lower than the rating of the destination planet");
        
        // Testing the transfer of two permits to planet Solo whereas the maximum capacity of the planet is 1
        System.out.println("\n**********Testing the transfer of 2 people to planet Solo (Capacity 1)**********");
        wayward.travel(1001,"ABC1");
        wayward.travel(1008,"ABC1");
        System.out.println("Transfering permit 1001 to Solo");
        System.out.print(wayward.travel(1001,"GHJ6"));
        System.out.println(" - Expected: Successful entry");
        System.out.println("Transfering permit 1008 to Solo (maximum capacity reached)");
        System.out.print(wayward.travel(1008,"GHJ6"));
        System.out.println(" - Expected: Maximun capacity of the destination planet has been reached");
        
        // Testing travel of permit from a planet which the permit is not listed on
        System.out.println("\n**********Testing travel of permit 1008 from a planet which the permit is not listed on**********");
        System.out.println(wayward.getPermitLocation(1008));
        System.out.print(wayward.travel(1008,"ABC1"));
        System.out.println(" - Expected: Permit is not listed in the source planet");
        
        // Getting all permits only on one planet
        System.out.println("\n**********Listing all permits only on one planet: Solo**********");
        System.out.println(wayward.getAllPermitsOnOnePlanet("Solo"));
        System.out.println(" - Expected: 1001");
        
        // Getting all rich guest details
        System.out.println("\n**********Listing all Rich Guests**********");
        System.out.println(wayward.getRichGuests ());
        System.out.println(" - Expected: 1002, 1006, 1007, 1008");
        
        // Moving a permit to the home planet by taking the permit id of the parameter
        System.out.println("\n**********Moving permit 1001 back to the home planet**********");
        System.out.println("Location before moving");
        System.out.println(wayward.getPermitLocation(1001));
        wayward.moveHome (1001);
        System.out.println("Location after moving");
        System.out.println(wayward.getPermitLocation(1001));
        System.out.println(" - Expected: Home");
        
        // Evacuating all of the permits to the home planet
        System.out.println("\n**********Evacuating all of the permits back to the home planet**********");
        wayward.evacuateAll ();
        System.out.println(" - Expected: Successfully Evacuated");
        System.out.println(wayward.getAllPermitsOnOnePlanet("Home"));
        System.out.println(" - Expected: 1000, 1001,1002,1003,1004,1005,1006,1007,1008");
        
        
    }
     
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
