package com.example.batch.tasklets;

import com.example.batch.entity.Batch;
import com.example.batch.service.TutorialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TutorialTasklet implements Tasklet {

    private final TutorialService tutorialService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception{
        log.debug("executed tastlet!!");

        Batch batch = new Batch();
        batch.setName("지훈");

        tutorialService.save(batch);

        System.out.println("실행");

        return RepeatStatus.FINISHED;
    }
}
