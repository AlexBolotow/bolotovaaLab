package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.UUID;

public class CreditAccount {
    private final UUID id;
    private User user;
    private Bank bank;
    private LocalDate startCredit;
    private LocalDate finishCredit;
    private long countMonth;
    private BigDecimal amountCredit;
    private BigDecimal monthlyPayment;
    private double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(User user, Bank bank, LocalDate startCredit, LocalDate finishCredit,
                         long countMonth, BigDecimal amountCredit, BigDecimal monthlyPayment,
                         Employee employee, PaymentAccount paymentAccount) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.bank = bank;
        this.startCredit = startCredit;
        this.finishCredit = finishCredit;
        this.countMonth = countMonth;
        this.amountCredit = amountCredit;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = bank.getInterestRate() - user.getCreditRating() * 0.005;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount creditAccount) {
        this.id = creditAccount.id;
        this.user = creditAccount.user;
        this.bank = creditAccount.bank;
        this.startCredit = creditAccount.startCredit;
        this.finishCredit = creditAccount.finishCredit;
        this.countMonth = creditAccount.countMonth;
        this.amountCredit = creditAccount.amountCredit;
        this.monthlyPayment = creditAccount.monthlyPayment;
        this.interestRate = creditAccount.interestRate;
        this.employee = creditAccount.employee;
        this.paymentAccount = creditAccount.paymentAccount;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public LocalDate getStartCredit() {
        return startCredit;
    }

    public void setStartCredit(LocalDate startCredit) {
        this.startCredit = startCredit;
    }

    public LocalDate getFinishCredit() {
        return finishCredit;
    }

    public void setFinishCredit(LocalDate finishCredit) {
        this.finishCredit = finishCredit;
    }

    public long getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(long countMonth) {
        this.countMonth = countMonth;
    }

    public BigDecimal getAmountCredit() {
        return amountCredit;
    }

    public void setAmountCredit(BigDecimal amountCredit) {
        this.amountCredit = amountCredit;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        String amountCredit = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.amountCredit);
        return "CreditAccount{" +
                "\nid=" + id +
                "\nuser=" + user.getFullName() +
                "\nbank=" + bank.getName() +
                "\nstartCredit=" + startCredit +
                "\nfinishCredit=" + finishCredit +
                "\ncountMonth=" + countMonth +
                "\namountCredit=" + amountCredit +
                "\nmonthlyPayment=" + monthlyPayment +
                "\ninterestRate=" + interestRate +
                "\nemployee=" + employee.getFullName() +
                "\npaymentAccount=" + paymentAccount.getId() +
                '}';
    }
}
