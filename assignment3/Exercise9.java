import java.util.Scanner; //import scanner class

public class Exercise9 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create scanner object
        System.out.print("Enter a sentence: ");
        String str = input.nextLine(); // take user input as a string
        input.close(); // closes the scanner
        StringBuilder reversedString = new StringBuilder(); // make a mutable string to
                                                            // store the reversed string
        char delimeter = ' '; // variable to store delimeter char
        StringBuilder tmp = new StringBuilder(); // variable to temporary store
                                                // all the letters and numbers
        char lastChar;  // variable to identify the end of the string
        
        // convert string to an array of char
        for( char c : str.toCharArray()){
            // store the very last char of the array
           lastChar = str.toCharArray()[str.toCharArray().length - 1];
            
           // if the char is a delimeter or the last char of the array
           // we start appending the char of temporary string as well as
           // the delimeter to the reversedString
            if( (c == '.' || c == ',') || (c == ' ' || c == '\t' || c == lastChar)){

                // check if the last char is an alpabet or numbers
                if(Character.isLetter(c) || Character.isDigit(c)){
                    // if so, we append it immediately 
                    reversedString.append(c);
                }
                // if not we store them as a delimeter 
                // and its position will remain unchanged
                else{
                    delimeter = c;}
               
                // we store the temporary string as a temporary char array
                char[] tmpArray = tmp.toString().toCharArray();
               
                // we append each char of the array from last index to first index
                for(int i = tmpArray.length - 1; i >= 0; i--){
                    reversedString.append(tmpArray[i]);
                    // and then clear out those index
                    tmpArray[i] = ' ';
                  
                }
                // we append the delimeter at the very last to ensure 
                // their position remain the same
                reversedString.append(delimeter);

                delimeter = ' ';  // clear the delimeter
                tmp.setLength(0); // clear the temporary string
            }

            // if they are alphabet or numbers, we store them in
            // a temporary string
            else{
                tmp.append(c);
            }
        }

       System.out.print("Reversed sentence: " + reversedString); // print the reversed string
    }
}

