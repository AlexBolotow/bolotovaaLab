package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.enums.BankOfficeStatus;
import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

public class BankOffice {
    public static final BigDecimal MAX_TOTAL_MONEY = new BigDecimal(1000000);
    private final UUID id;
    private String name;
    private String address;
    private BankOfficeStatus status;
    private boolean isAtmPossible;
    private long countAtm;
    private boolean isCreditPossible;
    private boolean isWithdrawMoney;
    private boolean isDepositMoney;
    private BigDecimal totalMoney;
    private BigDecimal rentPrice;

    public BankOffice(String name, String address, BankOfficeStatus status, boolean isAtmPossible, long countAtm,
                      boolean isCreditPossible, boolean isWithdrawMoney, boolean isDepositMoney, BigDecimal totalMoney,
                      BigDecimal rentPrice) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.status = status;
        this.isAtmPossible = isAtmPossible;
        this.countAtm = countAtm;
        this.isCreditPossible = isCreditPossible;
        this.isWithdrawMoney = isWithdrawMoney;
        this.isDepositMoney = isDepositMoney;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
    }

    public BankOffice(BankOffice bankOffice) {
        this.id = bankOffice.id;
        this.name = bankOffice.name;
        this.address = bankOffice.address;
        this.status = bankOffice.status;
        this.isAtmPossible = bankOffice.isAtmPossible;
        this.countAtm = bankOffice.countAtm;
        this.isCreditPossible = bankOffice.isCreditPossible;
        this.isWithdrawMoney = bankOffice.isWithdrawMoney;
        this.isDepositMoney = bankOffice.isDepositMoney;
        this.totalMoney = bankOffice.totalMoney;
        this.rentPrice = bankOffice.rentPrice;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankOfficeStatus getStatus() {
        return status;
    }

    public void setStatus(BankOfficeStatus status) {
        this.status = status;
    }

    public boolean isAtmPossible() {
        return isAtmPossible;
    }

    public void setAtmPossible(boolean atmPossible) {
        isAtmPossible = atmPossible;
    }

    public long getCountAtm() {
        return countAtm;
    }

    public void setCountAtm(long countAtm) {
        this.countAtm = countAtm;
    }

    public boolean isCreditPossible() {
        return isCreditPossible;
    }

    public void setCreditPossible(boolean creditPossible) {
        isCreditPossible = creditPossible;
    }

    public boolean isWithdrawMoney() {
        return isWithdrawMoney;
    }

    public void setWithdrawMoney(boolean withdrawMoney) {
        isWithdrawMoney = withdrawMoney;
    }

    public boolean isDepositMoney() {
        return isDepositMoney;
    }

    public void setDepositMoney(boolean depositMoney) {
        isDepositMoney = depositMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        String totalMoney = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.totalMoney);
        String rentPrice = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.rentPrice);
        return "BankOffice{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\naddress='" + address + '\'' +
                "\nstatus=" + status +
                "\nisAtmPossible=" + isAtmPossible +
                "\ncountAtm=" + countAtm +
                "\nisCreditPossible=" + isCreditPossible +
                "\nisWithdrawMoney=" + isWithdrawMoney +
                "\nisDepositMoney=" + isDepositMoney +
                "\ntotalMoney=" + totalMoney +
                "\nrentPrice=" + rentPrice +
                '}';
    }
}
