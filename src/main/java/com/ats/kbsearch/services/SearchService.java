package com.ats.kbsearch.services;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by amit on 5/10/17.
 */
@Service
public class SearchService {

    public static final String REGEX_TO_REMOVE_PUNCTUATIONS = "[\\p{P}\\p{S}]";

    public Set<String> tokenizeString(String string) {
        Set<String> tokens = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase().replaceAll(REGEX_TO_REMOVE_PUNCTUATIONS,""));
        while(stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        return tokens;
    }

    public Set<String> removeIgnoreWords(Set<String> tokens) {
        Set<String> relevantTokens = RemoveIgnoreWords.execute(tokens);
        return relevantTokens;
    }
}
