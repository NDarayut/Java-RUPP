import java.util.ArrayList;
import java.util.Arrays;


public class Exericse1 {
    // Static method which rotate numbers in array list to right
    static ArrayList<Integer> rotateRight(ArrayList<Integer> list){ 

        // Array list to store the rotated list
        ArrayList<Integer> rotatedList = new ArrayList<Integer>();

        // Check if the list is even
        if(list.size() % 2 == 0){

            // Start the rotation by taking the second to last index
            // and loop it to the last index with second for loop
            // this outer for loop works in way backward by decrementing 2 number at a time
            for(int i = (list.size() -2); i >= 0; i-=2){
                // This for loop is used to run second to last index to the last index
                for(int j = 0; j<2; j++){
                    rotatedList.add(list.get(i+j));
                }
            }
        }

        // Check if the Array list is odd
        else{
            // Start the rotation by taking the second to last index
            // but decrementing only by 1
            for(int i = (list.size() -2); i >= 0; i--){
                // This for loop is used to loop according to the count of i
                // to ensure that it doesnt go out of bound
                for(int j = 0; j<=i; j++){
                    rotatedList.add(list.get(i+j));
                }
            }
        }
        // Return the roated array list
        return rotatedList;

    }
    public static void main(String[] args) {

        // initialize an odd size of array list
        ArrayList<Integer> arrayListOdd = new ArrayList<Integer>(
            Arrays.asList(1, 2, 3)
        );
        // initialize an even size of array list
        ArrayList<Integer> arrayListEven = new ArrayList<Integer>(
            Arrays.asList(1, 2, 3, 5, 6, 7)
        );

        // Print both rotated array list
        System.out.print(rotateRight(arrayListOdd));
        System.out.print(rotateRight(arrayListEven));
        
    }
    
}
