import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Date;
//adding a timer for the game
public class Timere {
	public Timere(){
		startTime = System.currentTimeMillis();
	}
	private long currentTime = 0;
	private long startTime = 0;
	private long minutes = 0;
	private long seconds = 0;
	
	void refresh() {
		currentTime = System.currentTimeMillis()-startTime;
		minutes = currentTime/60000;
		seconds = (currentTime%60000)/1000;
		
		
	}
	
	public void paint(Graphics2D g) {
		//The precedence is important. Do NOT remove the brackets.
		//long counter = currentTime / (1000 / Game.SLEEP_TIME);
		//long remainder = counter % 3600;
		//long minutes = remainder / 60;
		//long seconds = remainder % 60; 

		//String time = String.format(minutes +":" + seconds); 
		String time = String.format("%1$tM:%1$tS", new Date(2000, 1, 1, 1, (int)minutes, (int)seconds)); 
		AttributedString as = new AttributedString(time);
		as.addAttribute(TextAttribute.SIZE, 20);
		as.addAttribute(TextAttribute.FOREGROUND, Color.white);
 
		//setting the timer on the screen
		//g.drawString(as.getIterator(), 520, 30);
 
		
		g.drawString(as.getIterator(), 620, 30);

	}
}