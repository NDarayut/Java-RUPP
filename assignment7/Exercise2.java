import java.util.ArrayList;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {

        // Initialize the first 2D array
        ArrayList<ArrayList<Integer>> List1 = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(5, 7)),
                new ArrayList<>(Arrays.asList(9, 11))
            )
        );

        // Initialize the second 2D array
        ArrayList<ArrayList<Integer>> List2 = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(6, 8)),
                new ArrayList<>(Arrays.asList(10, 12, 14))
            )
        );

        // Initialize the 2D array to store zip arrays
        ArrayList<ArrayList<Integer>> zipArrayList = new ArrayList<>();

        if(List1.size() == List2.size()){
            // Get the rows of the Array list
            for(int j = 0; j < List1.size(); j++){

                // Initiialize a temporary array to store all the element from List 1 and 2
                ArrayList<Integer> temporary = new ArrayList<>();
                // loop through cols of list 1
                for(int i = 0; i < List1.get(j).size(); i++){
                    temporary.add(List1.get(j).get(i));
                }
                // loop through cols of list 2
                for(int i = 0; i < List2.get(j).size(); i++){
                    temporary.add(List2.get(j).get(i));
                }
                
                // add the temporary array to the zip array
                zipArrayList.add(temporary);
          
            }
            // print zip array
            System.out.print(zipArrayList);
        }
        else{
            System.out.println("Array not the same size");
        }

    }
}
