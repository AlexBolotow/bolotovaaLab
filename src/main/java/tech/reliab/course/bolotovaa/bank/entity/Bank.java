package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final long id;
    private String name;
    private List<BankOffice> bankOffices;
    private List<User> users;
    private List<Employee> employees;
    private List<BankATM> bankATMS;
    private int rating;
    private BigDecimal totalMoney;
    private double interestRate;

    public Bank(long id, String name) {
        this.id = id;
        this.name = name;
        bankOffices = new ArrayList<>();
        users = new ArrayList<>();
        employees = new ArrayList<>();
        bankATMS = new ArrayList<>();
        rating = (int) (Math.random() * 101);
        totalMoney = BigDecimal.valueOf((Math.random() * ((1000000 - 100000) + 1)) + 100000);
        interestRate = Math.round(5 + Math.random() * (15 - rating / 10.));
    }

    public Bank(Bank bank) {
        this.id = bank.id;
        this.name = bank.name;
        this.bankOffices = bank.bankOffices;
        this.users = bank.users;
        this.employees = bank.employees;
        this.bankATMS = bank.bankATMS;
        this.rating = bank.rating;
        this.totalMoney = bank.totalMoney;
        this.interestRate = bank.interestRate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public List<BankOffice> getBankOffices() {
        return bankOffices;
    }

    public void setBankOffices(List<BankOffice> bankOffices) {
        this.bankOffices = bankOffices;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<BankATM> getBankATMS() {
        return bankATMS;
    }

    public void setBankATMS(List<BankATM> bankATMS) {
        this.bankATMS = bankATMS;
    }

    @Override
    public String toString() {
        String totalMoney = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.totalMoney);
        return "Bank{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nrating=" + rating +
                "\ntotalMoney=" + totalMoney +
                "\ninterestRate=" + interestRate +
                '}';
    }
}
