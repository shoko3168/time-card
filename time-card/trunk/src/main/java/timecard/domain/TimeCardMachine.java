package timecard.domain;

import java.util.Calendar;

import timecard.domain.factory.WorkerFactory;
import timecard.domain.worker.Worker;

public class TimeCardMachine {

	private static class InstanceHolder {
		static final TimeCardMachine instance = new TimeCardMachine();
	}

	public static TimeCardMachine getInstance() {
		return InstanceHolder.instance;
	}

	public static void main(String[] argv) {
		TimeCardRepositry tcr = TimeCardRepositry.getInstance();
		TimeCardMachine tcm = TimeCardMachine.getInstance();
		tcr.load();

		Worker worker = WorkerFactory.createTempStaff("cc", "cc");

		TimeCard tc = null;
		if (!tcr.contains(worker)) {
			tc = TimeCardPublisher.createTimeCard(worker);
			tcr.put(tc);
		}
		tcm.stamp(tc);
		tcr.save();
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

}
