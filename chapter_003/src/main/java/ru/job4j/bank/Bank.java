package ru.job4j.bank;

import java.util.*;

/**
 * class Bank.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Bank {

    /**
     * Коллекция обозначающая что у каждого пользователя может быть несколько счетов.
     */
    private Map<User, List<Account>> users = new TreeMap<>();

    /**
     * Метод addUser.
     * Метод добавляет пользователя.
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод deleteUser.
     * Метод  удаление пользователя.
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Метод addAccountToUser.
     * Метод добавляет счет пользователя.
     * @param passport паспорт пользователя.
     * @param account счет пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        for (User key : users.keySet()) {
            if (key.getPasport().equals(passport)) {
                this.users.get(key).add(account);
            }
        }
    }

    /**
     * Метод deleteAccountFromUser.
     * Метод удаляет один счет пользователя.
     * @param passport паспорт пользователя.
     * @param account счет пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User key : users.keySet()) {
            if (key.getPasport().equals(passport)) {
                this.users.get(key).remove(account);
            }
        }
    }

    /**
     * метод getUserAccounts.
     * Метод получения списка счетов для пользователя.
     * @param passport паспорт пользователя.
     * @return список счетов.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (User key : users.keySet()) {
            if (key.getPasport().equals(passport)) {
                list = this.users.get(key);
            }
        }
        return list;
    }

    /**
     * метод getUserAccounts.
     * Метод получения списка счетов для пользователя.
     * @param srcPassport паспорт отправителя
     * @param srcRequisite счет отправителя.
     * @param dstPassport паспорт получателя.
     * @param dstRequisite счет получателя.
     * @param amount сумма.
     * @return если перевод возможен возвращает true, если не возможен false.
     */
    public boolean transferMoney(
            String srcPassport,
            String srcRequisite,
            String dstPassport,
            String dstRequisite,
            double amount
    ) {
        boolean src = false;
        boolean dst = false;
        boolean trans = false;
        List<Account> srcList = getUserAccounts(srcPassport);
        List<Account> dstList = getUserAccounts(dstPassport);
        for (Account account : srcList) {
            if (account.getRequisites().equals(srcRequisite)) {
                src = true;
                srcList = Arrays.asList(account);
            }
        }
        for (Account account : dstList) {
            if (account.getRequisites().equals(dstRequisite)) {
                dst = true;
                dstList = Arrays.asList(account);
            }
        }
        if ((src && dst) && (srcList.get(0).transfer(dstList.get(0), amount))) {
            trans = true;
        }
        return trans;
    }
}
