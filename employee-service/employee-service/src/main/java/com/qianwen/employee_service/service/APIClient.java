package com.qianwen.employee_service.service;

import com.qianwen.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * send call to department api
 */
//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
//    dynamically call available instances of department-service
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);

}
