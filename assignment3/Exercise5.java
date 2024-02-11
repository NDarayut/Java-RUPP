//Import scanner class
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {

        //Make scanner object
        Scanner input = new Scanner(System.in);

        //Tell user to input and store in String numbers
        System.out.println("Enter 10 integers between 1 and 100 separated by space");
        String numbers = input.nextLine();

        //Closes the scanner
        input.close();

        //Split the string when there's space and store in array
        String[] array = numbers.split(" ");

        //Initialize the new array to index 101 to check which number occurs
        //we choose 101 because we want to count from 1 to 100
        int[] occurrences = new int[101];

        //Loop through each item in array and store in i
        for(String i: array){
            
            //Convert the integer whose type is String to Type integer
            //and store in "value"
            int value = Integer.parseInt(i);

            //Use index to tell which number occurs and how many time they occured
            //For example occurences[3]++ means that index 3 has value of 1
            //Therefore index 3 occur 1 time
            occurrences[value]++;
        }

        //Loop through all 100 index
        for (int i = 1; i <= 100; i++) {

            //If that index is greater than 1 we print out the index and it's value
            //The value indicates the number of time the index occurs
            //occurences[i] > i because to check for plurality
            if (occurrences[i] > 1){
                System.out.println(i + " occurs " + occurrences[i] + " times");
            }

            //Else if the occurences of that index is only 1 time
            //We use singular form
            else if(occurrences[i] == 1){
                System.out.println(i + " occurs " + occurrences[i] + " time");
            }
        }
    }
}
