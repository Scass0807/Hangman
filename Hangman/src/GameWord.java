import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import java.io.InputStream;
/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create a class for the word of a Hangman game
 */
public class GameWord
{
	private ArrayList <String> gameWords;
	private String gameWord;
	/**
	 * choose a new word for a hangman game from a list of words obtained from a file
	 */
	public GameWord()
	{
		gameWords = new ArrayList <String>();
		try (InputStream in =(getClass().getResourceAsStream("/HangmanWords.txt"))) 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		    	gameWords.add(line);
		    }
		    Random random = new Random();
			gameWord = gameWords.remove(random.nextInt(gameWords.size()));
		}   
		catch (Exception ex) 
		{
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader(new File("HangmanWords.txt")));
				String line;
	 
					while ((line = br.readLine()) != null) 
					{
					    gameWords.add(line);
					}
	            Random random = new Random();
	            gameWord = gameWords.get(random.nextInt(gameWords.size()));
			}
			catch (IOException e) 
			{
			
				System.out.println(e);
			}
		}
	}
	/**
	 * get the word for the game
	 * @return the word
	 */
	public String getGameWord() 
	{
		return gameWord;
	}

}
