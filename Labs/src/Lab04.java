/*


This assignment has four objectives:
1. to understand the binary representation of unsigned (positive) integer
2. to apply command line argument
3. to use String class process the numeric string characters
4. to format the binary from decimal format and output to the console
5. to format the decimal from binary format and output to the console
Description
Computers store positive integers using binary (base 2) format. That means instead of 10 numerical
digits (called decimal or base 10 format), computers only used two digits (either 0 or 1) to represent a
positive integer. For example, 1210 will be represented as 11002 in a computer. This assignment
requires you to write a java program using command line argument to acquire any positive integer
less than 231 -1 and output it binary representation. Also acquire any unsigned binary (up to 31 bits)
from the console and output it decimal representation. Following figure shows how to convert an
unsigned decimal to its binary format (this conversation will be further discussed in the class).
Instructions
For this assignment, you must use String class to store the positive decimal and unsigned binary from the
command line arguments. Create a class Lab04 with a main() method, and a decimalTobinary()
method to convert positive decimal to binary, a binaryTodecimal()method to convert unsigned
binary to positive decimal. In the main() method, you need to pass a string to the conversion methods,
the string stores the command line argument (positive decimal and unsigned binary) after complete the
conversion, both method return a string which contain the unsigned binary and positive decimal
respectively. Your main() method then output the result to the console. A program template as follow:

Specifications
Your program must meet the following specifications:
1. Work on your own.
2. The name of the source code file must be exactly Lab04.java
3. Name it exactly: upper/lower case letters are important!
4. Comments at the top with your name, e-Name (e-mail), date, course number, and short
description of the program.
5. The output format must exactly match the example shown above, including blank line, white
space and capitalization.
Note:
 Comments at the top with your name, e-mail, date and course.
 We expect programming assignments to be implemented using Java 1.8 (the version installed in
the MS-0110, OpenLab SRC 203 POD 14, or the VMHorizon (in SB lab)). Your code will be tested on
the machines (or machines installed the same Java compiler and JVM), so make sure your code
runs on those machines.
 Submit your program to Blackboard.
 Read the syllabus for the late policy.
Example of testing your program as follows (your submitted program name is Lab04.java)
 javac Lab04.java
 java Lab04 1492 11111110
 The conversion of positive decimal number 1492 to unsigned binary is
 10111010100
 The conversion of unsigned binary number 11111110 to positive decimal is
 254
 Java Lab04 2016 11100010
 The conversion of positive decimal number 2016 to unsigned binary is
 11111100000
 The conversion of unsigned binary number 11100010 to positive integer is
 226

 */

/**
 * Name: Daniel Eaton
 * Email: deaton5@cnm.edu
 * Date: 11/8/2017
 * Course Number: CSCI 1152
 *
 * Lab04: A program used to convert Unsigned Binary Strings to Positive Decimal Format and to turn
 *        Positive Decimal Strings to Unsigned Binary Format.
 */
import java.util.Scanner;

public class Lab04 {
    public static void main(String[] args) {
        String d_s = new String(); // stores command line input argument
        String b_s = new String(); // stores the binary conversion result
        Scanner scan = new Scanner(System.in);
        int decimalString = scan.nextInt();
        String binaryString = scan.next();
        System.out.println("Decimal String: " + decimalString);
        System.out.println("Binary String: " + binaryString);
        b_s = decimalTobinary(decimalString); // decimalString from command argument
        d_s = binaryTodecimal(binaryString); // binaryString from command argument
        // your output code here;
        int x = 591;
        int y = 2;
        int j = x/y;
        System.out.println("" + b_s);
        System.out.println("Test: " + (7%2));
    }

    public static String decimalTobinary(int decimal) {
        // your positive decimal to unsigned binary code here
        StringBuilder resultString = new StringBuilder();
        int result = decimal;
        while(result != 0)
        {
            if(result % 2 == 0){
                resultString.append('0');
            }else{
                resultString.append('1');
            }
            System.out.println("Result = " + result);
            result = result/2;
        }
        return resultString.reverse().toString();
    }
    public static String binaryTodecimal(String binary) {
        // your unsigned binary to positive decimal code here
        return "test";
    }
}
