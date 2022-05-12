package wf.hackathon.diversitydimension.elastic.service;

import org.elasticsearch.action.index.IndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
