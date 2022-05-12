package wf.hackathon.diversitydimension.elastic.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import wf.hackathon.diversitydimension.elastic.domain.DiversityDimension;

public interface DiversityDimensionElasticRepository extends ElasticsearchRepository<DiversityDimension, String> {

}