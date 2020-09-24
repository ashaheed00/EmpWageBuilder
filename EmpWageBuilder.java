// Version UC8

public class EmpWageBuilderMultiCompany {
	
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	public static int computeEmpWage(String company, int empRatePerHour, 
									 int numOfWorkingDays, int maxHoursPerMonth) {
		
		int empHours = 0, totalWorkingHours = 0, totalWorkingDays = 0;

		while (totalWorkingDays++ < numOfWorkingDays &&
				totalWorkingHours < maxHoursPerMonth) {
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
		
		int totalEmpWage = totalWorkingHours * empRatePerHour;
		System.out.println("Total Emp Wage for company " + company + ": " + totalEmpWage);
		
		return totalEmpWage;
	}

	public static void main(String[] args) {
		computeEmpWage("Dexon", 50, 22, 100);
		System.out.println("***********************************************");
		computeEmpWage("BlackCap", 150, 18, 110);
	}
}