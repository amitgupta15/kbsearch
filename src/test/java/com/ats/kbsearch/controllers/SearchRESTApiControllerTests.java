package com.ats.kbsearch.controllers;

import com.ats.kbsearch.services.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;

/**
 * Created by amit on 5/19/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class SearchRESTApiControllerTests {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    SearchService searchService;

    @Test
    public void searchRESTTest() throws Exception {

        String searchPhrase = "How do I pay my bill";
        mockMvc.perform(get("/api/search/" + searchPhrase))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        verify(searchService, times(1)).search(searchPhrase);

    }

}
