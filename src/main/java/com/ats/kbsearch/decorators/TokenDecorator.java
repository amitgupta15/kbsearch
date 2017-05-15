package com.ats.kbsearch.decorators;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */
public abstract class TokenDecorator {

    private Set<?> dataDictionary = new HashSet<>();

    public TokenDecorator(Set<?> dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public abstract Set<String> updateTokens(Set<String> tokens);

    public Set<?> getDataDictionary() {
        return dataDictionary;
    }
}
