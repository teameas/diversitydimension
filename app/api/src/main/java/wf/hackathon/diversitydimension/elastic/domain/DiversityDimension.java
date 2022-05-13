package wf.hackathon.diversitydimension.elastic.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "diversitydimension")
public class DiversityDimension {

    @Id
    private String id;

    @Field( type = FieldType.Keyword, name = "business_name")
    private String businessName;

    public DiversityDimension(String businessName) {
        this.businessName = businessName;
    }
}
