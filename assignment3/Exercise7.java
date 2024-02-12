import java.util.Scanner; // import scanner class

public class Exercise7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // make scanner object

        System.out.print("Enter a sentence: ");
        String str = input.nextLine(); // store user input and store in str

        input.close(); // closes the scanner

        String[] sentence = str.split(" "); // Split the string when there's space 
                                            // and store as array of strings

        String longestWord = ""; // make variable to store longest word

        // for each word in sentence we remove 
        // those punctuation and check those string
        // are made of only alphabet
        for(String word : sentence){

            // replace the punctuation to empty char
            word = word.replaceAll("[!,.?+;]", "");

            // set it to true and if it contain
            // more than alpahabet we set it to false
            boolean isWord = true;
            for(char c : word.toCharArray()){
                if(!Character.isLetter(c)){
                    isWord = false;
                    break;
                }
            }

            // if boolean still true then it only contain alphabet
            if(isWord){
                // if the length of word longer than
                // current longest word then swap
                if(word.length() > longestWord.length()){
                    longestWord = word;
                }
            }
        }
        // print out the longest word
        System.out.println("Longest word is " + longestWord);
    }
}
