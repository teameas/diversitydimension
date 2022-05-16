package wf.hackathon.diversitydimension.elastic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wf.hackathon.diversitydimension.controller.dto.LookupDto;
import wf.hackathon.diversitydimension.elastic.domain.DiversityDimension;
import wf.hackathon.diversitydimension.elastic.repositories.DiversityDimensionElasticRepository;

import java.util.List;

@Service
public class DiversityDimensionElasticService {

    @Autowired
    private DiversityDimensionElasticRepository diversityDimensionElasticRepository;

    public void createDiversityDimensionBulk(final List<DiversityDimension> dimensionList) {
        diversityDimensionElasticRepository.saveAll(dimensionList);
    }

    public void createDiversityDimension(final DiversityDimension diversityDimension) {
        diversityDimensionElasticRepository.save(diversityDimension);
    }

    public String createDiversityDimension(LookupDto dto) {
        DiversityDimension dd = new DiversityDimension();
        dd.setCity(dto.getCity());
        dd.setDunsName(dto.getDunsName());
        dd.setIsDisabled(dto.getIsDisabled());
        dd.setIsLgbtqiaPlus(dto.getIsLgbtqiaPlus());
        dd.setIsMinority(dto.getIsMinority());
        dd.setIsVeteran(dto.getIsVeteran());
        dd.setIsWomen(dto.getIsWomen());
        dd.setNltkscore(dto.getNltkscore());
        dd.setWebAddress(dto.getWebAddress());
        dd.setCity(dto.getCity());
        dd.setState(dto.getState());
        dd.setZip(dto.getZip());
        dd.setOwnership(dto.getOwnership());
        dd.setExecutivieContact1(dto.getExecutivieContact1());
        dd.setExecutivieContact2(dto.getExecutivieContact2());


        diversityDimensionElasticRepository.save(dd);
        return dd.getId();
    }

}
