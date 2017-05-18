package com.ats.kbsearch.services;
/**
 * Created by amit on 5/10/17.
 */

import com.ats.kbsearch.data.*;
import com.ats.kbsearch.decorators.*;
import com.ats.kbsearch.domains.Topic;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class SearchServiceTests {


    SearchService searchService;


    private List<TokenDecorator> tokenDecorators;

    private static final Set<Topic> ALL_TOPICS = new HashSet<>(Arrays.asList(
            new Topic("Can I pay my bill online?"),
            new Topic("How can I get help paying my bill?"),
            new Topic("How can I contact socalgas?"),
            new Topic("MyAccount home page", new HashSet<>(Arrays.asList("pay")))
    ));

    @Before
    public void setUp() {
        searchService = new SearchService(new TokenService());

        tokenDecorators = new ArrayList<>(Arrays.asList(
                new RemoveIgnoreWordsDecorator(new MockData()),
                new SpellCheckDecorator(new MockData()),
                new ContextMapDecorator(new MockData())
        ));


    }

    @Test
    public void searchTest() {

        String input = "How do I pey my bull online?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?"),
                new Topic("MyAccount home page", new HashSet<>(Arrays.asList("pay")))
        ));

        Set<Topic> searchResult = searchService.search(input, ALL_TOPICS ,tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);

    }

    @Test
    public void searchContextTest() {
        String input = "What is the address?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("How can I contact socalgas?")
        ));

        Set<Topic> searchResult = searchService.search(input, ALL_TOPICS, tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }

    @Test
    public void complexKeywordMatchTest() {
        Set<Topic> allTopics = new HashSet<>(Arrays.asList(
                new Topic("I need help paying my bill")
        ));

        String token = "paying my bill";

        Set<Topic> searchResult = searchService.searchTopicsForToken(allTopics, token);
        assertThat(searchResult).isEqualTo(allTopics);
    }

    @Test
    public void complexKeywordNotMatchTest() {
        Set<Topic> allTopics = new HashSet<>(Arrays.asList(
                new Topic("I need help paying my bill")
        ));

        String token = "paying your bill";

        Set<Topic> searchResult = searchService.searchTopicsForToken(allTopics, token);
        assertThat(searchResult.size()).isEqualTo(0);
    }

    @Test
    public void topicKeywordMatchTest() {
        Set<Topic> allTopics = new HashSet<>(Arrays.asList(
                new Topic("MyAccount home page", new HashSet<>(Arrays.asList("pay")))
        ));

        String token = "pay";

        Set<Topic> searchResult = searchService.searchTopicKeywordForToken(allTopics, token);
        assertThat(searchResult).isEqualTo(allTopics);
    }
}
