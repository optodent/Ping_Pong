import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public static Game game;
	
	public static final int GAME_HEIGHT = 350;
	public static final int GAME_WIDTH = 600;
	public static final int SLEEP_TIME = 10;
	
	public Ball ball;
	public Timere timer;
	public Paddle paddle1;
	public Paddle paddle2;
	
	public static boolean running = true;
	
	public Game(){
		ball = new Ball(this);
		timer = new Timere();
		
		paddle1 = new Paddle(this, 10 , GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		paddle2 = new Paddle(this, GAME_WIDTH - 5 - Paddle.PADDLE_WIDTH - 5, GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		JFrame frame = new JFrame("PingPong");
		frame.add(this);	
		frame.setSize(GAME_WIDTH, GAME_HEIGHT + 70);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		frame.addKeyListener(ih);
		frame.setLayout(null);
	
		JLabel text = new JLabel("Score: " + "0");	
		text.setBounds(0, GAME_HEIGHT, GAME_WIDTH, 30);		
		frame.getContentPane().add(text);
		
		ImagePanel panel = new ImagePanel("images/background.png");
		panel.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
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


		try {
			ball.paint(g2d);
		} catch (IOException e) {
			e.printStackTrace();
		}

		timer.paint(g2d);

		paddle1.paint(g2d);
		paddle2.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game();
		game.setOpaque(false); //hides the background of game
		game.running = false;
		
		while(game.paddle1.getScore() < 6 && game.paddle2.getScore() < 6){

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
