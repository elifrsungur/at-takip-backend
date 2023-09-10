package gov.dsi.attigh.model;

import gov.dsi.attigh.enums.TypeOfApplicationEnum;
import gov.dsi.attigh.enums.TypeOfProjectEnum;
import gov.dsi.attigh.enums.TypeOfStageEnum;
import gov.dsi.attigh.enums.WorkGroupEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String projectName;

    @Column(unique = true)
    private String projectCode;

    @Column(unique = true )
    private Double contractPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_city",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private List<City> cityList;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_village",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "village_id"))
    private List<Village> villageList;

    @ManyToMany
    @JoinTable(
            name = "project_constractor",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "constractor_id"))
    private List<Contractor> contractorList;

    @OneToMany(mappedBy = "project")

    private List<DistrictArea> districtAreas;

    @Enumerated(EnumType.STRING)
    private TypeOfProjectEnum typeOfProjectEnum;

    @Enumerated(EnumType.STRING)
    private TypeOfApplicationEnum typeOfApplicationEnum;

    @Enumerated(EnumType.STRING)
    private TypeOfStageEnum typeOfStageEnum;
}
