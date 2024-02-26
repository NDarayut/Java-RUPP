public class Exercise3 {
    public static void main(String[] args) {
        // Initialize array
        int[][] array = {{1, 2, 3, 4},
                         {5, 6, 7,8},
                         {9,10,11,12},
                         {13,14,15,16}};
                         
        // i start from 7 but rows will deduct it by length of array
        // which will always end up at last row of array
        // no matter the dimension
        for(int i = (array.length * 2) - 1 ; i >= 0; i--){
           
            // cols always start from 0 then increasse by 1
            for(int cols = 0; cols <= i + 2 ; cols++){
                // rows start from last rows of array then decrease by 1
                // but it increase by 1 again when cols increase by 1
                int rows = i - array.length + cols;
               
                // print only if the rows is positive value and within the dimension
                // of the arrays
                if((rows < array.length && rows >= 0)  && cols < array.length){
                    System.out.print(array[rows][cols] + " ");
                }
                
            }
    }
}
}
