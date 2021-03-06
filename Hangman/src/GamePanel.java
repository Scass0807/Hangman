import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create a class for the graphics of a Hangman game
 */
public class GamePanel extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private GameMain mainGame;
	private Game game;
	private Image gallows;
	private String welcomeMsg;
	private ImageIcon gallowsImg;
	
	
	private JButton choiceYes;
	private JButton choiceNo;
	/**
	 * create the panel for the game
	 * @param main the main class for the game
	 */
	public GamePanel(GameMain main)
	{
		mainGame = main;
		game = main.getHangman();
		welcomeMsg = "Welcome to " + game.getTitle();
		try{
			gallowsImg = new ImageIcon(getClass().getResource("images/gallows.png"));
		}
		catch(Exception e)
		{
			gallowsImg =  new ImageIcon("images/gallows.png");
		}
		
		gallows = gallowsImg.getImage();
		this.setSize(900, 600);
		this.setVisible(true);
		this.setFocusable(true);
		this.addLetters();
		this.addPlayAgainButtons();
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255));
		
	}
	/**
	 * paint the graphics to the screen
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		FontMetrics fm = getFontMetrics(new Font("Arial Black",Font.PLAIN,50));
		Rectangle2D welcomeSize = fm.getStringBounds(welcomeMsg, g);
		
		g.setFont(new Font("Arial Black",Font.PLAIN,50));
		g.drawString(welcomeMsg,  (int) ((this.getWidth() - welcomeSize.getWidth()) / 2), 60);
		g.drawImage(gallows, 0, 80, 300, 200, null);
		g.drawChars(game.getRevealedString(), 0, game.getRevealedString().length, 50, 325);
		g.setFont(new Font("Calibri",Font.PLAIN,12));
		g.drawString("Number of wrong guesses allowed: " + game.getWrongGuessesAllowed(), (this.getWidth()/2) -150, 100);
		g.drawString("Number of letters left to guess: " + game.getCharsLeftToGuess(), this.getWidth()/2 + 100, 100);
		
		if(game.getWrongGuessesAllowed() == 5)
		{
			g.drawOval(152, 94, 20, 20);
			
		}
		if(game.getWrongGuessesAllowed() == 4)
		{
			g.drawOval(152, 94, 20, 20);
			g.drawLine(162, 115, 162, 145);
		}
		if(game.getWrongGuessesAllowed() == 3)
		{
			g.drawOval(152, 94, 20, 20);
			g.drawLine(162, 115, 162, 145);
			g.drawLine(162, 120, 152, 132);
		}
		if(game.getWrongGuessesAllowed() == 2)
		{
			g.drawOval(152, 94, 20, 20);
			g.drawLine(162, 115, 162, 145);
			g.drawLine(162, 120, 152, 132);
			g.drawLine(162, 120, 172, 132);
		}
		if(game.getWrongGuessesAllowed() == 1)
		{
			g.drawOval(152, 94, 20, 20);
			g.drawLine(162, 115, 162, 145);
			g.drawLine(162, 120, 152, 132);
			g.drawLine(162, 120, 172, 132);
			g.drawLine(162, 145, 152, 167);
		}
		if(game.getWrongGuessesAllowed() == 0)
		{
			g.drawOval(152, 94, 20, 20);
			g.drawLine(162, 115, 162, 145);
			g.drawLine(162, 120, 152, 132);
			g.drawLine(162, 120, 172, 132);
			g.drawLine(162, 145, 152, 167);
			g.drawLine(162, 145, 172, 167);
		}
		if(game.isGameOver())
		{
			g.setFont(new Font("Calibri",Font.BOLD,12));
			FontMetrics fm2 = getFontMetrics(new Font("Calibri",Font.BOLD,12));
			Rectangle2D endSize = fm.getStringBounds((game.getEndMessage()), g);
			g.drawString(game.getEndMessage(), (this.getWidth()/2) + -100, 200);
			choiceYes.setLocation((this.getWidth()/2) -50, 210);
			choiceYes.setVisible(true);
			choiceNo.setLocation((this.getWidth()/2) + 100, 210);
			choiceNo.setVisible(true);
			if(game.checkIfWon())
			{
				this.setBackground(new Color(0,128,0));
			}
			else if(game.checkIfLost())
			{
				this.setBackground(new Color(255,0,0));
			}
			
		}
		
		repaint();
		
	}
	/**
	 * add the letter buttons to the screen
	 */
	public void addLetters()
	{
		
		int x = (this.getWidth()/2)-60;
		int y = 300;
		int btnSize =20;
		int btnsAdded = 0;
		
		for (Character c : game.getAlphabet()) 
		{
			this.setLayout(null);
			JButton letter = new JButton(Character.toString(c).toUpperCase());
			letter.setLayout(null);
			letter.setSize(btnSize, btnSize);
			letter.setLocation(x,y);
			letter.setFont(new Font("Calibri",Font.PLAIN,10));
			letter.setMargin(new Insets(0,0,0,0));
			letter.setVisible(true); 
			

			
			
			this.add(letter);
			
			
			char guess = Character.toLowerCase(c);
			letter.addActionListener(new ActionListener() 
			{
			@Override public void actionPerformed(ActionEvent e) 
			{
		    game.checkGuess(guess);
		    letter.setVisible(false);
		   
		    }
		  });
			 x += 25;
			 btnsAdded++;
			 if(btnsAdded == 13)
			 {
				 x=(this.getWidth()/2)-60;
				 y+=50;
			 }
		}
	}
	int xLocation = this.getWidth()/2;
	/**
	 * add buttons that allow the user to play again or not
	 */
	public void addPlayAgainButtons()
	{
		
		choiceYes = new JButton("Yes");
		choiceYes.setFont(new Font("Calibri",Font.PLAIN,10));
		this.setLayout(null);
		choiceYes.setMargin(new Insets(0,0,0,0));
		choiceYes.setSize(100, 50);
		choiceYes.setLocation((this.getWidth()/2) -50, 210);
		choiceYes.setVisible(false);
		this.add(choiceYes);
		choiceYes.addActionListener(this);
		
		choiceNo = new JButton("No");
		choiceNo.setFont(new Font("Calibri",Font.PLAIN,10));
		this.setLayout(null);
		choiceNo.setMargin(new Insets(0,0,0,0));
		choiceNo.setSize(100, 50);
		choiceNo.setLocation((this.getWidth()/2) + 100, 210);
		choiceNo.setVisible(false);
		this.add(choiceNo);
		choiceNo.addActionListener(this);
	}
			

	/**
	 * add actions to play again buttons
	 */
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		if(src == choiceYes)
		{
			mainGame.playAgain("yes");
		}
		else if(src == choiceNo)
		{
			mainGame.playAgain("no");
		}
		
		
	}
	
}
