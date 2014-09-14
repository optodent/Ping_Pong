import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ball extends Collidable{
	
	
	protected int vellX = 1; 	//velocity direction x
	protected int vellY = 1;	// velocity direction y
	
	private Game game;

	//constructor for ball
	public Ball(Game game) {
		
		this.game = game;
		this.min = new Point(0 , 0);
		this.max = new Point(10 , 10);
		
	}
	//method moving the ball
	void move() {
		if (positionX + vellX < 0){
			vellX = 1;
			int sc = game.paddle2.getScore();
			sc++;
			game.paddle2.setScore(sc);		
			game.ball = new Ball(game);
			game.setScorePlayer2(sc);		
		}
			
		if (positionX + vellX > game.getWidth() - 10){
			vellX = -1;
			int sc = game.paddle1.getScore();
			sc++;
			game.paddle1.setScore(sc);
			game.ball = new Ball(game);
			game.setScorePlayer1(sc);
		}
		if (positionY + vellY < 0)
			vellY = 1;
		if (positionY + vellY > Game.GAME_HEIGHT - 10)
			vellY = -1;
		
		
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
		g.fillOval(positionX, positionY, 10, 10);
	}
}