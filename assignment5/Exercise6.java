public class Exercise6 {
    public static void main(String[] args) {

        // initialize variable to store the count of won for player A
        int playerAwin = 0;

        // we check how many time they won out of 100 times
        for(int i = 0; i < 100; i++){
            // Randomize the number that player A and B will pick from 1 to 3
            int playerA = (int)(Math.random()*3)+1;
            int playerB = (int)(Math.random()*3)+1;

            // if player A pick the same number of player B
            if(playerA == playerB){
                // we count win
                playerAwin++;
            }
            
        }

        // print out how many time player A have won
        System.out.println("Player A won " + playerAwin + " times");

    }
}
