import java.util.Scanner;   // import scanner class
import java.text.DecimalFormat; // import DecimalFormat to round float to 2 decimal

public class Exercise8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create scanner object
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // create object to format float
                                                                 // to 2 decimal point
        char[] operators = {'+', '-', '*', '/'}; // array to store operators
        float[] result = new float[5]; // variable to store calculated results
        float[] answer = new float[5]; // arrays to store the answer
        int isCorrect = 0; // to check how many correct answer we got

        String[][] question = new String[5][3]; // store the asked question
        
        // Generate 5 random questions
        for(int i = 0; i < 5; i++){

            int num1 = (int)(Math.random() * 10); // first number for calculation
            int num2 = (int)(Math.random() * 10); // second number for calculation
            int random = (int)(Math.random() * 4); // random index to select an operator

            char operation = operators[random]; // the operator is then stored as a char

            // check if the selected operator matched any case
            // if so, we perform the calculation
            switch(operation){
                case '+':
                    result[i] = num1 + num2;
                    break;  // break out of switch case
                case '-':
                    result[i] = num1 - num2;
                    break;
                case '*':
                    result[i] = num1 * num2;
                    break;
                case '/':
                    result[i] = (float)num1 / (float)num2; // this return a float 
                    String resultDivide = decimalFormat.format(result[i]); // format the float to 2 decimal
                    result[i] = Float.parseFloat(resultDivide); // convert to the 2 decimal string to float
                    break;
            }

            // store the number and operator to the respective index in the 2d array
            question[i][0] = Integer.toString(num1);  
            question[i][1] = String.valueOf(operation);
            question[i][2] = Integer.toString(num2); 

            // ask user 5 question
            System.out.print("Question " + (i+1) + ": What is " + num1 + " " + operation + " " + num2 + ": ");
            // store each answer to an array for comparison with user answer later on
            answer[i] = input.nextFloat();
        }

        // loop compare the answer to calculated result
        for(int j = 0; j < answer.length - 1; j++){
            // if correct we update the number of correct
            if(answer[j] == result[j]){
                isCorrect++;
            }
        }

        // tell user how many they got correct
        System.out.println("You get " + isCorrect + " correct answers out of 5. The detail is below");

        // loop through every question and tell which one is correct and wrong
        for(int i = 0; i < question.length; i++){
            // if the answer correct
            if(answer[i] == result[i]){
                // we print out the question, equation and tell them it is correct
                System.out.println("Question " + (i+1) + ": " + question[i][0] + 
                                " " + question[i][1] + " " + question[i][2] + " = " + answer[i] + 
                                " Correct");
            }
            // if the answer is wrong we print out the question, equation and the correct answer
            else{
                System.out.println("Question " + (i+1) + ": " + question[i][0] + 
                                " " + question[i][1] + " " + question[i][2] + " = " + answer[i] + 
                                " Incorrect. The correct answer is " + result[i]);
            }
        }
        input.close(); // close scanner
       
    }
}
