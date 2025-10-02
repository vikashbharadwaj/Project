package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationApiClient {

    @GetMapping("/api/organization/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);
}
