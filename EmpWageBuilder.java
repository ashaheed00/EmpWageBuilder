// Version UC7

public class EmpWageBuilderClassMethod {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUMBER_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static int computeEmpWage() {
		int empHours = 0, totalWorkingHours = 0, totalWorkingDays = 0;

		while (totalWorkingDays++ < NUMBER_OF_WORKING_DAYS &&
				totalWorkingHours < MAX_HRS_IN_MONTH) {
			short empCheck = (short) (Math.random() * 10 % 3);

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
			System.out.println("Total Working Day: " + totalWorkingDays + 
								" & Total Working Hours: " + totalWorkingHours);
		}
		
		int totalEmpWage = totalWorkingHours * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Wage: " + totalEmpWage);
		
		return totalEmpWage;
	}
	
	public static void main(String[] args) {
		computeEmpWage();
	}
}