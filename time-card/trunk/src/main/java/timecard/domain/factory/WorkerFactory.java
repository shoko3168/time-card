package timecard.domain.factory;

import timecard.domain.worker.Employee;
import timecard.domain.worker.TempStaff;
import timecard.domain.worker.Worker;

public class WorkerFactory {

	public static Worker createEmployee(String code, String name) {
		return new Employee(code, name);
	}

	public static Worker createTempStaff(String code, String name) {
		return new TempStaff(code, name);
	}

}
