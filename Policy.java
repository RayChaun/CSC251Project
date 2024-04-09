import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Policy
{  
   //fields
   private int policyNumber;
   private String providerName;
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;

   //constructors
   public Policy()
   {
      policyNumber = 0;
      providerName = "";
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }
   
   public Policy(int pNumber, String pName, String fName, String lName,int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }
   
   //setters
   
   /*
   @param pNumber What the policy number wil be set to
   */
   public void setPolicyNumber(int pNumber)
   {
      policyNumber = pNumber;
   }
   
   /*
   @param pName What the provider name will be set to
   */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }
   
   /*
   @param fName What the first name will be set to
   */
   public void setFirstName(String fName)
   {
      firstName = fName;
   }
   
   /*
   @param lName What the last name will be set to
   */
   public void setLastName(String lName)
   {
      lastName = lName;
   }
   
   /*
   @param a What the age will be set to
   */
   public void setAge(int a)
   {
      age = a;
   }
   
   /*
   @param sStatus What the smoking status will be set to
   */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }
   
   /*
   @param h What the height will be set to
   */
   public void setHeight(double h)
   {
      height = h;
   }
   
   /*
   @param w What the weight will be set to
   */
   public void setWeight(double w)
   {
      weight = w;
   }

   
   //getters//
   
   /*
   @return The policy number
   */
   public int getPolicyNumber()
   {
      return policyNumber;
   }
   
   /*
   @return The provider name
   */
   public String getProviderName()
   {
      return providerName;
   }
   
   /*
   @return The first name
   */
   public String getFirstName()
   {
      return firstName;
   }
   
   /*
   @return The last name
   */
   public String getLastName()
   {
      return lastName;
   }
   
   /*
   @return The age
   */
   public int getAge()
   {
      return age;
   }
   
   /*
   @return The smoking status
   */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }
   
   /*
   @return The height
   */
   public double getHeight()
   {
      return height;
   }
   
   /*
   @return The weight
   */
   public double getWeight()
   {
      return weight;
   }
   
      
   /*
   Calculates the Policyholder's BMI
   @return The BMI
   */
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
   
   /*
   Calculates the Policy's price
   @return The price of the policy
   */
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;
      
      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;
      
      double price = BASE_PRICE;
      
      if(age > AGE_THRESHOLD) //over 50 years
         price += ADDITIONAL_FEE_AGE; //75
         
      if(smokingStatus.equalsIgnoreCase("smoker")) 
         price += ADDITIONAL_FEE_SMOKING; //100
            
      //call the getBMI method
      if(getBMI() > BMI_THRESHOLD) //BMI over 35
         price += ((getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI); //additional BMI fee - 20
         
      return price;
   }
   
   //method to display policy information
   public static void displayPolicyInformation(Policy policy) 
   {
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder's First Name: " + policy.getFirstName());
      System.out.println("Policyholder's Last Name: " + policy.getLastName());
      System.out.println("Policyholder's Age: " + policy.getAge());
      System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
      System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
      System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
      System.out.println("Policyholder's BMI: " + policy.getBMI());
      System.out.println("Policy Price: $" + policy.getPrice());
      System.out.println();
    }
   
   //method for counting the number of smokers
   public static int countSmokers(Policy[] policies) 
   {
      int count = 0;
      
      for (Policy policy : policies) 
      {
          if (policy.getSmokingStatus().equals("smoker")) 
          {
             count++;
          }
      }
      return count;
   }
   
   //method to read policy information from file
   public static Policy[] readPoliciesFromFile(String filename) 
   {
      Policy[] policies = null;
      try 
      {
          File file = new File(filename);
          Scanner scanner = new Scanner(file);

          int policyCount = 0;
          while (scanner.hasNextLine()) 
          {
              scanner.nextLine();
              policyCount++;
          }

          scanner.close();

          policies = new Policy[policyCount];
          scanner = new Scanner(file);

          int index = 0;
          while (scanner.hasNextLine()) 
          {
              int policyNumber = Integer.parseInt(scanner.nextLine());
              String providerName = scanner.nextLine();
              String firstName = scanner.nextLine();
              String lastName = scanner.nextLine();
              int age = Integer.parseInt(scanner.nextLine());
              String smokingStatus = scanner.nextLine();
              double height = Double.parseDouble(scanner.nextLine());
              double weight = Double.parseDouble(scanner.nextLine());

              policies[index] = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

              index++;
          }

          scanner.close();
      } 
      catch (FileNotFoundException e) 
      {
          e.printStackTrace();
      }

      return policies;
   }
   
}
