package com.example.lab5;

public class Product {
    private String _id;
    private String _productname;
    private Double _price;

    public Product() {
    }
    public Product(String id, String productname, Double price) {
        _id = id;
        _productname = productname;
        _price = price;

    }




    public void setId(String id) {
        _id = id;
    }
    public String getId() {
        return _id;
    }
    public void setProductName(String productname) {
        _productname = productname;
    }
    public String getProductName() {
        return _productname;
    }
    public void setPrice(Double price) {
        _price = price;
    }
    public Double getPrice() {
        return _price;
    }
}
