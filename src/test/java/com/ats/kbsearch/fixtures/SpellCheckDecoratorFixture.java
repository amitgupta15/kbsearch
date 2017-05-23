package com.ats.kbsearch.fixtures;

import com.ats.kbsearch.data.RealData;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.services.TokenService;
import org.apache.commons.lang3.StringUtils.*;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by amit on 5/22/17.
 */
public class SpellCheckDecoratorFixture {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> closeMatches() {
        TokenService tokenService = new TokenService();
        return tokenService.extractAndDecorateTokensFromString(token, Arrays.asList(new SpellCheckDecorator(new RealData())));
    }
}
