package com.ats.kbsearch.data;

import com.ats.kbsearch.domains.Topic;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by amit on 5/15/17.
 */

@Service
public class MockData implements Data {
    private static final Set<String> DICTIONARY = new HashSet<>(Arrays.asList("pay","bill","online"));
    private static final Set<String> IGNORE_WORDS =  new HashSet<>(Arrays.asList("how","do","my","i","what","where","was","is"));
    private static final Set<Set> CONTEXT_MAP = new HashSet<>(Arrays.asList(
            new HashSet<>(Arrays.asList("contact","mail","address","fax","facebook","twitter","phone")),
            new HashSet<>(Arrays.asList("assistance","gaf","liheap","low income"))
    ));


    @Override
    public Set<String> getDictionary() {
        return DICTIONARY;
    }

    @Override
    public Set<String> getIgnoreWords() { return IGNORE_WORDS; }

    @Override
    public Set<Set> getContextMap() {
        return CONTEXT_MAP;
    }

    @Override
    public List<Topic> getAllTopics() {
        return new ArrayList<>(Arrays.asList(
                new Topic("I need help paying my bill")
        ));
    }
}
