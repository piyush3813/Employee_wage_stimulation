package com.bridgelabz;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.util.Properties;
public class EmployeeWageComputation {
    static Logger logger = Logger.getLogger(EmployeeWageComputation.class);

    /**
    */ class constants

    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;
    /**
    instance constants
    */
    String COMPANY_NAME;
    int WAGE_PER_HR;
    int MAX_WORKING_DAYS;
    int MAX_WORKING_HRS;
    /**
    instance variable
     */
    int totalWage;

    EmployeeWageComputation(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalWage = 0;
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

     void calculatewage() {
        logger.info("Computation of total wage of " + COMPANY_NAME + " employee");

        logger.info( "           "+"Day"+"            "+ "Workinghrs"+"      "+ "Wage"+"          "+"Total working hrs");
        int workingHrs;
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHrs <= MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * WAGE_PER_HR;
            totalWage += wage;
            logger.info( "              "+day+"             "+ workingHrs+"             "+ wage+"               "+ totalWorkingHrs + workingHrs);
        }


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

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome To Employee Wage Computation ");
/**
 * creating new object for parametrized constructor .
 */

        EmployeeWageComputation google = new EmployeeWageComputation("Google", 8, 20, 100);
        EmployeeWageComputation microsoft = new EmployeeWageComputation("Microsoft", 4, 30, 150);

        google.calculatewage();
        System.out.println(google);

        microsoft.calculatewage();
        System.out.println(microsoft);


    }

}










