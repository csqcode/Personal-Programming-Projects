import java.util.*;
public class PasswordGenerator {

	public static void main(String[] args) {
		/*
		1. Length
		2. Uppercase & Lowercase
		3. Numbers & Symbols
		*/

		Scanner input = new Scanner(System.in);
		System.out.print("Minimum number of characters in password: ");
		int minNum = input.nextInt();
		System.out.print("Include numbers and symbols? (Y/N): ");
		String include = input.next();
		include.toLowerCase();
		String pass = "";
		
		if (include.equals("n"))
		{
			pass = basicPass(minNum);
		}
		if (include.equals("y"))
		{
			pass = advancedPass(minNum);
		}
		
		System.out.print("Your password is: " + pass); 
		
		
	}
	public static String basicPass(int minNum)
	{
		//Just letters (65 - 90, 97 - 122)
		String newPassword = "";
		for (int i = 0; i < minNum; i++)
		{
			char newChar = (char)((Math.random()*58)+65);
			
			while (newChar > 90 && newChar < 97)
			{
				newChar = (char)((Math.random()*58)+65);
			}
			newPassword += newChar;
		}
		return newPassword;
	}
	
	public static String advancedPass(int minNum)
	{
		//33 - 64
		String newPass = basicPass(minNum);
		for(int i = 0; i < minNum; i++)
		{
			char newChar = '\0';
			double coin = Math.random();
			if (coin > .5)
			{
				newChar = (char)((Math.random()*32)+33);
				String half1 = newPass.substring(0,i);
				String half2 = newPass.substring(i);
				newPass = half1 + newChar + half2;
			}
			
			
		}
		return newPass;
		
	}

}
