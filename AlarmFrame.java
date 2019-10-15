//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlarmFrame extends JFrame implements ActionListener
{
	public AlarmFrame() {
		JFrame frame = new JFrame("Alarms");
		JPanel panel = new JPanel();
		frame.add(panel);
		
		SpinnerDateModel year = new SpinnerDateModel();
		JSpinner model = new JSpinner(year);
		panel.add(model);
		
	   /* String[] hourStrings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	    String[] minuteStrings = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
	    		"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33",
	    		"34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51",
	    		"52", "53", "54", "55", "56", "57", "58", "59"};
	    String[] dayNightStrings = {"AM", "PM"};
	    String[] monthStrings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	    String[] dayStrings = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
	    		"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	    String[] yearStrings = {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
*/
	    
	    
	    
	    //Create the combo box
		JTextField optionalMessage = new JTextField();
		optionalMessage.setEditable(true);
		optionalMessage.setColumns(10);
		
		
/*	    JComboBox hourList = new JComboBox(hourStrings);
	    hourList.setSelectedIndex(0);
	    hourList.addActionListener(this);*/

/*	    JComboBox minuteList = new JComboBox(minuteStrings);
	    minuteList.setSelectedIndex(0);
	    minuteList.addActionListener(this);
	    
	    JComboBox dayNightList = new JComboBox(dayNightStrings);
	    dayNightList.setSelectedIndex(0);
	    dayNightList.addActionListener(this);*/

/*	    JComboBox monthList = new JComboBox(monthStrings);
	    monthList.setSelectedIndex(0);
	    monthList.addActionListener(this);
	    
	    JComboBox dayList = new JComboBox(dayStrings);
	    dayList.setSelectedIndex(0);
	    dayList.addActionListener(this);
	    
	    JComboBox yearList = new JComboBox(yearStrings);
	    yearList.setSelectedIndex(0);
	    yearList.addActionListener(this);*/
	    
	    
	    
	    
	    
	    
		//Labels of the combo boxes
	    JLabel label4 = new JLabel("Optional Message");
	    panel.add(label4);
		panel.add(optionalMessage);   
	    
		JButton button = new JButton("Submit");
	    panel.add(button);  
	    
/*		JLabel label = new JLabel("Hour");
		panel.add(label);
	    panel.add(hourList);
	    
		JLabel label2 = new JLabel("Minute");
		panel.add(label2);
	    panel.add(minuteList);
	    
		JLabel label3 = new JLabel("AM/PM");
		panel.add(label3);
	    panel.add(dayNightList);
	    
	    JLabel label5 = new JLabel("Month");
	    panel.add(label5);
	    panel.add(monthList);
	    
	    JLabel label6 = new JLabel("Day");
	    panel.add(label6);
	    panel.add(dayList);
	        
	    JLabel label7 = new JLabel("Year");
	    panel.add(label7);
	    panel.add(yearList);*/
	    

	    
	    //setting frame size and visibility
		frame.setSize(250,175);
		frame.setVisible(true);
		}
	
	//action event listener
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String num = (String)cb.getSelectedItem();
    }
    
    
    //main program
	public static void main(String args[]) {
		AlarmFrame af = new AlarmFrame();
	}
}
