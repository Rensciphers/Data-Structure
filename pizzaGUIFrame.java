import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pizzaGUIFrame extends JFrame{
    private static final int MAX_TOPPINGS = 10;

    private JTextField[] toppingsField;
    private JTextField addressField;
    private JCheckBox deliveryCheckbox;
    private JTextArea outputArea;

    public pizzaGUIFrame(){
        Color red = new Color(236, 11, 67);
        Color black = new Color(3, 25, 39);
        Color blue = new Color(83, 128, 131);

        setTitle("Pizza Order");
        setSize(850, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);


        JPanel toppingsPanel = new JPanel(new GridLayout(MAX_TOPPINGS, 1));
        JLabel toppingLabel = new JLabel("Enter toppings (max " +"\n"+ MAX_TOPPINGS + "):");
        toppingLabel.setForeground(blue);
        toppingsField = new JTextField[MAX_TOPPINGS];
        for (int now = 0; now < MAX_TOPPINGS; now++){
            toppingsField[now] = new JTextField();
            toppingsField[now].setBackground(black);
            toppingsField[now].setForeground(Color.WHITE);
            toppingsPanel.add(toppingsField[now]);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(toppingLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(toppingsPanel, gbc);

        JPanel deliveryPanel = new JPanel();
        deliveryCheckbox = new JCheckBox("Delivery");
        deliveryCheckbox.setForeground(blue);
        JLabel addressLabel = new JLabel("Delivery Address: ");
        addressLabel.setForeground(blue);
        addressField = new JTextField(10);
        addressField.setBackground(black);
        addressField.setForeground(Color.WHITE);
        deliveryPanel.add(deliveryCheckbox);
        deliveryPanel.add(addressLabel);
        deliveryPanel.add(addressField);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(deliveryPanel, gbc);

        JButton orderButton = new JButton("Place Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        orderButton.setBackground(red);
        orderButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(orderButton, gbc);

        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        outputArea.setBackground(black);
        outputArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        add(scrollPane, gbc);
    }

    private void placeOrder(){
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Pizza Details: \n");

        String[] toppings = new String[MAX_TOPPINGS];
        int numTops = 0;
        for (int now = 0; now < MAX_TOPPINGS; now++){
            String topping = toppingsField[now].getText().trim();
            if (!topping.isEmpty()){
                toppings[numTops++] = topping;
            }
        }
        if (numTops == 0){
            JOptionPane.showMessageDialog(this, "Please enter at least one topping.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean isDelivery = deliveryCheckbox.isSelected();
        double deliveryFee = 0.0;
        if (isDelivery){
            String deliveryAddress = addressField.getText().trim();
            if (deliveryAddress.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter the delivery address.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            orderDetails.append("Delivery Address: ").append(deliveryAddress).append("\n");

        }

        Pizza pizza;
        if (isDelivery){
            pizza = new DeliveryPizza(toppings, addressField.getText().trim(), numTops);
        } else {
            pizza = new Pizza(toppings, numTops);
        }
        orderDetails.append(pizza.toString());

        outputArea.setText(orderDetails.toString());
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new pizzaGUIFrame().setVisible(true);
            }
        });
    }
}