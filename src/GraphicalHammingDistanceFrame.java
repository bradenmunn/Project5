import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Class representing an interactive HammingDistance calculator. 
 * 
 * This overall project was conducted first by creating and positioning the JComponents in their 
 * proper positions in the frame, then by adding the functionality to all the components.
 * 
 * The overall frame contains 2 main panels: One for the "standard" components required
 * from the write-up, the other for the creative addition. While the 2 main panels 
 * were positioned in the frame using a GridLayout, each sub-panel arranged its components using a
 * GridBagLayout with GridBagConstraints to allow for more freedom with positioning elements.
 *
 * @author Braden Munn
 * @version 2019-04-20
 */
@SuppressWarnings("serial")
public class GraphicalHammingDistanceFrame extends JFrame
{
	private static final int FRAME_WIDTH = 525;
	private static final int FRAME_HEIGHT = 530;
	

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
	JScrollPane sp = new JScrollPane(stationResultsField);
	
	//==================================================================================================================
	// Components contained in the panel standard2
	//==================================================================================================================
			
	JLabel compareLabel = new JLabel("Compare with:");
	
	JComboBox<String> dropDownBox = new JComboBox<String>();
	ArrayList<String> dropDownContents = new ArrayList<String>();
	
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
	
	//==================================================================================================================
	// Components contained in the panel creative
	//==================================================================================================================

	JButton generateRandom = new JButton("Generate Random");
	
	JTextField randomStationID = new JTextField("", 5);
	
	JButton addAndCalculate = new JButton("Add & Calculate");
	
	
	
	
	GridBagConstraints layoutConst = null;
	
	
	//==================================================================================================================
	// End of Field Variables
	//==================================================================================================================

	/**
	 * Creates a GUI that displays information about the Hamming Distances between any two 4-letter station 
	 * IDs read in from a file. The frame has options for input and output of data, and involves a random
	 * station generator that will generate a random series of 4 letters that can be added and used to calculate
	 * hamming distance just like any of the station IDs read in from the original file.
	 */
	public GraphicalHammingDistanceFrame()
	{
		super("Hamming Distance Calculator");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new GridLayout(1, 2));
      
        // Setup panel 1 components
        distanceField.setEditable(false);
        distanceSlider.setMajorTickSpacing(1);
        distanceSlider.setPaintLabels(true);
        distanceSlider.setPaintTicks(true);
        
        stationResultsField.setEditable(false);
		stationResultsField.setColumns(10);
		stationResultsField.setRows(10);
		
		// Setup panel 2 compponents
		dist0Field.setEditable(false);
		dist1Field.setEditable(false);
		dist2Field.setEditable(false);
		dist3Field.setEditable(false);
		dist4Field.setEditable(false);
        
        ///////////////////////////////////////
        // Add components to standard1 panel //
        ///////////////////////////////////////
        standard1.setLayout(new GridBagLayout());
        
        // Enter Distance button and distance field
        layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		standard1.add(distanceLabel, layoutConst);
	
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard1.add(distanceField, layoutConst);
		
		// Slider
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 2;
		standard1.add(distanceSlider, layoutConst);
		
		// Show station button and field
		layoutConst = new GridBagConstraints();
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 2;
		standard1.add(showStationButton, layoutConst);
		
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard1.add(sp, layoutConst);
		
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
		addNewItem("NRMN");
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
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(dist0Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		standard2.add(dist1Label, layoutConst);
		
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(dist1Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		standard2.add(dist2Label, layoutConst);
		
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(dist2Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		standard2.add(dist3Label, layoutConst);
		
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(dist3Field, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		standard2.add(dist4Label, layoutConst);
		
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(dist4Field, layoutConst);
		
		// Add station button and field
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 7;
		standard2.add(addStation, layoutConst);
		
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		standard2.add(stationField, layoutConst);
		
		//////////////////////////////////////
		// Add components to creative panel //
		//////////////////////////////////////
		creativePanel.setLayout(new GridBagLayout());
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.fill = GridBagConstraints.CENTER;
		creativePanel.add(generateRandom, layoutConst);
		
		randomStationID.setEditable(false);
		layoutConst.gridx = 1;
		layoutConst.fill = GridBagConstraints.CENTER;
		creativePanel.add(randomStationID, layoutConst);
		
		addAndCalculate.setBackground(Color.PINK);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 2;
		creativePanel.add(addAndCalculate, layoutConst);
		
		
		//////////////////////////////////////
		// Add child panels to parent panel //
		//////////////////////////////////////
		standardPanel.setLayout(new GridBagLayout());
        standardPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		layoutConst = new GridBagConstraints();
		layoutConst.fill = GridBagConstraints.VERTICAL;
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		
		standardPanel.add(standard1, layoutConst);
		
		layoutConst.gridy = 1;
		standardPanel.add(standard2, layoutConst);
		

		/////////////////////////	
		// Add panels to frame //
		/////////////////////////
		this.add(standardPanel);
		this.add(creativePanel);
		
		
		
		
		distanceSlider.addChangeListener((l) -> {
			int value = distanceSlider.getValue();
			distanceField.setText(Integer.toString(value));
		});
		
		
		showStationButton.addActionListener((e) -> {
			
			ArrayList<String> stations = getStationList();
	
			String toPrint = "";
			for(int i = 0; i < stations.size(); ++i)
			{
				toPrint += stations.get(i) + "\n";
			}
			stationResultsField.setText(toPrint);
			
			// Starts the scroll bar at the top
			stationResultsField.setCaretPosition(0);
		});
		
		
		dropDownBox.addActionListener((e) -> {
			String item = (String)dropDownBox.getSelectedItem();
			dropDownBox.setSelectedItem(item);
		});
		
		
		addStation.addActionListener((e) -> {
			String stationID = stationField.getText();
			if(stationID.length() == 4 && !dropDownContents.contains(stationID))
			{
				addNewItem(stationID);
				stationField.setText("");
			}
		});
		
		
		calculate.addActionListener((e) -> {
			/** Stores the count of words in the text file that have a hamming distance
			 *  of 0, 1, 2, 3, and 4 with the selected word*/
			int[] hammingNodes = getHammingDistance();
			dist0Field.setText(Integer.toString(hammingNodes[0]));
			dist1Field.setText(Integer.toString(hammingNodes[1]));
			dist2Field.setText(Integer.toString(hammingNodes[2]));
			dist3Field.setText(Integer.toString(hammingNodes[3]));
			dist4Field.setText(Integer.toString(hammingNodes[4]));
		});
		
		
		generateRandom.addActionListener((e) -> {
			String randomStation = generateRandomStation();
			randomStationID.setText(randomStation);
			
		});
		
		
		addAndCalculate.addActionListener((e) -> {
			// Adds station to the station list
			String stationID = randomStationID.getText();
			if(stationID.length() == 4 && !dropDownContents.contains(stationID))
			{
				addNewItem(stationID);
				stationField.setText("");
			}
			
			dropDownBox.setSelectedItem(stationID);
			
			// Calculates HammingDistance
			
			/** Stores the count of words in the text file that have a hamming distance
			 *  of 0, 1, 2, 3, and 4 with the selected word*/
			int[] hammingNodes = getHammingDistance();
			dist0Field.setText(Integer.toString(hammingNodes[0]));
			dist1Field.setText(Integer.toString(hammingNodes[1]));
			dist2Field.setText(Integer.toString(hammingNodes[2]));
			dist3Field.setText(Integer.toString(hammingNodes[3]));
			dist4Field.setText(Integer.toString(hammingNodes[4]));
		});
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	/**
	 * Creates a HammingDistance object and uses the selected item in the JComboBox to
	 * generate an int array of the number of stations in the list that have hamming 
	 * distances of 0, 1, 2, 3, and 4.
	 * @return int[] where index at 0 is the number of stations of hamming distance 0 
	 * with the selected word, index 1 contains the number of stations of hamming distance 
	 * 1 with the selected word, and so on through the end of the array (length = 5)
	 */
	public int[] getHammingDistance()
	{
		HammingDistance hd = new HammingDistance();
		String currentStation = (String)dropDownBox.getSelectedItem();
		int[] results = new int[5];
		try {
			results = hd.checkAgainstAllWords(currentStation);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	/**
	 * Creates a HammingDistance object that uses the selected word from the JComboBox and the integer
	 * in the distance field to generate a list of station IDs from the file that have a hamming distance 
	 * of that integer [Integer.parseInt(distanceField.getText())] with the 
	 * word [(String)dropdownBox.getSelectedItem()].
	 * @return ArrayList of station IDs that have a hamming distance of (the integer in the distance field)
	 * with (the currently selected word in the JComboBox)
	 */
	public ArrayList<String> getStationList()
	{
		HammingDistance hd = new HammingDistance();
		
		int target = Integer.parseInt(distanceField.getText());
		String word = (String)dropDownBox.getSelectedItem();
		ArrayList<String> stations = new ArrayList<String>();
		
		try {
			stations = hd.getStationList(word, target);
		} 
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return stations;
	}
	
	public void addNewItem(String stationID)
	{
		dropDownContents.add(stationID);
		Collections.sort(dropDownContents);
		dropDownBox.removeAllItems();
		for(String station: dropDownContents)
		{
			dropDownBox.addItem(station);
		}
	}
	
	public String generateRandomStation()
	{
		RandomStation rs = new RandomStation();
		return rs.generateRandomStation();
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