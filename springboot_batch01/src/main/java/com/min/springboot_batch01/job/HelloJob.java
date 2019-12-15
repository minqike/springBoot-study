package com.min.springboot_batch01.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class HelloJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job Hello() {
        return  jobBuilderFactory.get("helloJob")
                .start(helloStep01()).build();
    }

    @Bean
    public Step helloStep01() {
        return stepBuilderFactory.get("Hello_step01")
               .tasklet(new Tasklet() {
                   @Override
                   public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                       System.out.println("Hello_Step01 runned");
                       return RepeatStatus.FINISHED;
                   }
               }).build();
    }
}
