package Services.Impl;

import Classes.Person;
import Classes.Shop;
import Enums.Products;
import Services.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ServiceImpl implements Services {
    Person person = new Person();
    List <Shop> shops = new LinkedList<>();
    List<Products>products = new LinkedList<>();
    List<Products> sales = new LinkedList<>();

    @Override
    public void createMarkets(List<Shop>shop) {
      this.shops.addAll(shop);
        System.out.println("Markets are successfully created!");
    }

    @Override
    public void getAllMarkets() {
            System.out.println(shops);

    }

    @Override
    public void createPerson() {
            System.out.print("Write the name: ");
            String name = new Scanner(System.in).next();
            System.out.print("Write your money: ");
            BigDecimal money = BigDecimal.valueOf(new Scanner(System.in).nextInt());
            Person person = new Person(name, money);
            this.person = person;
            System.out.println("You are successfully added!");
    }

    @Override
    public void working_time(List<Shop>shops) throws Exception {
            System.out.println("""
                    Choose the market:
                     Food
                     Clothe
                    """);
            String word = new Scanner(System.in).next();

            for (Shop shop : shops) {
                if (shop.getName().equalsIgnoreCase(word)) {
                    System.out.println(" Working time: " + shop.getWorking_time() + "\n Current time: " + LocalTime.now());
                }
            }
            if(!word.matches("[a-zA-Za-яА-Я]*")){
                throw new Exception("Word is wrong!");
            }
        }


    @Override
    public void allProductsInMarket(List<Shop>shops) throws Exception {
        System.out.println("""
                Choose the market:
                 Food
                 Clothe
                """);
        String word  = new Scanner(System.in).next();
        if(!word.matches("[a-zA-Za-яА-Я]*")){
            throw new Exception("Word is wrong!");
        }
        for (Shop shop : shops) {
            if (shop.getName().equalsIgnoreCase(word)) {
                for (Products product : shop.getProducts()) {
                    System.out.println(product+" "+product.getPrice()+" "+product.getSale());
                }
            }
        }
    }

    @Override
    public void saleProductsInMarket(List<Shop> shops) {
        List <Products> saleProducts = new LinkedList<>(Arrays.asList());
        for (Products value : Products.values()) {
            if(value.getSale().contains("sale")) {
                saleProducts.add(value);
            }
        }
        for (Products saleProduct : saleProducts) {
            System.out.println(saleProduct +" "+saleProduct.getPrice()+" "+ saleProduct.getSale());
        }
    }

    @Override
    public void buyProducts(List<Shop>shops) throws Exception {
        System.out.println("""
                Choose the market:
                 Food
                 Clothe
                """);
        String word1 = new Scanner(System.in).next();
        boolean v = true;
        String shopName = "";
        int sum = 0;
        int summ = 0;
        for (Shop shop : shops) {
            if (shop.getName().equals(word1)) {
                shopName = shop.getName();
                System.out.print("Write the product name: ");
                while (v) {
                    String word = new Scanner(System.in).next();
                    if(!word.matches("[a-zA-Za-яА-Я]*")){
                        throw new Exception("Word is wrong!");
                    }
                    for (Products product : shop.getProducts()) {
                        if (word.toUpperCase().equals(product.name())) {
                            this.products.add(product);
                        } else if (word.contains("Buy")) {
                            v = false;
                        }
                    }
                }

                for (Products product : this.products) {
                    sum += product.getPrice();
                    summ = person.getMoney().subtract(BigDecimal.valueOf(sum)).intValue();
                    if (product.getSale().contains("sale")) {
                        sales.add(product);
                    }
                }
            }
        }
        if (summ >= 0) {
            person.setMoney(BigDecimal.valueOf(summ));
            System.out.println(String.format("""
                    ~~~~~~ Check ~~~~~~~~
                    Who bought: %s
                    Name of market: %s
                    
                    List of product: %s
                    Total cost of goods: %d
                    Sale: %s
                    ~~~~~~~~~~~~~~~~~~~
                    Thank you for your purchase!
                    """, person.getName(), shopName, this.products, sum, sales));
        } else {
            System.out.println("You have not a enough money!");
        }
    }


    @Override
    public void allBoughtProducts() {
        System.out.println("Your all products are: ");
        for (Products product : this.products) {
            System.out.println(product);
        }
    }

    @Override
    public void myMoney() {
        System.out.println(person.getMoney());
    }
}
