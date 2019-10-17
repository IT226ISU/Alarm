import java.util.Timer;
import java.util.TimerTask;

public class Run {
	private static AlarmFrame af;
	public static void main(String args[]) {
		af = new AlarmFrame();
		Timer timer=new Timer(true);
		TimerTask task=new AlarmFirer();
		timer.schedule(task, 0, 10000);
		
	}
	public static void callAlarmSetOff(String message,int snoozes) {
		af.triggerAlarm(message, snoozes);
	}
}
