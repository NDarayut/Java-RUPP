
//Ask the user to enter a sentence, then capitalizes the first character of each word in the sentence. 
//Note that the other letters beside the first letter of each word must be in the lowercase.
import java.util.Scanner; //import scanner class
public class Exercise7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //creat scanner obeject

        int i;
        System.out.println("Enter a sentence: ");
        String inpuString = input.nextLine();  //initialize user input as string
        input.close(); // close scanner

        String str = inpuString.toLowerCase(); // lowercase string
        char[] charArray = str.toCharArray();   //convert string to character array
        boolean foundSpace = true; //check whether the last character processed was a space or not

    // Use for loop to iterate through all index in character array
        for(i = 0; i < charArray.length; i++){

    //check whether index of character array is letter or not
            if(Character.isLetter(charArray[i])){  

    // It checks if a space was found before the letter
                if(foundSpace){
                    charArray[i] = Character.toUpperCase(charArray[i]); // capitalize the letter
                    foundSpace = false; // indicate that character array is already capitalize
                }

    // If the character is a space
            } else if((charArray[i] == 32)) {
                foundSpace = true;

    // If the character is not a letter
            } else{

                foundSpace = false;
            }
        }

    // covert character array back to string
        str = String.valueOf(charArray);
        System.out.println("Capitalizes the first character of each word in the sentence: ");
        System.out.println(str);
    }
}
