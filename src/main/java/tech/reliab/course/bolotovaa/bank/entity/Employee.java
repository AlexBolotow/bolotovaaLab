package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private final long id;
    private String fullName;
    private LocalDate birthday;
    private String position;
    private Bank bank;
    private boolean isWorkRemotely;
    private BankOffice bankOffice;
    private boolean canIssueCredit;
    private BigDecimal salary;

    public Employee(long id, String fullName, LocalDate birthday, String position, Bank bank, boolean isWorkRemotely,
                    BankOffice bankOffice, boolean canIssueCredit, BigDecimal salary) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.position = position;
        this.bank = bank;
        this.isWorkRemotely = isWorkRemotely;
        this.bankOffice = bankOffice;
        this.canIssueCredit = canIssueCredit;
        this.salary = salary;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.fullName = employee.fullName;
        this.birthday = employee.birthday;
        this.position = employee.position;
        this.bank = employee.bank;
        this.isWorkRemotely = employee.isWorkRemotely;
        this.bankOffice = employee.bankOffice;
        this.canIssueCredit = employee.canIssueCredit;
        this.salary = employee.salary;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isWorkRemotely() {
        return isWorkRemotely;
    }

    public void setWorkRemotely(boolean workRemotely) {
        isWorkRemotely = workRemotely;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public boolean isCanIssueCredit() {
        return canIssueCredit;
    }

    public void setCanIssueCredit(boolean canIssueCredit) {
        this.canIssueCredit = canIssueCredit;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String salary = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.salary);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Employee{" +
                "\nid=" + id +
                "\nfullName='" + fullName + '\'' +
                "\nbirthday=" + birthday.format(formatter) +
                "\nposition='" + position + '\'' +
                "\nbank=" + bank.getName() +
                "\nisWorkRemotely=" + isWorkRemotely +
                "\nbankOffice=" + bankOffice.getName() +
                "\ncanIssueCredit=" + canIssueCredit +
                "\nsalary=" + salary +
                '}';
    }
}
