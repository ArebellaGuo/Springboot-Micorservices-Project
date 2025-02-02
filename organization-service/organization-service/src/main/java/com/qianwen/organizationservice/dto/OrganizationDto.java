package com.qianwen.organizationservice.dto;

import java.sql.Date;

public class OrganizationDto {

    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;


    public OrganizationDto(Long id, String organizationName, String organizationDescription, String organizationCode) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.organizationCode = organizationCode;

    }

    public OrganizationDto() {
    }

    public OrganizationDto(String organizationName, String organizationDescription, String organizationCode) {
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.organizationCode = organizationCode;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }


}
