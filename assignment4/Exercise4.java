import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {

        // Initialize 2 arrays
        int[][] array1 = {{5,6},
                          {1,2,3}};
        int[][] array2 = {{1,2,3},
                          {5,6},
                          {7,6}};
        
        // This loop set the item in array1 
        // to be compared with every item in array2
        for(int i = 0; i < array1.length; i++){

            boolean isSubset = false;

            // item in array1 is compared to item in array2 sequentially
            // if found then break out of loops
            for(int j = 0; j < array2.length; j++){

                // If item in array1 equals to item in array2
                // then isSubset is true and stop iterating
                if(Arrays.equals(array1[i], array2[j])){
                    // Set this to true so the if condition
                    // wont be true
                    isSubset = true;
                    break;
                }
            }
        
            // If isSubset is false then array1 is not subset of array2
            if(!isSubset){
                System.out.println("Array1 is not subset of Array2");
                // Terminate the program immediately when 
                // cannot find any subset
                System.exit(0);
            }
        }

        // If the program doesnt terminate then Array1 is a subset of Array2
        System.out.println("Array1 is subset of Array2");

    }     
}

