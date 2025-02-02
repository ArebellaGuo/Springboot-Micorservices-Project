package com.qianwen.organizationservice.service.impl;

import com.qianwen.organizationservice.dto.OrganizationDto;
import com.qianwen.organizationservice.entity.Organization;
import com.qianwen.organizationservice.mapper.OrganizationMapper;
import com.qianwen.organizationservice.repository.OrganizationRepository;
import com.qianwen.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);
        return savedOrganizationDto;
    }

    @Override
    public OrganizationDto findOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }

    @Override
    public String deleteById(Long id) {
        organizationRepository.deleteById(id);
        return "Deleted successfully!";
    }
}
