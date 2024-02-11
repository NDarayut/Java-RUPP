public class Exercise7 {
    public static void main(String[] args) {
        
        //Set count variable to keep tracks of how many number have been printed on 1 line
        int count = 0;

        //Increment i from 100 to 200
        for (int i = 100; i <= 200; i++) {

            //If i is divisible by 5 or 6 but not divisible by 30 (30 is divisible by both 5 and 6) execute code
            if ((i % 5 == 0 || i % 6 == 0) && (i % 30 != 0)) {

                //print i that is divisible by 5 or 6 but not both with a spacing of 1 line
                System.out.print(i + " ");

                //Increment count by 1
                count++;

                //If count reaches 10 then we add new line
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
