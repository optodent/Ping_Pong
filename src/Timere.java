import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class Timere {
	private long currentTime = 0;
	
	void refresh() {
		currentTime ++;
	}
	
	public void paint(Graphics2D g) {
		//The precedence is important. Do NOT remove the brackets.
		long counter = currentTime / (1000 / Game.SLEEP_TIME);
		long remainder = counter % 3600;
		long minutes = remainder / 60;
		long seconds = remainder % 60; 

		String time = ( (minutes < 10 ? "0" : "") + minutes 
				+ ":" + (seconds< 10 ? "0" : "") + seconds ); 

		AttributedString as = new AttributedString(time);
		as.addAttribute(TextAttribute.SIZE, 20);
		as.addAttribute(TextAttribute.FOREGROUND, Color.white);
		
		g.drawString(as.getIterator(), 520, 30);
	}
}