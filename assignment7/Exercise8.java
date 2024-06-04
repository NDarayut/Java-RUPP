import java.util.ArrayList; // import ArrayList class

public class Exercise8 {

    // Use recursion to locate the smallest value in the 2D array
    static ArrayList<Integer> locateSmallest(ArrayList<ArrayList<Float>> list, int row, int col, float smallestValue, ArrayList<Integer> index){
        
        // Condition to end recursion when row exceed the length of the array list
        if(row == list.size()){
            return index;
        }

         // Store the index of the smallest value after checking if it's the smallest one
        else if(list.get(row).get(col) < smallestValue){
            smallestValue = list.get(row).get(col);
            index.set(0, row);
            index.set(1, col);
        }
        
        // Move the search down by 1 row after it reaches the end of the column
        else if(col == list.get(row).size()){
            return locateSmallest(list, row + 1, 0, smallestValue, index);
        }
       
        // Move the search to the right by one column each
        return locateSmallest(list, row, col + 1, smallestValue, index);
       
    }
    public static void main(String[] args) {

        // Initialize a 2D array list
        ArrayList<ArrayList<Float>> list = new ArrayList<>();
        // Initialize an array list to pass in the index to the locateSmallest() function
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        index.add(0);

        // Randomly generate a value between 100.00 to 200.99 and store in the 2D array list
        for(int row = 0; row < 3; row++){
            // initialize a 1D list to store all the rows
            ArrayList<Float> arrayList1D = new ArrayList<>();
            for(int col = 0; col < 4;  col++){
                // Generate random float
                float randomFloat = 100 + (float)(Math.random() * 101);
                arrayList1D.add(randomFloat);
            }
            // Add the row of random float to the 2D array list
            list.add(arrayList1D);
        }

        // print out the 2D array list row by row
        for(int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        
        // Call the function
        System.out.println(locateSmallest(list, 0, 0, list.get(0).get(0), index));

    }
}
