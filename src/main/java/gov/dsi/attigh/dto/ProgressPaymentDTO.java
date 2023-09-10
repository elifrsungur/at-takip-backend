package gov.dsi.attigh.dto;

import gov.dsi.attigh.enums.WorkGroupEnum;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class ProgressPaymentDTO {

    private Long id;

    private Long proje;

    private Long contractor;

    private LocalDate tarih;

    private Integer tarihYil;

    private String hakedisNo;

    private Double sfYapilanHarcama;

    private Double ff;

    private Double kdv;

    private Double toplamOdeme;

    private Double sfKalan;

    private Double nakdiGerceklesme;

    private Double sozlesme;

    private WorkGroupEnum workGroupEnum;

}
