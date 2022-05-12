package wf.hackathon.diversitydimension.elastic.domain;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "diversitydimension")
public class DiversityDimension {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String name;

    public DiversityDimension(String name) {
        this.name = name;
    }
}
