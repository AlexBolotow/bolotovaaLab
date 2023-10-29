package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private String fullName;
    private LocalDate birthday;
    private String placeWork;
    private BigDecimal salary;
    private ArrayList<Bank> banks;
    private ArrayList<CreditAccount> creditAccounts;
    private ArrayList<PaymentAccount> paymentAccounts;
    private long creditRating;

    public User(String fullName, LocalDate birthday, String placeWork, ArrayList<Bank> banks) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.birthday = birthday;
        this.placeWork = placeWork;
        this.salary = BigDecimal.valueOf(Math.random() * 10001);
        this.banks = banks;
        int tmp = (int) Math.round(this.salary.doubleValue() / 1000) * 1000;
        this.creditRating = Math.min(tmp, 1000);
    }

    public User(User user) {
        this.id = user.id;
        this.fullName = user.fullName;
        this.birthday = user.birthday;
        this.placeWork = user.placeWork;
        this.salary = user.salary;
        this.banks = user.banks;
        this.creditRating = user.creditRating;
        this.creditAccounts = user.creditAccounts;
        this.paymentAccounts = user.paymentAccounts;
    }

    public UUID getId() {
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

    public String getPlaceWork() {
        return placeWork;
    }

    public void setPlaceWork(String placeWork) {
        this.placeWork = placeWork;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public ArrayList<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(ArrayList<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public ArrayList<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(ArrayList<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public long getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(long creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        String salary = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.salary);
        List<String> banksName = banks.stream().map(Bank::getName).toList();
        return "User{" +
                "\nid=" + id +
                "\nfullName='" + fullName + '\'' +
                "\nbirthday=" + birthday +
                "\nplaceWork='" + placeWork + '\'' +
                "\nsalary=" + salary +
                "\nbanks=" + banksName +
                "\ncreditAccounts=" + creditAccounts +
                "\npaymentAccounts=" + paymentAccounts +
                "\ncreditRating=" + creditRating +
                '}';
    }
}
