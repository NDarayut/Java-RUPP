import java.util.Scanner;     //import scanner class from package

class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     //make scanner object to take user input
        int computer_num = 50;
        int attempts = 1;     //initialize variable attempt to keep tracks of user attempt

        while(true){
            System.out.println("Guess a number: ");
            String guess = sc.next();     //take user input
            int value_1 = 0;     //initialize variable to be parse in

            try{
                value_1 = Integer.parseInt(guess);     //parse the user input in and convert it to integer
                if(value_1 > computer_num){            //compare if the user input is higher than true value
                    System.out.println("Too high!");   //if it's too high it will tell the user "Too high"
                    attempts += 1;     //add 1 to the attempts variable
                    continue;
                }
                else if(value_1 < computer_num){     //compare if the user input is lower than true value
                    System.out.println("Too low!");  //if it's lower then it will output "Too low"
                    attempts += 1;     //add 1 to the attempts variable
                    continue;
                }
                else{       //if user guess correctly it will output number of attempts
                    System.out.println("Well done you took " + attempts + " attempt/s"); 
                    break;     //break the forver loop
                }
            }

            catch(NumberFormatException ne){     //check for NumberFormatException error when parsing.
                System.out.println("Please input an integer!");
            }
        }
        sc.close();
    }
}
