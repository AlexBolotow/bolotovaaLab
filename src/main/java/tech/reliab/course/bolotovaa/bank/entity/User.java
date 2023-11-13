package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final long id;
    private String fullName;
    private LocalDate birthday;
    private String placeWork;
    private BigDecimal salary;
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;
    private long creditRating;

    public User(long id, String fullName, LocalDate birthday, String placeWork) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.placeWork = placeWork;
        banks = new ArrayList<>();
        creditAccounts = new ArrayList<>();
        paymentAccounts = new ArrayList<>();
        this.salary = BigDecimal.valueOf(Math.random() * 10001);
        int tmp = (int) Math.round(this.salary.doubleValue() / 1000) * 100;
        this.creditRating = Math.min(tmp, 1000);
    }

    public User(User user) {
        this.id = user.id;
        this.fullName = user.fullName;
        this.birthday = user.birthday;
        this.placeWork = user.placeWork;
        this.salary = user.salary;
        this.creditRating = user.creditRating;
        this.creditAccounts = user.creditAccounts;
        this.paymentAccounts = user.paymentAccounts;
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

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(ArrayList<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public void setCreditAccounts(List<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public List<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(ArrayList<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public long getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(long creditRating) {
        this.creditRating = creditRating;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    @Override
    public String toString() {
        String salary = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.salary);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "User{" +
                "\nid=" + id +
                "\nfullName='" + fullName + '\'' +
                "\nbirthday=" + birthday.format(formatter) +
                "\nplaceWork='" + placeWork + '\'' +
                "\nsalary=" + salary +
                "\ncreditRating=" + creditRating +
                '}';
    }
}
