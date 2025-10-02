package net.javaguides.organization_service.contoller;

import net.javaguides.organization_service.dto.OrganizationDto;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {


    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @PostMapping
    public ResponseEntity<OrganizationDto>saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto organizationDto1=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(organizationDto1, HttpStatus.CREATED);
    }
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto>getOrganisation(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto=organizationService.getOrganizatonByCode(organizationCode);
        return  new ResponseEntity<>(organizationDto,HttpStatus.OK);

    }



}
