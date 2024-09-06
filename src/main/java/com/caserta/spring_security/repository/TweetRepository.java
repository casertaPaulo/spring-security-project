package com.caserta.spring_security.repository;

import com.caserta.spring_security.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
