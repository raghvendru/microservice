package net.employeemgtsystem.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "org dto"
)
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "org fname"
    )
    private String firstName;
    @Schema(
            description = "org lname"
    )
    private String lastName;
    @Schema(
            description = "org email"
    )
    private String email;
    @Schema(
            description = "org dep code"
    )
   private String departmentCode;
    @Schema(
            description = "org org code"
    )
    private String organizationCode;
}
