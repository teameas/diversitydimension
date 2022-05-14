package wf.hackathon.diversitydimension.elastic.service;

import com.google.gson.Gson;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;
import wf.hackathon.diversitydimension.elastic.domain.DiversityDimension;

import java.io.IOException;

@Service
public class DiversityDimensionService {

    private static final String DD_INDEX = "diversitydimension";

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
}
