//adds a JPanel to the JFrame in the main function
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //for storing the snakes accumulated segments
import java.util.Random; //for the random food placement on screen
import javax.swing.*;


public class SnakeGame extends JPanel implements ActionListener, KeyListener{
    //settting board width and height
    int boardWidth;
    int boardHeight;
    int snake = 25; //sets snake head to be 25 pixels in length and width

    //Snake
    Square snakeHead;
    ArrayList<Square> snakeBody; //stores the growing snake when it eats apple

    //Apple
    Square apple;
    Random random;

    //Banana
    Square banana;
    Random random2;

    //game logic, for executeing the game every 1000 milliseconds
    Timer gameLoop;
    int velocityX; //snake x movement
    int velocityY; //snake y movement
    boolean gameOver = false;

    //stores x and y positions of game elements
    private class Square {
        int x;
        int y;

        Square(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //snake game constructor, initializes initial game state, sets up position of apple, banana, gamelogic and starts game loop
    SnakeGame(int boardWidth, int boardHeight) {
        //parameters setting visable on board
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this); //listens for key presses
        setFocusable(true); //listens for key presses specifically by SnakeGame (enables it to listen for keys)

        //default starting place
        snakeHead = new Square(5, 5);
        snakeBody = new ArrayList<Square>();

        //randomly places apple on board
        apple = new Square(10, 10);
        random = new Random();
        placeApple();

        //randomly place banana on board
        banana = new Square(10, 10);
        random2 = new Random();
        placeBanana();

        //allowing for up/down/left/right in move() function
        velocityX = 0; //0 = no horizontal movement, -1 = moves left, 1 = moves right
        velocityY = 0; //0 = not vertical movement, -1 = moves up, 1 = moves down

        //creates conditions for how the game runs, aka gameOver and gameStart condition
        gameLoop = new Timer(100, this); //measured in milliseconds, attaches listener
        gameLoop.start(); //starts game when pressing arrow keys
    }

    //used for drawing the snakes head
    //overrides paintComponent method to draw components on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //establishes clean canvas so overlap doesnt happen
        draw(g); //calls draw method to actually draw components
    }

    //draw function so it draws everything on the board, provided graphics logic
    public void draw(Graphics g) {
        //draws Grid (runs boardWidth/snake times)
        for (int i = 0; i < boardWidth/snake; i++){
            //needs (x1, y1, x2, y2)
            g.drawLine(i * snake, 0, i * snake, boardHeight); //vertical lines, drawn based on cell width
            g.drawLine(0, i * snake, boardWidth, i * snake); //horizontal lines, drawn based on height
        }
        //draws Apple
        g.setColor(Color.red);
        g.fillRect(apple.x * snake, apple.y * snake, snake, snake);
        g.fill3DRect(apple.x * snake, apple.y * snake, snake, snake, true); //adds border to apple

        //draws Banana
        g.setColor(Color.yellow);
        g.fillRect(banana.x * snake, banana.y * snake, snake, snake);
        g.fill3DRect(banana.x * snake, banana.y * snake, snake, snake, true);


        //draws snakeHead
        g.setColor(Color.green);
        g.fillRect(snakeHead.x * snake, snakeHead.y * snake, snake, snake); //note to self: mult. size of the starting position of the snake by the size of snake to get starting position correct aka 125 pixels by 125 pixels
        g.fill3DRect(snakeHead.x * snake, snakeHead.y * snake, snake, snake, true); //adds border to head

        //drawing snakeBody by moving through the arrayList which holds the segments of the snake
        for (int i = 0; i < snakeBody.size(); i++) {
            Square snakeParts = snakeBody.get(i);
            g.fillRect(snakeParts.x * snake, snakeParts.y * snake, snake, snake);
            g.fill3DRect(snakeParts.x * snake, snakeParts.y * snake, snake, snake, true); //adds border to body

        }

        //draws score and end game in top corner
        g.setFont(new Font("Arial", Font.PLAIN, 16));

        //sets font to a red color when game over is achieved
        if (gameOver) {
            g.setColor(Color.red);
            g.drawString("Game Over! Final Score: " + String.valueOf(snakeBody.size()), snake - 16, snake);
        } else {
            g.drawString("Score: " + String.valueOf(snakeBody.size()), snake - 16, snake);
        }
    }

    //randomly places the apple
    public void placeApple() {
        apple.x = random.nextInt(boardWidth/snake); // 600/25 = 24 (x will be random place between 0 and 24)
        apple.y = random.nextInt(boardHeight/snake); // 600/25 = 24 (y position will be random place between 0 and 24)
    }

    //randomly places the banana
    public void placeBanana() {
        //same logic as the apple
        banana.x = random2.nextInt(boardWidth/snake);
        banana.x = random2.nextInt(boardHeight/snake);
    }

    //sets condition for what happens when squares collide, checks for square overlap withing valid positions
    public boolean squareCollision(Square tile1, Square tile2) {
        return tile1.x == tile2.x && tile1.y == tile2.y;
    }

    //function for moving the snake left, right, up, down
    public void move() {
        //eating apples - adds segments
        if (squareCollision(snakeHead, apple)) {
            snakeBody.add(new Square(apple.x, apple.y));
            placeApple();
        }

        //eating banana - subtracts a segment from the snake body -- need to add condition for if the head is left
        if (squareCollision(snakeHead, banana)) {
            try {
                int index = snakeBody.size() - 1;
                snakeBody.remove(index);
                placeBanana();
            } catch (IndexOutOfBoundsException e) {
                gameOver = true;
            }
        }

        // Snake Body (iterates backwards in the arrayList so that those tiles move before the head does)
        for (int i = snakeBody.size()-1; i >= 0; i--) {
            Square snakeParts = snakeBody.get(i);
            if (i == 0) {
                snakeParts.x = snakeHead.x;
                snakeParts.y = snakeHead.y;
            } else {
                Square prevSnakeParts = snakeBody.get(i - 1);
                snakeParts.x = prevSnakeParts.x;
                snakeParts.y = prevSnakeParts.y;
            }
        }

        //snake head movement
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;

        //game over conditions
        //if snake collides with itself
        for (int i = 0; i < snakeBody.size(); i++) {
            Square snakeParts = snakeBody.get(i);
            //colliding with the snake head
            if (squareCollision(snakeHead, snakeParts)) {
                gameOver = true;
            }
        }
        //if snake collides with walls of the board
        if (snakeHead.x * snake < 0 || snakeHead.x * snake > boardWidth || snakeHead.y * snake < 0 || snakeHead.y * snake > boardHeight) {
            gameOver = true;
        }
    }

    //listens for movement, repainting tiles and if the game meets game over conditions
    @Override
    public void actionPerformed(ActionEvent e) {
        move(); //updates x and y position before repainting
        repaint(); //calls draw every 100 milliseconds

        //initiates game over condition
        if (gameOver) {
            gameLoop.stop();
        }
    }

   //only need this one: (listens for key presses and updates the velocity of the snake (direction) so it can't move in the opposite direction)
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1){
            velocityX = 0;
            velocityY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    //don't need: //note to self: code does not run without these two, so I'm keeping them here but are kept empty
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}