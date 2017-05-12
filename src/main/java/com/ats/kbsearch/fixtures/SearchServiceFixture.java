package com.ats.kbsearch.fixtures;

import com.ats.kbsearch.SearchService;

import java.util.Set;

/**
 * Created by amit on 5/11/17.
 */
public class SearchServiceFixture {
    private String searchTerm;

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Set<String> tokens() {
        SearchService service = new SearchService();

        return service.tokenizeString(searchTerm);
    }
}
