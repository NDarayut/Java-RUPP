import java.util.Scanner;   //import scanner class

class Exercise5 {
    public static void main(String[] args) {
   
    Scanner sc = new Scanner(System.in);    //make scanner object
    int n = 0;
    int value_1 = 0;
    
    while(true){
        System.out.println("Enter an even integer n so that n to the power of 3 is less than 10000");
        String input = sc.next();
      
        try{
            n = Integer.parseInt(input);    //parse the user input in and convert it to integer
            value_1 = (int)Math.pow(n, 3);  //(int) allow Math.pow() function to accept integer input

            if(n%2 == 0 && value_1 < 10000){    //check if n is even and power of 3 less than 100000
                
                while(value_1 < 10000){         //if value_1 less than 10000 keep adding 2 and take it to power of 3
                    n+=2;
                    value_1 = (int)Math.pow(n, 3);
                    
                }
                System.out.println("n is " + (n-2));    //minus 2 because it exceeded the 10000 mark
                break;
            }
            else if(n%2 == 1){       //execute below code if n is odd integer
                System.out.println("Please enter an EVEN integer");
                continue;
                
            }
            else{       //execute when value_1 exceed 10000
                System.out.println("Please try lower integer");
                continue;
            }
        }

        catch(NumberFormatException ne){     //check for NumberFormatException error when parsing.
            System.out.println("Please input an integer!");
        }
      


    
    }
    sc.close();   //close scanner
    }
}
