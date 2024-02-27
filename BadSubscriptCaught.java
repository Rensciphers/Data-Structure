import java.util.InputMismatchException;
import java.util.Scanner;

public class BadSubscriptCaught {
        public static void main(String[] args){
            System.out.println("Please input an name: ");
            String[] nameList = new String[10];
            int count;

            for (count = 0; count < nameList.length; count++) {
                Scanner in = new Scanner(System.in);
                nameList[count] = in.nextLine();

                System.out.println("Enter another name: ");
                }

            //for next part
            boolean on = true;
            do {
                try {
                    Scanner in = new Scanner(System.in);
                    System.out.println("Enter a number: ");
                    count = in.nextInt();
                    System.out.println(nameList[count]);
                    on = false;
                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.out.println("Please enter a number between 0 - 9");
                } catch (InputMismatchException exception){
                    System.out.println("Please enter an integer: ");
                }
                }while (on);


//            for (count = 0; count < nameList.length; count++){
//                System.out.println(nameList[count]);
//            }
        }
    }


