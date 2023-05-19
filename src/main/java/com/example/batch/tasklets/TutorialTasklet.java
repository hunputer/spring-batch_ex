package com.example.batch.tasklets;

import com.example.batch.dto.BookDto;
import com.example.batch.mapper.BookMapper;
import com.example.batch.service.TutorialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
public class TutorialTasklet implements Tasklet {

    private final BookMapper bookMapper;
    private final TutorialService tutorialService;

    @Autowired
    public TutorialTasklet(BookMapper bookMapper, TutorialService tutorialService) {
        this.bookMapper = bookMapper;
        this.tutorialService = tutorialService;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception{
        log.debug("executed tastlet!!");

        ArrayList<BookDto> list = bookMapper.findAll();

        for(BookDto bookDto : list){
            System.out.println(bookDto.getItemId());
            System.out.println(bookDto.getContents());
            System.out.println(bookDto.getName());
            System.out.println(bookDto.getCustNo());
        }

        return RepeatStatus.FINISHED;
    }
}
