import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Game extends JPanel{
	
	Ball b = new Ball(this);
	
	private void move(){
		b.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		b.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame panel = new JFrame("PingPong");
		Game game = new Game();
		panel.add(game);
		panel.setSize(300, 300);
		panel.setVisible(true);
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){
			
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
		
	}
		
	
}
