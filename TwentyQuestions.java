import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


//main class for game with UI
public class TwentyQuestions {
    private Tree tree;
    private TreeNode currentNode;
    private JButton yesButton, noButton, restartButton;
    private JTextPane textPane;
    private boolean started = false;

    //listeners located here
    private ActionListener buttonsListen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == yesButton)
                yes();
            else if (source == noButton)
                no();
            else if (source == restartButton)
                restart();
        }
    };

    public static void main(String[] args) {
        //makes new instance of the game
        TwentyQuestions twentyQuestions = new TwentyQuestions();
        twentyQuestions.tree = new Tree();
        twentyQuestions.tree.loadTree("C:\\Users\\rivka\\IdeaProjects\\BinaryTreeSearchGame\\src\\animal_Questions"); //add filenale here!!

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                twentyQuestions.buildUI();
            }
        });
    }

    //sets up the UI
    private void buildUI() {
        //builds UI here
        JFrame frame = new JFrame("Twenty Questions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = frame.getContentPane();

        //adding buttons
        JPanel buttonsPanel = new JPanel();

        //adds yes button
        yesButton = new JButton("Yes");
        yesButton.addActionListener(buttonsListen);
        buttonsPanel.add(yesButton, BorderLayout.LINE_START);

        //adds restart button
        restartButton = new JButton("Start");
        restartButton.addActionListener(buttonsListen);
        buttonsPanel.add(restartButton, BorderLayout.LINE_START);

        //adds no button
        noButton = new JButton("No");
        noButton.addActionListener(buttonsListen);
        buttonsPanel.add(noButton, BorderLayout.LINE_END);

        contentPanel.add(buttonsPanel, BorderLayout.PAGE_END);

        //adds text box
        textPane = new JTextPane();
        textPane.setEditable(false);
        updateText("Think of an Animal, then click Start!");

        //defines style constraints for text pane
        textPane.setFont(new Font("Arial", Font.BOLD, 16));

        contentPanel.add(textPane, BorderLayout.CENTER);

        frame.setMinimumSize(new Dimension(500, 250));

        //centering the JFrame
        Dimension objectDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int coordX = (objectDimension.width - frame.getWidth())/2;
        int coordY = (objectDimension.height - frame.getHeight())/2;
        frame.setLocation(coordX, coordY);

        //display the window
        frame.pack();
        frame.setVisible(true);
    }

    //callback methods for yes, no and restart
    private void yes() {
        //navigates through tree by moving current node on yes branch
        if (started && currentNode != null) {
            currentNode = currentNode.yes;

            if (currentNode != null) {
                if (currentNode.isQuestion()) {
                    updateText(currentNode.data);
                } else {
                    updateText("Are you thinking of a" + currentNode.data + "?");
                }
            } else {
                updateText("I win!!");
            }
        }
    }

    //if the user says no
    private void no() {
        //does similar to yes function, starts by moving throuhg the current node of the tree
        if (started && currentNode != null) {
            currentNode = currentNode.no;

            if (currentNode != null) {
                if (currentNode.isQuestion()) {
                    updateText(currentNode.data);
                } else {
                    updateText("Are you thinking of" + currentNode.data + "?");
                }
            } else {
                updateText("I lost :(");
                try
                {
                    //tries to update the text file with a new answer
                    String userInput = JOptionPane.showInputDialog("What were you thinking of?");

                    if (userInput != null && !userInput.isEmpty()) {
                        FileWriter file = new FileWriter("C:\\Users\\rivka\\IdeaProjects\\BinaryTreeSearchGame\\src\\animal_Questions");
                        file.write(userInput + "\n");
                        updateText("Thank you for playing!");
                    } else {
                        updateText("No input provided. Game over :(");
                    }

                } catch (IOException e)
                {
                    System.out.println("Error:" + e.getMessage());
                    updateText("Error occurred. Game Over :(");
                }

            }
        }
    }

    //restart the game (same as the start game)
    private void restart() {
        if (started) {
            started = false;
            updateText("Think of an animal, then click Start");
        } else {
            started = true;
            updateText("Think of an animal, and click on Start");
            currentNode = tree.root;
            updateText(currentNode.data);
        }
    }

    //updates the text in the GUI
    private void updateText(String txt) {
        textPane.setText("\n" + txt);
    }
}
