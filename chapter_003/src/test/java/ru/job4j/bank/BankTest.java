package ru.job4j.bank;

import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test class BankTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class BankTest {

    private static Bank bank;
    private static User userOne;
    private static User userTwo;
    private static Account accountOne;
    private static Account accountTwo;

    @Before
    public void beforeTest() {
        bank = new Bank();
        userOne = new User("Alexander", "1234");
        userTwo = new User("Artur", "5678");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        accountOne = new Account(100.0, "Alexander1234");
        accountTwo = new Account(50.0, "Artur5678");
    }

    /**
     * Test_01.
     */
    @Test
    public void whenAddAccountToUserThenNewAccount() {
        bank.addAccountToUser("1234", accountOne);
        assertThat(bank.getUserAccounts("1234"), is(Arrays.asList(accountOne)));
    }

    /**
     * Test_02.
     */
    @Test
    public void deleteAccountFromUserThenDeleteAccount() {
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("1234", accountTwo);
        bank.deleteAccountFromUser("1234", accountOne);
        assertThat(bank.getUserAccounts("1234"), is(Arrays.asList(accountTwo)));
    }
    /**
     * Test_03.
     */
    @Test
    public void whenTransferMoneyAmountSameUserAccountsThenTrue() {
        bank.addUser(userOne);
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("1234", accountOne);
        boolean result = bank.transferMoney(
                "1234",
                "Alexander1234",
                "1234",
                "Alexander1234",
                50.0
        );
        assertThat(result, is(true));
    }
    /**
     * Test_04.
     */
    @Test
    public void whenTransferMoneyAmountDifferentUserAccountsThenTrue() {
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);
        boolean result = bank.transferMoney(
                "1234",
                "Alexander1234",
                "5678",
                "Artur5678",
                50.0
        );
        assertThat(result, is(true));
    }
    /**
     * Test_05.
     */
    @Test
    public void whenTransferMoneyAmountDifferentUserAccountsThenFalse() {
        bank.addAccountToUser("1234", accountOne);
        bank.addAccountToUser("5678", accountTwo);
        boolean result = bank.transferMoney(
                "1234",
                "Alexander1234",
                "5678",
                "Artur5678",
                110.0
        );
        assertThat(result, is(false));
    }
}