public class Pizza {
    //setting toppings and price parameters
    private String[] toppings;
    private double price;

    //cunstructor that takes two parameters and stores then in the list
    public Pizza(String[] toppings, int numTops){
        this.toppings = new String[numTops];
        for (int now = 0; now < numTops; now++){
            this.toppings[now] = toppings[now];
        }
        calcPrice(numTops);
    }
    //calculates the price of pizza and toppings
    private void calcPrice(int numTops){
        price = 14 + (2 * numTops);
    }
    public double getPrice(){
        return price;
    }

    //makes a shopping list in the form a StringBuilder
    @Override
    public String toString(){
        StringBuilder descript = new StringBuilder("Pizza with following toppings: ");
        for (int now = 0; now < toppings.length; now++){
            descript.append(toppings[now]);
            if (now < toppings.length - 1){
                descript.append(", ");
            }
        }
        descript.append(". Price: $").append(price);
        return descript.toString();
    }
}
