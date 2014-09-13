import java.awt.Graphics2D;
import java.awt.Point;

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
		if (positionX + vellX < 0)
			vellX = 1;
		if (positionX + vellX > game.getWidth() - 10)
			vellX = -1;
		if (positionY + vellY < 0)
			vellY = 1;
		if (positionY + vellY > game.getHeight() - 10)
			vellY = -1;

		positionX = positionX + vellX;
		positionY = positionY + vellY;
	}
	// method painting the ball
	public void paint(Graphics2D g) {
		g.fillOval(positionX, positionY, 10, 10);
	}
}