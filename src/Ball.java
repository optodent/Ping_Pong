import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

// The class for the ball specifications
public class Ball extends Collidable {

	protected int vellX; // velocity direction x
	protected int vellY; // velocity direction y

	private Game game;
	private static Integer lastScore;
 

	// constructor for ball
 
	private static final int BALL_SPEED = 3; 
	
	//constructor for ball
 	public Ball(Game game) {
		this.game = game;
		this.min = new Point(0, 0);
		this.max = new Point(10, 10);
		// random postition for starting the ball for game start or after scored
		// goal
		Random rnd = new Random();
		int direction = rnd.nextInt(4);

		if (lastScore == null) {
			switch (direction) {
			case 0:
				vellX = 1;
				vellY = 1;
				break;
			case 1:
				vellX = 1;
				vellY = -1;
				break;
			case 2:
				vellX = -1;
				vellY = -1;
				break;
			case 3:
				vellX = -1;
				vellY = 1;
				break;
			}
		} else if (lastScore == 2) {
			switch (direction) {
			case 0:
			case 1:
				vellX = 1;
				vellY = 1;
				break;
			case 2:
			case 3:
				vellX = 1;
				vellY = -1;
				break;
			}
		} else {
			switch (direction) {
			case 0:
			case 1:
				vellX = -1;
				vellY = -1;
				break;
			case 2:
			case 3:
				vellX = -1;
				vellY = 1;
				break;
			}
		}
	}

	// Detecting goal and scoring first player
	void move() {
		if (positionX + BALL_SPEED < 0){

			vellX = 1;
			int sc = game.getPaddle2().getScore();
			sc++;
			game.getPaddle2().setScore(sc);
			lastScore = 2;
			game.setBall(new Ball(game));

			game.setScorePlayer2(sc);
			game.setScoreMessage(2);
			game.setLastScoreTime();
			Game.setRunning(false);
		}
			
		if (positionX  > Game.GAME_WIDTH - 10){
 
			vellX = -1;
			int sc = game.getPaddle1().getScore();
			sc++;
			game.getPaddle1().setScore(sc);
			lastScore = 1;
			game.setBall(new Ball(game));

			game.setScorePlayer1(sc);
			game.setScoreMessage(1);
			game.setLastScoreTime();
			Game.setRunning(false);
		}
		if (positionY - 10 < 0)
			vellY = 1;
		if (positionY  > Game.GAME_HEIGHT - 10)
			vellY = -1;

		if (vellX == 1){
			positionX = positionX + BALL_SPEED;			
		}else{
			positionX = positionX - BALL_SPEED;
		}
		if (vellY == 1){
			positionY = positionY + BALL_SPEED;			
		}else{
			positionY = positionY - BALL_SPEED;
		}

	}

	// method painting the ball and texture
	public void paint(Graphics2D g) throws IOException {

		int width = 30;
		int height = 30;

		BufferedImage ball = ImageIO.read(new File("images/ball.png"));
		TexturePaint texture = new TexturePaint(ball, new Rectangle(0, 0,
				width, height));
		g.setPaint(texture);
		g.fillOval(positionX - 5, positionY - 5, 20, 20);
	}
}