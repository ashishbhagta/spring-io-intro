package com.example.spring_io_intro.services;

import com.example.spring_io_intro.Model.Answer;
import com.example.spring_io_intro.Model.Question;
import lombok.Data;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Data
@Service
public class OpenAIServiceImpl implements OpenAIService
{

    private final ChatModel chatModel;

    @Override
    public String getAnswer(String question)
    {
        PromptTemplate promptTemplate=new PromptTemplate(question);
        Prompt prompt=promptTemplate.create();

        ChatResponse chatResponse=chatModel.call(prompt);
        return chatResponse.getResult().getOutput().getText();
    }

    @Override
    public Answer getAnswer(Question question)
    {
        PromptTemplate promptTemplate=new PromptTemplate(question.question());
        Prompt prompt=promptTemplate.create();

        ChatResponse chatResponse=chatModel.call(prompt);
        return new Answer(chatResponse.getResult().getOutput().getText());
    }


}
