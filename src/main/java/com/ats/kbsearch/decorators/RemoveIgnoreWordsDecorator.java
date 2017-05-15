package com.ats.kbsearch.decorators;

import com.ats.kbsearch.data.Data;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/15/17.
 */
public class RemoveIgnoreWordsDecorator extends TokenDecorator {

    public RemoveIgnoreWordsDecorator(Data data) {
        super(data);
    }

    @Override
    public Set<String> updateTokens(Set<String> tokens) {
        Set<String> dataDictionary = super.getData().getIgnoreWords();

        Set<String> relevantTokens = tokens.stream().filter(token -> !dataDictionary.contains(token)).collect(Collectors.toSet());
        return relevantTokens;
    }
}
