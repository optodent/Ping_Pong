import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {
//setting the keys for playing the game
	// detecting the pressed keys
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Application.getCurrentState() == Application.GameState.PingPongState){
			
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
	        	Game.setRunning(!Game.getRunning());
	        }
	        
	        if (key == KeyEvent.VK_M)
	        {
	        	Application.changeGameState(Application.GameState.MenuState);
	        }
	        
		}else if (Application.getCurrentState() == Application.GameState.MenuState){
        
			if (key == KeyEvent.VK_G)
	        {
	        	Application.changeGameState(Application.GameState.PingPongState);
	        }
	        
			if (key == KeyEvent.VK_X)
			{
				Application.getApplication().dispose();
			}
			
		}else{
		
	        if (key == KeyEvent.VK_M)
	        {
	        	Application.changeGameState(Application.GameState.MenuState);
	        }
		}
	}

	//releasing the keys
	@Override
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