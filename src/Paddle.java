import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.geom.RoundRectangle2D;

//detects if the ball is on the paddle from the Collidable class
public class Paddle extends Collidable{
	
	private int score = 0;
	//paddle size
	public static final int PADDLE_HEIGHT = 60;
	public static final int PADDLE_WIDTH = 14;
	private int dY;
	//paddle position
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
			positionY = Game.GAME_HEIGHT - PADDLE_HEIGHT;
		}else{
			positionY += dY;
		}
		
	}
	// painting the paddles /paddle graphics/ using image from file
	public void paint(Graphics2D g, int textureColor) throws IOException {
		
		int width = PADDLE_WIDTH + 20;
		int height= PADDLE_HEIGHT + 50;
		
		BufferedImage image = new BufferedImage(1, 1, 1); 
		switch(textureColor){
			case 0:
				image = ImageIO.read(new File("images/red-stripes.png"));break;
			case 1:
				image = ImageIO.read(new File("images/yellow-stripes.png"));break;
		}
		
		TexturePaint texture = 
		 new TexturePaint(image, 
		          new Rectangle(0, 0, width, height));
		g.setPaint(texture);
		g.fillRoundRect(positionX, positionY, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_WIDTH / 2, PADDLE_WIDTH / 2);
		g.setPaint(Color.black);
		RoundRectangle2D border = new RoundRectangle2D.Double(positionX, positionY, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_WIDTH / 2, PADDLE_WIDTH / 2);
		g.draw(border);
	}

	
}