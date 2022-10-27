package com.ej2;

import java.math.BigDecimal;

public class Product {

    public String name;
    public BigDecimal price;
    public Tax tax;

    Product(String name, BigDecimal price, Tax tax){
        this.name=name;
        this.price=price;
        this.tax=tax;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }
}

enum Tax {

    SUPERREDUCED(4), REDUCED(10), NORMAL(21);
    public int percert;
    private Tax(int percent) {this.percert = percent;}
    public int getPercert(){return percert;}
}