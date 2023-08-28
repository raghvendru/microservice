package net.employeemgtsystem.departmentservice.repository;

import net.employeemgtsystem.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //query method to get depat by depCode
    Department findByDepartmentCode(String separtmentCode);
}
