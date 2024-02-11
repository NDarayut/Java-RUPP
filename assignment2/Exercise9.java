//import scanner class to take user input
import java.util.Scanner;

public class Exercise9 {
    //main method to execute program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //create scanner object
        System.out.print("Enter the value: "); //asking user to enter value
        String input = scanner.nextLine();
        scanner.close(); //close scanner object

        boolean isHexadecimal = true; //initializes a boolean variable

        // Convert the input to upppercase for case-insensitive comparison
        for (char c : input.toUpperCase().toCharArray()) {
            //if the char is not digits and not contain A-F then it's not a hexadecimal
            if (!(Character.isDigit(c) || (c >= 'A' && c <= 'F'))) {
                //change boolean value to false
                isHexadecimal = false;
                break;
            }
        }

        //check if the boolean value True or False
        if (isHexadecimal) {
            System.out.println("Yes, it is a hexadecimal");
        } 
        else {
            System.out.println("No, it's not a hexadecimal");
        }
    }
}