import java.util.Scanner; // Import scanner class

public class Exercise6 {
    public static void main(String[] args) {
          Scanner input = new Scanner(System.in); // Create scanner object
        System.out.print("Enter 10 numbers: ");
   
        String numbers = input.nextLine();  // Store user input in string 
        input.close();  // Closes the scanner
        String[] array1 = numbers.split(" ");   // Split the string and store in array
        int[] array2 = new int[10];   // Create new array where initial value is 0
       
        // loop through array and compare if the number
        // is duplicated
        for(int i = 0; i < array1.length; i++){
            // set boolean to false because 
            // first value is always non duplicate
            boolean foundDuplicate = false;

            // compare value in array1 to array2
            for(int j = 0; j < array1.length; j++){
                // if we find any value from array1 already existed in array2
                if(Integer.parseInt(array1[i]) == array2[j]){
                    // set boolean to true then break out of loop
                    foundDuplicate = true;
                    break;
                }
            }
            // if we found no duplicate 
            // we can add the value from array1 to array2
            if(!foundDuplicate){
                array2[i] = Integer.parseInt(array1[i]);
            }

            // if we find duplicate, we wont add it 
            // and that remaining index is 0
            
        }

        // if value from that index is not 0
        // then print those value
        for(int i = 0; i < array2.length; i++){
            if(array2[i] != 0){
                System.out.print(array2[i] + " ");
            }
        }
    }
}
