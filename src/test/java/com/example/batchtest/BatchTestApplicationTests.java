package com.example.batchtest;

import com.example.batch.BatchConfig;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {BatchConfig.class})
@SpringBatchTest
@EnableAutoConfiguration
class BatchTestApplicationTests
{
    @Autowired
    JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void test()
    {
        JobExecution step = jobLauncherTestUtils.launchStep("step");
        System.out.println(step);
    }

}
