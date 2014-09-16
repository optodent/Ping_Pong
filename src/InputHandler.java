import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Game.getGame().getPaddle2().setdY(-2);
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.getGame().getPaddle2().setdY(2);
        }
        
        if (key == KeyEvent.VK_W)
        {
            Game.getGame().getPaddle1().setdY(-2);
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.getGame().getPaddle1().setdY(2);
        }
        
        if (key == KeyEvent.VK_SPACE)
        {
        	Game.running = ! Game.running;
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Game.getGame().getPaddle2().setdY(0);
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.getGame().getPaddle2().setdY(0);
        }
        
        if (key == KeyEvent.VK_W)
        {
        	Game.getGame().getPaddle1().setdY(0);
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.getGame().getPaddle1().setdY(0);
        }	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

}