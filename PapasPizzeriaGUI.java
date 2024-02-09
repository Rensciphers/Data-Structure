import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class PapasPizzeriaGUI extends JFrame {
   //setting frame size
    final static int FRAME_WIDTH = 500;
    final static int FRAME_HEIGHT = 400;

    public String size = "Small"; //sets default size to small
    public boolean peperoni = false;
    public boolean mushroom = false;
    public boolean broccoli = false;

    public boolean extraCheese = false;

    private JLabel calcprice = new JLabel("");

    private JLabel price;

    //looked up how to use a hashmap for key/value pairs (creative aspect)
    //note for self: hashmaps map variables together in key value pairs (like dictionaries in python)
    private static HashMap<String, Double> priceSize = new HashMap<>();

    static{
        priceSize.put("Small", 5.00);
        priceSize.put("Medium", 10.00);
        priceSize.put("Large", 15.00);
        priceSize.put("Super", 20.00);
    }

    public PapasPizzeriaGUI() {
        //custom colors creative piece
        Color lavender = new Color(210,145, 188);
        Color cottonCandy = new Color(254, 200, 216);
        Color peach = new Color(255,223, 211);
        Color skyBlue = new Color(144, 203, 249);

        setLayout(new BorderLayout());
        setTitle("Ren's Pizzeria Order");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting color of entire JFrame
        getContentPane().setBackground(skyBlue);

        //setting title
        JLabel title = new JLabel("Ren's Pizzeria");
        title.setFont(new Font("FlipLine", Font.BOLD, 18));
        title.setForeground(lavender);
        title.setBounds(175,20, 150, 30);
        add(title, BorderLayout.CENTER);

        //setting 'size' title
        JLabel sizeLabel = new JLabel("Size: ");
        sizeLabel.setForeground(lavender);
        sizeLabel.setFont(new Font("FlipLine", Font.BOLD, 14));
        sizeLabel.setBounds(50, 70, 80, 30);
        add(sizeLabel);

        //array for sizes
        String[] sizes = {"Small", "Medium", "Large", "Super"};
        JComboBox<String> sizeDropdown = new JComboBox<String>(sizes);
        sizeDropdown.setBackground(peach);
        sizeDropdown.setBounds(120, 70, 100, 30);
        sizeDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = sizeDropdown.getSelectedItem().toString();
            }
        });
        add(sizeDropdown);

        //setting 'toppings' title
        JLabel toppingsLabel = new JLabel("Toppings: ");
        toppingsLabel.setForeground(lavender);
        toppingsLabel.setFont(new Font("FlipLine", Font.BOLD, 14));
        toppingsLabel.setBounds(50, 120, 80, 30);
        add(toppingsLabel);

        //check box for pepperoni
        JCheckBox pepperoniCheckbox = new JCheckBox("Pepperoni");
        pepperoniCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peperoni = !peperoni;
            }
        });
        pepperoniCheckbox.setBackground(peach);
        pepperoniCheckbox.setBounds(120, 120, 100, 30);
        add(pepperoniCheckbox);

        //check box for mushroom
        JCheckBox mushroomsCheckbox = new JCheckBox("Mushroom");
        mushroomsCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mushroom = !mushroom;
            }
        });
        mushroomsCheckbox.setBackground(peach);
        mushroomsCheckbox.setBounds(120, 150, 100, 30);
        add(mushroomsCheckbox);

        //check box for broccoli
        JCheckBox broccoliCheckbox = new JCheckBox("Broccoli");
        broccoliCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                broccoli = !broccoli;
            }
        });
        broccoliCheckbox.setBackground(peach);
        broccoliCheckbox.setBounds(120, 180, 100, 30);
        add(broccoliCheckbox);

        JCheckBox extraCheeseCheckbox = new JCheckBox("Extra Cheese");
        extraCheeseCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extraCheese = !extraCheese;
            }
        });
        extraCheeseCheckbox.setBackground(peach);
        extraCheeseCheckbox.setBounds(120, 210, 100, 30);
        add(extraCheeseCheckbox);

        //price label
        price = new JLabel("Price: ");
        price.setForeground(lavender);
        price.setFont(new Font("FlipLine", Font.BOLD, 14));
        price.setBounds(50, 230, 100, 30);
        add(price);

        //calculate button math and button label with action listener
        JButton calculateButton = new JButton("Calculate Price");
        calculateButton.setBackground(cottonCandy);
        calculateButton.setBounds(175, 300, 150, 30);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                //math for the total price
                double total = 0;
                if (broccoli) {
                    total += 0.50;
                }
                if (mushroom){
                    total += 0.50;
                }
                if (peperoni){
                    total += 0.50;
                }
                if (total == 1.50){
                    total = 1.25;
                }

                total += priceSize.get(size);
                price.setText("Price: $" + total);

            }
        });
        add(calculateButton);
        add(calcprice);


    }

    //makes swing application visible to me, properly
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PapasPizzeriaGUI().setVisible(true);
            }
        });

    }

}
