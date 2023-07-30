//package PASSWORD_GENERATE;

public class Alphabet {
	
	public static final String uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lowercase="abcdefghijklmnopqrstuvwxyz";
	public static final String numbers="1234567890";
	public static final String symbols="!@#$%^&*()-=+_\\/~?";
	
	private final StringBuilder pool;
	
	public Alphabet(boolean ucIncluded,boolean lcIncluded,boolean numIncluded,boolean spCharIncluded)
	{	
		pool= new StringBuilder();
		if(ucIncluded)
		{
			pool.append(uppercase);
		}
		if(lcIncluded)
		{
			pool.append(lowercase);
		}
		if(numIncluded)
		{
			pool.append(numbers);
		}
		if(spCharIncluded)
		{
			pool.append(symbols);
		}
		
	}
	
	public String getAlphabet()
	{
		return pool.toString();
	}
	
}