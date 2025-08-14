package com.example.spring_io_intro.services;

import com.example.spring_io_intro.Model.Answer;
import com.example.spring_io_intro.Model.Question;

public interface OpenAIService
{
    String getAnswer(String question);

    Answer getAnswer(Question question);
}
