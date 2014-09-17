import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Menu extends JPanel{
	
	private JLabel menuOption1;
	private JLabel menuOption2;
	
	public Menu(){
		setLayout(null);
		
		ImagePanel panel = new ImagePanel("images/menu-background.jpg");
		panel.setBounds(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		add(panel, BorderLayout.CENTER);
			
		menuOption1 = new JLabel("press G for new game");	
		menuOption1.setBounds(15, Game.GAME_HEIGHT, Game.GAME_WIDTH / 2, 20);
		add(menuOption1);
		
		menuOption2 = new JLabel("press X to exit(not working)");	
		menuOption2.setBounds(Game.GAME_WIDTH / 2, Game.GAME_HEIGHT, Game.GAME_WIDTH / 2, 20);
		add(menuOption2);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	}
}
