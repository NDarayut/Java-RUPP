import java.util.ArrayList; // import arraylist class
import java.util.Scanner; // import scanner class

public class Exercise10 {

    // method to find the largest integer in arraylist
    public static Integer max(ArrayList<Integer> list){

        // initialize a variable to store the largest integer
        Integer biggestValue = 0;

        // checks if the list is empty, if yes return null
        if(list.isEmpty()){
            return null;
        }

        // check and compare every element in the list to the biggest number stored
        else{
            for(Integer i : list){
                if(i > biggestValue){
                    biggestValue = i;
                }
            }
        }

        // return the biggest element after the loop ended
        return biggestValue;
    }
    public static void main(String[] args) {

        // initialize the arraylist
        ArrayList<Integer> list = new ArrayList<>();

        // use (try-with-resources) to automatically closes scanner 
        // and prevent resource leaks
        try (Scanner input = new Scanner(System.in)) {

            // initialize a variable to store user input
            int num;
            
            // run as long as user input isnt 0
            while((num = input.nextInt()) != 0){
                // add user input to the arraylist
                list.add(num);
            }
        }
        
        // print out the list and its largest number
        System.out.println(list);
        System.out.println(max(list));
    }
}
