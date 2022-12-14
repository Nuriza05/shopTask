package Classes;

import Enums.Products;

import java.math.BigDecimal;
import java.util.List;

public class Shop {
    private String name;
    private String working_time;
    private String address;
    private BigDecimal bankAccount;
    private List<Products> products;

    public Shop(String name, String working_time, String address, BigDecimal bankAccount, List<Products> products) {
        this.name = name;
        this.working_time = working_time;
        this.address = address;
        this.bankAccount = bankAccount;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorking_time() {
        return working_time;
    }

    public void setWorking_time(String working_time) {
        this.working_time = working_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BigDecimal bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return String.format("""
                ~~~~~~~~~~~~~~~~~~~~~~~
                Name of market: %s
                \nWorking time: %s
                \nAddress: %s
                \nBank account: %f
              
                """,name,working_time,address,bankAccount);
    }
}
