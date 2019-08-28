package pro.antonvmax.summer2019spring.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountZInitializer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initAccountRepository(AccountRepository accountRepository) {
        return args -> {
            logger.info("Preparing account: {}",  accountRepository.save(new Account("Acc1", 99L, 1L)));
            logger.info("Preparing account: {}",  accountRepository.save(new Account("Acc2", 1L, 99L)));
        };
    }

}
