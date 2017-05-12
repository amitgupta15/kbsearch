package com.ats.kbsearch.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amit on 5/12/17.
 */
public class RemoveIgnoreWords {

    private static final Set<String> IGNORE_WORDS =  new HashSet<>(Arrays.asList("how","do","my","i"));

    public static Set<String> execute(Set<String> tokens) {
        Set<String> relevantTokens = tokens.stream().filter(token -> !IGNORE_WORDS.contains(token)).collect(Collectors.toSet());
        return relevantTokens;
    }
}
