public class Exercise8 {
    public static void main(String[] args) {

        // make a boolean with size of 51 but use 1 to 50
        boolean[] lockers = new boolean[51];
        // count how many open lockers are there
        int count = 0;

        // lockers 1 is open and the rest is close 
        // according to the exercise
        for(int p = 1; p < lockers.length; p++){

            // we close/open every locker with 1 increment
            // if the player is 1 or 2
            if(p == 1 || p ==2){
                for(int i = p; i < lockers.length; i++){
                    // swap open to close and close to open
                    lockers[i] = !lockers[i];
                }
                continue;
            }

            // we start from p and increment according to p
            // eg start from 3 and increment to 6, 9, 12...
            for(int i = p; i < lockers.length; i+=p){
                // swap open to close and close to open
                lockers[i] = !lockers[i];
            }
        }

        // print every open lockers and count how many there are
        for(int i = 1; i < lockers.length; i++){
            if(lockers[i]){
                System.out.print("L" + i + " ");
                count++;
            }
        }
        System.out.print("\nTotal number of open lockers: " + count);
      
    }
}
