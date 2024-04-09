import java.util.Scanner;// Importing scanner
import java.io.File;
import java.io.FileNotFoundException;

public class Project_raychaun_raglin
{
   public static void main(String[] args) 
   {
            
      try
      {
         

         //declare variables
         int policyNumber;
         String providerName;
         String firstName;
         String lastName;
         int age;
         String smokingStatus;
         double height;
         double weight;
         Scanner keyboard = new Scanner(System.in);
      

         //create a Policy object
         Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
         
         //put a blank line before the output
         System.out.println();
         

      }
      
      catch (FileNotFoundException e) 
      {
          e.printStackTrace();
      }
      
   }
}