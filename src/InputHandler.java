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
        	Application.getGame().getPaddle2().setdY(-2);
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Application.getGame().getPaddle2().setdY(2);
        }
        
        if (key == KeyEvent.VK_W)
        {
        	Application.getGame().getPaddle1().setdY(-2);
        }

        if (key == KeyEvent.VK_S)
        {
        	Application.getGame().getPaddle1().setdY(2);
        }
        //adding the pause key
        if (key == KeyEvent.VK_SPACE)
        {
        	Game.running = ! Game.running;
        }
        
        if (key == KeyEvent.VK_G)
        {
        	Application.changeGameState(Application.GameState.PingPongState);
        }
        
        if (key == KeyEvent.VK_M)
        {
        	Application.changeGameState(Application.GameState.MenuState);
        }
        
        if (key == KeyEvent.VK_X)
        {
        	Application.getApplication().dispose();
        }
		
	}

	@Override
	//releasing the keys
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP)
        {
        	Application.getGame().getPaddle2().setdY(0);
        }

        if (key == KeyEvent.VK_DOWN)
        {
        	Application.getGame().getPaddle2().setdY(0);
        }
        
        if (key == KeyEvent.VK_W)
        {
        	Application.getGame().getPaddle1().setdY(0);
        }

        if (key == KeyEvent.VK_S)
        {
        	Application.getGame().getPaddle1().setdY(0);
        }	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
}