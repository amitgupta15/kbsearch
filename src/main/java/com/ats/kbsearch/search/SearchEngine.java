package com.ats.kbsearch.search;

import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Set<Topic> search(String searchPhrase, List<Topic> allTopics, List<TokenDecorator> tokenDecorators) {

        Set<String> tokens = tokenService.extractAndDecorateTokensFromString(searchPhrase, tokenDecorators);

        List<Topic> topicsWithKeywords = allTopics.stream().filter(topic -> topic.getKeywords().size() > 0).collect(Collectors.toList());
        Set<Topic> searchResult = new HashSet<>();
        for(String token: tokens) {
            if(topicsWithKeywords.size() > 0) {
                searchResult.addAll(searchTopicKeywordForToken(topicsWithKeywords, token));
            }
            searchResult.addAll(searchTopicsForToken(allTopics, token));
        }
        return searchResult;
    }

    List<Topic> searchTopicsForToken(List<Topic> allTopics, String token) {
        List<Topic> result = new ArrayList<>();
        for(Topic topic: allTopics) {
            if(topic.getName().contains(token)) {
                result.add(topic);
                topic.getMatchedTokens().add(token);
            }
        }
        return result;
                //allTopics.stream().filter(topic -> topic.getName().contains(token)).collect(Collectors.toList());
    }

    List<Topic> searchTopicKeywordForToken(List<Topic> topicsWithKeywords, String token) {
        List<Topic> result = new ArrayList<>();
        for(Topic topic: topicsWithKeywords) {
            if(topic.getKeywords().contains(token)) {
                result.add(topic);
                topic.getMatchedTokens().add(token);
            }
        }
        return result;
        //return topicsWithKeywords.stream().filter(topicWithKeyword -> topicWithKeyword.getKeywords().contains(token)).collect(Collectors.toList());
    }
}
