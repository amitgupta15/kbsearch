package com.ats.kbsearch.decorators;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/15/17.
 */
public class ContextMapDecorator extends TokenDecorator {

    public ContextMapDecorator(Set<?> dataDictionary) {
        super(dataDictionary);
    }

    @Override
    public Set<String> updateTokens(Set<String> tokens) {
        Set<Set> dataDictionary = (Set<Set>) super.getDataDictionary();

        Set<String> tokensWithContext = new HashSet<>();

        for(Set<String> contextMap : dataDictionary) {
            if(contextMap.stream().anyMatch(word -> tokens.contains(word))) {
                tokensWithContext.addAll(contextMap);
            }
        }
        tokensWithContext.addAll(tokens);
        return tokensWithContext;
    }
}
