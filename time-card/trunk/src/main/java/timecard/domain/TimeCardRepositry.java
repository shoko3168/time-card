package timecard.domain;

import java.util.HashMap;
import java.util.Map;

import timecard.domain.worker.Worker;

/**
 * {@link TimeCard}のリポジトリ
 * 
 * @author j5ik2o
 * 
 */
public class TimeCardRepositry {

	/**
	 * シングルトンのインスタンスを取得する。
	 * 
	 * @return {@link TimeCardRepositry}
	 */
	public static TimeCardRepositry getInstance() {
		return InstanceHolder.instance;
	}

	private final Map<Worker, TimeCard> repositry = new HashMap<Worker, TimeCard>();

	private TimeCardRepositry() {

	}

	/**
	 * {@link Worker}が含まれるかどうかを取得する。
	 * 
	 * @param worker
	 *            {@link Worker}
	 * @return 含まれる場合true
	 */
	public boolean contains(Worker worker) {
		return repositry.containsKey(worker);
	}

	public TimeCard find(Worker worker) {
		return repositry.get(worker);
	}

	public void load() {

	}

	public void put(TimeCard timeCard) {
		repositry.put(timeCard.getWorker(), timeCard);
	}

	public void save() {

	}

	private static class InstanceHolder {
		static final TimeCardRepositry instance = new TimeCardRepositry();
	}

}
