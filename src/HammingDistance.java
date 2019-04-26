import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDistance {

	private String fileName = "Mesonet.txt";
	
	
	public int getHammingDistance(String str1, String str2)
	{
		int count = 0;
		for(int i = 0; i < str1.length(); ++i)
		{
			// If the letters in a position are NOT the same, increase the count
			if(str1.charAt(i) != str2.charAt(i))
				++count;
		}
		return count;
	}
	
	
	public int[] checkAgainstAllWords(String word) throws IOException
	{
		// Reads in the mesonet.txt file
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// This will track the frequency of different hamming distances when comparing a word to the whole list.
		// Index 1 shows count of times the hamming distance is 1 between that word and the selected word from the 
		// list, index 2 shows count of times hamming distance is 2, and so on (ignores index at 0)
		int[] results = new int[5];
		
		// As long as the file has more lines, ...
		while(br.ready())
		{
			// Takes out the 4 letter word from the string
			String str = br.readLine().substring(0, 4);
			
			int hDistance = getHammingDistance(word, str);
			if(hDistance == 0)
				results[0] = ++results[0];
			else if(hDistance == 1)
				results[1] = ++results[1];
			else if(hDistance == 2)
				results[2] = ++results[2];
			else if(hDistance == 3)
				results[3] = ++results[3];
			else if(hDistance == 4)
				results[4] = ++results[4];
			
		}
		
		br.close();
		
		return results;
	}
}
