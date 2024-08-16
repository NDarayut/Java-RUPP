import java.util.HashMap;

class Exercise6{

    // a method that converts a hexstring to binary, and throw a NumberFormatException
    // if the string is not a hexstring
    static StringBuilder hex2Binary(String hexString){
        
        // get length of the string to use in for-loops
        int stringLength = hexString.length();

        // check every characters in the string if it is in range 0-9 and A-F (hexadecimal system)
        for(int character = 0; character < stringLength; character++){
            // if the character is not within the range of 0-9 and A-F
            // we throw a custom NumberFormatException that display the text "Not a hex string"
            if((hexString.charAt(character) < '0' || hexString.charAt(character) > '9') && 
                (Character.toUpperCase(hexString.charAt(character)) < 'A' || Character.toUpperCase(hexString.charAt(character)) > 'F')){
                throw new NumberFormatException("Not a hex string");
            }
        }

        // Hash table that maps all the hexadecimal value to its corresponding binary
        HashMap<Character, String> hexToBinary = new HashMap<>();
        hexToBinary.put('0', "0000");
        hexToBinary.put('1', "0001");
        hexToBinary.put('2', "0010");
        hexToBinary.put('3', "0011");
        hexToBinary.put('4', "0100");
        hexToBinary.put('5', "0101");
        hexToBinary.put('6', "0110");
        hexToBinary.put('7', "0111");
        hexToBinary.put('8', "1000");
        hexToBinary.put('9', "1001");
        hexToBinary.put('A', "1010");
        hexToBinary.put('B', "1011");
        hexToBinary.put('C', "1100");
        hexToBinary.put('D', "1101");
        hexToBinary.put('E', "1110");
        hexToBinary.put('F', "1111");

        // string builder for concatinating binary value after hex to binary conversion
        StringBuilder binary = new StringBuilder();

        // loop through every characters in the string
        // if the string is not a digit, we convert it to uppercase to check with key in hahsmap
        for(int i = 0; i < stringLength; i++){
            if(Character.isDigit(hexString.charAt(i))){
                // append the character to the string builder object
                binary.append(hexToBinary.get(hexString.charAt(i)));
                binary.append(" ");
            }
            else{
                binary.append(hexToBinary.get(Character.toUpperCase(hexString.charAt(i))));
                binary.append(" ");
            }
        }

        // return the string builder object
        return binary;
    }

    public static void main(String[] args) {

        // create 2 string for demonstration
        String hexString = "AF0";
        String notHexString = "AF0g";

        // try to convert the hexstring to binary using the method
        try {
            System.out.println("Hexstring: " + hexString + ", Binary: " + hex2Binary(hexString));
            // this print statement doesnt get print out because there is an error exception being
            // thrown from the method
            System.out.println("Hexstring: " + notHexString + ", Binary: " + hex2Binary(notHexString));
       
        }

        // catch NumberFormatException that might've been thrown by the method
        catch (NumberFormatException e) {
            System.out.println("String: " + notHexString + ", " + e.getMessage());
        }
    }
}