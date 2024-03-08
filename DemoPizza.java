import java.util.Scanner;
public class DemoPizza {

    private static final String QUIT = "QUIT";
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] toppings = new String[10];
        int numTopps = 0;

        System.out.println("Welcome to the Pizza ordering system!");

        //ask user for toppings
        while (numTopps < 10){
            System.out.print("Enter a topping (type QUIT to finish");
            String topping = input.nextLine().trim();

            if (topping.equalsIgnoreCase(QUIT)){
                break;
            }
            toppings[numTopps] = topping;
            numTopps++;
        }
        //asks user for delivery option
        System.out.println("DP you want the pizza to be delivered? (y/n): ");
        String deliverChoice = input.nextLine().trim();
        boolean yesDeliver = deliverChoice.equalsIgnoreCase("y");

        //constructs Pizza or Delivery object based on user choice
        Pizza pizza;
        if (yesDeliver){
            System.out.print("Enter the deliver address: ");
            String deliverAddress = input.nextLine().trim();
            pizza = new DeliveryPizza(toppings, deliverAddress, numTopps);
        } else {
            pizza = new Pizza(toppings, numTopps);
        }

        //display all user inputed details
        System.out.println("\nYour pizza:");
        System.out.println(pizza);

        input.close();
    }
}
