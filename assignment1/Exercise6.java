import java.util.Scanner; //import Scanner class to be used later on

//Group 6
class Exercise6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);    //make scanner object
        int n;
        int positive = 0;
        int negative = 0;
        float total = 0;
       
        while(true){
            System.out.print("Enter an integer: "); 
            String input = sc.next();   //Store user input into variable input
            
            //We use try and catch to test if the input is an integer or letter
            try{
                
                n = Integer.parseInt(input);    //parse the user input in and convert it to integer

                //If user input is negative, we increment the number of negative number and add the input value to total
                if(n < 0){  
                    negative+=1;
                    total+=n;
                }

                //If user input is positive, we increment the number of positive number and add the input value to total
                else if(n > 0){
                    positive+=1;
                    total+=n;
                }

                //if user enter 0, we output the total number of positive and negative as well ass total and average value
                else{
                    System.out.println("Total number of positive integer: " + positive);
                    System.out.println("Total number of negative integer: " + negative);
                    System.out.println("Total is " + total);
                    System.out.print("Average is " + total/(negative+positive));
                    break;
                }
            }
            catch(NumberFormatException ne){    //check for NumberFormatException error when parsing.
                System.out.println("Please input an integer!");
            }
        }
        sc.close();     //close the scanner after using
    }
}
