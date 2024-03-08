public class DeliveryPizza extends Pizza {
    private double fee;
    private String address;

    public DeliveryPizza(String[] toppings, String address, int numTops){
        super(toppings, numTops);
        this.address = address;
        calcFee(); //note to self: needed to call calcFee() here to calculate the fee properly
    }
    private void calcFee(){
        if (getPrice() > 18){
            fee = 3;
        } else {
            fee = 5;
        }
    }
    @Override
    public String toString(){
        return super.toString() + ". Delivery Address: " + address + ". Delivery Fee: $" + fee;
    }
}
