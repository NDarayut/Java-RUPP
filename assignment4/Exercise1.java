import java.util.Scanner;   // Import scanner class

class Exercise1{
    public static void main(String[] args) {
       
        // Initialize a 3x3 array
        int[][] matrixA = new int[3][3];
        int[][] matrixB = new int[3][3];

        // Create scanner object
        Scanner input = new Scanner(System.in);

        // Loop through user input and add it to matrix A
        System.out.println("Enter Matrix A:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               
                // This reads only up to non-whitespace characters
                // that is an integer
                matrixA[i][j] = input.nextInt();
            }
        }
        // Loop through user input and add it to matrix B
        System.out.println("Enter Matrix B:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                matrixB[i][j] = input.nextInt();
            }
        }

        input.close();  //closes the scanner

        // Initialize matrix C to be the sum of matrix A and B
        int[][] matrixC = new int[matrixA.length][matrixB.length];

        System.out.println("Matrix C");
        for(int rows = 0; rows < matrixC.length; rows++){
            // Calculate the sum of each point and print it out
            // immediately
            for(int columns = 0; columns < matrixB[0].length; columns++){
                matrixC[rows][columns] = matrixA[rows][columns] + matrixB[rows][columns];
                System.out.printf("%-3d", matrixC[rows][columns]);
            }
            // Once first row is over, move to new line
            System.out.println();
        }
        

        
    }
}
