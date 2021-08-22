package com.kodilla.hibernate.manytomany.facade;

public class FindEngineException extends Exception {
    public static String ERR_COMPANY_NOT_FOUND = "Companies not found";
    public static String ERR_EMPLOYEE_NOT_FOUND = "Employees not found";

    public FindEngineException(String message) {
        super(message);
    }
}
