//import scanner class
import java.util.Scanner;

public class Exercise8 {
   
    public static void main(String[] args) {

        //create scanner object
        Scanner input = new Scanner(System.in);
       
        System.out.print("A password must have exactly 8 characters\n" + 
                        "A password must consist of only digits and letter\n" +
                        "A password must always start with a digit\n" +
                        "A password must contain at least one uppercase letter\n" +
                        "Enter: ");

        //take user input and store it in a variable
        String inputPassword = input.nextLine();
        //closes the scanner
        input.close();

        //call in some method to check for condition, we use if because we want to check for every condition
        if((invalidLength(inputPassword) || invalidDigitsAndLetters(inputPassword)) || 
            (invalidStartWithInteger(inputPassword) || invalidCase(inputPassword))){
            System.out.println("Invalid password");
            if(invalidLength(inputPassword)) System.out.println("A password must have exactly 8 characters");
            if(invalidDigitsAndLetters(inputPassword)) System.out.println("A password must consist of only digits and letter");
            if(invalidStartWithInteger(inputPassword)) System.out.println("A password must always start with a digit");
            if(invalidCase(inputPassword)) System.out.println("A password must contain at least one uppercase letter");
        }
      
        //if the password is valid then we will print the password and tell the user that it's valid
        else{
            System.out.println("Valid password, password is " + inputPassword);
        }
    }
//method to check if the length is invalid
public static boolean invalidLength(String password) {
    //if the length is exactly 8 return false
    if(password.length() == 8){
       return false;
    }
    //if the length is not 8 then it's true
    return true;
}

//method to check if the string contain digits and letters
public static boolean invalidDigitsAndLetters(String password){
    //string.matches() uses regex expression to check 
    if( password.matches("[a-zA-Z0-9]+")){
       //if the string mathces the regex then we 
        return false;
    }
    //if the string contain anything other than letters and digits it's true
   return true;
}

//method to check if the string start with an integer
public static boolean invalidStartWithInteger(String password){
    //use try and catch to check if the first index is an integer
    try {
        //we take the char of the first index and retrived it as a string then we try to convert it to an integer with parseInt
        //if succesful then we return false
        Integer.parseInt(String.valueOf(password.charAt(0)));
        return false;
    } catch (NumberFormatException e) {
        // If parsing fails return true
        return true;
    }
}

//method to check if there is uppercase in the string
public static boolean invalidCase(String password){
    //loop through the entire string
    for(int i = 0; i < password.length(); i++){
        //if there is atleast 1 upper character we return false
        if(Character.isUpperCase((password.charAt(i)))){
            return false;
        }
    }
    //if there's no uppercase then return true
    return true;
    }
}