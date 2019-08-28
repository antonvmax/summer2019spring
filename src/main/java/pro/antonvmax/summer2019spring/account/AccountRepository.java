package pro.antonvmax.summer2019spring.account;

import org.springframework.data.jpa.repository.JpaRepository;

interface AccountRepository extends JpaRepository<Account, String> {
}
