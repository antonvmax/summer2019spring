package pro.antonvmax.summer2019spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pro.antonvmax.summer2019spring.logger.LoggerBeanAnnotationProcessor;

@ComponentScan
@Component
public class ApplicationConfiguration {
    @Bean
    public LoggerBeanAnnotationProcessor loggerBeanAnnotationProcessor() {
        return new LoggerBeanAnnotationProcessor();
    }

    @Bean(name = "loggerBean")
    public Logger loggerBean() {
        return LoggerFactory.getLogger("loggerBean");
    }
}
