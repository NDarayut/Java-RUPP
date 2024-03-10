import java.util.Scanner; // import scanner class

public class Exercise7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // create scanner object
        int index = 0; // index to store the answered answer
        int[] isAnswered = new int[99]; // arrays to stored previously answered number
        boolean notCorrect = true; // boolean to check if user answer correctly
        int result = 0; // result of the calculated summation

        int num1 = (int)(Math.random() * 10); // generate first number for calculation
        int num2 = (int)(Math.random() * 10); // generate second number for calculation

        // loop until the user answer is correct 
        while(notCorrect){

            result = num1 + num2; // summation
            
            // ask user the question
            System.out.print("What is " + num1 + " +  " + num2 + ": ");
            int answer = input.nextInt();

            // check if the answer is correct and tell the user if it's wrong
            if(answer != result){

                System.out.println("Wrong answer. Try again.");

                // check if the answer has been answered before
                for(int j = 0; j < isAnswered.length; j++){
                    // if the stored previously answered number found
                    // tell the user
                    if(isAnswered[j] == answer){
                         System.out.println("You already entered " + answer);
                    }
                }   

                // store the answer to a specific index
                isAnswered[index] = answer;
                index++; // increment the index
            }
            // if answer is correct we break out of the loop
            else{
                System.out.println("You got it!");
                notCorrect = false;
            }
        }

        input.close(); // close scanner

    }
}
