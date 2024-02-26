public class Exercise2 {
    public static void main(String[] args) {

        // Initialize a 4x4 array
        int[][] array = {{1, 2, 3, 4},
                         {5, 6, 7,8},
                         {9,10,11,12},
                         {13,14,15,16}};
        
        // Start from the first row (index 0)
        for(int i = 0; i < array.length*2; i++){
           
            // The columns is always 0 until 5th iteration
            for(int cols = 0; cols <= i; cols++){
                
                // Rows increment by 1 at every iteration of i
                // and decrease by 1 subsequently at every iteraton of cols
                int rows = i - cols;
                // Check if it is out of bound since it's only a 4x4
                // array
                if(rows < array.length && cols < array.length){
                    System.out.print(array[rows][cols] + ", ");
                }
                
            }
        }
    }
}
