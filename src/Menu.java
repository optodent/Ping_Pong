import java.awt.BorderLayout;
import java.awt.Font;

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
		menuOption1.setFont(new Font("Courier New", Font.BOLD, 15));
		menuOption1.setBounds(100, Game.GAME_HEIGHT + 15, Game.GAME_WIDTH / 2, 20);
		add(menuOption1);
		
		menuOption2 = new JLabel("press X to exit");	
		menuOption2.setFont(new Font("Courier New", Font.BOLD, 15));
		menuOption2.setBounds(Game.GAME_WIDTH - 300, Game.GAME_HEIGHT + 15, Game.GAME_WIDTH / 2, 20);
		add(menuOption2);
	}
	
}
