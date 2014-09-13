import java.awt.Graphics2D;

public class Ball {
	
	private int ballX = 0;  //ball x
	private int ballY = 0;	//ball y
	private int vellX = 1; 	//velocity direction x
	private int vellY = 1;	// velocity direction y
	
	private Game game;

	//constructor for ball
	public Ball(Game game) {
		this.game = game;
	}
	//method moving the ball
	void move() {
		if (ballX + vellX < 0)
			vellX = 1;
		if (ballX + vellX > game.getWidth() - 10)
			vellX = -1;
		if (ballY + vellY < 0)
			vellY = 1;
		if (ballY + vellY > game.getHeight() - 10)
			vellY = -1;

		ballX = ballX + vellX;
		ballY = ballY + vellY;
	}
	// method painting the ball
	public void paint(Graphics2D g) {
		g.fillOval(ballX, ballY, 10, 10);
	}
}