/**
 * Details of your team
 * 
 * @author (Eman Aziz) 
 * @version (09/04/2022)
 */
public class Teamwork
{
    private String[] details = new String[6];
    
    public Teamwork()
    {   // In each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        // If there is only 1 team member, please complete details 
        // for programmer1
        
        details[0] = "Aziz";
        details[1] = "Eman";
        details[2] = "19009987";
        details[3] = "Shaheen";
        details[4] = "Mohamed";
        details[5] = "19000687";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
