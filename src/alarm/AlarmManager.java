package alarm;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;
public class AlarmManager {
	
	private JPanel buttonPanel,alarmListPanel,alarmSetPanel;
	private JScrollPane alarmListScrollPane,alarmSetScrollPane;
	private JSplitPane alarmPane,splitPane;
	private JButton addButton,editButton,deleteButton;
	/** This is the JFrame window that the user will see **/
	private JFrame frame;
	/**
	 * Default Constructor
	 */
	public AlarmManager() {
		frame= new JFrame("Alarm Manager");
	}
	
	/**
	 * Main Method -- runs the program.
	 * @param args runtime arguments
	 */
	public static void main(String[] args) {
		AlarmManager a=new AlarmManager();
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        a.createAndShowGUI();
		    }
		});
	}
	/**
	 * Creates GUI components
	 */
	private void createAndShowGUI() {
		//Create JPanels
		buttonPanel=new JPanel();
		alarmListPanel=new JPanel();
		alarmSetPanel=new JPanel();
		//Add alarm JPanels to JScrollPanes
		alarmListScrollPane=new JScrollPane(alarmListPanel);
		//alarmSetScrollPane=new JScrollPane(alarmSetPanel);
		//Create JSplitPanes
		alarmPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,alarmListScrollPane,alarmSetPanel);
		//splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,alarmPane,buttonPanel);
		//Set resize rules
		alarmPane.setResizeWeight(0.25);
		//splitPane.setResizeWeight(1.0);
		initButtons();
		
		alarmListPanel.add(buttonPanel);
		
		//JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(alarmPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Create and initialize buttons for buttonPanel
	 */
	private void initButtons() {
		//Create buttons
		addButton=new JButton("Add");
		editButton=new JButton("Edit");
		deleteButton=new JButton("Delete");

		//Button Tooltips
		addButton.setToolTipText("Click this button to add your alarm to the list");
		editButton.setToolTipText("Click this button to edit the selected alarm");
		deleteButton.setToolTipText("Click this button to delete the selected alarm");

		//These Buttons will be enabled when they can be used
		editButton.setEnabled(false);
		deleteButton.setEnabled(false);

		//Set Listeners for Buttons

		//Add Buttons to Panel
		//buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(deleteButton);
		
	}
}

