import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

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
	private final class GraphicalHammingDistancePanel extends JPanel
	{
		
		
		public GraphicalHammingDistancePanel()
		{
			this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
			// TODO
		}
	}
	
	GraphicalHammingDistancePanel  ghdPanel = new GraphicalHammingDistancePanel();
	
		//==================================================================================================================
		// Panels for component grouping and organization:
		//==================================================================================================================
		
		/** Holds the left components and the creative component */
		JPanel mainPanel = new JPanel(new GridLayout(1, 2));
		/** Holds the components of the standard Hamming Distance operations 
		 (everything but creative component) */
		JPanel standardPanel = new JPanel(new GridLayout(3,1));
			/** Panel containing slider, text field, and button */
			JPanel standard1 = new JPanel(new GridLayout(4, 1));
			/** Panel containing drop-down menu, "Calculate" button, 5 JLabels and 5 JTextFields,
			 and "Add Station" button and field */
			JPanel standard2 = new JPanel(new GridLayout(8, 2));
		/** Panel containing the creative aspect of the project */
		JPanel creativePanel = new JPanel(new GridLayout(2,1));
		
		//==================================================================================================================
		// Components contained in the panel standard1
		//==================================================================================================================
				
		JLabel distanceLabel = new JLabel("Enter Hamming distance");
		JTextField distanceEntry = new JTextField("");
		
		JSlider distanceSlider = new JSlider(0, 4, 2);
		
		
		
		public GraphicalHammingDistanceFrame()
		{
			super("GraphicalHammingDistanceFrame");
			this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	        this.setLayout(new GridLayout(2, 0));
			
			// TODO: add components to sub-panels
			standard1.add(distanceSlider);
			
			// Add components to sub-panels
			standardPanel.add(standard1);
			standardPanel.add(standard2);
			
			// Add panels to main panel
			mainPanel.add(standardPanel);
			mainPanel.add(creativePanel);
			
			// Add all panels to frame
			this.add(mainPanel);
			this.add(ghdPanel);
			
			
			// TODO
			
			
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
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