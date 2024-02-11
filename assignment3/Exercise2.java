//Import the ArrayList class from java.util package
import java.util.ArrayList; 

public class Exercise2 {
    public static void main(String[] args) {

        //Initialize 2 fixed size array
        String[] array1 = {"Joe", "John", "Jack"};
        String[] array2 = {"John", "Jack"};

        //ArrayList is dynamic and can be manipulated easily
        ArrayList<String> intersection = new ArrayList<>();

      
        //Loop through each item in array1 and store the string in str1
        for(String str1: array1){
            //Loop through each item in array2 and store the string in str2
            for(String str2: array2){
                //If str1 same as str2 then we add it to the dynamic array
                if(str1 == str2){
                    intersection.add(str1);
                }
            }
        }
        //Print out the array
        System.out.println("Intersection of two arrays of strings are " + intersection);
        
    }
}
