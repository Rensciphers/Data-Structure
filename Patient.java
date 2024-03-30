public class Patient {
    private int IdNum;
    private int age;
    private BloodData bloodData;

    //setting default parameters in initial constructor
    public Patient(){
        this.IdNum = 0;
        this.age = 0;
        this.bloodData = new BloodData();
    }

    //overload constructor
    public Patient(int IdNumber, int age, BloodData bloodData) {
        this.IdNum = IdNumber;
        this.age = age;
        this.bloodData = bloodData;
    }

    //get methods for each object
    public int getIdNumber() {
        return IdNum;
    }
    public int getAge() {
        return age;
    }
    public BloodData getBloodData() {
        return bloodData;
    }
}
