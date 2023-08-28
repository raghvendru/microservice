package net.employeemgtsystem.employeeservice.repository;

import net.employeemgtsystem.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
