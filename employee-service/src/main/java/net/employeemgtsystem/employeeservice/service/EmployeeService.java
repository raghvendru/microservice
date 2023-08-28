package net.employeemgtsystem.employeeservice.service;
import net.employeemgtsystem.employeeservice.dto.APIResponseDto;
import net.employeemgtsystem.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);


}
