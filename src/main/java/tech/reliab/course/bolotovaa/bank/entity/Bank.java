package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

public class Bank {
    private final UUID id;
    private String name;
    private long countOffices;
    private long countAtm;
    private long countEmployees;
    private long countClients;
    private int rating;
    private BigDecimal totalMoney;
    private double interestRate;

    public Bank(String name) {
        id = UUID.randomUUID();
        this.name = name;
        countOffices = 0;
        countAtm = 0;
        countEmployees = 0;
        countClients = 0;
        rating = (int) (Math.random() * 101);
        totalMoney = BigDecimal.valueOf(Math.random() * 1000000);
        interestRate = Math.round(5 + Math.random() * (15 - rating / 10.));
    }

    public Bank(Bank bank) {
        this.id = bank.id;
        this.name = bank.name;
        this.countOffices = bank.countOffices;
        this.countAtm = bank.countAtm;
        this.countEmployees = bank.countEmployees;
        this.countClients = bank.countClients;
        this.rating = bank.rating;
        this.totalMoney = bank.totalMoney;
        this.interestRate = bank.interestRate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountOffices() {
        return countOffices;
    }

    public void setCountOffices(long countOffices) {
        this.countOffices = countOffices;
    }

    public long getCountATM() {
        return countAtm;
    }

    public void setCountATM(long countAtm) {
        this.countAtm = countAtm;
    }

    public long getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(long countEmployees) {
        this.countEmployees = countEmployees;
    }

    public long getCountClients() {
        return countClients;
    }

    public void setCountClients(long countClients) {
        this.countClients = countClients;
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

    @Override
    public String toString() {
        String totalMoney = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.totalMoney);
        return "Bank{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\ncountOffices=" + countOffices +
                "\ncountAtm=" + countAtm +
                "\ncountEmployees=" + countEmployees +
                "\ncountClients=" + countClients +
                "\nrating=" + rating +
                "\ntotalMoney=" + totalMoney +
                "\ninterestRate=" + interestRate +
                '}';
    }
}
