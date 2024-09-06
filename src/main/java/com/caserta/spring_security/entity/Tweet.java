package com.caserta.spring_security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_tweets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private User user;

    private String content;

    @CreationTimestamp
    private Instant timestamp;
}
