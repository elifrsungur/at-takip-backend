package gov.dsi.attigh.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistrictArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @Getter(AccessLevel.NONE)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    private Double area;

}
