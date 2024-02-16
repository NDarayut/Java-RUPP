import java.util.Scanner;   // Import scanner class

public class Exercise10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creat scanner obeject
        System.out.print("Enter an integer number in a range of [0, 999]: ");
        int value = input.nextInt();    // Take user input

    // Declare variables in integer data type to represent index of string array
        int onesDigit;
        int tensDigit;
        int hundredsDigit;

    // Declare string array to store number in English
        String [] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        String [] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String [] hundreds = {"", "one hundred", "two hundred", "three hundred", "four hundred", "five hundred", 
            "six hundred", "seven hundred", "eight hundred", "nine hundred" };
    
    //  If number is from 0 - 19, print it directly
        if (value >= 0 && value < 20)
        {
            System.out.println("Number in English: " + ones[value]);
        }

    // If number is from 20 to 99, split into tens and ones digit
        else if (value >= 20 && value < 100)
        {
            tensDigit = value / 10;
            onesDigit = value % 10;

            // Check if the ones digit is 0 to handle special cases
            if(onesDigit == 0)
            {
                ones[onesDigit] = "";
            }

            System.out.print("Number in English: " + tens[tensDigit] + " " + ones[onesDigit]);
        }
    
    // If number is from 100 to 999, split into hundreds, tens, and ones digit
        else if (value >= 100 && value < 1000)
        {
            hundredsDigit = value / 100;
            tensDigit = (value / 10) % 10;
            onesDigit = value % 10;

            // Check if the ones digit is 0 to handle special cases
            if(onesDigit == 0){
                ones[onesDigit] = "";
            }
        
            System.out.print("Number in English: " + hundreds[hundredsDigit] + " " + tens[tensDigit] + " " + ones[onesDigit]);
        }

    // If the number is outside the range of [0, 999], inform the user
        else 
        {
            System.out.println("The number is outside the range of [0, 999]");
        }

        input.close();  // close scanner
    }    
}
