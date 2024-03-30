enum Blood {
    O, A, B, AB
}

public class BloodData {

    private Blood bloodType;
    private char RhFactor;

    //default constructor
    public BloodData() {
        this.bloodType = Blood.O;
        this.RhFactor = '+';
    }

    //Overloaded constructor
    public BloodData(Blood bloodType, char RhFactor) {
        this.bloodType = bloodType;
        this.RhFactor = RhFactor;
    }

    //get statement for bloodType
    public Blood getBlood() {
        return bloodType;
    }

    //set statement constructor
    public void setBlood(Blood bloodType) {
        this.bloodType = bloodType;
    }

    //Rh get statement
    public char getRhFactor() {
        return RhFactor;
    }

    //Rh set statement
    public void setRhFactor(char RhFactor) {
        this.RhFactor = RhFactor;
    }
}

