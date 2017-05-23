package com.ats.kbsearch.fixtures;

import com.ats.kbsearch.data.RealData;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.services.TokenService;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by amit on 5/22/17.
 */
public class RemoveIgnoreWordsDecoratorFixture {

    private String searchTerm;

    private TokenService tokenService = new TokenService();

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Set<String> tokens() {

        return tokenService.extractAndDecorateTokensFromString(searchTerm, Arrays.asList(new RemoveIgnoreWordsDecorator(new RealData())));
    }
}

