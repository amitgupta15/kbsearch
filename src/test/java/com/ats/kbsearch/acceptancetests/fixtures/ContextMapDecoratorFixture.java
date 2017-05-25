package com.ats.kbsearch.acceptancetests.fixtures;

import com.ats.kbsearch.data.RealData;
import com.ats.kbsearch.decorators.ContextMapDecorator;
import com.ats.kbsearch.services.TokenService;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by amit on 5/22/17.
 */
public class ContextMapDecoratorFixture {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> contextKeywords() {
        TokenService tokenService = new TokenService();
        return tokenService.extractAndDecorateTokensFromString(token, Arrays.asList(new ContextMapDecorator(new RealData())));
    }
}
