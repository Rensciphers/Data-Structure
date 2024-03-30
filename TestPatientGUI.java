import javax.swing.*;
public class TestPatientGUI {
    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        Patient p1 = new Patient();
        int id2 = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number for patient 2: "));
        int age2 = Integer.parseInt(JOptionPane.showInputDialog("Enter age for patient 2: "));
        String bloodType2 = JOptionPane.showInputDialog("Enter Blood Type for patient 2 (O, A, B, AB): ").toUpperCase();
        Blood blood2 = Blood.valueOf(bloodType2);
        char rHFactor2 = JOptionPane.showInputDialog("Enter rH Factor for patient 2 (+) or (-)").charAt(0);

        BloodData bloodData2 = new BloodData(blood2, rHFactor2);
        Patient p2 = new Patient(id2, age2, bloodData2);
        int id3 = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number for patient 3: "));
        int age3 = Integer.parseInt(JOptionPane.showInputDialog("Enter age for patient 3: "));
        Patient p3 = new Patient(id3, age3, new BloodData());

        data.append("Patient 1 Data (Default)\n");
        data.append("ID Number: ").append(p1.getIdNumber()).append("\n");
        data.append("Age: ").append(p1.getAge()).append("\n");
        data.append("Blood Data: ");
        data.append(displayBloodData(p1.getBloodData())).append("\n\n");

        data.append("Patient 2 Data \n");
        data.append("ID Number: ").append(p2.getIdNumber()).append("\n");
        data.append("Age: ").append(p2.getAge()).append("\n");
        data.append("Blood Data: ");
        data.append(displayBloodData(p2.getBloodData())).append("\n\n");

        data.append("Patient 1 Data \n");
        data.append("ID Number: ").append(p3.getIdNumber()).append("\n");
        data.append("Age: ").append(p3.getAge()).append("\n");
        data.append("Blood Data: ");
        data.append(displayBloodData(p3.getBloodData())).append("\n\n");

        JOptionPane.showMessageDialog(null, data.toString(), "Patient Data", JOptionPane.INFORMATION_MESSAGE);
    }
    public static String displayBloodData(BloodData bloodData) {
        StringBuilder dataOutput = new StringBuilder();
        dataOutput.append("Blood Type: ").append(bloodData.getBlood()).append("\n");
        dataOutput.append("rH Factor: ").append(bloodData.getRhFactor()).append("\n");
        return dataOutput.toString();
    }
}
