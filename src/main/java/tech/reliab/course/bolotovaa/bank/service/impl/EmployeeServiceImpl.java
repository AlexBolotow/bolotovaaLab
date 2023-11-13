package tech.reliab.course.bolotovaa.bank.service.impl;

import tech.reliab.course.bolotovaa.bank.entity.BankOffice;
import tech.reliab.course.bolotovaa.bank.entity.Employee;
import tech.reliab.course.bolotovaa.bank.service.EmployeeService;

import java.math.BigDecimal;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee createEmployee(Employee employee) {
        if (employee == null) {
            return null;
        }

        if (employee.getSalary().doubleValue() < 0) {
            return null;
        }

        return new Employee(employee);
    }

    @Override
    public boolean updateBankOffice(Employee employee, BankOffice bankOffice) {
        if (employee != null && bankOffice != null) {
            employee.setBankOffice(bankOffice);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSalary(Employee employee, BigDecimal salary) {
        if (employee != null) {
            if (salary.doubleValue() > 0) {
                employee.setSalary(salary);
                return true;
            }
        }
        return false;
    }
}
