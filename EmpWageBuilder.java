// Version UC11

// Two classes and an Interface are added one after another in a single file to push into git


// Interface created
public interface IComputeEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHour, 
				       int numOfWorkingDays, int maxHoursPerMonth);

	public void computeEmpWage();
	public int getTotalWage(String company);
}

// 1st class
public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHoursPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString() {
		return "Total Emp Wage for company " + company + ": " + totalEmpWage;
	}
}


// This class contains main method

public class EmpWageBuilderArray implements IComputeEmpWage{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyWageArray;

	public EmpWageBuilderArray() {
		companyWageArray = new CompanyEmpWage[5];
	}
	
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		companyWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays,
				maxHoursPerMonth);

		numOfCompany++;
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHours = 0, totalWorkingHours = 0, totalWorkingDays = 0;

		while (totalWorkingDays++ < companyEmpWage.numOfWorkingDays
				&& totalWorkingHours < companyEmpWage.maxHoursPerMonth) {
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
			System.out
					.println("Total Working Day: " + totalWorkingDays + " & Total Working Hours: " + totalWorkingHours);
		}

		return totalWorkingHours * companyEmpWage.empRatePerHour;
	}
	
	@Override
	public void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyWageArray[i].setTotalEmpWage(this.computeEmpWage(companyWageArray[i]));
			System.out.println(companyWageArray[i]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("Dexon", 50, 22, 100);
		empWageBuilder.addCompanyEmpWage("BlackCap", 150, 18, 110);
		empWageBuilder.computeEmpWage();
	}

		@Override
	public int getTotalWage(String company) {
		// TODO Auto-generated method stub
		return 0;
	}
}