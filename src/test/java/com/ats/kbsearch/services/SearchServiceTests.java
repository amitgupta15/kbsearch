package com.ats.kbsearch.services;
/**
 * Created by amit on 5/10/17.
 */

import com.ats.kbsearch.data.Data;
import com.ats.kbsearch.data.MockData;
import com.ats.kbsearch.decorators.ContextMapDecorator;
import com.ats.kbsearch.decorators.RemoveIgnoreWordsDecorator;
import com.ats.kbsearch.decorators.SpellCheckDecorator;
import com.ats.kbsearch.decorators.TokenDecorator;
import com.ats.kbsearch.domains.Topic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTests {

    @Autowired
    SearchService searchService;


    private Data data = new MockData();
    private List<TokenDecorator> tokenDecorators = new ArrayList<>(Arrays.asList(
            new RemoveIgnoreWordsDecorator(data),
            new SpellCheckDecorator(data),
            new ContextMapDecorator(data)
    ));

    @Before
    public void setUp() {
        searchService.setData(data);
    }

    @Test
    public void searchTest() {

        String input = "How do I pey my bull online?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?")));

        Set<Topic> searchResult = searchService.search(input, tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }

    @Test
    public void searchContextTest() {
        String input = "What is the address?";

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("How can I contact socalgas?")
        ));

        Set<Topic> searchResult = searchService.search(input, tokenDecorators);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }
}
