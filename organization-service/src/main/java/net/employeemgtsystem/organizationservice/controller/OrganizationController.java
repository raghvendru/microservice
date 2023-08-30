package net.employeemgtsystem.organizationservice.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.employeemgtsystem.organizationservice.dto.OrganizationDto;
import net.employeemgtsystem.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "org-controller",
        description = "org-controller apis"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;


    @Operation(
            summary = "save org ser",
            description = "to save org-service"
    )
    @ApiResponse(
            responseCode = "201",
            description = "http stat 201 created"
    )
    //build saved org rest api
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganozation = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganozation, HttpStatus.CREATED);
    }


    @Operation(
            summary = "get org ser",
            description = "to get org-service"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http stat 200 created"
    )
    //getorg by code
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }


}