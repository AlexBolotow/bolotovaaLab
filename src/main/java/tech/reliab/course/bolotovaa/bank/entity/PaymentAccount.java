package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

public class PaymentAccount {
    private final UUID id;
    private User user;
    private Bank bank;
    private BigDecimal amountMoney;

    public PaymentAccount(User user, Bank bank, BigDecimal amountMoney) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.bank = bank;
        this.amountMoney = amountMoney;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        this.id = paymentAccount.id;
        this.user = paymentAccount.user;
        this.bank = paymentAccount.bank;
        this.amountMoney = paymentAccount.amountMoney;
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

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    @Override
    public String toString() {
        String amountMoney = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.amountMoney);
        return "PaymentAccount{" +
                "\nid=" + id +
                "\nuser=" + user.getFullName() +
                "\nbank=" + bank.getName() +
                "\namountMoney=" + amountMoney +
                '}';
    }
}
