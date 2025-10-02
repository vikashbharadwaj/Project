package net.javaguides.organization_service.service;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizatonByCode(String organizationCode);
}
