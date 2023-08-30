package net.employeemgtsystem.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.employeemgtsystem.employeeservice.dto.APIResponseDto;
import net.employeemgtsystem.employeeservice.dto.EmployeeDto;
import net.employeemgtsystem.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
@CrossOrigin("*")
@Tag(
        name = "emp-controller",
        description = "emp-controller apis"
)
public class EmployeeController {

    private EmployeeService employeeService;


    @Operation(
            summary = "save emp ser",
            description = "to save emp-service"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http stat 201 created"
    )
    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @Operation(
            summary = "get emp ser",
            description = "to get emp-service"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http stat 200 created"
    )
    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }


}
