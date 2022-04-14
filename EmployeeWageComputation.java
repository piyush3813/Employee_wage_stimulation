package com.bridgelabz;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class EmployeeWageComputation {
    static Logger logger = Logger.getLogger(EmployeeWageComputation.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        logger.info("Welcome To Employee Wage Computation ");
        calculatewage();
    }

    public static void calculatewage(){
        final int FULL_TIME = 2;
        final int PART_TIME = 1;
        final int WAGE_PER_HRS = 20;
        final int MAX_WORKING_HRS = 100;
        final int MAX_WORKING_DAYS = 20;
        int total_wage=0;

        int working_hrs = 0;

        for (int day = 1, total_working_hrs = 0; day < MAX_WORKING_DAYS && total_working_hrs < MAX_WORKING_HRS; day++,total_working_hrs+=working_hrs) {

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
            logger.info("day | working_hrs  | wage | total_working_hrs ");
            logger.info(day+"       "+ working_hrs+"           "+ wage+"         "+ (total_working_hrs+working_hrs));
            total_wage+=wage;

        }
        logger.info("total wage = "+total_wage);
    }

}










