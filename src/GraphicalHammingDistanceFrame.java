import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class representing an interactive HammingDistance calculator.
 *
 * @author Braden Munn
 * @version 2019-04-20
 */
@SuppressWarnings("serial")
public class GraphicalHammingDistanceFrame extends JFrame
{
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 800;
	
	/**
	 * Interactive panel that the user clicks on to modify calculation of HammingDistance between stations. 
	 * The panel has multiple Graphical elements to perform different tasks
	 */
	@SuppressWarnings("unused")
	private final class HammingDistancePanel extends JPanel
	{
		
		
		public HammingDistancePanel()
		{
			this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
			// TODO
		}
		
		// Holds the left components and the creative component
		JPanel mainPanel = new JPanel(new GridLayout(1, 2));
		// Holds the components of the standard Hamming Distance operations 
		// (everything but creative component)
		JPanel standardPanel = new JPanel(new GridLayout(3,1));
		// Panel containing slider, text field, and button
		JPanel standard1 = new JPanel(new GridLayout(5, 1));
		// Panel containing drop-down, "Calculate" button, 5 JLabels and 5 JTextFields,
		// and "Add Station" button and field
		JPanel standard2 = new JPanel(new GridLayout(8, 2));
	}

	/**
	 * Main method to the program. Creates a new GraphicalCalculatorFrame object,
	 * calling its constructor.
	 *
	 * @param args The program arguments.
	 */
	public static void main(String[] args) {
		new GraphicalHammingDistanceFrame();
	}

}