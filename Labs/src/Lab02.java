/**
 * Author: Daniel Eaton
 * Date: 9/26/2017
 * Email: deaton5@cnm.edu
 * Course: CSCI1152
 * */

// Import the Scanner class from the util package to receive input
import java.util.Scanner;

//begin class Lab02
public class Lab02
{
        //begin main function
        public static void main(String[] args)
        {   //initialize Scanner with System.in as a parameter to receive input
            Scanner scanner = new Scanner(System.in);
            //prompt user for number of Exemptions
            System.out.println("Number of Exemptions: ");
            //store Exemptions from the user in an integer
            int exemptions = scanner.nextInt();
            //prompt user for number of Gross Salary
            System.out.println("Gross Salary: ");
            //store grossSalary from user in a floating point value
            float grossSalary = scanner.nextFloat();
            //prompt user for number of Interest Income
            System.out.println("Interest Income: ");
            //store interestIncome from user in a floating point value
            float interestIncome = scanner.nextFloat();
            //prompt user for number of Capital Gains
            System.out.println("Capital Gains: ");
            //store capitalGains from user in a floating point value
            float capitalGains = scanner.nextFloat();
            //prompt user for number of Charitable Contributions
            System.out.println("Charitable Contributions: ");
            //store charitableContributions  from user in a floating point value
            float charitableContributions = scanner.nextFloat();
            //calculate the user's total income
            float totalIncome = grossSalary + interestIncome + capitalGains;
            //calculate the user's adjustedIncome
            float adjustedIncome = totalIncome - (exemptions * 1500) - charitableContributions;
            //initialize and declare totalTax variable
            float totalTax = 0;

            //calculate the users adjusted tax:

            //if adjusted income is greater than 10,000 and less than 32,000, tax that amount by 15%, with no tax on tax up to 1----
            //if adjusted income is greater than 32,000 and less than 50,000, tax that amount by 23% and lower amount of income appropriately
            //if adjusted income is greater than 50,000 , tax that amount by 28% and lower amount of income appropriately
            if (adjustedIncome > 10000 && adjustedIncome <= 32000){
                totalTax = (adjustedIncome-10000) * .15f;
            } else if (adjustedIncome > 32000 && adjustedIncome <= 50000){
                totalTax = (22000 * .15f) + (adjustedIncome-32000 * .23f);
            } else if (adjustedIncome > 50000){
                totalTax = (22000 * .15f) + (18000 * .23f) + ((adjustedIncome - 50000) * .28f);
            }
            // display the user's Total income, with only 2 decimal places
            System.out.printf("Total Income: %.2f \n", totalIncome);
            //display the user's Adjusted Income, with only 2 decimal places
            System.out.printf("Adjusted Income: %.2f \n", adjustedIncome);
            //display the user's Total Tax, with only 2 decimal places
            System.out.printf("Total Tax: %.2f \n", totalTax);

        }


}
