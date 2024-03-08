import java.util.ArrayList;
public class ShoppingCart {
    public ArrayList<ItemOrder> shoppingList = new ArrayList<ItemOrder>();

    public void addItem(ItemOrder order) {
        shoppingList.add(order);
    }

    public void removeItem(ItemOrder order) {
        shoppingList.remove(order);
    }

    public boolean searchItem(ItemOrder order) {
        return shoppingList.contains(order);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (ItemOrder order : shoppingList) {
            try {
                totalPrice += order.getWholePrice();
            } catch (Exception e) {
                System.err.println("Error calculating total price: " + e.getMessage());
            }
        }
        return totalPrice;
    }
}