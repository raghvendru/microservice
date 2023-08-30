package net.employeemgtsystem.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.employeemgtsystem.departmentservice.dto.DepartmentDto;
import net.employeemgtsystem.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "dep-controller",
        description = "dep-controller apis"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    //inject service
    private DepartmentService departmentService;

    @Operation(
            summary = "save dep ser",
            description = "to save dep-service"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http stat 201 created"
    )
    //build save depart rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }


    @Operation(
            summary = "get dep ser",
            description = "to get dep-service"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http stat 200 created"
    )
    // Build get department rest api
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
