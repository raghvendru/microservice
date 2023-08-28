package net.employeemgtsystem.organizationservice.repository;

import net.employeemgtsystem.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long >{

    Organization findByOrganizationCode(String organizationCode);
}
