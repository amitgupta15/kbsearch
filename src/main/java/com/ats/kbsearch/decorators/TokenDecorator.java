package com.ats.kbsearch.decorators;

import com.ats.kbsearch.data.Data;

import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */
public abstract class TokenDecorator {

    private Data data;

    public TokenDecorator(Data data) {
        this.data = data;
    }

    public abstract Set<String> updateTokens(Set<String> tokens);

    public Data getData() {
        return data;
    }
}
