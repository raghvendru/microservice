package net.employeemgtsystem.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.employeemgtsystem.departmentservice.dto.DepartmentDto;
import net.employeemgtsystem.departmentservice.entity.Department;
import net.employeemgtsystem.departmentservice.mapper.DepartmentMapper;
import net.employeemgtsystem.departmentservice.repository.DepartmentRepository;
import net.employeemgtsystem.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

       //convert department dto to department jpa entity
     Department department = DepartmentMapper.mapToDepartment(departmentDto);

        //save this in db
       Department saveDepartment = departmentRepository.save(department);

        //convert department jpa to departmentDto entity

        DepartmentDto saveDepartmentDto = DepartmentMapper.mapToDepartmentDto(saveDepartment);

       return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
