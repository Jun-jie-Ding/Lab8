package com.example.lab5;

import static org.junit.Assert.*;
import org.junit.Test;


public class ProductTest {

    @Test
    public void checkProductName(){
        Product aProduct = new Product("1", "DELL MONITOR",180.0);
        assertEquals("Check the name of the product", "DELL MONITOR",aProduct.getProductName());
    }

    @Test
    public void checkProductId(){
        Product aProduct = new Product("1", "DELL MONITOR",  180.0);
        assertEquals("Check the name of the product", "1",aProduct.getId());
    }

    @Test
    public void checkProductPrice(){
        Product aProduct = new Product("1", "DELL MONITOR",180.0);
        Object except = 180.0;
        assertEquals("Check the name of the product", except ,aProduct.getPrice());
    }
}
