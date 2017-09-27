/**
 * Author: Daniel Eaton
 * Date: 9/26/2017
 * Email: deaton5@cnm.edu
 * Course: CSCI1152
 * */

import java.util.Scanner;

public class Lab02
{
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Number of Exemptions: ");
            int exemptions = scanner.nextInt();
            System.out.println("Gross Salary: ");
            float grossSalary = scanner.nextFloat();
            System.out.println("Interest Income: ");
            float interestIncome = scanner.nextFloat();
            System.out.println("Capital Gains: ");
            float capitalGains = scanner.nextFloat();
            System.out.println("Charitable Contributions: ");
            float charitableContributions = scanner.nextFloat();

            float totalIncome = grossSalary + interestIncome + capitalGains;
            float adjustedIncome = totalIncome - (exemptions * 1500) - charitableContributions;

            float totalTax = 0;

            if (adjustedIncome > 10000 && adjustedIncome <= 32000){
                totalTax = adjustedIncome * .15f;
            } else if (adjustedIncome > 32000 && adjustedIncome <= 50000){
                totalTax = (22000 * .15f) + (adjustedIncome-32000 * .23f);
            } else if (adjustedIncome > 50000){
                totalTax = (22000 * .15f) + (18000 * .23f) + ((adjustedIncome - 50000) * .28f);
            }

           System.out.printf("Total Income: %.2f \n", totalIncome);
            System.out.printf("Adjusted Income: %.2f \n", adjustedIncome);
            System.out.printf("Total Tax: %.2f \n", totalTax);

        }


}
