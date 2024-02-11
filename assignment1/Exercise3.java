import java.util.Scanner;     //import scanner class from java package

class Exercise3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);     //make an object to take user input
        int total = 0;     //initialize variable to calculate total

        while(true){

            System.out.println("Enter first number: ");
            String user_1 = scan.next();                     //take first user input
            System.out.println("Enter second number: ");
            String user_2 = scan.next();                     //take second user input
            int inputValue_1 = 0, inputValue_2 = 0;          //initialize value to be parse in

            try{
                inputValue_1 = Integer.parseInt(user_1);     //parse the user input 1 in and convert it to integer
                inputValue_2 = Integer.parseInt(user_2);     //parse the user input 2 in and convert it to integer
                inputValue_1 += inputValue_2;
                total+=inputValue_1;                         //store the sum of input 1 and input 2 in total
                System.out.println("Do you want to continue? [y/n]");
                String ask = scan.next();

                if(ask.equals("y")){    //check if user input is 'y'
                    continue;           //if true, it will run the loop again and add again
                }

                else if(ask.equals("n")){     //check if user input is 'n'
                    System.out.println("The total is " + total);     //if true, output user totals
                    break;
                }

                else{     //if user enter anything other than "y" and "n" it will execute the code below
                    System.out.println("Invalid input!");
                    while(ask != "y" || ask != "n"){    //if user input isnt equal to "y" or "n" this while loop will run
                        System.out.println("Do you want to continue? [y/n]");
                        ask = scan.next();
                        if(ask.equals("y")){
                            break;
                        }
                        else if(ask.equals("n")){
                            System.out.println("The total is " + total);     //if true (user input equal "n"), output user totals
                            System.exit(0);     //terminate program
                        }
                    }
                }
            }
            catch(NumberFormatException ne){     //check for NumberFormatException error when parsing.
                System.out.println("Please input an integer!");
            }
        }
        scan.close();
    }
}
