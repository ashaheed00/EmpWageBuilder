// Version UC9

public class EmpWageBuilderObject {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;

	public EmpWageBuilderObject(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}

	public void computeEmpWage() {

		int empHours = 0, totalWorkingHours = 0, totalWorkingDays = 0;

		while (totalWorkingDays++ < numOfWorkingDays && totalWorkingHours < maxHoursPerMonth) {
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
		}
		System.out.println("Total Working Day: " + totalWorkingDays + " & Total Working Hours: " + totalWorkingHours);
		totalEmpWage = totalWorkingHours * empRatePerHour;
	}

	@Override
	public String toString() {
		return "Total Emp Wage for company " + company + ": " + totalEmpWage;
	}

	public static void main(String[] args) {
		EmpWageBuilderObject dexon = new EmpWageBuilderObject("Dexon", 50, 22, 100);
		EmpWageBuilderObject blackCap = new EmpWageBuilderObject("BlackCap", 150, 18, 110);
		
		dexon.computeEmpWage();
		System.out.println(dexon);
		blackCap.computeEmpWage();
		System.out.println(blackCap);
	}

}