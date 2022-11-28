import java.util.Scanner;
import java.util.Random;

public class Andrew {

    public static int drawCard() {

        // Generate a random card value
        Random rand = new Random();
        int card = rand.nextInt(14);

        // Convert the card value to the points given in blackjack
        if (card >= 2 && card <= 10){
            return card;
        } else if (card == 13) {
            return 11;
        }
        else {
            return 10;
        }
    }

    // Make print not fucking stupid
    public static void print(String input){
        System.out.println(input);
    }

    // The player class, pretty self-explanatory
    public static class Player{
        int wallet;
        int hand;
        String name;
            public Player(String input){
                wallet = 100;
                hand = 0;
                name = input;
            }
    }


    public static void main(String[] args) {

        // Asking the user for their name, and making a new instance of the player object with that name
        Scanner scanner_1 = new Scanner(System.in);
        print("What is your name?");
        String name = scanner_1.nextLine();
        Player a = new Player(name);

        // The main loop of the program, this ends when the player runs out of money. Or leaves the casino I guess.
        while (a.wallet > 0){

            // Getting the bet out of the user, removing it from the wallet.
            print("How much do you wanna bet? You have " + a.wallet + " right now. ");
            int bet = scanner_1.nextInt();
            a.wallet -= bet;
            if (a.wallet < 0){
                break;
            }
            print("You now only have " + a.wallet + ". Good luck, " + a.name + "\n");

            // Special message for the first card
            int andrew_hand = drawCard();
            a.hand += drawCard();
            print(a.name + ", your first card is " + a.hand + ". Andrew's first card is " + andrew_hand);

            // The core loop of drawing the cards
            while (a.hand < 21) {
                print("Do you want to hit or stand? Type 'h' for hit and 's' for stand. ");
                String move = scanner_1.next();
                if (move.equals("h")) {
                    a.hand += drawCard();
                    print(a.name + ", your hand is at " + a.hand);
                } else {
                    print(a.name + ", your hand is at " + a.hand);
                    break;

                }
            }

            // Checking to see if they lose by busting, if yes then mock them.
            if (a.hand > 21){
                print("Ha ha you fucking dumbass I always knew you were gonna die alone. Nice bust, " +
                        a.name + "\n");
            }

            /* Andrew's algorithm! Andrew keeps drawing cards until he's over 17. Then, if he busted or you're higher,
               You win! Alternatively, andrew beat you.
             */
            else{
                while (andrew_hand < 17) {
                    andrew_hand += drawCard();
                    print("Andrew's hand is " + andrew_hand);
                }
                if (andrew_hand > 21 || andrew_hand < a.hand) {
                    print("You win! \n");
                    a.wallet += bet * 2;
                }
                else {
                    print("Andrew beat you, you stupid fucking gambling addict! ");
                }
            }
        }
        print("you lose, buckaroooooo ");
    }
}
