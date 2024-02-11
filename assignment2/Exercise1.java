//Group 6
import java.util.Scanner; //import scanner class to take user input

//1. Convert each alphabet of a string into its next alphabet and print the string.

public class Exercise1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //create scanner object name input

    // Declare varriable
        int n;
        int i;
        char chr;
        String regex = "[a-zA-Z ]+"; // regular expression from 'a-z', 'A-Z' and 'space'
    
    while(true){
    // Print statement to inform user
        System.out.print("\nPlease enter alphabets \n(\"Space\" is allow to use only between alphabets): ");
        String str = input.nextLine(); //initialize user input as string

    // Check if the input is contain 'regex' value or not 
    // and make sure it isn't contain only a space  
        if(str.matches(regex) && str.charAt(0) != 32){
            System.out.print("Convert each alphabet into its next alphabet: ");

        // Use for loop to iterate through all index in string
            for (n = 0; n < str.length(); n++){

        // Use if statement to change ASCII Code of 'z' and 'Z' to 'a' and 'A'
                if(str.charAt(n) == 90 || str.charAt(n) == 122){
                    i = str.charAt(n) - 25;
                } 
                // If ASCII Code of char is 32 which means "space" keep it as it is in "i"
                else if(str.charAt(n) == 32){
                    i = str.charAt(n);
                } 
                // Else plus i by 1
                else{
                    i = str.charAt(n) + 1;
                }
            // convert ASCII Code to character
                chr = (char)i;
            // Print each character in one line
                System.out.print(chr);
            }
            break;
        }
        else{
            System.out.println("Wrong! You entered a anything other than alphabet");
        }
    }
    input.close();
    }
}
