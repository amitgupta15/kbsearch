package com.ats.kbsearch.decorators;


import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/15/17.
 */
public class SpellCheckDecorator extends TokenDecorator {

    public static final double JARO_WINKLER_THRESHOLD = 0.8;

    public SpellCheckDecorator(Set<String> dataDictionary) {
        super(dataDictionary);
    }

    @Override
    public Set<String> updateTokens(Set<String> tokens) {
        Set<String> dataDictionary = super.getDataDictionary();
        Set<String> tokensNotInDictionary = tokens.stream().filter(token -> !dataDictionary.contains(token)).collect(Collectors.toSet());
        Set<String> checkedTokens = new HashSet<>();

        for (String token : tokensNotInDictionary) {
            checkedTokens.addAll(dataDictionary.stream().filter(word -> StringUtils.getJaroWinklerDistance(word, token) >= JARO_WINKLER_THRESHOLD).collect(Collectors.toSet()));
        }
        checkedTokens.addAll(tokens);
        return checkedTokens;
    }
}
