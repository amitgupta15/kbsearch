package com.ats.kbsearch.repositories;

import com.ats.kbsearch.domains.Topic;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by amit on 5/25/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TopicRepositoryTests {

    @Autowired
    TopicRepository topicRepository;

    @Ignore
    @Test
    public void findATopicTest() {
        Topic topic = topicRepository.findOne(new Long(1));

        assertThat(topic).isInstanceOf(Topic.class);
    }

}
