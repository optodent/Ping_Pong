import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel{
	
	//public static Game game;
	
	public static final int GAME_HEIGHT = 450;
	public static final int GAME_WIDTH = 800;
	public static final int SLEEP_TIME = 80;
	public static final int SCORE_MESSAGE_SHOWTIME = 2500;
	
	private Ball ball;
	private Timere timer;
	private Paddle paddle1;
	private Paddle paddle2;
	private long lastScoreTime = System.currentTimeMillis();
	
	private JLabel scoreMessage;
	private JLabel scorePlayer1;
	private JLabel scorePlayer2;
	
	public static boolean running = true;
	
	public Game(){
		setLayout(null);
		setOpaque(false); 
		running = false;
		
		ball = new Ball(this);
		timer = new Timere();
		
		paddle1 = new Paddle(this, 10 , GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		paddle2 = new Paddle(this, GAME_WIDTH - 5 - Paddle.PADDLE_WIDTH - 5, GAME_HEIGHT / 2 - Paddle.PADDLE_HEIGHT / 2);
		
		scorePlayer1 = new JLabel("Score: " + 0);	
		scorePlayer1.setBounds(15, GAME_HEIGHT, GAME_WIDTH / 8, 30);
		add(scorePlayer1);

		scorePlayer2 = new JLabel("Score: " + 0);	
		scorePlayer2.setBounds(GAME_WIDTH / 8 * 7 + 20, GAME_HEIGHT, GAME_WIDTH / 8, 30);		
		add(scorePlayer2);
		
		scoreMessage = new JLabel(" ");
		scoreMessage.setFont(new Font("Courier New", Font.ITALIC, 20));
		scoreMessage.setBounds(GAME_WIDTH / 8 * 3 - 20, GAME_HEIGHT + 5, GAME_WIDTH / 2, 30);
		add(scoreMessage);
		
		JLabel pressExit = new JLabel("X - exit game");	
		pressExit.setBounds(GAME_WIDTH / 8 - 20, GAME_HEIGHT + 30, GAME_WIDTH / 4, 30);		
		add(pressExit);
		
		JLabel pressMenu = new JLabel("M - menu");	
		pressMenu.setBounds(GAME_WIDTH / 8 * 4 - 20, GAME_HEIGHT + 30, GAME_WIDTH / 4, 30);		
		add(pressMenu);
		
		JLabel pressPause = new JLabel("SPACE - pause / center kick");	
		pressPause.setBounds(GAME_WIDTH / 8 * 6 - 50, GAME_HEIGHT + 30, GAME_WIDTH / 4, 30);		
		add(pressPause);
		
		ImagePanel panel = new ImagePanel("images/background.png");
		panel.setBounds(0, 0, GAME_WIDTH, GAME_HEIGHT);
		add(panel, BorderLayout.CENTER);
		
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
	
	//public static Game getGame(){
		//return Game.game;
	//}
	
	public void detectCollisions(){
		
		if (ball.Intersect(paddle1)) {
			ball.vellX  = +1;
		}
		if (ball.Intersect(paddle2)) {
			ball.vellX  = -1;
		}
	}
	
	public void move(){
		
		if (paddle1.getScore() == 6){
			Application.changeGameState(Application.GameState.VictoryState);
			Application.getVictory().setWinnerMessage("1");

		}else if(paddle2.getScore() == 6){
			Application.changeGameState(Application.GameState.VictoryState);
			Application.getVictory().setWinnerMessage("1");
		}
		
		ball.move();
		paddle1.move();
		paddle2.move();
		if (System.currentTimeMillis() - lastScoreTime > SCORE_MESSAGE_SHOWTIME) {
			Application.getGame().deleteScoreMessage();
		}
	}
	
	public void setScorePlayer1(int score){
		scorePlayer1.setText("Score: " + score);
	}
	
	public void setScorePlayer2(int score){
		scorePlayer2.setText("Score: " + score);
	}
	
	public void setScoreMessage(int player){
		if (player == 1) {
			scoreMessage.setForeground(Color.red);
		}else{
			scoreMessage.setForeground(new Color(182, 177, 21));
		}
		scoreMessage.setText("Player " + player + " scored a goal !!!");
	}
	
	public void deleteScoreMessage(){
		scoreMessage.setText(" ");
	}

	public void timeRefresh () {
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
	
	
}