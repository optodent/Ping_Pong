import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel{
	
	private static Game game;
	
	public static final int GAME_HEIGHT = 450;
	public static final int GAME_WIDTH = 800;
	public static final int SLEEP_TIME = 10;
	public static final int SCORE_MESSAGE_SHOWTIME = 2500;
	
	private Ball ball;
	private Timere timer;
	private Paddle paddle1;
	private Paddle paddle2;
	private long lastScoreTime = System.currentTimeMillis();
	
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
		scorePlayer2.setBounds(GAME_WIDTH / 8 * 7 + 20, GAME_HEIGHT, GAME_WIDTH / 8, 30);		
		frame.getContentPane().add(scorePlayer2);
		
		scoreMessage = new JLabel(" ");
		scoreMessage.setBounds(GAME_WIDTH / 8 * 3, GAME_HEIGHT, GAME_WIDTH / 2, 30);
		frame.getContentPane().add(scoreMessage);
		
		ImagePanel panel = new ImagePanel("images/background.png");
		panel.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	public void setBall(Ball ball){
		this.ball = ball;
	}
	
	public void setLastScoreTime(){
		this.lastScoreTime = System.currentTimeMillis();
	}
	
	public Paddle getPaddle1(){
		return this.paddle1;
	}
	
	public Paddle getPaddle2(){
		return this.paddle2;
	}
	
	public static Game getGame(){
		return Game.game;
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
		scorePlayer1.setText("Score: " + score);
	}
	
	public void setScorePlayer2(int score){
		scorePlayer2.setText("Score: " + score);
	}
	
	public void setScoreMessage(int player){
		scoreMessage.setText("Player " + player + " scored a goal !!!");
	}
	
	public void deleteScoreMessage(){
		scoreMessage.setText(" ");
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