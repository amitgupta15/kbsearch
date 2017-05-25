package com.ats.kbsearch.services;

import com.ats.kbsearch.data.MockData;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.search.SearchEngine;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by amit on 5/19/17.
 */
public class SearchServiceTests {

    private SearchService searchService;

    @Before
    public void setUp() {
        searchService = new SearchService(new SearchEngine(new TokenService()), new MockData());
    }

    @Test
    public void searchTest() {
        String searchPhrase = "bill";

        Set<Topic> searchResult = (Set<Topic>) searchService.search(searchPhrase);
        System.out.println(searchResult);
    }
}
