package Classes;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Person {
    private String name;
    private BigDecimal money;

    public Person(String name, BigDecimal money) {
       exception(name,money);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                \nMoney of person: %f
                """, name,money);
    }
    public static void exception(String name, BigDecimal money) throws InputMismatchException{
        try{
            if(!name.matches("[a-zA-Za-яА-Я]*")){
                throw new Exception("Name is wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
