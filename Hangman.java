import java.util.*;
public class Hangman {
	/*
	 1. Print underscores of letters
	 2. Allow for guess & have used word bank
	 3. Update letters or word bank
	 4. Update hangman
	 5. Interpret letter & word guesses
	 6. If correct guess, end game
	 */
	private static String[] words = {"constance", "rehabilitation", "identification", "horseshoe", "contemporary", "accumulation", "exaggerate", "spokesperson", "disposition", "administrative", "constitutional", "superintendent"};
	private String hangWord;
	private static Scanner input = new Scanner(System.in);
	private static int numLimbs = 0;
	private static String[] letterBank = {"","","","","","","","","","","","","","","","","","","","","","","","","",""};
	private static int guessNum = 0;
	

	public Hangman()
	{
		this.hangWord = words[(int)(Math.random()*12)];
	}
	
	public static void play(Hangman newGuy)
	{
		String[] chars = new String[newGuy.hangWord.length()];
		for(int i = 0; i < newGuy.hangWord.length(); i++)
		{
			chars[i] = "_";
		}
		
		for (int i = 0; i < newGuy.hangWord.length(); i++)
		{
			System.out.print("_ ");
		}
		
		String guess = "";
		
		while(numLimbs < 6)
		{
		System.out.print("\nGuess a letter or word: ");
		guess = input.next();
		guess.toLowerCase();
		
		if(guess.equals(newGuy.hangWord))
			break;
		
		guess(newGuy, guess, chars);
		getStatus(newGuy, chars);
		}
		
		
		if (numLimbs == 6)
		{
			System.out.println("\nHangman Completed, You Lose");
			System.out.println("Word was: " + newGuy.hangWord);
		}
		if(guess.equals(newGuy.hangWord))
		{
			System.out.println("\nCongrats! You guessed the word!");
		}

	}
	public static void guess(Hangman newGuy, String guess, String[] chars)
	{
		
		int correctCount = 0;
		for(int i = 0; i < newGuy.hangWord.length(); i++)
		{
			if(guess.charAt(0) == (newGuy.hangWord.charAt(i)))
			{
				chars[i] = guess;
				correctCount++;
			}
		}
		if (correctCount == 0)
		{
			System.out.println("Letter not present");
			numLimbs++;
			letterBank[guessNum] = guess;
			guessNum++;
		}

	}
	public static void getStatus(Hangman newGuy, String[] chars)
	{
		System.out.println("____");
		System.out.println("   |");
		if (numLimbs >= 1)
			System.out.println("   O");
		if (numLimbs >= 2)
			System.out.print("  /");
		if (numLimbs >= 3)
			System.out.print("|");
		if (numLimbs >= 4)
			System.out.println("\\");
		if (numLimbs >= 5)
			System.out.print("  /");
		if (numLimbs >= 6)
			System.out.print("\\");
		System.out.print("\n");
		
		for(int i = 0; i < chars.length; i++)
		{
			System.out.print(chars[i] + " ");
		}
		System.out.println("\n\nLetterBank:");
		
		for(int i = 0; i < chars.length; i++)
		{
			System.out.print(letterBank[i] + " ");
		}
		
		
	}
}
