import java.util.*;
import java.util.HashMap;
/**This class implements the WISH interface
 *
 * @author (Coding Mohamed Shaheen, Supervising Eman Aziz) 
 * @version (11/04/2022) 
 **/
public class Resort implements WISH
{
    private String location;
    private ArrayList<Permit> permit_list = new ArrayList<Permit>();
    private ArrayList<Planet> planet_list = new ArrayList<Planet>();
    private ArrayList<Shuttle> shuttle_list = new ArrayList<Shuttle>();
    
    /** constructor
     */
    public Resort(String loc) 
    {
        location = loc;
        loadPlanets();
        loadPermits();
        setUpShuttles();
        put_all_permits_in_home();
    }
    
    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, on "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    public String toString()
    {
        String info = location +"\n";
        for (Planet planet: planet_list)
        {
            info += "\n" + planet.to_String();
        }
        return info;
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    public String getPermitDetails(int permitId)
    {
        Permit permit = getPermit(permitId);
        if (permit != null)
        {
            return permit.to_String();
        }
        else
        {
            return "No such permit";
        }
        
    }

    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    public int getPlanetNumber(String ww)
    {
        for (Planet planet: planet_list)
        {
            if(planet.get_planetname() == ww)
            {
                return planet.get_planetno();
            }
        }
        return -1;
    }
    
    /**Returns a String representation of all the permits on all planets
     * @return a String representation of all permits on all planets
     **/
    public String getAllPermitsOnEachPlanet()
    {
        String permits = "";
        for (Permit permit: permit_list)
        {
            permits +=  permit.to_String();
        }
        return permits;
    } 
 
    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
    public String getPermitLocation(int tr)
    {
        Permit permit = getPermit(tr);
        for (Planet planet: planet_list)
        {
            if(planet.permit_exist(permit))
            {
                return "Location: " + planet.get_planetname();
            }
        }
        return null;
    }
    
               
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    public String getAllPermitsOnOnePlanet(String planet)
    {
        Planet p1 = getPlanet(planet);
        return p1.get_permit_list();
    } 

    
     /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
      * A move can be made if:  
      * the rating of the permit  >= the rating of the destination planet
      * AND the destination planet is not full
      * AND the permit has sufficient credits
      * AND the permit is currently on the source planet
      * AND the permit id is for a permit on the system
      * AND the shuttle code is the code for a shuttle on the system
      * @param pId is the id of the permit requesting the move
      * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
      * @return true if the permit is allowed on the shuttle journey, false otherwise 
      **/
    public boolean canTravel(int pId, String shtlCode)
    {   //other checks optional
         Permit permit = getPermit(pId);
         Shuttle shuttle = getShuttle(shtlCode);
         if (permit == null || shuttle == null)
         {
            return false;
         }
         else
         {
            return shuttle.check_entry(permit);
         }
    }     

    /**Returns the result of a permit requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the permit  >= the luxury rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient credits
     * AND the permit is currently on the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the permit information is removed from the source
     * planet, added to the destination planet and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param ppId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return a String giving the result of the request 
     **/
    public String travel(int ppId, String shtlCode )
    {   //other checks optional
        Permit permit = getPermit(ppId);
        Shuttle shuttle = getShuttle(shtlCode);
        if(permit == null)
        {
            return "\nPermit doesn't exist";
        }
        else if(shuttle == null)
        {
            return "\nShuttle doesn't exist";
        }
        else
        {
            return shuttle.move_planet(permit);
        }
    } 
         
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following code
    
    /** Allows a permit to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the permit toping up their credits
     *  @param creds the number of credits purchased to be added to permits information
     */
    public void topUpCredits(int id, int creds)
    {
        Permit permit = getPermit(id);
        permit.add_credits(creds);
    }
    
    //**************Additional Functionality - Challenge tasks**************
    // this method gets all permits with luxury rating above 5
    public String getRichGuests ()
    {
        String richguests= "";
        for(Permit permit: permit_list)
        {
            if(permit.get_luxuryRating() > 5)
            {
                richguests += permit.to_String();
            }
        }
        return richguests;
    }
    
    // this method moves a permit to the home planet by taking the permit id of the parameter
    public void moveHome(int permit_id)
    {
        Permit permit = getPermit(permit_id);
        Planet Home = getPlanet("Home");
        for(Planet planet: planet_list){
            if(planet.permit_exist(permit))
            {
                planet.leave(permit);
            }
        }
        Home.enter(permit);
    }
    
    // this method evacuates all permits to the home planet
    public void evacuateAll ()
    {
        for(Planet planet: planet_list)
        {
            for(Permit permit: permit_list)
            {
                if(planet.permit_exist(permit))
                {
                    planet.leave(permit);
                }
            }
        }
        put_all_permits_in_home();
    }
   
    //***************private methods**************
    // this method automaticall puts all the permits on the home planet initially
    private void put_all_permits_in_home()
    {
        Planet Home = getPlanet("Home");
        for(Permit permit: permit_list)
        {
            Home.enter(permit);
        }
    }
    // this method load all the planet objects on the planetlist listarray
    private void loadPlanets()
    {
        Planet p1 = new Planet(0,"Home",0,1000);
        planet_list.add(p1);
        Planet p2 = new Planet(1,"Sprite",1,100);
        planet_list.add(p2);
        Planet p3 = new Planet(2,"Tropicana",3,10);
        planet_list.add(p3);
        Planet p4 = new Planet(3,"Fantasia",5,2);
        planet_list.add(p4);
        Planet p5 = new Planet(4,"Solo",1,1);
        planet_list.add(p5);
    }
    // this loads all the shuttle objects on the shuttlelist arraylist
    private void setUpShuttles()
    {
        Planet Home = getPlanet("Home");
        Planet Sprite = getPlanet("Sprite");
        Planet Tropicana = getPlanet("Tropicana");
        Planet Fantasia = getPlanet("Fantasia");
        Planet Solo = getPlanet("Solo");
        
        Shuttle s1 = new Shuttle("ABC1",Home,Sprite);
        shuttle_list.add(s1);
        Shuttle s2 = new Shuttle("BCD2",Sprite,Home);
        shuttle_list.add(s2);
        Shuttle s3 = new Shuttle("CDE3",Sprite,Tropicana);
        shuttle_list.add(s3);
        Shuttle s4 = new Shuttle("DEF4",Tropicana,Sprite);
        shuttle_list.add(s4);
        Shuttle s5 = new Shuttle("JKL8",Tropicana,Fantasia);
        shuttle_list.add(s5);
        Shuttle s6 = new Shuttle("EFG5",Fantasia,Sprite);
        shuttle_list.add(s6);
        Shuttle s7 = new Shuttle("GHJ6",Sprite,Solo);
        shuttle_list.add(s7);
        Shuttle s8 = new Shuttle("HJK7",Solo,Sprite);
        shuttle_list.add(s8);
    }
    
    // this method loads all the permitobjects on the permitlist arraylist
    private void loadPermits()
    {
        Permit p1 = new Permit(1000,"Lynn",5,10);
        permit_list.add(p1);
        Permit p2 = new Permit(1001,"May",3,20);
        permit_list.add(p2);
        Permit p3 = new Permit(1002,"Nils",10,20);
        permit_list.add(p3);
        Permit p4 = new Permit(1003,"Olek",2,12);
        permit_list.add(p4);
        Permit p5 = new Permit(1004,"Pan",3,3);
        permit_list.add(p5);
        Permit p6 = new Permit(1005,"Quin",1,5);
        permit_list.add(p6);
        Permit p7 = new Permit(1006,"Raj",10,6);
        permit_list.add(p7);
        Permit p8 = new Permit(1007,"Sol",7,20);
        permit_list.add(p8);
        Permit p9 = new Permit(1008,"Tel",6,24);
        permit_list.add(p9);
    }
    
    // this method returns all the planet names inside the resort
    private String get_all_planets()
    {
        String planets = "";
        for (Planet planet: planet_list)
        {
            planets += "\n" + planet.get_planetname();
        }
        return planets;
    }
 
    /** Returns the permit with the permit id specified by the parameter
     * @return the permit with the specified name
     **/
    public Permit getPermit(int id)
    {
        for (Permit permit: permit_list)
        {
            if(permit.get_permitID() == id)
            {
                return permit;
            }
        }
        return null;
    }
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Planet getPlanet(String planetName)
    {
        for (Planet planet: planet_list)
        {
            if(planet.get_planetname().equals(planetName))
            {
                return planet;
            }
        }
        return null;
    }
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Shuttle getShuttle(String shut)
    {
        for (Shuttle shuttle: shuttle_list)
        {
            if(shuttle.get_shuttleNo().equals(shut))
            {
                return shuttle;
            }
        }
        return null;
    }
}