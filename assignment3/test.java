import java.util.Scanner;
import java.util.Arrays;

public class test{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a line of array with space");

        String arrayString = input.nextLine();
        String[] array = arrayString.split(" ");

       
        String[] copiedArray = new String[array.length];

      

        System.arraycopy(array, 0, copiedArray, 0, array.length);
        
        Arrays.sort(copiedArray);

       

        if(Arrays.equals(array, copiedArray)){
            System.out.println("This array is in ascending order");
        }
        else{
            System.out.println("This array is not in ascending order");
        }
        input.close();


        

        
    }
}
