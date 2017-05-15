package com.ats.kbsearch.data;

import com.ats.kbsearch.domains.Topic;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by amit on 5/15/17.
 */

@Service
public class RealData implements Data {
    @Override
    public Set<String> getDictionary() {
        return null;
    }

    @Override
    public Set<String> getIgnoreWords() {
        return null;
    }

    @Override
    public Set<Set> getContextMap() {
        return null;
    }

    @Override
    public Set<Topic> getAllTopics() {
        return null;
    }
}
