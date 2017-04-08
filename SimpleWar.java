/**  
 * NAME: <Ruoxin Huang>
 * ID: <A99084753>
 * LOGIN: <cs12whl>
 * */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class SimpleWar {
    public static int totalGames, winGames, loseGames, tieGames, winRate, loseRate, tieRate; //Use these to calculate win rates and tie rate
    public static void main( String[] args )
    {
        int[] NumberOfUsedKinds = new int[13];  //Use it to count the number of used KINDS
        String[] UsedCards = new String[52]; //Use it to count used cards

        Scanner input=new Scanner(System.in); //Scanner object that takes an input from a user 
        String[] Suits = {"Hearts","Diamonds","Spades","Clubs"}; //0,1,2,3 
        String[] Kinds = {"Two","Three","Four","Five", "Six", //0, 1, 2, 3, 4
                "Seven", "Eight", "Nine", "Ten", "Jack",  // 5,6,7,8,9
                "Queen", "King", "Ace"}; //10, 11, 12

        //stores computer moves
        LinkedList<String> computerMoves = new LinkedList<String>(); 

        //stores users moves
        LinkedList<String> userMoves = new LinkedList<String>(); 

        int suitIndex, kindIndex, userPick, counter = 0; //suit and kind chosen randomly by a computer
        boolean playAgain = true; //whether to start a new game or end 
        String userCard, computerCard; //the cards picked

        // Continue...
        Scanner in = new Scanner (System.in); 
        while(playAgain){
            //computer picks random cards until a non-repeated card is picked
            do{
                suitIndex = randomSuit(); 
                kindIndex = randomKind();
                computerCard = (Kinds[kindIndex] + " of " + Suits[suitIndex]);
            }while(Arrays.asList(UsedCards).contains(computerCard));
            NumberOfUsedKinds[kindIndex] += 1; //keep track of used numbers
            UsedCards[counter] = computerCard; //fill UsedCards with cards used
            counter++;
            computerMoves.add(computerCard); //keep track of cards computer picked
            System.out.println("My card is: " + computerCard);
            System.out.println("What is your card (kind)? (2­14, ­1 to finish the game):");

            userPick = in.nextInt() - 2; //index of card is 2 less than the card
            
            //if user enter -1, print stats, stop the game and reset everything
            if(userPick == -3){
                System.out.println("I won: " +  loseRate +  "% " + "You won: " + winRate + "% " + "We tied: " + tieRate + "%");
                System.out.println("Your moves: " + userMoves);
                System.out.println("My moves: " + computerMoves);
                System.out.println("Play again? (y/n)");
                String n = "n";
                String answer = in.next();
                Arrays.fill(UsedCards, null);
                Arrays.fill(NumberOfUsedKinds, 0);
                computerMoves = new LinkedList<String>(); 
                userMoves = new LinkedList<String>(); 
                winGames = 0;
                loseGames = 0;
                tieGames = 0;
                totalGames = 0;
                counter = 0;
                userPick = 0;
                
                //if user chooses to end game by entering n, break the while loop, otherwise continue
                if(answer.equals(n)){
                    playAgain = false;
                    System.out.println("Bye, see you later!");
                    break;
                }
                continue;
            }
            
            //check if 4 of the same number of card is dealt already
            while(NumberOfUsedKinds[userPick] == 4)
            {
                System.out.println("All cards of this type have been played. Pick another one.");
                userPick = in.nextInt() - 2;
            }
            
            //player picks random card until a non-repeated cacrd is picked
            do{
                suitIndex = randomSuit();
                userCard = (Kinds[userPick] + " of " + Suits[suitIndex]);
            }while(Arrays.asList(UsedCards).contains(userCard));
            NumberOfUsedKinds[userPick] += 1; //keep track of used numbers
            UsedCards[counter] = userCard; //keep track of used cards
            counter++;
            userMoves.add(userCard);
            System.out.println(userCard);
            compare(userPick, kindIndex); //compare which card is bigger
            System.out.println();
        }
    }   

    //generates random number
    public static int randomKind()
    {
        Random rn = new Random();
        int y = rn.nextInt(13);
        return y;
    }

    //generates random suit
    public static int randomSuit()
    {
        Random rn = new Random();
        int y = rn.nextInt(4);
        return y;
    }

    //caompares player`s card with computer`s card, and calculates win rates and tie rate
    public static void compare(int player, int computer)
    {
        if(player > computer){
            System.out.println("You won!");
            winGames = winGames + 1;
        }else if(player < computer){
            System.out.println("I won!");
            loseGames = loseGames + 1;
        }else{
            System.out.println("A tie!");
            tieGames = tieGames + 1;
        }
        totalGames = totalGames + 1;
        winRate = (int) ((winGames*100)/totalGames);
        loseRate = (int) ((loseGames*100)/totalGames);
        tieRate = (int) ((tieGames*100)/totalGames);
    }
}
