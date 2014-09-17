import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {
//setting the keys for playing the game
	@Override
	
	// detecting the pressed keys
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
        //adding the pause key
        if (key == KeyEvent.VK_SPACE)
        {
        	Game.running = ! Game.running;
        }
		
	}

	@Override
	//releasing the keys
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