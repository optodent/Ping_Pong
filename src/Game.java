import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Game extends JPanel{
	
	public static Game game;
	
	public Ball b;
	public Padle p;
	public Padle p2;
	
	public Game(){
		b = new Ball(this);
		p = new Padle(this, 5 , 150);
		p2 = new Padle(this, 200, 150);
		JFrame panel = new JFrame("PingPong");
		panel.add(this);
		panel.setSize(300, 300);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		panel.addKeyListener(ih);
	
	}
	
	
	private void move(){
		b.move();
		p.move();
		p2.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		b.paint(g2d);
		p.paint(g2d);
		p2.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		game = new Game();
		
		
		while(true){
			
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
		
	}
		
	
}
