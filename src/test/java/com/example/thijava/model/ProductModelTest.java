package com.example.thijava.model;

import com.example.thijava.entity.Product;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductModelTest {

    @Test
    void findAll() {
        ProductModel productModel = new ProductModel();
        try {
            List<Product> list = productModel.findAll();
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}