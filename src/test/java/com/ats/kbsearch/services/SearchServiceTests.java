package com.ats.kbsearch.services;
/**
 * Created by amit on 5/10/17.
 */

import com.ats.kbsearch.domains.Topic;
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
    public void searchTest() {
        String input = "How do I pey my bull online?";
        Set<Topic> allTopics = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?"),
                new Topic("How can I contact socalgas?")));

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?")));

        Set<Topic> searchResult = searchService.search(input, allTopics);

        assertThat(searchResult).isEqualTo(expectedOutput);
    }

    @Test
    public void searchContextTest() {
        String input = "What is the address?";
        Set<Topic> allTopics = new HashSet<>(Arrays.asList(
                new Topic("Can I pay my bill online?"),
                new Topic("How can I get help paying my bill?"),
                new Topic("How can I contact socalgas?")));

        Set<Topic> expectedOutput = new HashSet<>(Arrays.asList(
                new Topic("How can I contact socalgas?")
        ));

        Set<Topic> searchResult = searchService.search(input, allTopics);

        assertThat(searchResult).isEqualTo(expectedOutput);


    }
}
