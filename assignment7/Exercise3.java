import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {

    // creat a static variable that can be use by all methods in the class
    static ArrayList<Integer> arrayList = new ArrayList<>();

    // static method that checks for duplicates integer
    static void checkDuplicates(int num){

        // if the array doesn't contain the entered number, add it to the array list
        if(!arrayList.contains(num)){
            arrayList.add(num);
        }

    }
    public static void main(String[] args) {

        // create a scanner object
       try( Scanner input = new Scanner(System.in)){

        // variable to store user entered number
            int number;

            // ask the user to enter a number
            System.out.print("Enter number: ");
            number = input.nextInt();

            // infinite loop to check if the user had entered 0
            while(number != 0){

                // call in the method to check for duplicates
                Exercise3.checkDuplicates(number);

                // ask the user again but this time in the infinite loop
                System.out.print("Enter number: ");
                number = input.nextInt();
            }
        }

        // print out the array list
        System.out.println(arrayList);
        

    }
}
