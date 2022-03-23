package com.vladanristic.repository;

import com.vladanristic.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Long> {
}
