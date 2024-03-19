import java.util.Scanner; // import scanner class
import java.util.ArrayList; // import ArrayList class
import java.util.Arrays;   // import Arrays class

public class Exercise4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create scanner object
        System.out.print("Enter sentence here: ");
        String userSentence = input.nextLine(); // take user input as a string
        input.close(); // closes the scanner

        System.out.println(Arrays.toString(split(userSentence))); // print out the array of words
    }

    static String[] split(String sentence){
        // create arraylist because it is dynamic and its size can be adjusted
        ArrayList<String> listOfWord = new ArrayList<>();
        // stringbuilder is a mutable string which we will use to store words
        StringBuilder word = new StringBuilder();

        // loop through the string and get each characer
        for(int i = 0; i < sentence.length(); i++){
            // store the character in a char variable
            char character = sentence.charAt(i);
            // if the character is a letter, we append it to stringbuilder "word"
            if(Character.isLetter(character)){
                word.append(character);
            }
            // check if it is the end of the sentence
            else if(i == sentence.length() - 1){
                // if the stringbuilder word still contain letters
                // we add it to the list of word
                if(word.length() > 0){
                    listOfWord.add(word.toString()); 
                }
            }
            // if we hit a space or anything else other than letter
            // we append it to listOfWord
            else{
                if(word.length() > 0){
                    listOfWord.add(word.toString());
                    word.setLength(0); // reset the stringbuilder
                }
            }
        }
        // we make an array that store string with the size of 
        // the list of word
        String[] stringArray = new String[listOfWord.size()];
        // return the array containing strings
        return listOfWord.toArray(stringArray);
    }
}
