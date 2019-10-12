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
	private void createAndShowGUI() {
		JFrame frame= new JFrame("Alarm Manager");
		buttonPanel=new JPanel();
		alarmSetPanel=new JPanel();
		alarmSetScrollPane=new JScrollPane(alarmSetPanel);
		alarmListPanel=new JPanel();
		alarmListScrollPane=new JScrollPane(alarmListPanel);
		alarmPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,alarmSetScrollPane,alarmListScrollPane);
		splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,alarmPane,buttonPanel);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(splitPane);
		frame.pack();
		frame.setVisible(true);
	}

}

