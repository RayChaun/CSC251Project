import java.util.Scanner;// Importing scanner
public class Project_raychaun_raglin
{
   public static void main(String[] args)
   {
   Scanner keyboard = new Scanner(System.in);
   Policy policy = new Policy();
   
   int policyNumber;
   double a = 0, h, w, bmi, price;
   double smokingNum = 0;
   String providerName, policyholderFirst, policyholderLast, smokingStatus;
   
   
   System.out.println("Please enter the Policy Number: ");
   policyNumber = keyboard.nextInt();
   
   System.out.print("Please enter the Provider Name: ");
   providerName = keyboard.nextLine();
   
   System.out.print("Please enter the Policyholder's First Name: ");
   // Not sure why this line is getting skipped
   policyholderFirst = keyboard.nextLine();
   
   System.out.print("Please enter the Policyholder's Last Name: ");
   policyholderLast = keyboard.nextLine();
   
   System.out.println("Please enter the Policyholder's Age: ");
   a = keyboard.nextDouble(); 
   
   System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
   // Not sure why this line is getting skipped
   smokingStatus = keyboard.nextLine();
   
   System.out.print("Please enter the Policyholder's Height (in inches): ");
   h = keyboard.nextDouble();
   
   System.out.print("Please enter the Policyholder's weight (in pounds): ");
   w = keyboard.nextDouble();
   
   if(smokingStatus.equals("smoker"))
   smokingNum = 1;
   
   bmi = policy.GetBMI(w, h);
   price = policy.GetPrice(smokingNum);
   
   System.out.println("Policy Number: " + policyNumber);
   System.out.println("Provider NameL: " + providerName);
   System.out.println("Policyholder's First Name: " + policyholderFirst);
   System.out.println("Policyholder's Last Name: " + policyholderLast);
   System.out.println("Policyholder's Age" + a);
   System.out.println("Policyholder's Smoking Status: " + smokingStatus);
   System.out.println("Policyholder's Height: " + h);
   System.out.println("Policyholder's Weight: " + w);
   System.out.println("Policyholder's BMI: " + bmi);
   System.out.println("Policy Price: " + price);
   }
}
