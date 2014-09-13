import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Game.game.paddle1.dY = -2;
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.game.paddle1.dY = 2;
        }
        
        if (key == KeyEvent.VK_W)
        {
            Game.game.paddle2.dY = -2;
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.game.paddle2.dY = 2;
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Game.game.paddle1.dY = 0;
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.game.paddle1.dY = 0;
        }
        
        if (key == KeyEvent.VK_W)
        {
        	Game.game.paddle2.dY = 0;
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.game.paddle2.dY = 0;
        }
		
	}

}
