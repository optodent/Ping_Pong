import java.awt.Graphics2D;
import java.awt.Point;


public class Paddle extends Collidable{
	
	
	public int dY;
	
	public Paddle(Game game, int x, int y) {
		setX(x);
		setY(y);
		
		this.min = new Point(0, 0);
		this.max = new Point(10 , 50);
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
		}else if ((this.positionY + dY) > Game.game.getHeight() - 51){
			positionY = Game.game.getHeight() - 51;
		}else{
			positionY += dY;
		}
		
	}
	
	public void paint(Graphics2D g) {
		g.drawRect(positionX, positionY, 10, 50);
	}
}
