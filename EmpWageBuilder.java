// Version UC14

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private ArrayList<CompanyEmpWage> companyEmpWageList;
	private Map<String, CompanyEmpWage> companyEmpWageMap;

	public EmpWageBuilder() {
		companyEmpWageList = new ArrayList<>();
		companyEmpWageMap = new HashMap<>();
	}

	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);

		companyEmpWageList.add(companyEmpWage);
		companyEmpWageMap.put(company, companyEmpWage);
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
		for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	@Override
	public int getTotalWage(String company) {
		return companyEmpWageMap.get(company).totalEmpWage;
	}

	public static void main(String[] args) {
		EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addCompanyEmpWage("Dexon", 50, 22, 100);
		empWageBuilder.addCompanyEmpWage("BlackCap", 150, 18, 110);
		empWageBuilder.computeEmpWage();

		// query to get total wage of company Dexon
		System.out.println("Total Wage for Dexon(using query): " 
								+ empWageBuilder.getTotalWage("Dexon"));
	}
}