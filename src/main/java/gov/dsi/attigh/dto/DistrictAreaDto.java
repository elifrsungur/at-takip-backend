package gov.dsi.attigh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistrictAreaDto {
    private Long projectId;
    private List<DistrictDTO> districts;
}
