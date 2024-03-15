public class Exercise9 {
    public static void main(String[] args) {
        
        // array to count how many time each player has been shot
        int[] playersShot = new int[6];

        // 1000 round out of every 6 players
        for(int round = 0; round < 1000; round++){
            // true = bullet, false = no bullet
            // after 6 player shot, we reload the barrel
            boolean[] bulletInBarrel = {false, true, true, true, true, true};

            // loop to shoot through every player
            for(int player = 0; player < 6; player ++){

                // spin the barrel
                for(int i = 0; i < bulletInBarrel.length; i++){
                    int randomIndex = (int)(Math.random() * bulletInBarrel.length);
                    boolean temp = bulletInBarrel[i];
                    bulletInBarrel[i] = bulletInBarrel[randomIndex];
                    bulletInBarrel[randomIndex] = temp;
                }

                // if the gun is fired we count player who's shot
                if(bulletInBarrel[player]){
                    playersShot[player]++;  // count how many time the player is shot 
                    bulletInBarrel[player] = false; // empty the barrel at that index
                }
            }
        }

        // print out how manyt time the player has been shot over 1000 round
        for(int i = 0; i < 6; i++){
            System.out.println("Player " + (i+1) + " got shot " + playersShot[i] + " times");
        }
    }
}
