//package PASSWORD_GENERATE;

import java.util.Scanner;

public class Generator {
	
	Alphabet alphabet;
	public static Scanner sc;
	
	public Generator(Scanner sc)
	{
		this.sc=sc;
	}
	
	public Generator(boolean includeUpper,boolean includeLower,boolean includeNum,boolean includeSymbol)
	{
		alphabet=new Alphabet(includeUpper,includeLower,includeNum,includeSymbol);
		
	}
	
	public void options()
	{
		System.out.println("----Welcome to password generator----");
		printMenu();
		String choice="0";
		
		while(!choice.equals("4"))
		{
			choice=sc.next();
			switch(choice)
			{
			case "1":
				requestPassword();
				printMenu();
				break;
			case "2":
				checkPassword();
				printMenu();
				break;
			case "3":
				printInfo();
				printMenu();
				break;
			case "4":
				System.out.println("GOODBYE!!");
				return;
			default:
				System.out.println("Kindly choose appropriate option...");
				printMenu();
				break;
			}
		}
	}
	private void printInfo()
	{
		System.out.println();
		System.out.println("• Use a minimum password length of 8 or more characters");
		System.out.println("• Include atleast one lowercase character,uppercase character,number and symbol");

	}
	private void requestPassword()
	{
		boolean upper=false,lower=false,num=false,sym=false;
		boolean correctParams;
		//String input;
		System.out.println();
		System.out.println("Answer the following questions by YES/NO\n");
		do
		{
			String input;
			correctParams=false;
			do
			{
				System.out.println("Do you want Lowercase letters \"abcd...\"to be used?");
				input=sc.next();
				passwordError(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") );
		 
			if(isInclude(input))
				lower=true;
			
			do
			{
				System.out.println("Do you want Uppercase letters \"ABCD...\"to be used?");
				input=sc.next();
				passwordError(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") );
		
			if(isInclude(input))
				upper=true;
			
			do
			{
				System.out.println("Do you want numbers \"1234...\"to be used?");
				input=sc.next();
				passwordError(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") );
		
			if(isInclude(input))
				num=true;
			
			do
			{
				System.out.println("Do you want symbols \"!@#$...\"to be used?");
				input=sc.next();
				passwordError(input);
			}while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") );
		
			if(isInclude(input))
				sym=true;
			
			if(!upper && !lower && !num && !sym)
			{
				System.out.println("You have selected no character for password generation");
				correctParams=true;
			}
		
		}while(correctParams);
		System.out.println("Now enter the length of the password:");
		int length=sc.nextInt();
		
		final Generator generator=new Generator(upper,lower,num,sym);
		final Password password=generator.generatePassword(length);
	
		System.out.println();
		System.out.println("\nGENERATED PASSWORD: "+password);
	}
	
	private Password generatePassword(int n)
	{
		final StringBuilder pass=new StringBuilder("");
		final int alphaLength=alphabet.getAlphabet().length();
		System.out.println(alphabet.getAlphabet());
		
		int max=alphaLength-1;
		int min=0;
		int range=max-min+1;
		
		for(int i=0;i<n;i++)
		{
			int index=(int)(Math.random()*range)+min;
			pass.append(alphabet.getAlphabet().charAt(index));
		}
		return new Password(pass.toString());
	}
	private void checkPassword()
	{
		String input;
		System.out.println("\nEnter your password:");
		input=sc.next();
		final Password p=new Password(input);
		System.out.println(p.passwordStrength());
	}
	
	private boolean isInclude(String input)
	{
		if(input.equalsIgnoreCase("yes"))
			return true;
		return false;
	}
	
	private void passwordError(String s)
	{
		if(!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no"))
		{
			System.out.println("You have entered something incorrect!!\nRE-ENTER...");
			
		}
	}
	
	
	public void printMenu()
	{
		System.out.println();
		System.out.println("Enter 1 : Generate Password");
		System.out.println("Enter 2 : Check Password strength");
		System.out.println("Enter 3 : IMPORTANT INFORMATION");
		System.out.println("Enter 4 : Exit");
		System.out.println("Enter your choice: ");
		
	}
	
}