import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class VictoryScreen extends JPanel{
	
	private JLabel winMessage;
	
	public VictoryScreen(){
		setLayout(null);
		
		ImagePanel panel = new ImagePanel("images/victory.jpg");
		panel.setBounds(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT - 25);
		add(panel, BorderLayout.CENTER);
		
		winMessage = new JLabel(" ");	
		winMessage.setFont(new Font("Courier New", Font.ITALIC, 25));
		winMessage.setBounds(Game.GAME_WIDTH / 3 + 40, Game.GAME_HEIGHT + 10, Game.GAME_WIDTH / 2, 20);
		add(winMessage);
		
		JLabel menuOption = new JLabel("press M to go back to menu");	
		menuOption.setBounds(20, Game.GAME_HEIGHT + 30, Game.GAME_WIDTH / 4, 20);
		add(menuOption);
		
	}
	
	public void setWinnerMessage(String win){
		winMessage.setText("Player " + win + " won !!!");
	}

}
