//import java.awt.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class AlarmFrame
{
	SpinnerDateModel year = new SpinnerDateModel();
	JTextField optionalMessage = new JTextField();
	JFrame frame = new JFrame("Alarms");
	
	public AlarmFrame() {
		JPanel pane=new JPanel();
		
		pane.setLayout(new GridLayout(5,1));
	
		JSpinner model = new JSpinner(year);
		   
	    
	    //Create the combo box
		optionalMessage.setEditable(true);
		optionalMessage.setColumns(10);
	    
	    
	    
		//Labels of the combo boxes
		JLabel label = new JLabel("Alarm");
		pane.add(label);
		pane.add(model);
		
	    JLabel label4 = new JLabel("Optional Message");
	    pane.add(label4);
		pane.add(optionalMessage);   
	    
		JButton button = new JButton("Submit");
	    pane.add(button);  
	    button.addActionListener(new ButtonActionListener());
	    //triggerAlarm("test",0);
	    
	    //setting frame size and visibility
	    frame.add(pane);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,175);
		frame.setVisible(true);
		}
	public void triggerAlarm(String message,int snoozes) {
		Toolkit.getDefaultToolkit().beep();
		String outputMessage=message;
		if (snoozes>0) {
			outputMessage+="\n Snoozed "+snoozes+" times.";
		}
		Object[] options = {"Snooze","Dismiss"};
		int n = JOptionPane.showOptionDialog(frame,
				outputMessage,
				"Alarm",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		//System.out.println(n);
		if (n==1) {
			//User is finished with the alarm
		}else {
			//create a new alarm with the time in 1 minute from now, the same message, and 1 more snooze than before
			new Saver(new Date(java.util.Calendar.getInstance().getTimeInMillis()+60000),message,snoozes+1);
		}
		}
	//action event listener
public class ButtonActionListener implements ActionListener
{
    public void actionPerformed(ActionEvent e){
    	String s;
    	Date y;
    	
 
    	y = year.getDate();
    	s = optionalMessage.getText();
    	if(s.equals("")) {
    		Saver alarm = new Saver(y);
    		return;
    	}
    	Saver alarm = new Saver(y, s);
    }
}
}