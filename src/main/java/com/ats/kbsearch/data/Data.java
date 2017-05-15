package com.ats.kbsearch.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */
public class Data {
    private static final Set<String> DICTIONARY = new HashSet<>(Arrays.asList("pay","bill","online"));
    private static final Set<String> IGNORE_WORDS =  new HashSet<>(Arrays.asList("how","do","my","i"));

    public static Set<String> getDictionary() {
        return DICTIONARY;
    }

    public static Set<String> getIgnoreWords() { return IGNORE_WORDS; }
}
