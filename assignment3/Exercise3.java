//import Scanner class
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        //Make scanner object
        Scanner input = new Scanner(System.in);

        //Initialize variable to store youngest person and youngest age
        String youngestPerson = "";
        int youngestAge = 999;

        //Ask the user to input 3 time with this for loop
        for(int i = 1; i <= 3; i++){
            System.out.print("Enter name and age of person " + i + ": ");
            //Take user input and store in String 
            String info = input.nextLine();

            //Split the string into an array when where there's a comma and space
            String[] array = info.split(", ");
            
            //If the age of the person is younger than youngest age than it is the new youngest person
            if(Integer.parseInt(array[1]) < youngestAge){
                youngestAge = Integer.parseInt(array[1]);
                youngestPerson = array[0];
            }
        }

        //Print out the youngest person's name
        System.out.println("The youngest person is " + youngestPerson);
        
        //Closes the scanner object
        input.close();

       

    }
}
