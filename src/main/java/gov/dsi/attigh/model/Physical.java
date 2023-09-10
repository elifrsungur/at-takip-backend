package gov.dsi.attigh.model;

import gov.dsi.attigh.enums.ProcessEnum;
import gov.dsi.attigh.enums.TechnicsEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Physical {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(precision = 38)
    private Double alani;

    private Double planlananYol;
    private Double yol;
    private Double planlananStabilize;
    private Double stabilize;
    private Integer yapilanAskiSayisi;
    private String tescil;
    private LocalDate tescilTarihi;
    private Long yevmiyeNo;
    private String tescilYili;
    private Double planlananDrenaj;
    private Double drenaj;
    private Double planlananTasToplama;
    private Double tasToplama;
    private Double planlananTesviye;
    private Double tesviye;
    private Integer kadastroParselSayisi;
    private Integer yeniOlusanParselSayisi;
    private Integer isletmeSayisi;
    private Double toplulastirmaOrani;
    private Integer isletmeParselSayisiEski;
    private Integer isletmeParselSayisiYeni;
    private Double ortEskiParselYuzOlc;
    private Double ortYeniParselYuzOlc;
    private Double okpOrani;

    @Enumerated(EnumType.STRING)
    private TechnicsEnum technicsEnum;

    @Enumerated(EnumType.STRING)
    private ProcessEnum processEnum;
}
