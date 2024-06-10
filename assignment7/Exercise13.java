import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; // import hash map to store card name as key and its value
import java.util.Scanner;


public class Exercise13 {

     // this method is used to generate a deck of card and shuffle it
     static ArrayList<String> deckGeneration(){
        // Initialize a 2D arraylist that hold all card names
        ArrayList<ArrayList<String>> cardName = new ArrayList<>(
            Arrays.asList(
                new ArrayList<>(Arrays.asList("Diamonds", "Clubs", "Hearts", "Spades")),
                new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"))                 
            )
        );

        // Arraylist to store deck of cards that is already shuffled
        ArrayList<String> deck = new ArrayList<>();

        // Generate the entire deck by looping through all the names
        for(String i: cardName.get(0)){
            for(String j: cardName.get(1)){
                deck.add(j + " of " + i);
            }
        }

        /*  
            Fisher Yates shuffling algorithm:
            -- Starts from the very last index of the list and swap with the index that is randomly generated.
            -- If the randomly generated index generate the same number as the index to be swap,  then it stays the same.
        */

        for(int i = deck.size() - 1; i > 0; i--){
            // Generate a random index to be swap with current index
            int random = (int)(Math.random() * (i + 1));

            // stores the current index in a temporary string
            String temporaryCard = deck.get(i);

            // swap the current index with a randomly generated index
            deck.set(i, deck.get(random));
            deck.set(random, temporaryCard);
        }

        return deck;
    }

    // this method is used to calculate the points of user and computer have in their hand
    static Integer countingPoints(ArrayList<String> hand, int turn){

        // generate a hashmap that store keys and its corresponding value
        HashMap<String, Integer> cardValue = new HashMap<String, Integer>() {{
            put("King", 0);
            put("Queen", 0);
            put("Jack", 0);
            put("Ace", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
        }};

        // Variable to keep track of user points
        Integer point = 0;

        // loop through the cards in a hand
        for(String cards: hand){

            // split each word of card by spaces
            String[] card = cards.split(" ");

            // the key is always at the first index of the string array
            // get the first index and see which key matches the one in hash map
            point += cardValue.get(card[0]);
        }

        // if the point is still 0 and is at round 2 then we assume that we got 3 picture card
        if((turn == 2) && (point == 0)){
            // set the point to the highest value to ensure winning
            point = 999;
            return point;
        }
        // if the point cannot be mod by 10 then it will just return the point
        return point % 10;
    }

    // This method check whether the user or the computer have met a required condition to win
    static void winCondition(Integer userPoints, Integer computerPoints, int turn, ArrayList<String> computerHand){
        
        // check if the user and computer points the same
        if(userPoints == computerPoints){
            System.out.println("It's a draw");
            System.out.println("Computer hand: " + computerHand);
            System.exit(0);
        }

        // check if either the user or computer score is 8 or 9, if so who's higher
        else if((userPoints > 7 && userPoints < 10) || ((computerPoints > 7 && computerPoints < 10))){
            if(userPoints > computerPoints){
                System.out.println("You won!");
                System.out.println("Computer hand: " + computerHand);
                System.exit(0);
            }
            else{
                System.out.println("Computer won!");
                System.out.println("Computer hand: " + computerHand);
                System.exit(0);
            }
        }
        
        // after turn 1 if no one got 8 or 9; check what is their score in round 2
        else if(turn == 2){
            if(userPoints > computerPoints){
                System.out.println("You won!");
            }
            else{
                System.out.println("Computer won!");
            }
        }
    }

    // method use to determine if the computr should pull or not based on their score
    static void computerDecision(Integer computerPoints, ArrayList<String> computerHand, ArrayList<String> shuffledDeck){

        // computer always pull if point under 4
        if(computerPoints < 4){
            computerHand.add(shuffledDeck.get(0));
        }

        // computer has a 80% chance to pull if has 4 points
        else if(computerPoints == 4){
            int probability = (int)(Math.random() * 100) + 1;
            if(probability <= 80){
                computerHand.add(shuffledDeck.get(0));
            }
        }

        // computer has 40% chance to pull if has 5 points
        else if(computerPoints == 5){
            int probability = (int)(Math.random() * 100) + 1;
            if(probability <= 40){
                computerHand.add(shuffledDeck.get(0));
            }
        }

        // computer has 10% chance to pull if have 6 points
        else if(computerPoints == 6){
            int probability = (int)(Math.random() * 100) + 1;
            if(probability <= 10){
                computerHand.add(shuffledDeck.get(0));
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> shuffledDeck = deckGeneration();

        ArrayList<String> computerHand = new ArrayList<>();

        ArrayList<String> userHand = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        // variable is used to calculate score of player in turn 2 (turn after their initial turn)
        int turn = 1;

        /*
            Dealing starts from the bottom of the deck and starts from computer.
            When dealing, the card should be removed from the deck.
        */
        for(int round = 1; round < 3; round++){
            computerHand.add(shuffledDeck.get(shuffledDeck.size() - 1));
            shuffledDeck.remove(shuffledDeck.size() - 1);
            userHand.add(shuffledDeck.get(shuffledDeck.size() - 1));
            shuffledDeck.remove(shuffledDeck.size() - 1);
        }
        
        System.out.println("Your hand contain: " + userHand);

        // store user and computer current point
        Integer userPoints = countingPoints(userHand, turn);
        Integer computerPoints = countingPoints(computerHand, turn);

        // check if their current point met the required condition to win/lose/draw
        winCondition(userPoints, computerPoints, turn, computerHand);

        // ask user if they wanna pull the 3rd card
        System.out.print("Do you wanna pull the third card? [y/n]: ");
        String user = input.nextLine();
        input.close();

        if("y".equals(user)){
            userHand.add(shuffledDeck.get(0));
            shuffledDeck.remove(0);

            // store user point after pulling
            userPoints = countingPoints(userHand, turn); 
        }

        computerDecision(computerPoints, computerHand, shuffledDeck);
        turn++;

        // display round 2 hand
        System.out.println("Your hand contain: " + userHand);
      
        // store computer current point
        computerPoints = countingPoints(computerHand, turn);

        // check whose point is larger 
        winCondition(userPoints, computerPoints, turn, computerHand);
        System.out.println("Computer hand: " + computerHand);

    }
}

