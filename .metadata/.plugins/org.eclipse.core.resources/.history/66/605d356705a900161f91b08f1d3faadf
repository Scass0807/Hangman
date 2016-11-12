import javax.swing.JFrame;;

/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create a class for the window frame of a Hangman game
 */
public class GameFrame extends JFrame
{
	
	private static final long serialVersionUID = 1852705343580942878L;
	
	private GamePanel panel;
	/**
	 * create a frame for a hangman game
	 * @param main the main class for the game
	 */
	public GameFrame(GameMain main)
	{
		panel = new GamePanel(main);
		JFrame frame = new JFrame(main.getHangman().getTitle());
		frame.add(panel);
		frame.pack();
		frame.setSize(900, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
	}
	


	
}
