package com.ats.kbsearch.search;
/**
 * Created by amit on 5/10/17.
 */

import com.ats.kbsearch.data.*;
import com.ats.kbsearch.decorators.*;
import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.services.TokenService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class SearchEngineTests {

    private SearchEngine searchEngine = new SearchEngine(new TokenService());
    private List<TokenDecorator> tokenDecorators = new ArrayList<>(Arrays.asList(
            new RemoveIgnoreWordsDecorator(new MockData()),
            new SpellCheckDecorator(new MockData()),
            new ContextMapDecorator(new MockData())
    ));

    private static final List<Topic> ALL_TOPICS = new ArrayList<>(Arrays.asList(
            new Topic("Can I pay my bill online?"),
            new Topic("How can I get help paying my bill?"),
            new Topic("How can I contact socalgas?"),
            new Topic("MyAccount home page", new ArrayList<>(Arrays.asList("pay")))
    ));

    @Test
    public void searchTest() {

        String input = "How do I pey my bull online?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?"),
                new Topic("MyAccount home page", new ArrayList<>(Arrays.asList("pay")))
        ));

        Set<Topic> searchResult = searchEngine.search(input, ALL_TOPICS, tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);

    }

    @Test
    public void searchContextTest() {
        String input = "What is the address?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("How can I contact socalgas?")
        ));

        Set<Topic> searchResult = searchEngine.search(input, ALL_TOPICS, tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }

    @Test
    public void searchTopicsForTokenMatchFoundTest() {
        List<Topic> allTopics = new ArrayList<>(Arrays.asList(
                new Topic("I need help paying my bill")
        ));

        String token = "paying my bill";

        List<Topic> searchResult = searchEngine.searchTopicsForToken(allTopics, token);
        assertThat(searchResult).isEqualTo(allTopics);
    }

    @Test
    public void searchTopicsForTokenMatchNotFoundFoundTest() {
        List<Topic> allTopics = new ArrayList<>(Arrays.asList(
                new Topic("I need help paying my bill")
        ));

        String token = "paying your bill";

        List<Topic> searchResult = searchEngine.searchTopicsForToken(allTopics, token);
        assertThat(searchResult.size()).isEqualTo(0);
    }

    @Test
    public void searchTopicKeywordForTokenTest() {
        List<Topic> allTopics = new ArrayList<>(Arrays.asList(
                new Topic("MyAccount home page", new ArrayList<>(Arrays.asList("pay")))
        ));

        String token = "pay";

        List<Topic> searchResult = searchEngine.searchTopicKeywordForToken(allTopics, token);
        assertThat(searchResult).isEqualTo(allTopics);
    }
}
