import java.util.Scanner;	//import scanner class
//Ask user to input a string and remove all constanant in the string then print it

public class Exercise3 { 

	// making a function to remove const where the parameter is str
	static String  removeConstanants(String str) { 

		// replace constanants to empty string and return it to main method
		return str.replaceAll("[a-zA-Z&&[^aeiouAEIOU ]]", "");
	}

	// main method to test the above function
	public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in); //Creating a scanner object named input
        System.out.print("Enter the strings: ");
        String str = input.nextLine(); //initialize user input as string "str"

        // we pass the str value to the function and replace all const
		System.out.println("After removing consonants: " +  removeConstanants(str)); 
		input.close(); //close the scanner
        
	}
}
