package timecard.domain;

import java.util.Calendar;

import timecard.domain.worker.Worker;

public class TimeCardMachine {

	public static TimeCardMachine getInstance() {
		return InstanceHolder.instance;
	}

	public TimeCard load(Worker worker, int month) {
		// load
		return new TimeCard(worker, month);
	}

	public void save(TimeCard timeCard) {
		// save
	}

	public void stamp(TimeCard timeCard) {
		Calendar cal = Calendar.getInstance();
		if (timeCard.hasWorkingTime(cal.getTime())) {
			WorkingTime w = timeCard.findWorkingTime(cal.getTime());
			w.setFinishedTime(cal.getTime());
		} else {
			WorkingTime w = timeCard.newWorkingTime(cal.getTime());
			timeCard.getWorkingTimes().add(w);
		}
		// 
	}

	private static class InstanceHolder {
		static final TimeCardMachine instance = new TimeCardMachine();
	}

}
