/**
 * Author Daniel Eaton
 * Email: deaton5@cnm.edu
 * Course: CS1152-101
 * Date: 10/18/2017
 *
 * The purpose of Class Lab03 is to iterate through an array of times and find the fastest and second fastest times
 * and display them to the user in a manner dictated by my Professor.
 */

// Begin Class Lab 03
public class Lab03 {
    //begin main method
    public static void main(String[] arguments) {
        //declare and initialize the array names, with string items representing a runner's name
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };

        //declare and initialize the array times, with integer items representing a runner's time
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };
        //run fastestIndex method with 'times' as an argument, to store the index of the fastest runner in i1
        int i1 = fastestIndex(times);
        //run secondFastestIndex method with 'times' as an argument, to store the index of the second fastest runner in i2
        int i2 = secondFastestIndex(times);

        /*
         run output() function with the arguments names, times, i1, and i2 to output the information in a proper manner to
         the user
        */
        output(names,times, i1,i2);
    }
    // End Main Method

    /**
     *
     * @param  times: array of integers representing runner's times
     * @return int fastestTimeIndex: The index of the fastest time in the array.
     */
    private static int fastestIndex(int[] times) {
        int fastestTimeIndex = 0;
        //iterate through to find the fastest time
        for (int count = 0; count < times.length - 1; count++) {
            if (times[count] > times[count + 1] && times[fastestTimeIndex] > times[count + 1]) {
                fastestTimeIndex = count + 1;
            }
        }
        return fastestTimeIndex;
    }

    /**
     *
     * @param times array of integers representing runners times
     * @return int secondFastestIndex: the array index number of the second fastest time
     */
    private static int secondFastestIndex(int[] times) {
        //use
        int fastestTimeIndex = fastestIndex(times);
        int secondFastestTimeIndex = 0;

        //iterate through loop once searching for the biggest number just in case the first number in the array is the lowest
        for(int count = 0; count < times.length-1; count++){
            if (times[count] < times[count + 1]) {
                secondFastestTimeIndex = count + 1;
            }
        }

        for(int count = 0; count < times.length; count++) {
            for(int count2 = 0; count2 < times.length; count2++) {
                if (times[count] < times[count2] && times[count] < times[secondFastestTimeIndex] && times[count] > times[fastestTimeIndex]) {
                    secondFastestTimeIndex = count;
                }
            }
        }
        return secondFastestTimeIndex;
    }//

    /**
     *
     * @param names array of names of runners
     * @param times array of times of runners
     * @param fastest index number of fastest time
     * @param secondFastest index number of 2nd fastest time
     */
    public static void output(String names[], int times[],int fastest, int secondFastest){

        //Initialize Stringbuilders used to determine spaces that should go in between each name
        StringBuilder spacesFastestBuilder = new StringBuilder();
        StringBuilder spacesSecondFastestBuilder = new StringBuilder();

        ////if else statements to determine number of spaces in between the name and time of the fastest runner
        if(names[fastest].length() > 4 ){
        for(int index = 0; index <= 15 - (names[fastest].length()-4) ; index++) {
            spacesFastestBuilder.append(" ");
        }}else if(names[fastest].length() < 4){
            for(int index = 0; index <= 15 + names[fastest].length();index++)
                spacesFastestBuilder.append(" ");
        } else if( names[fastest].length() == 4 ){
            for(int index = 0; index <= 15; index++)
                spacesFastestBuilder.append(" ");
        }
        //if else statements to determine number of spaces in between the name and time of the second fastest runner
        if(names[secondFastest].length() > 4 ){
            for(int index = 0; index <= (15 - (names[secondFastest].length()-4)) ; index++) {
                spacesSecondFastestBuilder.append(" ");
            }}else if(names[secondFastest].length() < 4){
            for(int index = 0; index <= 15+ names[secondFastest].length(); index++)
                spacesSecondFastestBuilder.append(" ");
        } else{
            for(int index = 0; index <= 15; index++)
                spacesSecondFastestBuilder.append(" ");
        }

        //changing the Stringbuilders to Strings for output
        String spacesFastest = spacesFastestBuilder.toString();
        String spacesSecondFastest = spacesSecondFastestBuilder.toString();

        //Ouput information to user
        System.out.println("Name                Time(minutes)");
        System.out.println("_________________________________");
        System.out.println(names[fastest] +  spacesFastest + times[fastest]);
        System.out.println(names[secondFastest] + spacesSecondFastest + times[secondFastest]);
    }//end output function
}// end class Lab03