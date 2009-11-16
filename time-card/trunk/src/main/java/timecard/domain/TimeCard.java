package timecard.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import timecard.domain.worker.Worker;

/**
 * タイムカードを表すモデル。
 * 
 * @author j5ik2o
 */
public class TimeCard {

	private final Worker worker;

	private final List<WorkingTime> workingTimes = new ArrayList<WorkingTime>();

	private final int month;

	/**
	 * @param worker
	 * @param month
	 */
	public TimeCard(Worker worker, int month) {
		if (worker == null) {
			throw new NullPointerException("worker is null.");
		}
		if (month < 0 || month > 12) {
			throw new IllegalArgumentException("month is out of range.");
		}
		this.worker = worker;
		this.month = month;
	}

	public WorkingTime findWorkingTime(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		for (WorkingTime w : workingTimes) {
			if (w.getDate().equals(cal.getTime())) {
				return w;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * {@link Worker}を取得する。
	 * 
	 * @return {@link Worker}
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * このタイムカードの勤務時間の{@link List}を取得する。
	 * 
	 * @return {@link List}
	 */
	public List<WorkingTime> getWorkingTimes() {
		return workingTimes;
	}

	public boolean hasWorkingTime(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		for (WorkingTime w : workingTimes) {
			if (w.getDate().equals(cal.getTime())) {
				return true;
			}
		}
		return false;
	}

	public WorkingTime newWorkingTime(Date startDateTime) {
		return new WorkingTime(startDateTime);
	}

}
