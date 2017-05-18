package com.ats.kbsearch.services;

import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/10/17.
 */

public class SearchService {

    private TokenService tokenService;

    public SearchService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public Set<Topic> search(String searchPhrase, Set<Topic> allTopics, List<TokenDecorator> tokenDecorators) {

        Set<String> tokens = tokenService.extractAndDecorateTokensFromString(searchPhrase, tokenDecorators);

        Set<Topic> searchResult = new HashSet<>();
        for(String token: tokens) {
            searchResult.addAll(searchTopicsForToken(allTopics, token));
        }
        return searchResult;
    }

    Set<Topic> searchTopicsForToken(Set<Topic> allTopics, String token) {
        return allTopics.stream().filter(topic -> topic.getName().indexOf(token) >= 0).collect(Collectors.toSet());
    }

    Set<Topic> searchTopicKeywordForToken(Set<Topic> allTopics, String token) {
        return null;
    }

}
