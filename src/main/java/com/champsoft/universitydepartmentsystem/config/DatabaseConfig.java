package com.champsoft.universitydepartmentsystem.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");

        System.out.println("Original DATABASE_URL: " + databaseUrl);

        if (databaseUrl != null && databaseUrl.startsWith("postgresql://")) {
            databaseUrl = "jdbc:" + databaseUrl;
            System.out.println("Fixed DATABASE_URL: " + databaseUrl);
        }

        return DataSourceBuilder
                .create()
                .url(databaseUrl != null ? databaseUrl : "jdbc:postgresql://localhost:5432/universitydb")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}