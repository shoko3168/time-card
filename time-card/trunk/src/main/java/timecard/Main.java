package timecard;

import timecard.domain.TimeCard;
import timecard.domain.TimeCardMachine;
import timecard.domain.TimeCardRepositry;
import timecard.domain.factory.TimeCardFactory;
import timecard.domain.factory.WorkerFactory;
import timecard.domain.worker.Worker;

public class Main {

	public static void main(String[] argv) {
		TimeCardRepositry tcr = TimeCardRepositry.getInstance();
		TimeCardMachine tcm = TimeCardMachine.getInstance();
		tcr.load();

		Worker worker = WorkerFactory.createTempStaff("cc", "cc");

		TimeCard tc = null;
		if (!tcr.contains(worker)) {
			tc = TimeCardFactory.createTimeCard(worker);
			tcr.put(tc);
		}
		tcm.stamp(tc);
		tcr.save();
	}
}
