import java.awt.Graphics2D;
import java.awt.Point;


public class Paddle extends Collidable{
	
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
	
	public void move(){
		
		if ((this.positionY + dY) < 0) {
			positionY = 0;
		}else if ((this.positionY + dY) > Game.game.getHeight() - PADDLE_HEIGHT + 1){
			positionY = Game.game.getHeight() - PADDLE_HEIGHT + 1;
		}else{
			positionY += dY;
		}
		
	}
	
	public void paint(Graphics2D g) {
		g.drawRect(positionX, positionY, PADDLE_WIDTH, PADDLE_HEIGHT);
	}
}
