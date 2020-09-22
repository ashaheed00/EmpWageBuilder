// Version UC2

public class EmpWageBuilder {

	static final short IS_FULL_TIME = 1;
	static short empCheck;
	static final int EMP_RATE_PER_HOUR = 20;
	static short empHours = 0;
	static int empWage;

	public static void main(String[] args) {

		empCheck = (short) (Math.random() * 10 % 2);

		if (empCheck == 1)
			empHours = 8;
		empWage = empHours * EMP_RATE_PER_HOUR;
		System.out.println("Emp Wage: " + empWage);
	}
}
