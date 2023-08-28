package net.employeemgtsystem.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.employeemgtsystem.employeeservice.dto.APIResponseDto;
import net.employeemgtsystem.employeeservice.dto.DepartmentDto;
import net.employeemgtsystem.employeeservice.dto.EmployeeDto;
import net.employeemgtsystem.employeeservice.dto.OrganizationDto;
import net.employeemgtsystem.employeeservice.entity.Employee;
import net.employeemgtsystem.employeeservice.mapper.EmployeeMapper;
import net.employeemgtsystem.employeeservice.repository.EmployeeRepository;
import net.employeemgtsystem.employeeservice.service.APIClient;
import net.employeemgtsystem.employeeservice.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;

   private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
       Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);

       EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return savedEmployeeDto;
    }

    @Retry(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
  //  @CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee =employeeRepository.findById(employeeId).get();
        LOGGER.info("inside getEmpById");

        //rest template communication
//       ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//
//       DepartmentDto departmentDto = responseEntity.getBody();

        //webclient comm
       DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class).block();

        //openfeign
     //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/orgainizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class).block();

       EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception) {

        LOGGER.info("inside getDefaultDepartment");

        Employee employee =employeeRepository.findById(employeeId).get();

       DepartmentDto departmentDto = new DepartmentDto();
       departmentDto.setDepartmentName("R&D dep");
       departmentDto.setDepartmentCode("rd001");
       departmentDto.setDepartmentDescription("reseach and development");

        EmployeeDto employeeDto=EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    }
