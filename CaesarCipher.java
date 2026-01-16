import java.util.*;
public class CaesarCipher {

	public static void main(String[] args) {
		/*
		 1. Get starting word
		 2. Shift left/Right (Convert to ASCII)
		 3. Shift by input
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter word or phrase: ");
		String word = input.nextLine();
		System.out.print("Do you wish to shift left or right? (L/R): ");
		String shift = input.next();
		System.out.print("How many letters to shift by?: ");
		int num = input.nextInt();
		System.out.print("Your cipher is: " + makeCipher(word,shift,num));
		
		

	}
	
	public static String makeCipher(String word, String shift, int num)
	{
		String newWord = "";
		if(shift.toLowerCase().equals("l"))
		{
			for(int i = 0; i < word.length(); i++)
			{
				int letter = word.charAt(i);
				int initValue = word.charAt(i);
				letter -= num;
				
				if(initValue < 32 || (initValue >= 91 && initValue < 97) || initValue > 122)
				{
					newWord += (char)initValue;
					continue;
				}
				
				if (letter < 65 || (letter < 97 && initValue > 96))
				{
					letter += 26;
				}
				newWord += (char)letter;
				
			}
		}
		
		if(shift.toLowerCase().equals("r"))
		{
			for(int i = 0; i < word.length(); i++)
			{
				int letter = word.charAt(i);
				int initValue = word.charAt(i);
				letter += num;
				
				if(initValue == 32)
				{
					newWord += (char)initValue;
					continue;
				}
					
				
				if ((letter > 90 && initValue < 91)|| letter > 122)
				{
					letter -= 26;
				}
				newWord += (char)letter;
				
			}
		}
		return newWord;
	}

}
