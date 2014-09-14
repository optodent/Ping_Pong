import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public static Game game;
	
<<<<<<< HEAD
	public static final int GAME_HEIGHT = 300;
	public static final int GAME_WIDTH = 500;
=======
	public static final int GAME_HEIGHT = 350;
	public static final int GAME_WIDTH = 600;
	public static final int SLEEP_TIME = 10;
>>>>>>> 79864564dc9239d864de4f322312611e366fc8dd
	
	public Ball ball;
	public Timer timer;
	public Paddle paddle1;
	public Paddle paddle2;
	
	public static boolean running = true;
	
	public Game(){
		ball = new Ball(this);
		timer = new Timer();
		
		paddle1 = new Paddle(this, 5 , GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		paddle2 = new Paddle(this, GAME_WIDTH - 5 - Paddle.PADDLE_WIDTH, GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		JFrame frame = new JFrame("PingPong");
		frame.add(this);	
		frame.setSize(GAME_WIDTH + 1, GAME_HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		frame.addKeyListener(ih);

		ImagePanel panel = new ImagePanel("images/background.png");
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(GAME_WIDTH, GAME_HEIGHT);	
	}
	private void detectCollisions(){
		
		if (ball.Intersect(paddle1)) {
			ball.vellX  = +1;
		}
		if (ball.Intersect(paddle2)) {
			ball.vellX  = -1;
		}
	}
	
	private void move(){
		ball.move();
		paddle1.move();
		paddle2.move();
	}
	
	private void timeRefresh () {
		timer.refresh();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

<<<<<<< HEAD
		try {
			ball.paint(g2d);
		} catch (IOException e) {
			e.printStackTrace();
		}
=======
		ball.paint(g2d);
		timer.paint(g2d);
>>>>>>> 79864564dc9239d864de4f322312611e366fc8dd
		paddle1.paint(g2d);
		paddle2.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game();
		game.setOpaque(false); //hides the background of game
		
		while(true){
			if (running) {
				game.move();
				game.repaint();
				game.detectCollisions();
				game.timeRefresh();
			}
			Thread.sleep(SLEEP_TIME);
		}	
	}	
}
