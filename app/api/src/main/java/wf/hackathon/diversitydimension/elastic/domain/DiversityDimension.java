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

    @Field( type = FieldType.Keyword, fielddata = true, name = "business_name")
    private String dunsName;
    @Field( type = FieldType.Text, fielddata = true )
    private String webAddress;
    @Field( type = FieldType.Text, fielddata = true )
    private String city;
    @Field( type = FieldType.Text, fielddata = true )
    private String state;
    @Field( type = FieldType.Text, fielddata = true )
    private String zip;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String ownership;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String minorityOwnedDesc;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String nltkscore;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String isMinority;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String isWomen;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String isDisabled;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String isLgbtqiaPlus;
    @Field( type = FieldType.Keyword, fielddata = true )
    private String isVeteran;

    //@JsonProperty("business_name")
//    @Field( type = FieldType.Keyword, fielddata = true )
//    private String businessName;

    public DiversityDimension() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDunsName() {
        return dunsName;
    }

    public void setDunsName(String dunsName) {
        this.dunsName = dunsName;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getMinorityOwnedDesc() {
        return minorityOwnedDesc;
    }

    public void setMinorityOwnedDesc(String minorityOwnedDesc) {
        this.minorityOwnedDesc = minorityOwnedDesc;
    }

    public String getNltkscore() {
        return nltkscore;
    }

    public void setNltkscore(String nltkscore) {
        this.nltkscore = nltkscore;
    }

    public String getIsMinority() {
        return isMinority;
    }

    public void setIsMinority(String isMinority) {
        this.isMinority = isMinority;
    }

    public String getIsWomen() {
        return isWomen;
    }

    public void setIsWomen(String isWomen) {
        this.isWomen = isWomen;
    }

    public String getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(String isDisabled) {
        this.isDisabled = isDisabled;
    }

    public String getIsLgbtqiaPlus() {
        return isLgbtqiaPlus;
    }

    public void setIsLgbtqiaPlus(String isLgbtqiaPlus) {
        this.isLgbtqiaPlus = isLgbtqiaPlus;
    }

    public String getIsVeteran() {
        return isVeteran;
    }

    public void setIsVeteran(String isVeteran) {
        this.isVeteran = isVeteran;
    }
}
