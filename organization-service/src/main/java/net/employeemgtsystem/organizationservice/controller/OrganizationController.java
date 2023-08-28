package net.employeemgtsystem.organizationservice.controller;


import lombok.AllArgsConstructor;
import net.employeemgtsystem.organizationservice.dto.OrganizationDto;
import net.employeemgtsystem.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;

    //build saved org rest api
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganozation = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganozation, HttpStatus.CREATED);
    }

    //getorg by code
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }


}