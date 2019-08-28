package pro.antonvmax.summer2019spring.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    List<Account> allAccounts() {
        logger.info("{} :: GET allAccounts()", this.getClass());
        return accountRepository.findAll();
    }
}
