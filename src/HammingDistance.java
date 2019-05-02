import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that contains a file with Station IDs that is used in calculations of hamming distance 
 * between stations
 * @author Munn
 *
 */
public class HammingDistance {

	private String fileName = "Mesonet.txt";
	
	
	/**
	 * Checks the chosen station against all stations in the file and tallies the count
	 * of words that have a hamming distance of 0, 1, 2, 3, pr 4 and puts those counts in their 
	 * corresponding indices in the returned array (ie. the count of words with hamming distance 
	 * 0 is placed at index 0 in the array)
	 * @param staion the stationID to be checked against all stationIDs in the list
	 * @return int[] array containing the counts of how many words have a hamming distance of 
	 * 0, 1, 2, 3, or 4 with the given station. Index 0 represents the count of stations with 
	 * hamming distance 0 with the given word, index 1 represents the count of stations with
	 * hamming distance 1 with the given word, etc.
	 * @throws IOException
	 */
	public int[] checkAgainstAllWords(String station) throws IOException
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
			
			int hDistance = getHammingDistance(station, str);
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
	
	/**
	 * Calculates the haming distance between the two given station IDs
	 * @param str1 The first stationID to be compared
	 * @param str2 The second stationID to be compared
	 * @return The hamming distance between the two given stationIDs
	 */
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
	
	/**
	 * Generates a list of stationIDs that have a hamming distance of value 'target' with
	 * the given 'stationID'		
	 * @param stationID The stationID to be compared to the list
	 * @param target The hamming distance chosen on the JSlider that determines the stationIDs 
	 * that are returned. Any stationIDs from the file that have a hamming distance of this value with
	 * the inputed stationID will be returned
	 * @return The stationIDs that have a hamming distance of 'target' with 'stationID'
	 * @throws IOException
	 */
	public ArrayList<String> getStationList(String stationID, int target) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		ArrayList<String> stations = new ArrayList<String>();
		
		// As long as the file has more lines, ...
		while(br.ready())
		{
			// Takes out the 4 letter word from the string
			String str = br.readLine().substring(0, 4);
			
			int hDistance = getHammingDistance(stationID, str);
			if(hDistance == target)
				stations.add(str);
			
		}
		
		br.close();
		
		return stations;
	}
	
	/**
	 * Returns a list of all stationIDs in the file.
	 * @return ArrayList of all the stationIDs in the file
	 * @throws IOException
	 */
	public ArrayList<String> getAllStations() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		ArrayList<String> stations = new ArrayList<String>();
		
		// As long as the file has more lines, ...
		while(br.ready())
		{
			String str = br.readLine().substring(0, 4);
			stations.add(str);
		}
		
		br.close();
		
		return stations;
	}
}
