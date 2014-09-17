
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Application extends JFrame{
	
	private static Application app;
	private static Game game;
	private static Menu menu;
	private static VictoryScreen victory;
	
	public static enum GameState {
	    MenuState, PingPongState, VictoryState;
	}
	
	private static GameState currentState;
	
	public Application(){

		menu = new Menu();
		game = new Game();
		victory = new VictoryScreen();
		
		setSize(Game.GAME_WIDTH, Game.GAME_HEIGHT + 60);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InputHandler ih = new InputHandler();
		addKeyListener(ih);
		
		currentState = GameState.MenuState;
	}
	
	public static Application  getApplication(){
		return app;
	}
	
	public static VictoryScreen getVictory(){
		return victory;
	}
	
	public static Game getGame(){
		return game;
	}
	
	public static void setGame(){
		game = new Game();
	}
	
	public static GameState getCurrentState(){
		return currentState;
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
				
				if (Game.getRunning()) {
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
			game.detectCollisions();;break;
		case VictoryState:
			break;
		}
	}
	
	private void render(){
		
		switch(currentState){
		case MenuState:
			break;
		case PingPongState:
			game.repaint();break;
		case VictoryState:
			break;
		}
	}
	
	public static void changeGameState(GameState state){
		currentState = state;

		app.remove(game);
		app.remove(menu);
		app.remove(victory);
		app.revalidate();
		app.repaint();
		
		switch(state){
		case MenuState:
			game = new Game();
			app.add(menu); break;
		case PingPongState:
			app.add(game); break;
		case VictoryState:
			app.add(victory); break;
		}
		
		app.revalidate();
		app.repaint();	
	}
	
}