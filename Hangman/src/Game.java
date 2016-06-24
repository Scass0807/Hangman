import java.util.ArrayList;
/**
 * @author Steven Cassidy
 * Date: 6/11/16
 * Purpose: To create a class for the structure of a Hangman game
 */
public class Game 
{
	private String title;
	private ArrayList <Character> alphabet;
	private String secretWord;
	private int wrongGuessesAllowed;
	private int charsLeftToGuess;
	private char[] revealedString;
	private String endMessage;
	
	/**
	 * Instantiate instance field
	 * @param gameTitle the title of the hangman game
	 */

	public Game(String gameTitle) 
	{
		title = gameTitle;
		alphabet = new ArrayList <Character>();
		GameWord word = new GameWord();
		secretWord = word.getGameWord();
		charsLeftToGuess = secretWord.length();
		revealedString = new char[secretWord.length()];
		wrongGuessesAllowed = 6;
		for(char ch ='a';ch <= 'z';ch++)
		{
			alphabet.add(ch);
		}
		
		for(int index = 0;index < secretWord.length();index++)
		{
			revealedString[index] = '-';
		}
		
		endMessage = "";
	}
	/**
	 * Check a letter that is guessed by the player
	 * @param guess the guess inputed by the player
	 */
	public void checkGuess(char guess)
	{
		String before = new String(revealedString);
		
		for(int index = 0; index < secretWord.length();index++)
		{
			Character aGuess = guess;
			if(guess == secretWord.charAt(index) && alphabet.contains(aGuess))
			{
				revealedString[index] = guess;
				charsLeftToGuess--;
			}
			
		}
		String after = new String(revealedString);
		if(before.equals(after))
		{
			wrongGuessesAllowed--;
		}
	}
	/**
	 * check if the player has won the game
	 * @return true if won or false if game is not over or player lost
	 */
	public boolean checkIfWon()
	{
		String revealed = new String(revealedString);
		if(revealed.equals(secretWord) && charsLeftToGuess == 0)
		{
			return true;
		}
		return false;
	}
	/**
	 * check if the player has lost the game
	 * @return true if lost or false if game is not over or player won
	 */
	public boolean checkIfLost()
	{
		if(wrongGuessesAllowed == 0)
		{
			return true;
		}
		return false;
	}
	/**
	 * check if the game is over
	 * @return true if game is over false if not over
	 */
	public boolean isGameOver()
	{
		if(checkIfWon() || checkIfLost())
		{
			endMessage = "Game Over! ";
			if(checkIfWon())
			{
				endMessage += "Congradulations you win! Would you like to play again? ";
				return true;
			}
			else if(checkIfLost())
			{
				endMessage += "Sorry you lose! The word was: " + secretWord.toUpperCase() + ". Would you like to play again? ";
				return true;
			}
			
		}
		return false;
		
	}
	
	/**
	 * get the title of the game
	 * @return the title
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * get the alphabet
	 * @return the alphabet
	 */
	public ArrayList<Character> getAlphabet() 
	{
		return alphabet;
	}
	
	/**
	 * get the number of letters left to guess
	 * @return the number of letters
	 */
	public int getCharsLeftToGuess() 
	{
		return charsLeftToGuess;
	}
	/**
	 * get the current word in the game
	 * @return the word
	 */
	public String getSecretWord() 
	{
		return secretWord;
	}
	/**
	 * get the number of wrong guesses allowed
	 * @return the number of guesses
	 */
	public int getWrongGuessesAllowed() 
	{
		return wrongGuessesAllowed;
	}
	/**
	 * get the current revealed String on the screen
	 * @return this string as an array of chars
	 */
	public char[] getRevealedString() 
	{
		return revealedString;
	}
	/**
	 * get the message to be displayed at the end of the game
	 * @return the message
	 */
	public String getEndMessage() 
	{
		return endMessage;
	}	
}
