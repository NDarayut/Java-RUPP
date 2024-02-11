public class Exercise8 {
    /* write a program to sum the following series:
    1/3 + 3/5 + 5/7 + 7/9 + 9/11 + 11/13 + ... + 95/97 + 97/99 */
    public static void main (String[] args){

        // Declare variable in double to store and compute fractional number
        double sum = 0;
        double n;

        // use for loop to iterate through the series
        for( n = 1; n <= 97; n+=2 ){
         
            //calculate the sum of the series as per the given pattern
            sum += n / (n+2);
        }
        System.out.println("Sum of the following series is " + sum); // print sum
    }
}
