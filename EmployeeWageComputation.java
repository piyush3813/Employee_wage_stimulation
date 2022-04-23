package com.bridgelabz;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;

interface IntEmployeeWageComputation{
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);

    public void calculateWage();

}
class CompanyEmpWage{
    Logger logger = Logger.getLogger(CompanyEmpWage.class);
    /**
     instance constants
     */
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
    /**
     instance variable
     */
    int totalWage;

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalWage = 0;
    }
    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalWage = totalEmpWage;
    }

    public String toString()
    {
        logger.info("Details of " + COMPANY_NAME + " employee");
        logger.info("-----------------------------------------------------");
        logger.info("Wage per hour:" + WAGE_PER_HR);
        logger.info("Maximum working days:" + MAX_WORKING_DAYS);
        logger.info("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalWage + "\n";
    }

}


 class EmployeeWageComputation implements IntEmployeeWageComputation
 {
    static Logger logger = Logger.getLogger(EmployeeWageComputation.class);

    /**
     * class constants
    */

    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    ArrayList<CompanyEmpWage> companies;


    public EmployeeWageComputation() {

        companies = new ArrayList<>();

    }

    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
    }

    int generateEmployeeType() {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType)
    {
        switch (empType)
        {
            case FULL_TIME:
                return 8;
            case PART_TIME:
                return 4;
            default:
                return 0;
        }
    }

    public void calculateWage()
    {
        for (CompanyEmpWage company : companies)
        {   int totalWage = calculateWage(company);
            company.setTotalEmployeeWage(totalWage);
            logger.info(company);
        }
    }

     int calculateWage(CompanyEmpWage companyEmpWage) {
        logger.info("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");

        logger.info( "           "+"Day"+"            "+ "Workinghrs"+"      "+ "Wage"+"          "+"Total working hrs");
        int workingHrs , totalwage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            companyEmpWage.totalWage += wage;
            logger.info( "              "+day+"             "+ workingHrs+"             "+ wage+"               "+ totalWorkingHrs + workingHrs);
        }

        return totalwage;

    }



    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome To Employee Wage Computation ");
/**
 * creating new object for parametrized constructor .
 */

        EmployeeWageComputation employeeWageComputation = new EmployeeWageComputation();
        employeeWageComputation.addCompany("Microsoft", 4, 30, 100);
        employeeWageComputation.addCompany("Google", 5, 40, 170);
        employeeWageComputation.addCompany("Apple", 9, 10, 70);

        employeeWageComputation.calculateWage();



    }

}










