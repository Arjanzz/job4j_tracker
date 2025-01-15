package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис для управления банковскими счетами и пользователями.
 */
public class BankService {

    /**
     * Карта, которая хранит пользователя и их счета.
     * Ключ - пользователь, значение - список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему.
     * Если пользователь уже существует, ничего не происходит.
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по его паспорту.
     * @param passport паспорт пользователя, которого нужно удалить
     */
    public void deleteUser(String passport) {
       users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет пользователю.
     * Если пользователь не существует или счет уже добавлен, ничего не происходит.
     * @param passport паспорт пользователя, которому нужно добавить счет
     * @param account счет, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);

        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по паспорту.
     * @param passport паспорт пользователя, которого нужно найти
     * @return пользователь, если найден, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }

        }
        return null;
    }

    /**
     *Находит счет пользователя по его паспорту и реквизитам.
     * @param passport паспорт пользователя, которому принадлежит счет
     * @param requisite реквизиты счета, который нужно найти
     * @return счет, если найдет, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);

            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги с одного счета на другой.
     * @param sourcePassport паспорт пользователя, владельца счета, с которого нужно перевести деньги
     * @param sourceRequisite реквизиты счета, с которого нужно перевести деньги
     * @param destinationPassport паспорт пользователя, владельца счета, которому нужно перевести деньги
     * @param destinationRequisite реквизиты счета, на который нужно перевести деньги
     * @param amount сумма, которую нужно перевести
     * @return true если перевод успешен, иначе  false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {

        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null || sourceAccount.getBalance() < amount) {
            return false;
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        return true;
    }

    /**
     * Возвращает список счетов пользователя.
     * @param user пользователь, чьи счета нужно получить
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}