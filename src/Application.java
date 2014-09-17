
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Application extends JFrame{
	
	private static Application app;
	private static Game game;
	private static Menu menu;
	
	public static enum GameState {
	    MenuState, PingPongState;
	}
	
	private static GameState currentState;
	
	public Application(){

		menu = new Menu();
		game = new Game();

		setSize(Game.GAME_WIDTH, Game.GAME_HEIGHT + 60);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		addKeyListener(ih);
		
		currentState = GameState.PingPongState;
	}
	
	public static Game getGame(){
		return game;
	}
	
	public static void setGame(){
		game = new Game();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		app = new Application();

		app.add(menu);
		app.revalidate();
		app.repaint();
			
		double mSperFrame = 1 / 60.0 * 1000;
		long before = System.currentTimeMillis();
		double lag = 0.0;
		
		while(true){
			
			boolean shouldRender = false;
			long now = System.currentTimeMillis();
			long elapsed = now - before;
			before = now;
			lag += elapsed;

			while (lag >= mSperFrame) {
				lag -= mSperFrame;
				
				if (Game.running) {
					app.updateGame();
					shouldRender = true;
				}
			}

			if (shouldRender) {
				app.render();
				shouldRender = false;
			}
		}	
	}
	
	private void updateGame(){
		
		switch(currentState){
		case MenuState:
			break;
		case PingPongState:
			game.move();
			game.detectCollisions();
			game.timeRefresh();break;
		}
	}
	
	private void render(){
		
		switch(currentState){
		case MenuState:
			break;
		case PingPongState:
			game.repaint();break;
		}
	}
	
	public static void changeGameState(GameState state){
		currentState = state;

		app.remove(game);
		app.remove(menu);
		app.revalidate();
		app.repaint();
		
		switch(state){
		case MenuState:
			menu = new Menu();
			app.add(menu); break;
		case PingPongState:
			app.add(game); break;
		}
		
		app.revalidate();
		app.repaint();	
	}
	
}