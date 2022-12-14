package Enums;

public enum Products {
    APPLE(50,"sale/ 70"),
    BANANA(120,""),
    ORANGES(100,"sale/ 150"),
    MANGO(200,""),
    CARROT(100,""),
    CUCUMBER(40,"sale/ 50"),
    TOMATO(50,""),
    POTATO(90,""),
    OIL(70,"sale/ 90"),
    T_SHIRT(800,""),
    DRESS(5000,"sale/ 6000"),
    PANTS(1500,""),
    SCARF(400,"sale/ 500"),
    SHOES(6000,""),
    SOCS(50,"");
    private int price;
    private String sale;
    Products(int price, String sale) {
        this.price = price;
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
