package gov.dsi.attigh.dto;

import gov.dsi.attigh.enums.WorkGroupEnum;
import gov.dsi.attigh.model.Contractor;
import gov.dsi.attigh.model.Project;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ExplorationDTO {

    private Long id;

    private Project project;

    private Contractor contractor;

    private LocalDate explorationDate;

    private WorkGroupEnum workGroupEnum;

    private Double explorationPrice;
}
