import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
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
			/** Panel containing JLabel and JTextField, slider, and button, and text field */
			JPanel standard1 = new JPanel();
			/** Panel containing drop-down menu, "Calculate" button, 5 JLabels and 5 JTextFields,
			 and "Add Station" button and field */
			JPanel standard2 = new JPanel(new GridLayout(8, 2));
		/** Panel containing the creative aspect of the project */
		JPanel creativePanel = new JPanel(new GridLayout(2,1));
		
		//==================================================================================================================
		// Components contained in the panel standard1
		//==================================================================================================================
				
		JLabel distanceLabel = new JLabel("Enter Hamming Dist:");
		JTextField distanceField = new JTextField("2");
		
		JSlider distanceSlider = new JSlider(1, 4, 2);
		
		JButton showStationButton = new JButton("Show Station");
		
		JTextArea stationResultsField = new JTextArea();
		
		//==================================================================================================================
		// Components contained in the panel standard2
		//==================================================================================================================
				
		JLabel compareLabel = new JLabel("Compare with:");
		JComboBox<String> dropDownBox = new JComboBox<String>();
		
		GridBagConstraints layoutConst = null;
		
		
		
		public GraphicalHammingDistanceFrame()
		{
			super("GraphicalHammingDistanceFrame");
			this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	        this.setLayout(new GridBagLayout());
	        
	        distanceField.setEditable(false);
	        distanceSlider.setMajorTickSpacing(1);
	        distanceSlider.setPaintLabels(true);
	        distanceSlider.setPaintTicks(true);
	        
	        ////////////////////////////////////
	        // Add components to standard1 panel
	        layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			standard1.add(distanceLabel);
			
			layoutConst.gridy = 1;
			standard1.add(distanceField);
			
			layoutConst.gridx = 1;
			layoutConst.gridy = 0;
			standard1.add(distanceSlider);
			
			layoutConst.gridx = 2;
			standard1.add(showStationButton);
			
			stationResultsField.setColumns(75);
			stationResultsField.setRows(120);
			layoutConst.gridx = 3;
			standard1.add(stationResultsField);
			
			//////////////////////////////////		
			// Add components to standard2 panel
	        layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			standard2.add(compareLabel);
			
			dropDownBox.addItem("Hello");
			dropDownBox.addItem("Yes");

			
			
			layoutConst.gridy = 1;
			standard2.add(dropDownBox);
			
			
			
			
			
			// Add components to sub-panels
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			
			standardPanel.add(standard1);
			
			layoutConst.gridx = 1;
			standardPanel.add(standard2);
			///////////////////////////////
			
			// Add panels to main panel
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			
			mainPanel.add(standardPanel);
			
			layoutConst.gridy = 1;
			mainPanel.add(creativePanel);
			//////////////////////////////
			
			// Add all panels to frame
			this.add(mainPanel);
			// TODO: this.add(ghdPanel);
			
			
			// TODO
			
			dropDownBox.addActionListener((e) -> {
				String stationID = (String)dropDownBox.getSelectedItem();
				dropDownBox.setSelectedItem(stationID);
				
				
			});

			
			distanceSlider.addChangeListener((l) -> {
				int value = distanceSlider.getValue();
				distanceField.setText(Integer.toString(value));
			});
			
			
			
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