import java.util.Random;

public class RandomStation {
	
	
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
