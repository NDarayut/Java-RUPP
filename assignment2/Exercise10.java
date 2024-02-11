//import scanner class
import java.util.Scanner;
public class Exercise10 {
    public static void main(String[] args) {
        //make scanner object
        Scanner input = new Scanner(System.in);

        //take user input and store it in a variable
        System.out.print("Enter a string: ");
        String string = input.nextLine();

        //closes the scanner
        input.close();

       //initialize necessary variable
        //we split the string into sub-string based on whitespace and get the length of the array
        //(the sub string is then converted into an array)
        int wordCount = string.split("\\s+").length;
        int consonantCount = 0;
        int vowelCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        
        //loop through the string
        for(int i = 0; i < string.length(); i++){
            //get the char of the current index
            char currentChar = Character.toLowerCase(string.charAt(i));
            //check if the char is a letter
            if(Character.isLetter(currentChar)){
                //if it is a vowel, vowel++
                if(currentChar == 'a' || currentChar == 'i' || currentChar == 'e' || 
                currentChar == 'o' || currentChar == 'u'){
                    vowelCount++;
                }
                //if not a vowel then it must be a consonant 
                else{
                    consonantCount++;
                }
            }
            //if the char is a digit
            else if(Character.isDigit(currentChar)){
                digitCount++;
            }
            //if the char is whitespace we skip to avoid adding to special character
            else if(Character.isWhitespace(currentChar)) continue;
            //if no condition match then it is probably a special character
            else{
                specialCharCount++;
            }
        }
    //print all the data
    System.out.println("Number of word: " + wordCount);
    System.out.println("Number of consonant: " + consonantCount);
    System.out.println("Number of vowel: " + vowelCount);
    System.out.println("Number of digit: " + digitCount);
    System.out.println("Number of special character: " + specialCharCount);

    }
}
