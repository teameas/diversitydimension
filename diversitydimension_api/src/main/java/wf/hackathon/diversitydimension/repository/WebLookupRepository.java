package wf.hackathon.diversitydimension.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wf.hackathon.diversitydimension.model.WebLookup;

@Repository
public interface WebLookupRepository extends JpaRepository<WebLookup, Long> {
}
