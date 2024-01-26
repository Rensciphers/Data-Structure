import java.util.Scanner;
public class ChangeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creative implement, checks if the user implements a decimal
        //displays message if invalid input is inputted
        while (true) {
            System.out.println("Enter Amount: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Please Enter a Valid Amount");
                sc.next();
            } else {

                double input = sc.nextDouble();

                //converts input to cents
                int cents = (int) Math.round(input * 100);
                //calculates quarters
                int quarters = cents / 25;
                cents = cents % 25;
                int dimes = cents / 10;
                cents = cents % 10;
                int nickels = cents / 5;
                cents = cents % 5;
                int pennies = cents;

                //prints out number of each cent, also checks for single coins and changes wording
                if (quarters == 1){
                    System.out.println("Quarter: 1");
                } else {
                    System.out.println("Quarters: " + quarters);
                }
                if (dimes == 1){
                    System.out.println("Dime: 1");
                } else{
                    System.out.println("Dimes: " + dimes);
                }
                if (nickels == 1){
                    System.out.println("Nickel: 1");
                } else {
                    System.out.println("Nickels: " + nickels);
                }
                if (pennies == 1){
                    System.out.println("Penny: 1");
                } else{
                    System.out.println("Pennies: " + pennies);
                }

                break;
            }
        }
        sc.close();
    }
}
