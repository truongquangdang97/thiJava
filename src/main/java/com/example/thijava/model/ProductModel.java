package com.example.thijava.model;

import com.example.thijava.entity.Product;
import com.example.thijava.entity.User;
import com.example.thijava.util.ConnectionHelper;
import com.example.thijava.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    public List<Product> findAll() throws SQLException,ClassNotFoundException{
        List<Product> listObj = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();//kết nối
        PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.LIST_PRODUCT);// truyề câu lệnh vào
        ResultSet resultSet = preparedStatement.executeQuery(SQLConfig.LIST_PRODUCT); // trả là dữ liệu
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            int amount = resultSet.getInt("amount");
            String details  = resultSet.getString("details");
            Product obj = new Product(id,name,price,amount,details);
            listObj.add(obj);
        }
        return  listObj;
    }
}
