package de.billmaier.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"de.billmaier.example.emailmgmt", "de.billmaier.example.taskmgmt"})
@ConfigurationPropertiesScan
@EnableAsync
public class Application
{
    protected Application()
    {
    }

    public static void main(final String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
