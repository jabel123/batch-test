package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig
{
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job()
    {
        return jobBuilderFactory.get("job")
                .start(step())
                .build();
    }

    @Bean
    public Step step()
    {
        return stepBuilderFactory.get("step")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("step test");

                    return RepeatStatus.FINISHED;
                }))
                .build();
    }

}
