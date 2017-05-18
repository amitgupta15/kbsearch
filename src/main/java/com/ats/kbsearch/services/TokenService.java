package com.ats.kbsearch.services;

import com.ats.kbsearch.decorators.TokenDecorator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by amit on 5/12/17.
 */


public class TokenService {

    private static final String REGEX_TO_REMOVE_PUNCTUATIONS = "[\\p{P}\\p{S}]";

    public Set<String> extractAndDecorateTokensFromString(String string, List<TokenDecorator> tokenDecoratorList) {
        Set<String> tokens = tokenizeString(string);
        for (TokenDecorator tokenDecorator : tokenDecoratorList) {
            tokens = tokenDecorator.updateTokens(tokens);
        }
        return tokens;
    }

    public Set<String> tokenizeString(String string) {
        Set<String> tokens = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase().replaceAll(REGEX_TO_REMOVE_PUNCTUATIONS,""));
        while(stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        return tokens;
    }
}
