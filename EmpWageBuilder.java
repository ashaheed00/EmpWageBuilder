// Version UC4

public class EmpWageBuilder {

	static final short IS_PART_TIME = 1;
	static final short IS_FULL_TIME = 2;
	static short empCheck;
	static final int EMP_RATE_PER_HOUR = 20;
	static short empHours = 0;
	static int empWage;

	public static void main(String[] args) {

		empCheck = (short) (Math.random() * 10 % 3);

		switch (empCheck) {
		case IS_PART_TIME:
			empHours = 4;
			break;
		case IS_FULL_TIME:
			empHours = 8;
			break;
		default:
			empHours = 0;
		}

		empWage = empHours * EMP_RATE_PER_HOUR;
		System.out.println("Emp Wage: " + empWage);
	}
}
