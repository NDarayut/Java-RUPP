import java.util.Scanner;   //importing scanner class


//Ask the user to enter a word that contains uppercase and lowercase characters, then insert a space 
//before every capital letter (except the first character) appears in the word

public class Exercise2 {
    public static void main(String[] args)
    {   
        //making scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word with Uppercase and Lowercase = ");
        //storing user input to a string "Alphabet"
        String Aplhabet = input.nextLine();
       
        System.out.println("The word you have been enter is " + Aplhabet);
        String Result = InsertSpace(Aplhabet);  //using the InsertSpace method we just made
      
        // Display the result
        System.out.println("Result: " + Result);
        input.close();
    }

    //Making a method to insert space before every capital letter
    public static String InsertSpace(String input)
    {   
        //use string builder because it is mutable
        StringBuilder result = new StringBuilder();

        //Loop through every character in the string
        for (int i = 0; i < input.length(); i++) 
        {   
            //store the character from a specific index into a char type variable
            char currentChar = input.charAt(i);
            //if the character is uppcase and the index is more than 0, add space
            if (Character.isUpperCase(currentChar) && i > 0)    
            {
                // Insert a space before the capital letter
                result.append(' ');
            }
            //append the character to string "result"
            result.append(currentChar);
        }
        //convert from StringBuilder to String and return it
        return result.toString();
    }
    
}
