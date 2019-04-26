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
		
		/** Holds the components of the standard Hamming Distance operations 
		 (everything but creative component) */
		JPanel standardPanel = new JPanel();
			/** Panel containing JLabel and JTextField, slider, and button, and text field */
			JPanel standard1 = new JPanel();
			/** Panel containing drop-down menu, "Calculate" button, 5 JLabels and 5 JTextFields,
			 and "Add Station" button and field */
			JPanel standard2 = new JPanel();
		/** Panel containing the creative aspect of the project */
		JPanel creativePanel = new JPanel();
		
		//==================================================================================================================
		// Components contained in the panel standard1
		//==================================================================================================================
				
		JLabel distanceLabel = new JLabel("Enter Hamming Dist:");
		JTextField distanceField = new JTextField("2", 5);
		
		JSlider distanceSlider = new JSlider(1, 4, 2);
		
		JButton showStationButton = new JButton("Show Station");
		
		JTextArea stationResultsField = new JTextArea();
		
		//==================================================================================================================
		// Components contained in the panel standard2
		//==================================================================================================================
				
		JLabel compareLabel = new JLabel("Compare with:");
		
		JComboBox<String> dropDownBox = new JComboBox<String>();
		
		JButton calculate = new JButton("Calculate HD");
		
		JLabel dist0Label = new JLabel("Distance 0");
		JLabel dist1Label = new JLabel("Distance 1");
		JLabel dist2Label = new JLabel("Distance 2");
		JLabel dist3Label = new JLabel("Distance 3");
		JLabel dist4Label = new JLabel("Distance 4");
		
		JTextField dist0Field = new JTextField();
		JTextField dist1Field = new JTextField();
		JTextField dist2Field = new JTextField();
		JTextField dist3Field = new JTextField();
		JTextField dist4Field = new JTextField();
		
		JButton addStation = new JButton("Add Station");
		
		JTextField stationField = new JTextField();
		
		
		
		
		
		
		GridBagConstraints layoutConst = null;
		
		
		//==================================================================================================================
		// Components contained in the panel standard2
		//==================================================================================================================

		public GraphicalHammingDistanceFrame()
		{
			super("GraphicalHammingDistanceFrame");
			this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	        this.setLayout(new GridLayout(1, 2));
	        
	        distanceField.setEditable(false);
	        distanceSlider.setMajorTickSpacing(1);
	        distanceSlider.setPaintLabels(true);
	        distanceSlider.setPaintTicks(true);
	        
	        ///////////////////////////////////////
	        // Add components to standard1 panel //
	        ///////////////////////////////////////
	        standard1.setLayout(new GridBagLayout());
	        
	        layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			standard1.add(distanceLabel, layoutConst);
		
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard1.add(distanceField, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
			layoutConst.anchor = GridBagConstraints.LINE_START;
			standard1.add(distanceSlider, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridy = 2;
			standard1.add(showStationButton, layoutConst);
			
			stationResultsField.setEditable(false);
			stationResultsField.setColumns(10);
			stationResultsField.setRows(10);
			layoutConst.gridy = 3;
			layoutConst.gridwidth = 2;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard1.add(stationResultsField, layoutConst);
			
			///////////////////////////////////////	
			// Add components to standard2 panel //
			///////////////////////////////////////
			standard2.setLayout(new GridBagLayout());
			
	        layoutConst = new GridBagConstraints();
	        layoutConst.anchor = GridBagConstraints.LINE_START; // TODO
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			standard2.add(compareLabel, layoutConst);
			
			layoutConst = new GridBagConstraints();
			dropDownBox.addItem("NRMN");
			layoutConst.gridx = 1;
			layoutConst.gridy = 0;
			standard2.add(dropDownBox, layoutConst);
			
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
			standard2.add(calculate, layoutConst);
			
			layoutConst.gridx = 0;
			layoutConst.gridy = 2;
			standard2.add(dist0Label, layoutConst);
			
			// Distance labels and fields
			dist0Field.setEditable(false);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(dist0Field, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 3;
			standard2.add(dist1Label, layoutConst);
			
			dist1Field.setEditable(false);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(dist1Field, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 4;
			standard2.add(dist2Label, layoutConst);
			
			dist2Field.setEditable(false);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(dist2Field, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 5;
			standard2.add(dist3Label, layoutConst);
			
			dist3Field.setEditable(false);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(dist3Field, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 6;
			standard2.add(dist4Label, layoutConst);
			
			dist4Field.setEditable(false);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(dist4Field, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 7;
			standard2.add(addStation, layoutConst);
			
			dist4Field.setEditable(true);
			layoutConst.gridx = 1;
			layoutConst.fill = GridBagConstraints.HORIZONTAL;
			standard2.add(stationField, layoutConst);
			
			
			// Add child panels to parent panel
			standardPanel.setLayout(new GridBagLayout());
	        standardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT - 300));
			
			layoutConst = new GridBagConstraints();
			layoutConst.fill = GridBagConstraints.VERTICAL;
			layoutConst.gridx = 0;
			layoutConst.gridy = 0;
			
			standardPanel.add(standard1, layoutConst);
			
			layoutConst.gridy = 1;
			standardPanel.add(standard2, layoutConst);
			

			///////////////////////////////
			
			// Add all panels to frame
			this.add(standardPanel);
			this.add(creativePanel);
			

			distanceSlider.addChangeListener((l) -> {
				int value = distanceSlider.getValue();
				distanceField.setText(Integer.toString(value));
			});
			
			dropDownBox.addActionListener((e) -> {
				String item = (String)dropDownBox.getSelectedItem();
				dropDownBox.setSelectedItem(item);
			});
			
			addStation.addActionListener((e) -> {
				String stationID = stationField.getText();
				if(stationID.length() == 4)
					dropDownBox.addItem(stationID);
				stationField.setText("");
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