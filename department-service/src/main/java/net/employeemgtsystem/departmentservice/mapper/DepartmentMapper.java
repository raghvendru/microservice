package net.employeemgtsystem.departmentservice.mapper;

import net.employeemgtsystem.departmentservice.dto.DepartmentDto;
import net.employeemgtsystem.departmentservice.entity.Department;
import net.employeemgtsystem.employeeservice.dto.EmployeeDto;
import net.employeemgtsystem.employeeservice.entity.Employee;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        //convert department jpa to departmentDto entity

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()

        );
        return departmentDto;
    }
    //convert department dto to department jpa entity

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
