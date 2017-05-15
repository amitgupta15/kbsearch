package com.ats.kbsearch.services;

import com.ats.kbsearch.data.Data;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.decorators.TokenDecorator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 5/12/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceTests {

    @Autowired
    TokenService tokenService;

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

        TokenDecorator removeIgnoreWordsDecorator = new RemoveIgnoreWordsDecorator(Data.getIgnoreWords());
        TokenDecorator spellCheckDecorator = new SpellCheckDecorator(Data.getDictionary());

        Set<String> tokens = tokenService.extractTokensFromString(searchPhrase, new ArrayList<>(Arrays.asList(removeIgnoreWordsDecorator, spellCheckDecorator)));

        assertThat(tokens).isEqualTo(expectedTokens);
    }

}
