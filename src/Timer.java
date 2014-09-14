import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class Timer {
	private long currentTime = 0;
	
	void refresh() {
		currentTime ++;
	}
	
	public void paint(Graphics2D g) {
		
		long counter = currentTime / 100;
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