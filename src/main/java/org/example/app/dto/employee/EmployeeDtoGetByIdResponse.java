package org.example.app.dto.employee;

import jakarta.servlet.http.HttpServletResponse;
import org.example.app.entity.Employee;

public record EmployeeDtoGetByIdResponse(
        int statusCode,
        boolean success,
        String message,
       Employee employee) {

    public static final String SUCCESS_MESSAGE = "Employee with id %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Employee with id %s has not been found!";

    public static org.example.app.dto.employee.EmployeeDtoGetByIdResponse of(Long id, boolean isEmployeeFound, Employee employee) {
        if (isEmployeeFound)
            return new org.example.app.dto.employee.EmployeeDtoGetByIdResponse(
                    HttpServletResponse.SC_OK,
                    true, SUCCESS_MESSAGE.formatted(id), employee);
        else
            return new org.example.app.dto.employee.EmployeeDtoGetByIdResponse(
                    HttpServletResponse.SC_NOT_FOUND,
                    false, FAILURE_MESSAGE.formatted(id), null);
    }
}
