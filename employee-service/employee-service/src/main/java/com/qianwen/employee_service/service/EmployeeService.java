package com.qianwen.employee_service.service;

import com.qianwen.employee_service.dto.APIResponseDto;
import com.qianwen.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
