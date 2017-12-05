/**
 * Name: Daniel Eaton
 * Email: deaton5@cnm.edu
 * Date: December 2, 2017
 * Course: CSCI 1152
 */


//Necessary Import Statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

//Begin Class
public class Project {

    //Begin Main Method
    public static void main(String[] args) {

        //get file from Command Line Argument
        File file = new File(args[0]);
        //Initialize two lists I will be using for sorting and collection
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        try {
            //initialize scanner to read file
            Scanner scanner = new Scanner(file);
            //delimit non alphanumeric characters
            scanner.useDelimiter("[^a-zA-Z0-9']+");

            while (scanner.hasNext()) {
                String word = scanner.next();
                //add all words in file to list
                list.add(word);
            }
            //add first variable of list to list 2 for logic purposes of the next loop
            list2.add(list.get(0));

            //adds only one of each word to list 2
            for (int i = 0; i < list.size(); i++) {

                boolean check = true;
                for (int j = 0; j < list2.size(); j++) {
                    String word = list.get(i);
                    String word2 = list2.get(j);
                    if (word.equals(word2)) {
                        check = false;
                    }
                }

                if (check) {
                    list2.add(list.get(i));
                }
            }

            //sort list 2 in ascending order
            Collections.sort(list2);
            //print total number of words in the file
            System.out.println("The total number of word in the file is: " + list.size());
            //print total number of different words in file
            System.out.println("The total number of different word in the file is: " + list2.size());
            //print words of the input file in ascending order without duplication
            System.out.println("Words of the input file in ascending order without duplication");
            for(int count = 0; count < list2.size(); count++){
                System.out.println(list2.get(count));
            }
            scanner.close();

            //initalize scanner to read input from user
            Scanner scanner2 = new Scanner(System.in);
            //prompts user for search pattern until user enters 'EINPUT'
            System.out.println("");
            System.out.print("Please enter a search pattern: ");
            String input = scanner2.next();
            while(!input.equals("EINPUT")) {
                //searches file for user
                fileSearcher(file,input);
                System.out.print("Please enter a search pattern: ");
                input = scanner2.next();
            }

            System.out.println("Bye!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    //begin method to search file for search pattern
    public static void fileSearcher(File file, String input) {
        try{
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[^a-zA-Z0-9']+");
            ArrayList<String> fullLines = new ArrayList<String>();
            ArrayList<Integer> lineMarker;
            StringBuilder resultString;
            //read file line by line and store in ArrayList<String>
            while(scanner.hasNextLine()){
                fullLines.add(scanner.nextLine());
            }
            scanner.close();
            int search;
            int startIndex;
            boolean check;
            //main logic of function that prints lines where word is found along with line number and marks location with '^'
            for(int i = 0; i < fullLines.size(); i++){
            lineMarker =  new ArrayList<Integer>();
            startIndex = 0;
            resultString = new StringBuilder(fullLines.get(i).length());
            check = false;
            boolean check2 = false;
            //gets indexes where line is found
                while(true){
                    search = fullLines.get(i).indexOf(input,startIndex);
                    if(search == -1){
                        break;
                    }else{
                        //if input is found
                        startIndex = search+ input.length();
                        lineMarker.add(search);
                        check = true;
                    }
                }

                int[] lineMarkerInts = new int[lineMarker.size()];
                int tempint = 0;
                for(int j = 0; j < lineMarker.size(); j++){
                    tempint = lineMarker.get(j);
                    lineMarkerInts[j] = tempint;
                }

                if(check) {
                    System.out.println("Line Number" + i);
                    System.out.println(fullLines.get(i));
                    for(int k = 0; k < fullLines.get(i).length(); k++){
                       for(int x = 0; x < lineMarkerInts.length; x++){
                           if(k == lineMarkerInts[x]){
                               check2 = true;
                               System.out.print("^");
                           }
                       }

                       if(!check2) {
                           System.out.print(" ");
                       }
                       check2 = false;
                    }
                }

                if(check){
                    System.out.println("");
                }

            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}