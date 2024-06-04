import java.util.ArrayList;
import java.util.Scanner;

public class Exercise9 {

     // Insertion sort to sort the array list
    public static void sort(ArrayList<Integer> list){

        // Temporary variable to hold value to be swap
        int temp; 

        // loop through the whole array starting from index 1
        for(int i = 1; i < list.size(); i++){

            // store the value at index 1 into a temporary variable
            temp = list.get(i);

            // j is the index before the current index
            int j = i - 1;

            // check if the value before the index of i is bigger than temp (current index)
            // if so set the value in index of i to the value before it
            // this loop run until the first element
            while(j >= 0 && list.get(j) > temp){
                // set the current element to the element before it if bigger
                list.set(j+1, list.get(j));
                // move to the next element on the left
                j--;
            }

            // set the temp value at a position where no element is smaller than it
            list.set(j+1, temp);
        }

        // print out the sorted array list
        System.out.println("Sorted array list: " + list);
    }

    public static void main(String[] args) {
        
        // create scanner object
        Scanner input = new Scanner(System.in);

        // initialize array list to store integer
        ArrayList<Integer> arrayListUnsorted = new ArrayList<>();

        System.out.print("Enter 5 number: ");

        // prompt the user to enter 5 numbers
        for(int i = 0; i < 5; i++){

                // add it to the array list
                arrayListUnsorted.add(input.nextInt());
            }

            // print the array list (unsorted)
            System.out.println("Unsorted array list: " + arrayListUnsorted);

            // call the sort function which takes in an array list as a parameter
            sort(arrayListUnsorted);
            
            // close scanner
            input.close();
    }
}
