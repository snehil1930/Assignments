package com.example.Assignment4.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/*
 * configuration class
 */
@Configurable
@EnableAsync
public class AsynchronousConfig {
    /*
     * Defining the execution of thread using complete future
     */
    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        final var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("ItemThread-");
        executor.initialize();
        return executor;
    }
}
