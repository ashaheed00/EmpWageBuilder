// Version UC1

public class EmpWageBuilder {

	static final short IS_FULL_TIME = 1;
	static short empCheck;

	public static void main(String[] args) {

		empCheck = (short) (Math.random() * 10 % 2);
		System.out.println("Employee is " + (empCheck == 1 ? "Present" : "Absent"));

	}
}