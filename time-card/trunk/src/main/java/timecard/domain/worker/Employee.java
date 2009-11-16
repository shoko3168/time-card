package timecard.domain.worker;

/**
 * 従業員
 * 
 * @author j5ik2o
 * 
 */
public class Employee implements Worker {

	private final String empCode;

	private final String name;

	public Employee(String empCode, String name) {
		this.empCode = empCode;
		this.name = name;
	}

	@Override
	public String getCode() {
		return empCode;
	}

	@Override
	public String getName() {
		return name;
	}

}
