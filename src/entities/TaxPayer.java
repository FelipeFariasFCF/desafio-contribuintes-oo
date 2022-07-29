package entities;

public class TaxPayer {

	protected double salaryIncome;
	protected double servicesIncome;
	protected double capitalIncome;
	protected double healthSpending;
	protected double educationSpeding;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpeding) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpeding = educationSpeding;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpeding() {
		return educationSpeding;
	}

	public void setEducationSpeding(double educationSpeding) {
		this.educationSpeding = educationSpeding;
	}

	public double salaryTax() {
		if (salaryIncome / 12 > 5000) {
			return salaryIncome * 0.2;
		} else if (salaryIncome / 12 >= 3000 && salaryIncome / 12 <= 5000) {
			return salaryIncome * 0.1;
		} else {
			return 0;
		}
	}
	
	public double servicesTax() {
		if(servicesIncome > 0) {
			return servicesIncome * 0.15;
		} else {
			return 0;
		}
	}
	
	public double capitalTax() {
		if(capitalIncome > 0) {
			return capitalIncome * 0.2;
		} else {
			return 0;
		}
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double totalExpenses = healthSpending + educationSpeding;
		if(totalExpenses > grossTax() * 0.3) {
			return grossTax() * 0.3;
		} else {
			return totalExpenses;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
}