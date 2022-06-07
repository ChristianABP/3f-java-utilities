package dk.fff.loentjek.utilities;

public class UtilityCalculation {
	
   public static double calculatePartTimeSalaryPerHour(double salaryHourRate, double hoursPerWeek) {
    	double totalHours = 37.0;
    	double result = 0;
    	if (salaryHourRate > 0 && hoursPerWeek > 0 ) {
    		result = hoursPerWeek / totalHours * salaryHourRate;
	   	} else {
	   		System.err.println("Input to calculatePartTimeSalaryPerHour was less than 0");
	   	}
    	return result;
    }
   
   public static double calculateHourlySalaryFromYearSalary(double salaryPerYear) {
	   	double result = 0;
	   	if (salaryPerYear > 0) {
		   	result = salaryPerYear / 1924;
	   	} else {
	   		System.err.println("Input to calculateHourlySalaryFromYearSalary was less than 0");
	   	}
	   	return result;
  }
   
   public static double calculateMonthlySalaryFromYearSalary(double salaryPerYear) {
	   	double result = 0;
		if (salaryPerYear > 0) {
		   	result = salaryPerYear / 12;
	   	} else {
	   		System.err.println("Input to calculateMonthlySalaryFromYearSalary was less than 0");
	   	} 
	   	return result;
   }
   
   public static double calculateSalaryForEmploymentAtSchool(double salaryPerYear, double regulationPercentage) {
	   	double result = 0;
		if (salaryPerYear > 0 && regulationPercentage > 0) {
		   	result = salaryPerYear * (regulationPercentage * 100);
	   	} else {
	   		System.err.println("Input to calculateSalaryForEmploymentAtSchool was less than 0");
	   	} 
	   	return result;
  }
   
   public static double calculateSalaryWithAddedPercentage(double salaryRate, double percentage) {
	   	double result = 0;
		if (salaryRate > 0 && percentage > 0) {
		   	result = salaryRate * (percentage + 1);
	   	} else {
	   		System.err.println("Input to calculateSalaryWithAddedPercentage was less than 0");
	   	} 
	   	return result;
 }
 
   
}
