//import scanner class
import java.util.Scanner;
//import arrays class to use sort and equal method
import java.util.Arrays;

public class Exercise1{
    public static void main(String[] args) {
        
        //make scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a line of array with space");

        //store user input in string
        String arrayString = input.nextLine();
        //split the user input when there's space and store it as an array
        String[] array = arrayString.split(" ");

       //initialize new array so we can copy the original array
        String[] copiedArray = new String[array.length];
        
        //copy from "array" from index 0 and store in "copiedArray"
        //until the end of the "array" index
        System.arraycopy(array, 0, copiedArray, 0, array.length);
        
        //We sort the copied array so we can compare them
        Arrays.sort(copiedArray);

        //If the original array equals the sorted copied array, then it is in ascending order
        if(Arrays.equals(array, copiedArray)){
            System.out.println("This array is in ascending order");
        }
        else{
            System.out.println("This array is not in ascending order");
        }

        //closes the scanner
        input.close();
    }
}
