package com.ats.kbsearch;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by amit on 5/10/17.
 */
@Service
public class SearchService {

    public Set<String> tokenizeString(String string) {
        Set<String> tokens = new HashSet<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase().replaceAll("[\\p{P}\\p{S}]",""));
        while(stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        return tokens;
    }
}
