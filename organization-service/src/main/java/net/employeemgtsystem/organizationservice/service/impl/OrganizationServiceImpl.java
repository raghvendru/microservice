package net.employeemgtsystem.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.employeemgtsystem.organizationservice.dto.OrganizationDto;
import net.employeemgtsystem.organizationservice.entity.Organization;
import net.employeemgtsystem.organizationservice.mapper.OrganizationMapper;
import net.employeemgtsystem.organizationservice.repository.OrganizationRepository;
import net.employeemgtsystem.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
    //cov dto to jpa
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

       Organization savedOrganization = organizationRepository.save(organization);

       return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return  OrganizationMapper.mapToOrganizationDto(organization);
    }
}