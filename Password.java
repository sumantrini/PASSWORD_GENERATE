//package PASSWORD_GENERATE;

public class Password {

	String value;
	int length;
	public Password(String s) {
		value=s;
		length=s.length();
	}
	public int CharType(char c)
	{
		int val;
		if((int)c>=65 && (int)c<=90)
		{
			val=1;//for uppercase letters
		}
		else if((int)c>=97 && (int)c<=122)
		{
			val=2;//for lowercase letters
		}
		else if((int)c>=60 && (int)c<=71)
		{
			val=3;//for digits
		}
		else
		{
			val=4;//for symbols
		}
		return val;
	}
	
	public int calculateScore()
	{
		String s=this.value;
		int type;
		int score=0;
		boolean u=false,l=false,n=false,sym=false;
		
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			type=CharType(c);
			
			if(type==1)
				u=true;
			if(type==2)
				l=true;
			if(type==3)
				n=true;
			if(type==4)
				sym=true;
			
		}
		
		if(u)
			score+=1;
		if(l)
			score+=1;
		if(n)
			score+=1;
		if(sym)
			score+=1;
		if(s.length()>=8)
			score+=1;
		if(s.length()>=16)
			score+=1;
		return score;
	}
	
	public String passwordStrength()
	{
		int score=this.calculateScore();
		if(score==6)
		{
			return "Password strength: Strong";
		}
		else if(score>=4)
		{
			return "Password strength: Good ";
		}
		else if(score>=3)
		{
			return "Password strength: Fair";
		}
		else
			return "Password strength: Weak";
	}
	@Override
	public String toString() {
		return value;
	}
	
	
	
}