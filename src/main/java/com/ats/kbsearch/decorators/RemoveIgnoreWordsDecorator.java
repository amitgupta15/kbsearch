package com.ats.kbsearch.decorators;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/15/17.
 */
public class RemoveIgnoreWordsDecorator extends TokenDecorator {

    public RemoveIgnoreWordsDecorator(Set<String> dataDictionary) {
        super(dataDictionary);
    }

    @Override
    public Set<String> updateTokens(Set<String> tokens) {

        Set<String> relevantTokens = tokens.stream().filter(token -> !super.getDataDictionary().contains(token)).collect(Collectors.toSet());
        return relevantTokens;
    }
}
