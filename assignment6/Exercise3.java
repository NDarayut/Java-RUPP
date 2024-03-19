import java.util.Scanner; // import scanner class
public class Exercise3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create scanner object
        // prompt user to enter the 2 words
        System.out.print("Enter first word: ");
        String firstWord = input.nextLine();
        System.out.print("\nEnter second word: ");
        String secondWord = input.nextLine();
        input.close(); // closes the scanner

        // use the isAnagram method to check if those 2 word are anagram
        if(isAnagram(firstWord, secondWord)){
            System.out.println("These 2 word is anagram");
        }
        else{
            System.out.println("These two word is not an anagram");
        }
    }

    // method to check if 2 word are anagram that retuns a boolean and take string as input
    static boolean isAnagram(String a, String b) {
        // convert strings into arrays of characters
        char[] firstWord = a.toCharArray();
        char[] secondWord = b.toCharArray();
        
        // loop through the first string
        for(int i = 0; i < firstWord.length; i++){
            // boolean to check if the same word is found
            boolean notFoundSameWord = true;
            // loop through the second string
            for(int j = 0; j < secondWord.length; j++){
                // if we found the same characters in first and second string
                if(firstWord[i] == secondWord[j]){
                    secondWord[j] = ' '; // we set the characters that was found to empty space
                    break; // break out of the loop immediately
                }
                // if after loop through the second string and we havent found any matching characters
                // then we return false promptly exiting the method
                else if(notFoundSameWord && j == secondWord.length - 1){
                    return false;
                }
            }
        }
        // after checking everything and the else if statement doesnt run
        // then we can assume that those word are anagram and return true
        return true;
    }
}