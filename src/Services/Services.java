package Services;

import Classes.Shop;

import java.util.List;

public interface Services {
    void createMarkets(List<Shop>shop);
    void getAllMarkets();
    void createPerson();
    void working_time(List<Shop> shops) throws Exception;
    void allProductsInMarket(List<Shop>shops) throws Exception;
    void saleProductsInMarket(List<Shop>shops);
    void buyProducts(List<Shop>shops) throws Exception;
    void allBoughtProducts();
    void myMoney();

}
