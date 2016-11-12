import javax.swing.JFrame;;

/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create a class for the window frame of a Hangman game
 */
public class GameFrame extends JFrame
{
	private GameMain main;
	private GamePanel panel;
	private static final long serialVersionUID = 1852705343580942878L;
	private JFrame frame;
	
	/**
	 * create a frame for a hangman game
	 * @param main the main class for the game
	 */
	public GameFrame(GameMain mainGame)
	{
		main = mainGame;
		panel = createPanel();
	    frame = new JFrame(main.getHangman().getTitle());
		frame.add(panel);
		frame.pack();
		frame.setSize(900, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
	}
	public GamePanel createPanel()
	{
		GamePanel aPanel = new GamePanel(main);
		return aPanel;
	}
	
	public void resetFrame()
	{
		frame.dispose();
		frame = new GameFrame(main);
		
	}
	


	
}
