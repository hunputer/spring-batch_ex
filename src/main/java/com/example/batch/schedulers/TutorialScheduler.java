package com.example.batch.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TutorialScheduler {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 5 * 1000L)
    public void executeJob(){
        try{
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datatime", LocalDateTime.now().toString())
                            .toJobParameters()
            );
        }catch (JobExecutionException e){
            e.printStackTrace();
        }
    }
}
