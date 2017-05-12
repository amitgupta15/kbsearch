package com.ats.kbsearch;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by amit on 5/10/17.
 */
@Service
public class SearchService {

    public List<String> tokenizeSearchPhrase(String searchPhrase) {
        return Arrays.asList("hello");
    }
}
