import java.util.Timer;
import java.util.TimerTask;

public class Run {
	public static void main(String args[]) {
		AlarmFrame af = new AlarmFrame();
		Timer timer=new Timer(true);
		TimerTask task=null;
		timer.schedule(task,10000);
		
	}
}
