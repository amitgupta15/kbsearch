package com.ats.kbsearch.services;

import com.ats.kbsearch.data.Data;
import com.ats.kbsearch.data.MockData;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.decorators.TokenDecorator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 5/12/17.
 */

public class TokenServiceTests {

    TokenService tokenService;
    Data data;

    @Before
    public void setUp() {

        tokenService = new TokenService();
        data = new MockData();
    }
    @Test
    public void tokenizeSearchPhraseTest() {
        String searchPhrase = "How do I pay my bill online online?";
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("bill","how","pay","do","my","i","online"));
        Set<String> tokens = tokenService.tokenizeString(searchPhrase);

        assertThat(tokens).isEqualTo(expectedTokens);

    }

    @Test
    public void extractTokensWithDecoratorsTest() {
        String searchPhrase = "How do do I pey my bull online online?";
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("pay","pey","bull","bill","online"));

        TokenDecorator removeIgnoreWordsDecorator = new RemoveIgnoreWordsDecorator(data);
        TokenDecorator spellCheckDecorator = new SpellCheckDecorator(data);

        Set<String> tokens = tokenService.extractAndDecorateTokensFromString(searchPhrase, new ArrayList<>(Arrays.asList(removeIgnoreWordsDecorator, spellCheckDecorator)));

        assertThat(tokens).isEqualTo(expectedTokens);
    }

}
