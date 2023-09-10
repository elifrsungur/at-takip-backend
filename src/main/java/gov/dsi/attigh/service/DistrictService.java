package gov.dsi.attigh.service;
import gov.dsi.attigh.model.District;
import gov.dsi.attigh.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public  DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    public List<District> getAllDistricts(){
        return districtRepository.findAll();
    }

    public List<District> getDistrictsByCityId(Long cityId) {
        return districtRepository.findByCityId(cityId);
    }

}
