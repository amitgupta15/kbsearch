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
    private static final Set<Set> CONTEXT_MAP = new HashSet<>(Arrays.asList(
            new HashSet<>(Arrays.asList("contact","mail","address","fax","facebook","twitter","phone")),
            new HashSet<>(Arrays.asList("assistance","gaf","liheap","low income"))
    ));

    public static Set<String> getDictionary() {
        return DICTIONARY;
    }

    public static Set<String> getIgnoreWords() { return IGNORE_WORDS; }

    public static Set<Set> getContextMap() {
        return CONTEXT_MAP;
    }
}
