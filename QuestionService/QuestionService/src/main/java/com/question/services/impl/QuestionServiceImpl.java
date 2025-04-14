package com.question.services.impl;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Override
    public Question create(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> get() {
        return repository.findAll();
    }

    @Override
    public Question get(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Question not found")
                );
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return repository.findByQuizId(quizId);
    }


}
