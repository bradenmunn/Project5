import java.util.Random;

/**
 * Class to generate a random stationID
 * @author Braden Munn
 *
 */
public class RandomStation {
	
	/**
	 * Generates a random 4-letter station ID
	 * @return 4-letter station ID (letters from 'A' - 'Z')
	 */
	public String generateRandomStation()
	{
		String station = "";
		
		for(int i = 0; i < 4; ++i)
		{
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'A');
			station += Character.toString(c);
		}
		
		return station;
	}
	
}
