package wf.hackathon.diversitydimension.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="WEB_LOOKUP")
public class WebLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="web_address")
    private String webAddress;

    @Column(name="search_keyword")
    private String searchKeyword;

    @Column(name="status")
    private String status;

    @Column(name="minority_owned")
    private String minorityOwned;

    @Column(name="last_scan_date")
    private LocalDateTime lastScanDate;

    public WebLookup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastScanDate() {
        return lastScanDate;
    }

    public void setLastScanDate(LocalDateTime lastScanDate) {
        this.lastScanDate = lastScanDate;
    }

    public String getMinorityOwned() {
        return minorityOwned;
    }

    public void setMinorityOwned(String minorityOwned) {
        this.minorityOwned = minorityOwned;
    }
}
