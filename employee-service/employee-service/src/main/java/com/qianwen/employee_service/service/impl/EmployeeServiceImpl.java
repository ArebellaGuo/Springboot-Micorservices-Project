package com.qianwen.employee_service.service.impl;


import com.qianwen.employee_service.dto.APIResponseDto;
import com.qianwen.employee_service.dto.DepartmentDto;
import com.qianwen.employee_service.dto.EmployeeDto;
import com.qianwen.employee_service.dto.OrganizationDto;
import com.qianwen.employee_service.entity.Employee;
import com.qianwen.employee_service.mapper.EmployeeMapper;
import com.qianwen.employee_service.repository.EmployeeRepository;
import com.qianwen.employee_service.service.APIClient;
import com.qianwen.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //@Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;

    private static final Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        logger.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/"+ employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class) //return type
                .block();

        //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception e) {
        logger.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        //create a default department
        DepartmentDto departmentDto = new DepartmentDto(404L,"Default department","Default department","123");

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
