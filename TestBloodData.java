import java.util.Scanner;
public class TestBloodData {
    public static void main(String[] args) {
        //TestBloodData starts here
        Scanner scanner = new Scanner(System.in);
        //declare two BloodData objects
        BloodData storedData = new BloodData();
        BloodData userData = new BloodData();

        boolean validUserInput = false;

        while (!validUserInput) {
            try {
                //prompt user for their blood type
                System.out.println("Enter your blood type (O, A, B, AB): ");
                String userBlood = scanner.nextLine().toUpperCase();
                Blood bloodType = Blood.valueOf(userBlood); //converts stored data to user inputed data
                System.out.println("Enter Rh factor (+) or (-): ");
                char RhFactor = scanner.nextLine().charAt(0); //note to self charAt(0) gives the first character of the inputed data

                if (RhFactor != '+' && RhFactor != '-') {
                    System.out.println("Invalid input. Please input (+) or (-)");
                } else {

                    //set userData input
                    userData.setBlood(bloodType);
                    userData.setRhFactor(RhFactor);

                    //display userData to make sure it set correctly, compares two
                    System.out.println("Stored Data:");
                    System.out.println("Blood Type: " + storedData.getBlood());
                    System.out.println("rH Factor: " + storedData.getRhFactor());
                    System.out.println("User Data:");
                    System.out.println("Blood Type: " + bloodType);
                    System.out.println("rH Factor: " + RhFactor);

                    //changing values in the default to the user data
                    storedData.setBlood(bloodType);
                    storedData.setRhFactor(RhFactor);

                    //display to make sure changes were made
                    System.out.println("Updated Blood Type Data: ");
                    System.out.println(storedData.getBlood());
                    System.out.println(storedData.getRhFactor());

                    validUserInput = true; //exits while loop if no exceptions are caught
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input. Please enter a valid input.");
            }
        }
        scanner.close();
    }
}
