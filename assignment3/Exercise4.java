//Import scanner class
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        //Make scanner object
        Scanner input = new Scanner(System.in);

        //Tell user to input and take input to store as string
        System.out.println("Enter 5 scores seperated by a space");
        String scores = input.nextLine();

        //closes scanner object
        input.close();

        //Split the string into an array when there's space
        String[] arrayScores = scores.split(" ");

        //Loop through array and store in i string
        for(String i: arrayScores){

            //Check condition and evaluate grade (i is integer type)
            if(Integer.parseInt(i) >= 90){
                System.out.println("Score is " + i + " and Grade is A");
            }
            else if((Integer.parseInt(i) >= 80) && (Integer.parseInt(i) < 90)){
                System.out.println("Score is " + i + " and Grade is B");
            }
            else if((Integer.parseInt(i) >= 70) && (Integer.parseInt(i) < 90)){
                System.out.println("Score is " + i + " and Grade is C");
            }
            else if((Integer.parseInt(i) >= 60) && (Integer.parseInt(i) < 70)){
                System.out.println("Score is " + i + " and Grade is D");
            }
            //if nothing match then it is an F
            else{
                System.out.println("Score is " + i + " and Grade is F");
            }
        }
    }
}
