package net.javaguides.organization_service.mapper;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.entity.Organization;
import org.antlr.v4.runtime.atn.SemanticContext;

public class OrganizationMapper {

    public static OrganizationDto mapTOOrganizationDto(Organization organization){
        OrganizationDto organizationDto=new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getOrganizationCreatedDate()
        );
        return organizationDto;
    }
    public static  Organization mapToOrganization(OrganizationDto organizationDto){
        Organization organization1=new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getOrganizationCreatedDate()


        );
        return  organization1;
    }

}
