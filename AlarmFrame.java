//import java.awt.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class AlarmFrame extends JFrame
{
	SpinnerDateModel year = new SpinnerDateModel();
	JTextField optionalMessage = new JTextField();

	
	public AlarmFrame() {
		JFrame frame = new JFrame("Alarms");
		Container pane = frame.getContentPane();
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
	    

	    
	    //setting frame size and visibility
		frame.setSize(300,175);
		frame.setVisible(true);
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
