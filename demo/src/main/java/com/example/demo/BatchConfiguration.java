package com.example.demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@ImportResource({  "spring/batch/jobs/job-report.xml" })
public class BatchConfiguration {
	Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);
/*	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
*/	 //@Bean
@Autowired
private JobBuilderFactory jobBuilders;

@Autowired
private StepBuilderFactory stepBuilders;

@Bean
public PlatformTransactionManager transactionManager() {
    return new ResourcelessTransactionManager();
}

@Bean
public JobRepository jobRepository() throws Exception {
    return new MapJobRepositoryFactoryBean(transactionManager()).getJobRepository();
}

@Bean
public JobLauncher jobLauncher() throws Exception {
    SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
    jobLauncher.setJobRepository(jobRepository());
    return jobLauncher;
}
}
