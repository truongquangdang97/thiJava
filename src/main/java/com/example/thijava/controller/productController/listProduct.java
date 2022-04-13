package com.example.thijava.controller.productController;

import com.example.thijava.entity.Product;
import com.example.thijava.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class listProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        try{
            List<Product> productList = productModel.findAll();
            req.setAttribute("productList",productList);
            req.getRequestDispatcher("/admin/product/listProduct.jsp").forward(req,resp);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
