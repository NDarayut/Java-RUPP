import java.util.Scanner; //import scanner class
//Check if the word that user input is a palindrome

public class Exercise4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);   //make scanner object
        System.out.print("Enter a word =  ");
        String word = scanner.nextLine();   //store scanner object in string word

        System.out.println("The word you input is " + word);
        //if the function return true then we can assume that it's palindrome
        if(reversed(word))
        {
            System.out.print(word + " is Palindrome");
        }
        //if not then it's not a palindrome
        else{
            System.out.print(word + " is not Palindrome");
        }
        scanner.close();
    }
    
    //make method to check if the string is reversed
    public static boolean reversed(String word)
    {   
    //reversing the input string and convert it to string then storing it in "reverse"
    String str_reverse = new StringBuilder(word).reverse().toString();
    //equalsIgnoreCase method compares 2 string ignoring lower and upper case and return a boolean
    return word.equalsIgnoreCase(str_reverse);
    }   
    

    
}


