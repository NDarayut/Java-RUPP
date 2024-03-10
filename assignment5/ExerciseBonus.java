import java.util.Scanner;   // import scanner class
import java.text.DecimalFormat; // import DecimalFormat to round float to 2 decimal

public class ExerciseBonus {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); // create scanner object
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // create object to format float
                                                                 // to 2 decimal point

        char[] operators = {'+', '-', '*', '/'}; // array to store operators
        float result = 0; // variable to store calculated results
        int index = 0; // index to store the answered answer
        float[] isAnswered = new float[99]; // arrays to stored previously answered number
                                          
        // loop creating 5 questions
        for(int i = 0; i < 6; i++){

            boolean notCorrect = true; // boolean to check if the user is correct

            int num1 = (int)(Math.random() * 10); // first number for calculation
            int num2 = (int)(Math.random() * 10); // second number for calculation
            int random = (int)(Math.random() * 4); // random index to select an operator

            char operation = operators[random]; // the operator is then stored as a char

            // check if the selected operator matched any case
            // if so, we perform the calculation
            switch(operation){
                case '+':
                    result = num1 + num2;
                    break;  // break out of switch case
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (float)num1 / (float)num2; // this return a float 
                    String resultDivide = decimalFormat.format(result); // format the float to 2 decimal
                    result = Float.parseFloat(resultDivide); // convert to the 2 decimal string to float
                    break;
            }

            // check if the user answer is correct and ask them to answer
            // until they are correct
            while(notCorrect){

                System.out.print("What is " + num1 + " " + operation + " " + num2 + ": ");
                float answer = input.nextFloat(); // take user input as a float

                // if the answer isnt equal to the result we tell them wrong
                if(answer != result){
                    System.out.println("Wrong answer. Try again.");
                    
                    // check if the answer has been answered before
                    for(int j = 0; j < isAnswered.length; j++){
                        if(isAnswered[j] == answer){
                            System.out.println("You already entered " + answer);
                        }
                    }   
                    // store the answer to a specific index
                    isAnswered[index] = answer;
                    index++; // increment the index
                }
                // print if user got correct answer
                else{
                    System.out.println("You got it!");
                    notCorrect = false;
                }
            }
        }

        input.close(); // closes the input
    }
    
}
