import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args) {

        // Initialize the arrays
        int[][] points = {{ 8, 5 }, { 10, 1 }, { 4, 5 }, { 3, 1 }, { 1, 1 }, { 4, 1 }};
        
        System.out.println("Original array:\n" + Arrays.deepToString(points));

        // Sort the smallest value from left to right
        for(int i = 0; i < points.length; i++){

            //Initialize an empty array to temporary store 
            //An item for switch
            int[] tmp;

            // Get the next item and compare to previous item
            //Ex: if we get item from index 0 then we compare
            // them to index 1 and so on
            for(int j = i + 1; j < points.length; j++){

                // If the y coordinate are the same we check the x coordinate
                if(points[i][1] == points[j][1]){

                    // Switch the item if the first item x coordinate
                    // is larger than the next item
                    if(points[i][0] > points[j][0]){

                        // store the first item in tmp
                        tmp = points[i];

                        // swap the items
                        points[i] = points[j];
                        points[j] = tmp;
                    }
                }

                // If the first item x coordinate is larger than the next item
                else if(points[i][1] > points[j][1]){

                    // We swap the first item with the next item
                    tmp = points[i];
                    points[i] = points[j];
                    points[j] = tmp;
                }
            }
        }

        // Print the sorted array
        System.out.print("Sorted array: \n" + Arrays.deepToString(points));
    }
}
