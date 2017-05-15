package com.ats.kbsearch.services;

import com.ats.kbsearch.data.Data;
import com.ats.kbsearch.decorators.ContextMapDecorator;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/10/17.
 */
@Service
public class SearchService {

    @Autowired
    private TokenService tokenService;


    private Data data;

    public Set<Topic> search(String searchPhrase, List<TokenDecorator> tokenDecorators) {

        Set<Topic> allTopics = data.getAllTopics();
        Set<String> tokens = tokenService.extractAndDecorateTokensFromString(searchPhrase, tokenDecorators);

        Set<Topic> searchResult = new HashSet<>();
        for(String token: tokens) {
            searchResult.addAll(allTopics.stream().filter(topic -> topic.getName().indexOf(token) >= 0).collect(Collectors.toSet()));
        }
        return searchResult;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
