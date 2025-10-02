package net.javaguides.organization_service.service.impl;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;
import net.javaguides.organization_service.mapper.OrganizationMapper;
import net.javaguides.organization_service.repository.OrganizationRepository;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);

       Organization saved= organizationRepository.save(organization);
        return OrganizationMapper.mapTOOrganizationDto(saved);
    }

    @Override
    public OrganizationDto getOrganizatonByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapTOOrganizationDto(organization);
    }
}
