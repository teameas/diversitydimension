package wf.hackathon.diversitydimension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wf.hackathon.diversitydimension.elastic.domain.DiversityDimension;
import wf.hackathon.diversitydimension.elastic.service.DiversityDimensionElasticService;
import wf.hackathon.diversitydimension.elastic.service.DiversityDimensionService;
import wf.hackathon.diversitydimension.model.WebLookup;
import wf.hackathon.diversitydimension.service.WebLookupService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lookup")
public class WebLookupController {

    @Autowired
    WebLookupService service;

    @Autowired
    private DiversityDimensionElasticService diversityDimensionElasticService;

    @Autowired
    private DiversityDimensionService dimensionService;

    @GetMapping
    public ResponseEntity<List<WebLookup>> getAllLookups() {
        List<WebLookup> list = service.getAllWebLookups();

        return new ResponseEntity<List<WebLookup>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebLookup> getLookupById(@PathVariable("id") Long id)
             {
                 WebLookup entity = service.getWebbLookupById(id);

        return new ResponseEntity<WebLookup>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WebLookup> createOrUpdateLoookup(WebLookup lookup) {
        //WebLookup updated = service.createOrUpdateLookup(lookup);
        DiversityDimension diversityDimension = new DiversityDimension("test.com");
        diversityDimensionElasticService.createDiversityDimension(diversityDimension);
//        dimensionService.indexDocument(diversityDimension);
//        try {
//            dimensionService.indexDocumentJson(diversityDimension);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return new ResponseEntity<WebLookup>(lookup, new HttpHeaders(), HttpStatus.OK);
    }

}
