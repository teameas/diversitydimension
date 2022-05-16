package wf.hackathon.diversitydimension.elastic.service;

import com.google.gson.Gson;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;
import wf.hackathon.diversitydimension.controller.dto.LookupDto;
import wf.hackathon.diversitydimension.elastic.domain.DiversityDimension;

import java.io.IOException;

@Service
public class DiversityDimensionService {

    private static final String DD_INDEX = "search-diversitydimension-api";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private RestHighLevelClient client;

    public String indexDocument
            (DiversityDimension dimension) {

        IndexQuery query = new IndexQueryBuilder()
                .withObject(dimension).build();


        return elasticsearchOperations.index(query, IndexCoordinates.of(DD_INDEX));
    }

    public void indexDocumentJson(DiversityDimension dimension) throws IOException {

        IndexRequest indexRequest = new IndexRequest(DD_INDEX);
        indexRequest.source(new Gson().toJson(dimension));
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
    }

    public String updateMinorityIndicator(LookupDto dto) {
        String id = "";
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery(DiversityDimension.BUS_NAME, dto.getDunsName());

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DiversityDimension> diversityDimensionSearchHits =
                elasticsearchOperations
                        .search(searchQuery,
                                DiversityDimension.class,
                                IndexCoordinates.of(DD_INDEX));

        if(diversityDimensionSearchHits.getTotalHits() > 0){
            DiversityDimension dimension = diversityDimensionSearchHits.getSearchHits().get(0).getContent();
            dimension.setIsMinority(dto.getIsMinority());
            dimension.setMinorityOwnedDesc(dto.getMinorityOwnedDesc());
            dimension.setOwnership(dto.getOwnership());
            id = dimension.getId();

            IndexQuery query = new IndexQueryBuilder()
                    .withObject(dimension).build();

            elasticsearchOperations.index(query, IndexCoordinates.of(DD_INDEX));
        }
        return id;
    }

    public String updateWomenIndicator(LookupDto dto) {
        String id = "";
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery(DiversityDimension.BUS_NAME, dto.getDunsName());

        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        SearchHits<DiversityDimension> diversityDimensionSearchHits =
                elasticsearchOperations
                        .search(searchQuery,
                                DiversityDimension.class,
                                IndexCoordinates.of(DD_INDEX));

        if(diversityDimensionSearchHits.getTotalHits() > 0){
            DiversityDimension dimension = diversityDimensionSearchHits.getSearchHits().get(0).getContent();
            dimension.setIsWomen(dto.getIsWomen());
            dimension.setNltkscore(dto.getNltkscore());
            dimension.setOwnership(dto.getOwnership());
            id = dimension.getId();

            IndexQuery query = new IndexQueryBuilder()
                    .withObject(dimension).build();

            elasticsearchOperations.index(query, IndexCoordinates.of(DD_INDEX));
        }
        return id;
    }
}
