import java.util.Scanner;     //import scanner class to take user input

class Exercise2 {
    public static void main(String[] args){
   
        Scanner input = new Scanner(System.in);     //create scanner object called input
        
        while(true){

            System.out.println("Enter a number: ");
            String userInput = input.next();     //initialize user input as string 
            int inputValue = 0;     //create a new variable to be parse in

            try{
                inputValue = Integer.parseInt(userInput);     //parse the user input in and convert it to integer
                if(inputValue<=5){     //check if user input is less than or equal 5
                    continue;     //if true, it will run the loop again
                }
                else{     //if false, it will end the loop
                    System.out.println("The last number you enter is " + inputValue);
                    break;
                }
            }

            catch(NumberFormatException ne){     //check for NumberFormatException error when parsing.
                System.out.println("Please input an integer!");
            }
        }
        input.close();     //close scanner
    }
}
