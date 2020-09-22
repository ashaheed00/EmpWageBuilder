// Version UC6

public class EmpWageBuilder {

	static final short IS_PART_TIME = 1;
	static final short IS_FULL_TIME = 2;
	static short empCheck;
	static final int EMP_RATE_PER_HOUR = 20;
	static final int NO_OF_WORKING_DAYS = 20;
	static final int MAX_WORK_HOUR = 100;
	static short empHours = 0;
	static int empWage = 0;
	static int totalEmpWage = 0;

	public static void main(String[] args) {
		int totalWorkingDays = 0;
		int totalWorkingHours = 0;

		while (totalWorkingDays++ < NO_OF_WORKING_DAYS && totalWorkingHours < MAX_WORK_HOUR) {
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

			totalWorkingHours += empHours;
			System.out.println("Total Working Day: " + totalWorkingDays + " & Total Working Hours: " + totalWorkingHours);
		}

		empWage = totalWorkingHours * EMP_RATE_PER_HOUR;
		totalEmpWage += empWage;
		System.out.println("Total Emp Wage: " + totalEmpWage);
	}
}
