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
            Game.game.p.dY = -1;
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.game.p.dY = 1;
        }
        
        if (key == KeyEvent.VK_W)
        {
            Game.game.p2.dY = -1;
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.game.p2.dY = 1;
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Game.game.p.dY = 0;
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Game.game.p.dY = 0;
        }
        
        if (key == KeyEvent.VK_W)
        {
        	Game.game.p2.dY = 0;
        }

        if (key == KeyEvent.VK_S)
        {
        	Game.game.p2.dY = 0;
        }
		
	}

}
