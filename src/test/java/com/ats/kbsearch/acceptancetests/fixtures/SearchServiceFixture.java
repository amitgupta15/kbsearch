package com.ats.kbsearch.acceptancetests.fixtures;

import com.ats.kbsearch.data.MockData;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.search.SearchEngine;
import com.ats.kbsearch.services.SearchService;
import com.ats.kbsearch.services.TokenService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by amit on 5/22/17.
 */
public class SearchServiceFixture {

    private String searchPhrase;

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public Collection<String> searchResult() {
        SearchService searchService = new SearchService(new SearchEngine(new TokenService()), new MockData());

        Collection<Topic> results = searchService.search(searchPhrase);
        Collection<String> topicNameList = new ArrayList<>();
        for (Topic topic: results) {
            topicNameList.add(topic.getName());
        }
        return topicNameList;
    }
}
