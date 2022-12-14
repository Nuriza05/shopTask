import Classes.Person;
import Classes.Shop;
import Enums.Products;
import Services.Impl.ServiceImpl;
import Services.Services;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List <Products> products = new LinkedList<>(Arrays.asList(Products.APPLE,Products.BANANA,Products.ORANGES,
                Products.MANGO,Products.CARROT,Products.CUCUMBER,Products.TOMATO,Products.POTATO,Products.OIL));
        List <Products> clothes = new LinkedList<>(Arrays.asList(Products.T_SHIRT,Products.DRESS,Products.PANTS,
                Products.SCARF,Products.SHOES,Products.SOCS));

        Shop market = new Shop("Food","24/7","SUM", BigDecimal.valueOf(10000),products);
        Shop shop = new Shop("Clothe","7:00/20:00","Vostok-5",BigDecimal.valueOf(5000),clothes);
        List<Shop>shops = new LinkedList<>(Arrays.asList(market,shop));
        ServiceImpl s = new ServiceImpl();





        while (true) {
            System.out.println("""
                    1. Create markets!
                    2. Get all markets!
                    3. Create person!
                    4. Working time of the market's!
                    5. All products in market!
                    6. Sale products in market!
                    7. Shopping!
                    8. All bought products!
                    9. My money!
                    """);
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> s.createMarkets(shops);
                case 2 -> s.getAllMarkets();
                case 3 -> s.createPerson();
                case 4 -> s.working_time(shops);
                case 5 -> s.allProductsInMarket(shops);
                case 6 -> s.saleProductsInMarket(shops);
                case 7 -> s.buyProducts(shops);
                case 8 -> s.allBoughtProducts();
                case 9 -> s.myMoney();
                default -> throw new Exception("Wrong Input!");
            }
        }
    }
}
