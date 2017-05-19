package com.ats.kbsearch.services;

import com.ats.kbsearch.data.Data;
import com.ats.kbsearch.decorators.ContextMapDecorator;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.search.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by amit on 5/19/17.
 */

@Service
public class SearchService {

    @Autowired
    private SearchEngine searchEngine;

    @Autowired
    private Data data;


    public Collection<Topic> search(String searchPhrase) {
        return searchEngine.search(searchPhrase, data.getAllTopics(), getTokenDecorators());
    }

    private ArrayList<TokenDecorator> getTokenDecorators() {
        return new ArrayList<>(Arrays.asList(
                    new RemoveIgnoreWordsDecorator(data),
                    new SpellCheckDecorator(data),
                    new ContextMapDecorator(data)
            ));
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setSearchEngine(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }


}
