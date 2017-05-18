package com.ats.kbsearch.data;

import com.ats.kbsearch.domains.Topic;

import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */
public interface Data {

    Set<String> getDictionary();
    Set<String> getIgnoreWords();
    Set<Set> getContextMap();
}
