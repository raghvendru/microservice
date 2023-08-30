package net.employeemgtsystem.departmentservice.dto;

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
        description = "dep dto"
)
public class DepartmentDto {
    private long id;

    @Schema(
            description = "dep name"
    )
    private String departmentName;

    @Schema(
            description = "dep description"
    )
    private String departmentDescription;

    @Schema(
            description = "dep code"
    )
    private String departmentCode;
}
