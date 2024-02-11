import java.util.Scanner;     //importing the scanner class from java.util package

class Exercise1 {
    public static void main(String[] args){

       Scanner input = new Scanner(System.in);     //Creating a scanner object that is named input
       int total = 0;     //initialize a variable with int type and has a value of 0

        while(total<=50){
            System.out.println("Enter an integer: ");
            String userInput = input.next();     //initialize user input as string 
            int inputValue = 0;     //create a new variable to parse in

            try{
                inputValue = Integer.parseInt(userInput);     //parse the user input in and convert it to integer
                total+=inputValue;                          //if successful, it will do the total calculation
               
            }
            catch(NumberFormatException ne){     //check for NumberFormatException error when parsing.
                System.out.println("Please input an integer!");
            }
        }
        input.close();     //closes the scanner
        System.out.println("Total is " + total);    //print total on screen
    }
}
