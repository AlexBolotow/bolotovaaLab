package tech.reliab.course.bolotovaa.bank.service;

import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.entity.Employee;

import java.math.BigDecimal;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    boolean updateBankOffice(Employee employee, BankOffice bankOffice);

    boolean updateSalary(Employee employee, BigDecimal salary);
}
