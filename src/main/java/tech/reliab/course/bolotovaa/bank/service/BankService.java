package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.*;

import java.util.List;

public interface BankService {
    /**
     * Создание банка
     *
     * @param bank банк
     * @return банк
     */
    Bank createBank(Bank bank);

    /**
     * Добавление офисов
     *
     * @param bank        банк
     * @param bankOffices офисы
     * @return значение true, если офисы добавлены, иначе false
     */
    boolean addBankOffices(Bank bank, List<BankOffice> bankOffices);

    /**
     * Удаление офисов
     *
     * @param bank        банк
     * @param bankOffices офисы
     * @return значение true, если офисы удалены, иначе false
     */
    boolean deleteBankOffices(Bank bank, List<BankOffice> bankOffices);

    /**
     * Добавление банкоматов
     *
     * @param bank     банк
     * @param bankATMS банкоматы
     * @return значение true, если банкоматы добавлены, иначе false
     */
    boolean addBankATMS(Bank bank, List<BankATM> bankATMS);

    /**
     * Удаление банкоматов
     *
     * @param bank     банк
     * @param bankATMS банкоматы
     * @return значение true, если банкоматы удалены, иначе false
     */
    boolean deleteBankATMS(Bank bank, List<BankATM> bankATMS);

    /**
     * Добавление сотрудников
     *
     * @param bank      банк
     * @param employees сотрудники
     * @return значение true, если сотрудники добавлены, иначе false
     */
    boolean addEmployees(Bank bank, List<Employee> employees);

    /**
     * Удаление сотрудников
     *
     * @param bank      банк
     * @param employees сотрудники
     * @return значение true, если сотрудники удалены, иначе false
     */
    boolean deleteEmployees(Bank bank, List<Employee> employees);

    /**
     * Добавление клиентов
     *
     * @param bank  банк
     * @param users клиенты
     * @return значение true, если клиенты добавлены, иначе false
     */
    boolean addUsers(Bank bank, List<User> users);

    /**
     * Удаление клиентов
     *
     * @param bank  банк
     * @param users клиенты
     * @return значение true, если клиенты удалены, иначе false
     */
    boolean deleteUsers(Bank bank, List<User> users);

}
