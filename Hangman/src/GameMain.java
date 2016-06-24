/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create the main class for a Hangman game to run
 */
public class GameMain 
{
	private Game hangman;
	private GameFrame hangmanFrame;
	
	/**
	 * create a constructor for the GameMain class
	 */

	public GameMain() 
	{
		super();
	}
	static GameMain hangmanMain = new GameMain();
	/**
	 * allow user to start the game
	 */
	public void start()
	{
		hangman = new Game("Hangman");
		hangmanFrame = new GameFrame(hangmanMain);
	}
	/**
	 * play again or quit based on choice
	 * @param choice the choice made by the player whether to play again or not
	 */
	public void playAgain(String choice)
	{
		if(choice.equals("yes"))
		{
			hangmanFrame.setVisible(false);
			hangmanFrame.dispose();
			start();
		}
		else if(choice.equals("no"))
		{
			hangmanFrame.setVisible(false);
			hangmanFrame.dispose();
			System.exit(0);
		}
	}
	
	/**
	 * get the current hangman game
	 * @return the game
	 */
	public Game getHangman() 
	{
		return hangman;
	}
	/**
	 * Start the game
	 */
	public static void main(String[] args) 
	{
		hangmanMain.start();
	}

}
