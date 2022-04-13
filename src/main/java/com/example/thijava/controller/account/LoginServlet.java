package com.example.thijava.controller.account;



import com.example.thijava.entity.Product;
import com.example.thijava.entity.User;
import com.example.thijava.model.AccountModel;
import com.example.thijava.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class LoginServlet extends HttpServlet {
    AccountModel accountModel = new AccountModel();
//    int max_count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("password");
        try {
          User user =  accountModel.finfByName(userName);
          if (user==null){
              resp.getWriter().println("Sai thong tin tai khoan .");
          }
          if (user!=null){
              if (Objects.equals(user.getPassWord(), passWord)){
                  ProductModel productModel = new ProductModel();
                  List<Product> productList = productModel.findAll();
                  req.setAttribute("productList",productList);
                  req.getRequestDispatcher("/admin/product/listProduct.jsp").forward(req,resp);
              }
          }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
