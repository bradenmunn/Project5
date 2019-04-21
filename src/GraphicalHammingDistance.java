import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class representing an interactive HammingDistance calculator.
 *
 * @author Braden Munn
 * @version 2019-04-20
 */
@SuppressWarnings("serial")
public class GraphicalHammingDistance extends JFrame
{
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 800;
	
	/**
	 * Interactive panel that the user clicks on to modify calculation of HammingDistance between stations. 
	 * The panel has multiple Graphical elements to perform different tasks
	 */
	@SuppressWarnings("unused")
	private final class GraphicalCalculatorPanel extends JPanel
	{
		
	}

	/**
	 * Main method to the program. Creates a new GraphicalCalculatorFrame object,
	 * calling its constructor.
	 *
	 * @param args The program arguments.
	 */
	public static void main(String[] args) {
		new GraphicalHammingDistance();
	}

}