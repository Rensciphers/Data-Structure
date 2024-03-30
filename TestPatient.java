import java.util.Scanner;
public class TestPatient {
    public static void main(String[] args) {
        try {
            //initialized new patient object for patient 1
            Patient p1 = new Patient();

            //scanners for user input
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);

            //prints patient 1 data
            System.out.println("Patient 1 Data");
            System.out.println("ID Number: " + p1.getIdNumber());
            System.out.println("Age: " + p1.getAge());
            System.out.println("Blood Type" + p1.getBloodData().getBlood());
            System.out.println("rH Factor: " + p1.getBloodData().getRhFactor());

            //asks user for patient 2 data input
            System.out.println("Enter Patient 2 ID Number: ");

            //holds user input for ID, age, bloodData
            int ID = scan.nextInt();
            System.out.println("Enter Patient 2 age: ");
            int age = scan.nextInt();
            System.out.println("Enter Patient 2 blood type (0, A, B, AB) and rH Factor (+, -): ");
            String bloodData = scan2.nextLine().toUpperCase();

            //gets values for blood type and rH Factor
            Blood bld = Blood.valueOf(bloodData.substring(0, bloodData.length() - 1));
            char rH = bloodData.charAt(bloodData.length() - 1);

            //Establishes patient two with user inputted data
            Patient p2 = new Patient(ID, age, new BloodData(bld, rH));

            //prints p2
            System.out.println("Patient 2 Data");
            System.out.println("ID Number: " + p2.getIdNumber());
            System.out.println("Age: " + p2.getAge());
            System.out.println("Blood Type: " + p2.getBloodData().getBlood());
            System.out.println("rH Factor: " + p2.getBloodData().getRhFactor());

            //patient 3 data, not custom data for blood type and rh Factor
            System.out.println("Enter Patient 3 ID number: ");
            int ID3 = scan.nextInt();
            System.out.println("Enter Patient 2 age: ");
            int age3 = scan.nextInt();
            Patient p3 = new Patient(ID3, age3, new BloodData());

            //prints patient 3 data
            System.out.println("Patient 3 Data");
            System.out.println("ID Number: " + p3.getIdNumber());
            System.out.println("Age: " + p3.getAge());
            System.out.println("Blood Type: " + p3.getBloodData().getBlood());
            System.out.println("rH Factor: " + p3.getBloodData().getRhFactor());

            //closes the scanners
            scan.close();
            scan2.close();
        } catch (Exception e) {
            System.out.println("Error Ocurred: " + e.getMessage());
        }

    }
}
