package com.ats.kbsearch.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit on 5/12/17.
 */

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Set<String> keywords;

    protected Topic() {}

    public Topic(String name) {
        this.name = name;
        this.keywords = new HashSet<>();
    }

    public Topic(String name, Set<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords=" + keywords +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;

        Topic topic = (Topic) o;

        if (name != null ? !name.equals(topic.name) : topic.name != null) return false;
        return keywords != null ? keywords.equals(topic.keywords) : topic.keywords == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }
}
