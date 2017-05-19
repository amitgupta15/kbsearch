package com.ats.kbsearch.search;

import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.services.TokenService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/10/17.
 */

@Service
public class SearchEngine {

    private TokenService tokenService;

    public SearchEngine(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public Set<Topic> search(String searchPhrase, Set<Topic> allTopics, List<TokenDecorator> tokenDecorators) {

        Set<String> tokens = tokenService.extractAndDecorateTokensFromString(searchPhrase, tokenDecorators);

        Set<Topic> topicsWithKeywords = allTopics.stream().filter(topic -> topic.getKeywords().size() > 0).collect(Collectors.toSet());
        Set<Topic> searchResult = new HashSet<>();
        for(String token: tokens) {
            if(topicsWithKeywords.size() > 0) {
                searchResult.addAll(searchTopicKeywordForToken(topicsWithKeywords, token));
            }
            searchResult.addAll(searchTopicsForToken(allTopics, token));
        }
        return searchResult;
    }



    Set<Topic> searchTopicsForToken(Set<Topic> allTopics, String token) {
        return allTopics.stream().filter(topic -> topic.getName().indexOf(token) >= 0).collect(Collectors.toSet());
    }

    Set<Topic> searchTopicKeywordForToken(Set<Topic> topicsWithKeywords, String token) {
        return topicsWithKeywords.stream().filter(topicWithKeyword -> topicWithKeyword.getKeywords().contains(token)).collect(Collectors.toSet());
    }

}
