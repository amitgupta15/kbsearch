package com.ats.kbsearch.decorators;

import com.ats.kbsearch.data.MockData;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amit on 5/15/17.
 */
public class DecoratorTests {

    @Test
    public void removeIgnoreWordsTest() {
        Set<String> input = new HashSet<>(Arrays.asList("bill","how","pay","do","my","i","online"));
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("bill","pay","online"));

        TokenDecorator removeIgnoreWordsDecorator = new RemoveIgnoreWordsDecorator(new MockData());

        Set<String> tokens = removeIgnoreWordsDecorator.updateTokens(input);

        assertThat(tokens).isEqualTo(expectedTokens);
    }

    @Test
    public void spellCheckTest() {
        Set<String> input = new HashSet<>(Arrays.asList("pey","bull","online"));
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("pey","pay","bill","online", "bull"));

        TokenDecorator spellCheckDecorator = new SpellCheckDecorator(new MockData());

        Set<String> tokens = spellCheckDecorator.updateTokens(input);

        assertThat(tokens).isEqualTo(expectedTokens);
    }

    @Test
    public void findContextKeywordsTest() {
        Set<String> input = new HashSet<>(Arrays.asList("contact","socalgas"));
        Set<String> expectedTokens = new HashSet<>(Arrays.asList("contact","socalgas","mail","phone","address","fax","facebook","twitter"));

        TokenDecorator contextMapDecorator = new ContextMapDecorator(new MockData());

        Set<String> tokens = contextMapDecorator.updateTokens(input);

        assertThat(tokens).isEqualTo(expectedTokens);
    }

}
