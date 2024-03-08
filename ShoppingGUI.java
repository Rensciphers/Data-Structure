import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingGUI extends JFrame {
    private ShoppingCart cart;
    private JTextArea cartTextArea;

    public ShoppingGUI() {
        //initializes new cart
        cart = new ShoppingCart();

        //setting frame
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //setting colors; creative piece
        Color purpleBlack = new Color(41, 23, 32);
        Color pink = new Color(217, 3, 104);
        Color orange = new Color(247, 92, 3);

        //creating components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); //3 rows, 1 column
        panel.setBackground(purpleBlack);

        JLabel titleLabel = new JLabel("Shopping Cart");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(pink);
        panel.add(titleLabel);

        cartTextArea = new JTextArea(10, 20);
        cartTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartTextArea);
        panel.add(scrollPane);

        JButton addItemButton = new JButton("Add ITem");
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToCart();
            }
        });
        addItemButton.setBackground(orange);
        addItemButton.setForeground(Color.WHITE);
        panel.add(addItemButton, BorderLayout.SOUTH);

        //Add panel to frame
        add(panel);

        //Displaying the frame
        setVisible(true);
    }
    private void addItemToCart() {
        try {
            String itemName = JOptionPane.showInputDialog(this, "Enter item name:");
            if (itemName != null && !itemName.isEmpty()) {
                double itemPrice = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter item price:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter quantity:"));
                Item item = new Item(itemName, itemPrice);
                ItemOrder order = new ItemOrder(item, quantity);
                cart.addItem(order);
                updateCartTextArea();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
        }
    }
    private void updateCartTextArea() {
        cartTextArea.setText("");
        for (ItemOrder order : cart.shoppingList) {
            cartTextArea.append(order.getItem().getItem() + " - Quantity: " + order.getQuantity() + " - Price: $" + order.getWholePrice() + "\n");
        }
        cartTextArea.append("Total Price: $" + cart.getTotalPrice());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShoppingGUI();
            }
        });
    }
}