package com.qianwen.organizationservice.service;

import com.qianwen.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto findOrganizationByCode(String organizationCode);

    String deleteById(Long id);
}
