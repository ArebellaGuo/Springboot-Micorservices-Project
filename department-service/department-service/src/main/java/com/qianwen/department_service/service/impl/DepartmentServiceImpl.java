package com.qianwen.department_service.service.impl;

import com.qianwen.department_service.dto.DepartmentDto;
import com.qianwen.department_service.entity.Department;
import com.qianwen.department_service.mapper.DepartmentMapper;
import com.qianwen.department_service.repository.DepartmentRepository;
import com.qianwen.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}
