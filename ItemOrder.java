//takes in an item user wants and gets total of how many of that item user wants
//maybe implement bulk buying ex: two for 4
public class ItemOrder {
    private Item items;
    private int quantity;
    private double bulk; //bulk implement

    public ItemOrder(Item items, int quantity) {
        this.items = items;
        this.quantity = quantity;
        this.bulk = -1; //default is no bulk
    }

    //for bulk buying
    public ItemOrder(Item items, int quantity, double bulk){
        this.items = items;
        this.quantity = quantity;
        this.bulk = bulk;
    }

    public Item getItem() {
        return items;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWholePrice() {
        try {
            if (bulk > 0 && quantity >= 2) {
                int bulkQuant = quantity / 2; //number of times bulk applies
                int remaining = quantity % 2; //remaining items after bulk
                return (bulkQuant * bulk) + (remaining * items.getPrice());
            } else {
                return items.getPrice() * quantity;
            }
        } catch (ArithmeticException e) {
            System.err.println("Error in calculating whole price: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
