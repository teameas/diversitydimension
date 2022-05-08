package wf.hackathon.diversitydimension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wf.hackathon.diversitydimension.model.WebLookup;
import wf.hackathon.diversitydimension.repository.WebLookupRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebLookupService {

    @Autowired
    private WebLookupRepository repository;

    public List<WebLookup> getAllWebLookups()
    {
        List<WebLookup> lookupList = repository.findAll();

        if(lookupList.size() > 0) {
            return lookupList;
        } else {
            return new ArrayList<WebLookup>();
        }
    }

    public WebLookup getWebbLookupById(Long id)
    {
        Optional<WebLookup> lookup = repository.findById(id);

        if(lookup.isPresent()) {
            return lookup.get();
        } else {
            return new WebLookup();
        }
    }

    public WebLookup createOrUpdateLookup(WebLookup entity)
    {
        Optional<WebLookup> lookup = Optional.empty();

        if(entity.getId() != null) {
            lookup = repository.findById(entity.getId());
        }
        entity.setLastScanDate(LocalDateTime.now());
        if(lookup.isPresent())
        {
            WebLookup newEntity = lookup.get();
            newEntity.setWebAddress(entity.getWebAddress());
            newEntity.setSearchKeyword(entity.getSearchKeyword());
            newEntity.setStatus(entity.getStatus());
            newEntity.setLastScanDate(entity.getLastScanDate());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deletelookupById(Long id)
    {
        Optional<WebLookup> lookup = repository.findById(id);

        if(lookup.isPresent())
        {
            repository.deleteById(id);
        }
    }
}
