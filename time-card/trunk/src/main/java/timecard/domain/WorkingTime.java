package timecard.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class WorkingTime {

	private final Date startDateTime;

	private Date finishedDateTime;

	public WorkingTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDateTime);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public Date getFinishedDateTime() {
		return finishedDateTime;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public BigDecimal getWorkingTime() {
		return BigDecimal.ZERO;
	}

	public void setFinishedTime(Date time) {
		finishedDateTime = time;
	}

}
