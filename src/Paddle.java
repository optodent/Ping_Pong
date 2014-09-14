import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class Paddle extends Collidable{
	
	private int score = 0;
	
	public static final int PADDLE_HEIGHT = 50;
	public static final int PADDLE_WIDTH = 10;
	private int dY;
	
	public Paddle(Game game, int x, int y) {
		setX(x);
		setY(y);
		
		this.min = new Point(0, 0);
		this.max = new Point(PADDLE_WIDTH , PADDLE_HEIGHT);
	}
	
	public void setdY (int dy){
		this.dY = dy;
	}
		
	public int getdY (){
		return this.dY;
	}
	
	public void setX (int x){
		this.positionX = x;
	}
	
	public void setY (int y){
		this.positionY = y;
	}
	
	public int getX(){
		return this.positionX;
	}
	
	public int getY(){
		return this.positionY;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public void move(){
		
		if ((this.positionY + dY) < 0) {
			positionY = 0;
		}else if ((this.positionY + dY) > Game.GAME_HEIGHT - PADDLE_HEIGHT + 1){
			positionY = Game.GAME_HEIGHT - PADDLE_HEIGHT + 1;
		}else{
			positionY += dY;
		}
		
	}
	
	public void paint(Graphics2D g) {
		g.setColor(new Color(255, 51, 0));
		g.fillRect(positionX, positionY, PADDLE_WIDTH, PADDLE_HEIGHT);
	}

	
}
