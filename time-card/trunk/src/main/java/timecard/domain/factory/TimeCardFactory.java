package timecard.domain.factory;

import java.util.Calendar;

import timecard.domain.TimeCard;
import timecard.domain.worker.Worker;

public class TimeCardFactory {
	public static TimeCard createTimeCard(Worker worker) {
		return new TimeCard(worker,
				Calendar.getInstance().get(Calendar.MONTH) + 1);
	}
}
