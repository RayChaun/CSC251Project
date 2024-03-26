public class Policy
{
   private double age, ageFee, smokeFee, height, weight, bmi, bmiFee, smokingNum;
   
   public Policy()
   {
   age = 0;
   ageFee = 0;
   smokeFee = 0;
   height = 0;
   weight = 0;
   bmi = 0;
   bmiFee = 0;
   smokingNum = 0;
   }
   
   public void setInfo(double a, double h, double w, double b)
   {
      age = a;
      height = h;
      weight = w;
      bmi = b;
   }
   
   public double GetBMI(double weight, double height)
   {
      return (weight * 703) / (height * height);
   }
   
   public double GetPrice(double smokingNum)
   {
      if(age > 50)
      ageFee = 75;
      
      if(smokingNum > 0)
      smokeFee = 100;
      
      if(bmi > 35)
      bmiFee = (bmi - 35) * 20;
      
      return 600 + ageFee + smokeFee + bmiFee;
   }
   
   /** this below goes into the demo file
   */
   public void printPolicyInfo(Policy policy, double price)
   {
      System.out.println("Policy Number: ");
      System.out.println("Provider Name:");
      System.out.println("Policyholder's First Name: ");
      System.out.println("Policyholder's Last Name: ");
      System.out.println("Policyholder's Age: ");
      System.out.println("Policyholder's Smoking Status: ");
      System.out.println("Policyholder's Height (in inches): ");
      System.out.println("Policyholder's Weight (in pounds): ");
      System.out.println("Policyholder's BMI: " + bmi);
      System.out.println("Policy Price: " + price);
   }
   
}