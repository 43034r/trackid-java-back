package wiki.monitoring.counter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackageClasses = RestServiceCounter.class)
@EnableScheduling
public class JmxSample {
public static void main(String[] args) {
        new SpringApplicationBuilder(JmxSample.class).profiles("jmx").run(args);
    }
}
