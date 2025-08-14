package com.example.spring_io_intro.Controller;

import com.example.spring_io_intro.Model.Answer;
import com.example.spring_io_intro.Model.Question;
import com.example.spring_io_intro.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController
{
    OpenAIService openAIService;

    @PostMapping("/ask")
    public Answer askQuestion(@RequestBody Question question)
    {
        return openAIService.getAnswer(question);
    }
}
