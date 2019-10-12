package alarm;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.SpinnerDateModel;
public class Alarm {
	
	private JPanel buttonPanel,alarmSetPanel,alarmListPanel;
	private JScrollPane alarmSetScrollPane,alarmListScrollPane;
	private JSplitPane alarmPane,splitPane;
	/**
	 * Default Constructor
	 */
	public Alarm() {}
	
	/**
	 * Main Method -- runs the program.
	 * @param args runtime arguments
	 */
	public static void main(String[] args) {
		Alarm a=new Alarm();
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
		alarmSetPanel=new JPanel();
		alarmListPanel=new JPanel();
		//Add alarm JPanels to JScrollPanes
		alarmSetScrollPane=new JScrollPane(alarmSetPanel);
		alarmListScrollPane=new JScrollPane(alarmListPanel);
		//Create JSplitPanes
		alarmPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,alarmSetScrollPane,alarmListScrollPane);
		splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,alarmPane,buttonPanel);
		//Set resize rules
		alarmPane.setResizeWeight(0.25);
		splitPane.setResizeWeight(1.0);
		
		//JFrame
		JFrame frame= new JFrame("Alarm Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(splitPane);
		frame.pack();
		frame.setVisible(true);
	}

}

