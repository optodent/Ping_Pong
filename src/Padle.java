import java.awt.Graphics2D;


public class Padle {
	
	private int x;
	private int y;
	public int dY;
		
	public void setX (int x){
		this.x = x;
	}
	
	public void setY (int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Padle(Game game, int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void move(){
		y += dY;
	}
	
	public void paint(Graphics2D g) {
		g.drawRect(x, y, 10, 50);
	}
}
