package Beginner.Project.Beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
@EnableJpaRepositories
public class BeginnerApplication {
    // 병합 커밋
    public static void main(String[] args) {
        SpringApplication.run(BeginnerApplication.class, args);
    }
}
