//Group 6
import java.util.LinkedHashSet;
import java.util.Scanner;
public class Exercise6
{
    public static void main(String[] args)
    {
        java.util.Scanner word = new Scanner(System.in);
        System.out.print("Enter a word = ");
        String words = word.nextLine();

        String result = Removed(words);

        System.out.println("String after removing duplicates: " + result);
        word.close();
    }
    public static String Removed(String words)
    {
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        //take user input (string) then convert and store it as an array of characters
        char[] chars = words.toCharArray();

        //for each character in the array
        for (char c : chars) {
            
            //if the character is not in the set add it
            charSet.add(Character.toLowerCase(c));
        }
        StringBuilder result = new StringBuilder();
        for (Character c : charSet) {
            result.append(c);
        }
        return result.toString();
    }
}
