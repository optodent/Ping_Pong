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
	public static final int SLEEP_TIME = 80;
	private static final int SCORE_MESSAGE_SHOWTIME = 2000;
	
	public Ball ball;
	public Timere timer;
	public Paddle paddle1;
	public Paddle paddle2;
	public long lastScoreTime = System.currentTimeMillis();
	
	private JLabel scoreMessage;
	private JLabel scorePlayer1;
	private JLabel scorePlayer2;
	private JFrame frame;
	
	public static boolean running = true;
	
	public Game(){
		ball = new Ball(this);
		timer = new Timere();
		
		paddle1 = new Paddle(this, 10 , GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		paddle2 = new Paddle(this, GAME_WIDTH - 5 - Paddle.PADDLE_WIDTH - 5, GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		frame = new JFrame("PingPong");
		frame.add(this);	
		frame.setSize(GAME_WIDTH, GAME_HEIGHT + 60);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		frame.addKeyListener(ih);
		frame.setLayout(null);
	
		scorePlayer1 = new JLabel("Score: " + 0);	
		scorePlayer1.setBounds(15, GAME_HEIGHT, GAME_WIDTH / 8, 30);		
		frame.getContentPane().add(scorePlayer1);
		
		scorePlayer2 = new JLabel("Score: " + 0);	
		scorePlayer2.setBounds(GAME_WIDTH / 8 * 7, GAME_HEIGHT, GAME_WIDTH / 8, 30);		
		frame.getContentPane().add(scorePlayer2);
		
		scoreMessage = new JLabel();
		
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
		if (System.currentTimeMillis() - lastScoreTime > SCORE_MESSAGE_SHOWTIME) {
			game.deleteScoreMessage();
		}
	}
	
	public void setScorePlayer1(int score){
		frame.getContentPane().remove(scorePlayer1);
		scorePlayer1 = new JLabel("Score: " + score);
		scorePlayer1.setBounds(15, GAME_HEIGHT, GAME_WIDTH / 8, 30);
		frame.getContentPane().add(scorePlayer1);
	}
	
	public void setScorePlayer2(int score){
		frame.getContentPane().remove(scorePlayer2);
		scorePlayer2 = new JLabel("Score: " + score);
		scorePlayer2.setBounds(GAME_WIDTH / 8 * 7, GAME_HEIGHT, GAME_WIDTH / 8, 30);
		frame.getContentPane().add(scorePlayer2);
	}
	
	public void setScoreMessage(int player){
		scoreMessage = new JLabel("Player " + player + " scored a goal !!!");
		scoreMessage.setBounds(GAME_WIDTH / 8 * 3, GAME_HEIGHT, GAME_WIDTH / 2, 30);
		frame.getContentPane().add(scoreMessage);
	}
	
	public void deleteScoreMessage(){
		frame.getContentPane().remove(scoreMessage);
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
			paddle1.paint(g2d, 0);
			paddle2.paint(g2d, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		timer.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game();
		game.setOpaque(false); 
		Game.running = false;
		
		double mSperFrame = 1 / 60.0 * 1000;
		long before = System.currentTimeMillis();
		double lag = 0.0;
		
		while(game.paddle1.getScore() < 6 && game.paddle2.getScore() < 6){
			
			boolean shouldRender = false;
			long now = System.currentTimeMillis();
			long elapsed = now - before;
			before = now;
			lag += elapsed;
			
			while (lag >= mSperFrame) {
				lag -= mSperFrame;
				
				if (running) {
					game.move();
					//game.repaint();
					game.detectCollisions();
					game.timeRefresh();
					shouldRender = true;
				}
			}
			
			if (shouldRender) {
				game.repaint();
				shouldRender = false;
			}
		}	
	}	
}
