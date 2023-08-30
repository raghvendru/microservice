package net.employeemgtsystem.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "org dto"
)
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "org name"
    )
    private String organizationName;
    @Schema(
            description = "org desc"
    )
    private String organizationDescription;
    @Schema(
            description = "org code"
    )
    private String organizationCode;
    @Schema(
            description = "org date"
    )
    private LocalDateTime createdDate;
}
