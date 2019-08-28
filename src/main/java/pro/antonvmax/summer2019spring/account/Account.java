package pro.antonvmax.summer2019spring.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Account {
    /***
     *  id
     */
    @Id
    @GeneratedValue
    @NotNull
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /***
     *  name
     */
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /***
     *  balance
     */
    @Column
    private Long balanceBigDigit;
    @Column
    private Long balanceSmallDigit;

    public Long[] getBalance() {
        return new Long[]{balanceBigDigit, balanceSmallDigit};
    }

    public void setBalanse(Long[] balance) {
        if (balance.length != 2) {
            throw new RuntimeException("balance array must contain exactly 2 values");
        }
        balanceBigDigit = balance[0];
        balanceBigDigit = balance[1];
    }

    public Account() {
    }

    public Account(@NotNull @Size(min = 1, max = 255) String name, Long balanceBigDigit, Long balanceSmallDigit) {
        this.name = name;
        this.balanceBigDigit = balanceBigDigit;
        this.balanceSmallDigit = balanceSmallDigit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balanceBigDigit=" + balanceBigDigit +
                ", balanceSmallDigit=" + balanceSmallDigit +
                '}';
    }
}
