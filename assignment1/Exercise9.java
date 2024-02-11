public class Exercise9 {
    public static void main(String[] args) {
        
        //Declare vairable to be used for calculation
        double sum = 0;
        double n;

        //start n from 1 and increment all the way to 624
        for (n = 1; n <= 624; n++) {

            //Use Math.sqrt() to calculate the square root of n and n + 1 and add it to sum
            sum += 1 / (Math.sqrt(n) + Math.sqrt(n + 1));
        }

        //Once everything is added to sum we print it out to the console
        System.out.println("Sum of the following series is " + sum);
    }
}