package lab1.backend.other;

import java.time.LocalTime;
import java.util.Calendar;

public class Common {
	
	public static String getCumprimento() {
		return
			LocalTime.now().isBefore(LocalTime.NOON) ? "bom dia" :
			LocalTime.now().isAfter(LocalTime.of(18, 0)) ? "boa noite" :
        	"boa tarde";
	}
    
    public static String getServerTime() {
    	Calendar c = Calendar.getInstance();
    	return
    		String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":" +
    		String.format("%02d", c.get(Calendar.MINUTE)) + ":" +
    		String.format("%02d", c.get(Calendar.SECOND));
    }
}
