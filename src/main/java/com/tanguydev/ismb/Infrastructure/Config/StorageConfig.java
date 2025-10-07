package com.tanguydev.ismb.Infrastructure.Config;

import com.tanguydev.ismb.Domain.Ports.FileStorageServiceInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    CommandLineRunner init(FileStorageServiceInterface fileStorageService) {
        return (args) -> {
            fileStorageService.init();
        };
    }
}
