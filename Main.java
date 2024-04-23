import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //sets board length and width
        int boardWidth = 600;
        int boardHeight = boardWidth;

        //sets JFrame parameters
        JFrame newFrame = new JFrame("Snake Game"); //makes new JFrame and sets title
        newFrame.setVisible(true); //makes visible to user
        newFrame.setSize(boardWidth, boardHeight); //sets size
        newFrame.setLocationRelativeTo(null); //sets the JFrame to appear in the middle of the screen
        newFrame.setResizable(false); //cannot resize the JFrame
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when exit it pressed it closes the program

        //makes new snake game object (JPanel)
        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        newFrame.add(snakeGame); //adds JPanel to the JFrame
        newFrame.pack(); //places JPanel from SnackGame in the JFrame with full dimensions
        snakeGame.requestFocus(); //makes sure snakeGame is the one listening for key presses
    }
}