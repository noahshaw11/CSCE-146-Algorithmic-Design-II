/*
 * Written by Noah Shaw
 */
public class WordHelper {
	//Sort by least number of vowels to greatest number of vowels
	public static String[] sortByVowels(String[] aString)
	{
		String[] copy = copyArray(aString);
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < copy.length - 1; i++)
			{
				if(countVowels(copy[i]) > countVowels(copy[i+1]))
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		return copy;
	}
	//Sort by least number of consonants to greatest number of consonants
	public static String[] sortByConsonants(String[] aString)
	{
		String[] copy = copyArray(aString);
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < copy.length - 1; i++)
			{
				if(countConsonants(copy[i]) > countConsonants(copy[i+1]))
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		return copy;
	}
	//Sort by smallest length to greatest length
	public static String[] sortByLength(String[] aString)
	{
		String[] copy = copyArray(aString);
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < copy.length - 1; i++)
			{
				if(copy[i].length() > copy[i+1].length())
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		return copy;
	}
	//Count the number of vowels in each word
	public static int countVowels(String aString)
	{
		int count = 0;
		for(int i = 0; i < aString.length(); i++)
		{
			char c = aString.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
			{
				count++;
			}
		}
		return count;
	}
	//Count the number of consonants in each word
	public static int countConsonants(String aString)
	{
		int count = 0;
		for(int i = 0; i < aString.length(); i++)
		{
			char c = aString.charAt(i);
			if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y')
			{
				count++;
			}
		}
		return count;
	}
	//Create a copy of the initial array
	public static String[] copyArray(String[] aString)
	{
		String[] copy = new String[aString.length];
		for(int i = 0; i < aString.length; i++)
		{
			copy[i] = aString[i];
		}
		return copy;
	}

}
