public class Exercise10 {
    public static void main(String[] args) {
        // There are 7 possible choice to arrange this
        int[][][] choice = {
                            {{1,1,1}, {0,0,0}}, // 1 is white 0 is black
                            {{1,1,1,0}, {0,0}},
                            {{1,1,1,0,0}, {0}},
                            {{1,1,0,0}, {1,0}},
                            {{1,0,0}, {1,1,0}},
                            {{1,1}, {0,0,0,1}},
                            {{1}, {0,0,0,1,1}}
                            };
       
        int randomBowl = 0; // variable to store random index which we will use to 
                            // randomly pick a bowl
        int randomPearl = 0;// variable to store random index which we will use to
                            // randomly pick out a pearl from a bowl

        // i denote the choice, e.g if i = 1 then it is choice 1
        // each choice is then loop 100 time to see how many time we survive
        for(int i = 0; i < choice.length; i++){
        
            int survive = 0; // variable to store how many time player survive
                             // during each choice
            // Replaying the same choice 100 times
            for(int j = 0; j < 100; j++){

                randomBowl = (int)(Math.random() * 2); // generate a number to randomly
                                                       // choose a bowl 
                randomPearl = (int)(Math.random() * choice[i][randomBowl].length); // generate a number to
                                                                                   // randomly choose a pearl             
                if(choice[i][randomBowl][randomPearl] == 1){ // if the user pick a white pearl then they survive
                    survive++; // count how many time the user have survived during each choice
                }
            }
            
            // print out which the choice and how many time have the user survived
            System.out.print("Choice " + (i+1) + " Survive: " + survive + " times");
            // loop to see how many black and white are in each bowl in choice i
            // loop to check how many pearl in bowl 1 and 2
            for(int bowl = 0; bowl < 2; bowl++){
                // variable to store the number of black and white pearls
                int black = 0, white = 0 ;
                // loop to check every single pearl's color in a bowl 
                // the loop is based on the amount of pearl in a bowl
                for(int pearl = 0; pearl < choice[i][bowl].length; pearl++){
                    // if the pearl is 0 or black then we count the black pearl
                    if(choice[i][bowl][pearl] == 0){
                        black++;
                    }
                    // else we count the white pearl
                    else{
                        white++;
                    }
                }
               // print out the combination of pearl in bowl 1 and bowl 2 in choice i
                System.out.print("\tBowl " + (bowl+1) + ": " + black + " black. " + white + " white.");
            }
            System.out.println();
        }
    }
}
