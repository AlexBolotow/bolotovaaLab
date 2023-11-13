package tech.reliab.course.bolotovaa.bank.entity;

import tech.reliab.course.bolotovaa.bank.enums.BankATMStatus;
import tech.reliab.course.bolotovaa.bank.utils.DecimalFormatConstants;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

public class BankATM {
    public static final BigDecimal MAX_TOTAL_MONEY = new BigDecimal(70000);
    private final UUID id;
    private String name;
    private String address;
    private BankATMStatus status;
    private Bank bank;
    private BankOffice office;
    private Employee serviceEmployee;
    private boolean isWithdrawMoney;
    private boolean isDepositMoney;
    private BigDecimal totalMoney;
    private BigDecimal serviceCost;

    public BankATM(String name, String address, BankATMStatus status, Bank bank, BankOffice bankOffice, Employee serviceEmployee,
                   boolean isWithdrawMoney, boolean isDepositMoney, BigDecimal totalMoney, BigDecimal serviceCost) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.office = bankOffice;
        this.serviceEmployee = serviceEmployee;
        this.isWithdrawMoney = isWithdrawMoney;
        this.isDepositMoney = isDepositMoney;
        this.totalMoney = totalMoney;
        this.serviceCost = serviceCost;
    }

    public BankATM(BankATM bankAtm) {
        this.id = bankAtm.id;
        this.name = bankAtm.name;
        this.address = bankAtm.address;
        this.status = bankAtm.status;
        this.bank = bankAtm.bank;
        this.office = bankAtm.office;
        this.serviceEmployee = bankAtm.serviceEmployee;
        this.isWithdrawMoney = bankAtm.isWithdrawMoney;
        this.isDepositMoney = bankAtm.isDepositMoney;
        this.totalMoney = bankAtm.totalMoney;
        this.serviceCost = bankAtm.serviceCost;
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

    public BankATMStatus getStatus() {
        return status;
    }

    public void setStatus(BankATMStatus status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getOffice() {
        return office;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public Employee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(Employee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public boolean isWithdrawMoney() {
        return isWithdrawMoney;
    }

    public void setPaymentMoney(boolean isWithdrawMoney) {
        this.isWithdrawMoney = isWithdrawMoney;
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

    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        String totalMoney = new DecimalFormat(DecimalFormatConstants.MONEY_FORMAT).format(this.totalMoney);
        return "BankATM{" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\naddress='" + address + '\'' +
                "\nstatus=" + status +
                "\nbank=" + bank.getName() +
                "\noffice=" + office.getName() +
                "\nserviceEmployee=" + serviceEmployee.getFullName() +
                "\nisWithdrawMoney=" + isWithdrawMoney +
                "\nisDepositMoney=" + isDepositMoney +
                "\ntotalMoney=" + totalMoney +
                "\nserviceCost=" + serviceCost +
                '}';
    }
}
