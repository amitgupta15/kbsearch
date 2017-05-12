package com.ats.kbsearch.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
    public void removeIgnoreWordsTest() {
        Set<String> input = new HashSet<>(Arrays.asList("bill","how","pay","do","my","i","online"));
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("bill","pay","online"));
        Set<String> tokens = tokenService.removeIgnoreWords(input);

        assertThat(tokens).isEqualTo(expectedTokens);
    }

}
