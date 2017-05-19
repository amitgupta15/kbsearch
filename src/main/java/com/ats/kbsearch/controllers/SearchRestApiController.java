package com.ats.kbsearch.controllers;

import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by amit on 5/19/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SearchRestApiController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search/{searchPhrase}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Topic> search(@PathVariable String searchPhrase) {
        return searchService.search(searchPhrase);
    }
}
