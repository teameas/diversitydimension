package wf.hackathon.diversitydimension.elastic.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "diversitydimension")
public class DiversityDimension {

    @Id
    private String id;

    @JsonProperty("business_name")
    //@Field( type = FieldType.Keyword, fielddata = true )
    private String businessName;

    public DiversityDimension() {
    }

    public DiversityDimension(String id, String businessName) {
        this.id = id;
        this.businessName = businessName;
    }

    public DiversityDimension(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
