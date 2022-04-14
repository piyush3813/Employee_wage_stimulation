package com.bridgelabz;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class EmployeeWageComputation {
    static Logger logger = Logger.getLogger(EmployeeWageComputation.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome To Employee Wage Computation ");

        final int FULL_TIME = 2;
        final int PART_TIME = 1;
        final int WAGE_PER_HRS = 20;
        int working_hrs = 0;
        int emp_typ = (int) ((Math.random() * 100) % 3);

        switch (emp_typ) {

            case (FULL_TIME):
                logger.info("the employee is Present full time ");
                working_hrs = 8;
                break;

            case (PART_TIME):
                logger.info("the employee is Present Part time ");
                working_hrs = 4;
                break;

            default:
                logger.info("the employee is absent full time ");
        }
        int wage = working_hrs * WAGE_PER_HRS;
        logger.info("employee wage per day is - " + wage);
    }
}