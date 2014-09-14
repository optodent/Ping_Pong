import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Ball extends Collidable{
	
	
	protected int vellX; 	//velocity direction x
	protected int vellY;	// velocity direction y
	
	private Game game;
	private static Integer lastScore;
	private long lastScoreTime = System.currentTimeMillis();
	
	//constructor for ball
	public Ball(Game game) {
		this.game = game;
		this.min = new Point(0 , 0);
		this.max = new Point(10 , 10);
		
		Random rnd = new Random();
		int direction = rnd.nextInt(4);
		
		if (lastScore == null){
			switch (direction){
				case 0:
					vellX = 1;
					vellY = 1; break;
				case 1:
					vellX = 1;
					vellY = -1; break;
				case 2:
					vellX = -1;
					vellY = -1; break;
				case 3:
					vellX = -1;
					vellY = 1; break;
			}		
		} else if (lastScore == 2) {
			switch (direction){
				case 0:
				case 1:
					vellX = 1;
					vellY = 1; break;
				case 2:
				case 3:
					vellX = 1;
					vellY = -1; break;
			}		
		} else{
			switch (direction){
				case 0:
				case 1:
					vellX = -1;
					vellY = -1; break;
				case 2:
				case 3:
					vellX = -1;
					vellY = 1; break;
			}
		}
	}
	
	//method moving the ball
	void move() {
		if (positionX + vellX < 0){
			vellX = 1;
			int sc = game.paddle2.getScore();
			sc++;
			game.paddle2.setScore(sc);
			lastScore = 2;
			game.ball = new Ball(game);
			
			game.setScorePlayer2(sc);
			game.setScoreMessage(2);
			lastScoreTime = System.currentTimeMillis();
		}
			
		if (positionX + vellX > Game.GAME_WIDTH - 10){
			vellX = -1;
			int sc = game.paddle1.getScore();
			sc++;
			game.paddle1.setScore(sc);
			lastScore = 1;
			game.ball = new Ball(game);
			
			game.setScorePlayer1(sc);
			game.setScoreMessage(1);
			lastScoreTime = System.nanoTime();
		}
		if (positionY + vellY < 0)
			vellY = 1;
		if (positionY + vellY > Game.GAME_HEIGHT - 10)
			vellY = -1;
		
		if (System.currentTimeMillis() - lastScoreTime > 2000) {
			game.deleteScoreMessage();
		}
		
		positionX = positionX + vellX;
		positionY = positionY + vellY;
	}
	// method painting the ball
	public void paint(Graphics2D g) throws IOException {
		
		int width =10;
		int height=10;
		
		BufferedImage ball = ImageIO.read(new File("images/ball.png")); 
		TexturePaint texture = 
		 new TexturePaint(ball, 
		          new Rectangle(0, 0, width, height));
		g.setPaint(texture);
		g.fillOval(positionX - 5, positionY - 5, 10, 10);
	}
}