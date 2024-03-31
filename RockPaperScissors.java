import java.util.Random;
import java.util.Scanner;
enum Hand{
    ROCK, PAPER, SCISSORS
}
public class RockPaperScissors {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public void play() {
        while (true) {
            System.out.println("Enter your move (Rock, Paper, Scissors)");
            String userInput = scanner.nextLine().toUpperCase();
            Hand user;

            try {
                user = Hand.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please Input a Valid Input.");
                continue;
            }

            Hand computersMove = Hand.values()[random.nextInt(Hand.values().length)];

            System.out.println("Computer Move: " + computersMove);

            if (user == computersMove) {
                System.out.println("It's a tie!");
            } else if ((user == Hand.ROCK && computersMove == Hand.SCISSORS) || (user == Hand.PAPER && computersMove == Hand.ROCK) || (user == Hand.SCISSORS && computersMove == Hand.PAPER)) {
                System.out.println("YOU WIN!!!!");
            } else {
                System.out.println("You Lose :(");
            }

            System.out.println("Would You Like To Challenge Us Again?");
            String again = scanner.nextLine().toLowerCase();

            if (!again.equals("yes")) {
                break;
            }
        }
        scanner.close();
    }

   public static void main(String[] args) {
       RockPaperScissors game = new RockPaperScissors();
       game.play();
   }
}
