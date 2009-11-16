package timecard.domain;

import java.util.Calendar;

import timecard.domain.worker.Worker;

public class TimeCardPublisher {
	public static TimeCard createTimeCard(Worker worker) {
		return new TimeCard(worker,
				Calendar.getInstance().get(Calendar.MONTH) + 1);
	}
}
