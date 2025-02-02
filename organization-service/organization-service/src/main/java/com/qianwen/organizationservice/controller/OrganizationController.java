package com.qianwen.organizationservice.controller;

import com.qianwen.organizationservice.dto.OrganizationDto;
import com.qianwen.organizationservice.service.OrganizationService;
import com.qianwen.organizationservice.service.impl.OrganizationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Organization Service - OrganizationController",
        description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get organization object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByOrgCode(@PathVariable String organizationCode){
        OrganizationDto savedOrganizationDto = organizationService.findOrganizationByCode(organizationCode);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Organization REST API",
            description = "Delete Organization REST API is used to delete organization object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedOrganizationById(@PathVariable Long id){
        String deleted = organizationService.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
