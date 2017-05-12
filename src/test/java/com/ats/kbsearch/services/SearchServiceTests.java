package com.ats.kbsearch.services;
/**
 * Created by amit on 5/10/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTests {

    @Autowired
    SearchService searchService;

    @Test
    public void tokenizeSearchPhraseTest() {
        String searchPhrase = "How do I pay my bill online online?";
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("bill","how","pay","do","my","i","online"));
        Set<String> tokens = searchService.tokenizeString(searchPhrase);

        assertThat(tokens).isEqualTo(expectedTokens);

    }

    @Test
    public void removeIgnoreWordsTest() {
        Set<String> input = new HashSet<>(Arrays.asList("bill","how","pay","do","my","i","online"));
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("bill","pay","online"));
        Set<String> tokens = searchService.removeIgnoreWords(input);

        assertThat(tokens).isEqualTo(expectedTokens);
    }

    @Test
    public void searchTest() {
        String input = "How do I pay my bill online?";
        Set<String> allTopics = new HashSet<>(Arrays.asList("Can I pay my bill online?","How can I get help paying my bill?","How can I contact socalgas?"));
        Set<String> expectedOutput = new HashSet<>(Arrays.asList("Can I pay my bill online?","How can I get help paying my bill?"));

        Set<String> searchResult = searchService.search(input, allTopics);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }
}
