package gov.dsi.attigh.service;


import gov.dsi.attigh.dto.DistrictAreaDto;
import gov.dsi.attigh.exception.DistrictAreaNotFoundException;
import gov.dsi.attigh.model.DistrictArea;
import gov.dsi.attigh.repository.DistrictAreaRepository;
import gov.dsi.attigh.repository.DistrictRepository;
import gov.dsi.attigh.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictAreaService {

    private final DistrictAreaRepository districtAreaRepository;
    private final DistrictRepository districtRepository;
    private final ProjectRepository projectRepository;


    public List<DistrictArea> getAllDistrictAreas() {
        return districtAreaRepository.findAll();
    }

    public DistrictArea getDistrictAreaById(Long id){
        return districtAreaRepository.findById(id)
                .orElseThrow(() -> new DistrictAreaNotFoundException("Bulunamadı: DA" + id));
    }

    public List<DistrictArea> createDistrictArea(DistrictAreaDto districtArea){
        return this.districtAreaRepository.saveAll(districtArea.getDistricts().stream().map(district->
                DistrictArea.builder()
                        .area(district.getArea())
                        .project(this.projectRepository.findById(districtArea.getProjectId()).orElseThrow())
                        .district(this.districtRepository
                                .findById(district.getDistrictId())
                                .orElseThrow()).build()

        ).collect(Collectors.toList()));
    }



    
}
