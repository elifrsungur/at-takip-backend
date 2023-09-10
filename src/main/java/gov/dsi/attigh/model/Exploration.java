package gov.dsi.attigh.model;


import gov.dsi.attigh.enums.WorkGroupEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data

public class Exploration {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne(optional = false)
    private Project project;

    @ManyToOne
    private Contractor contractor;

    private LocalDate explorationDate;

    @Enumerated(EnumType.STRING)
    private WorkGroupEnum workGroupEnum;

    @Column(precision = 10)
    private Double explorationPrice;
}
