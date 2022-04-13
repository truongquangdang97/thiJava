package com.example.thijava.model;


import com.example.thijava.entity.User;
import com.example.thijava.util.ConnectionHelper;
import com.example.thijava.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountModel  {
    public User finfByName (String txt)throws SQLException,ClassNotFoundException{
        User obj = null;
        Connection connection = ConnectionHelper.getConnection();//Kết nốt csdl
        PreparedStatement preparedStatement = /// thực thi câu lệnh truy vấn .
                connection.prepareStatement(SQLConfig.SELECT_ACCOUNT_BY_USERNAME); /// truy vấn khi truyền vào
        preparedStatement.setString(1, txt);// ứng với tùng giá trị
        ResultSet resultSet =  preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getString("username");
            String password = resultSet.getString("password");
            obj = new User(name,password);
            return obj;
        }
        return null;
    }
}
