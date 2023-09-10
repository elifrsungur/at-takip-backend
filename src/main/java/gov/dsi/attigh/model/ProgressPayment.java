package gov.dsi.attigh.model;


import gov.dsi.attigh.enums.WorkGroupEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PARASAL_GERCEKLESME")
public class ProgressPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Contractor contractor;

    private LocalDate progressPaymentDate;

    private String progressPaymentNo;

    @Column(precision = 10)
    private Double sf;

    @Column(precision = 10)
    private Double ff;

    @Column(precision = 10)
    private Double kdv;

    @Column(precision = 10)
    private Double totalPayment;

    @Column(precision = 10)
    private Double sfKalan;

    @Column(precision = 10)
    private Double nakdiGerceklesme;


    @Enumerated(EnumType.STRING)
    private WorkGroupEnum workGroupEnum;

}
