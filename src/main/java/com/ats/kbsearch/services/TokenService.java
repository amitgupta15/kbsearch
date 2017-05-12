package com.ats.kbsearch.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/12/17.
 */

@Service
public class TokenService {

    private static final String REGEX_TO_REMOVE_PUNCTUATIONS = "[\\p{P}\\p{S}]";
    private static final Set<String> IGNORE_WORDS =  new HashSet<>(Arrays.asList("how","do","my","i"));

    public Set<String> extractTokensFromSearchPhrase(String searchPhrase) {
        Set<String> tokens = tokenizeString(searchPhrase);
        tokens = removeIgnoreWords(tokens);
        return tokens;
    }

    Set<String> tokenizeString(String string) {
        Set<String> tokens = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase().replaceAll(REGEX_TO_REMOVE_PUNCTUATIONS,""));
        while(stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        return tokens;
    }

    Set<String> removeIgnoreWords(Set<String> tokens) {
        Set<String> relevantTokens = tokens.stream().filter(token -> !IGNORE_WORDS.contains(token)).collect(Collectors.toSet());
        return relevantTokens;
    }


}
