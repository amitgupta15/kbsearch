package com.ats.kbsearch;

import com.ats.kbsearch.domains.Topic;
import com.ats.kbsearch.repositories.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class KbsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbsearchApplication.class, args);
	}

	@Bean
	CommandLineRunner init(TopicRepository topicRepository) {
		return(topics) -> Arrays.asList(
				new Topic("How do I locate information on financing?", new ArrayList<>(Arrays.asList("money"))),
				new Topic("How do I retrieve an online document sent to me by the company?"),
				new Topic("How do I register for bill payment?"),
				new Topic("Where can I retrieve business account?"),
				new Topic("How can I rename an account?"),
				new Topic("What is the mailing address?")
		).forEach( topic -> topicRepository.save(topic));
	}
}

