package net.employeemgtsystem.organizationservice.service;


import net.employeemgtsystem.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
OrganizationDto saveOrganization(OrganizationDto organizationDto);
OrganizationDto getOrganizationByCode(String organizationCode);
}