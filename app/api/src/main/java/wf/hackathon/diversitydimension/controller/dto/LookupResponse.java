package wf.hackathon.diversitydimension.controller.dto;

public class LookupResponse {
    private String id;
    private String dnsName;

    public LookupResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDnsName() {
        return dnsName;
    }

    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }
}
