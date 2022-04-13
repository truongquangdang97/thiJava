package com.example.thijava.model;

import com.example.thijava.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AccountModelTest {

    @Test
    void finfByName() {
        AccountModel accountModel = new AccountModel();
        try {
            User user = accountModel.finfByName("quang");
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}