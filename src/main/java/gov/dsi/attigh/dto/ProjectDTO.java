package gov.dsi.attigh.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectDTO {

    private Long id;
    private String projectName;
    private String projectCode;
    private Double contractPrice;
    private List<Long> cityIds;
    private List<Long> districtIds;
    private List<Long> villageIds;
    private List<Long> contractorIds;


}
