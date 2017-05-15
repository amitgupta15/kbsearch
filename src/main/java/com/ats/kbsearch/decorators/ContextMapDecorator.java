package com.ats.kbsearch.decorators;

import com.ats.kbsearch.data.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */
public class ContextMapDecorator extends TokenDecorator {

    public ContextMapDecorator(Data data) {
        super(data);
    }

    @Override
    public Set<String> updateTokens(Set<String> tokens) {

        Set<String> tokensWithContext = new HashSet<>();
        Set<Set> dataDictionary = super.getData().getContextMap();

        for(Set<String> contextMap : dataDictionary) {
            if(contextMap.stream().anyMatch(word -> tokens.contains(word))) {
                tokensWithContext.addAll(contextMap);
            }
        }
        tokensWithContext.addAll(tokens);
        return tokensWithContext;
    }
}
