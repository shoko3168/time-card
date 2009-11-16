package timecard.domain.worker;

public class TempStaff implements Worker {

	private final String code;
	private final String name;

	public TempStaff(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}

}
