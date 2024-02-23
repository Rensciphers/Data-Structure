import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Please input a number");
        double[] arrayList = new double[20];
        int count;

        for (count = 0; count < arrayList.length; count++){
            Scanner in = new Scanner(System.in);
            arrayList[count] = in.nextDouble();

            System.out.println("Enter another number: ");

        }
        for (count = 0; count < arrayList.length; count++){
            System.out.println(arrayList[count]);
        }
    }
}
