package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.*;

public interface BankService {
    /**
     * Создание банка
     *
     * @param bank банк
     * @return банк
     */
    Bank createBank(Bank bank);

    /**
     * Добавление офиса
     *
     * @param bank       банк
     * @param bankOffice офис
     * @return значение true, если офис добавлен, иначе false
     */
    boolean addBankOffice(Bank bank, BankOffice bankOffice);

    /**
     * Удаление офиса
     *
     * @param bank       банк
     * @param bankOffice офис
     * @return значение true, если офис удален, иначе false
     */
    boolean deleteBankOffice(Bank bank, BankOffice bankOffice);

    /**
     * Добавление банкомата
     *
     * @param bank    банк
     * @param bankAtm банкомат
     * @return значение true, если банкомат добавлен, иначе false
     */
    boolean addBankAtm(Bank bank, BankAtm bankAtm);

    /**
     * Удаление банкомата
     *
     * @param bank    банк
     * @param bankAtm банкомат
     * @return значение true, если банкомат удален, иначе false
     */
    boolean deleteBankAtm(Bank bank, BankAtm bankAtm);

    /**
     * Добавление сотрудника
     *
     * @param bank     банк
     * @param employee сотрудник
     * @return значение true, если сотрудник добавлен, иначе false
     */
    boolean addEmployee(Bank bank, Employee employee);

    /**
     * Удаление сотрудника
     *
     * @param bank     банк
     * @param employee сотрудник
     * @return значение true, если сотрудник удален, иначе false
     */
    boolean deleteEmployee(Bank bank, Employee employee);

    /**
     * Добавление клиента
     *
     * @param bank банк
     * @param user клиент
     * @return значение true, если клиент добавлен, иначе false
     */
    boolean addClient(Bank bank, User user);

    /**
     * Удаление клиента
     *
     * @param bank банк
     * @param user клиент
     * @return значение true, если клиент удален, иначе false
     */
    boolean deleteClient(Bank bank, User user);

}
