package controller;

import model.Category;
import model.NewProduct;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.NewProductServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "NewProductServlet", urlPatterns = "/news")
public class NewProductServlet extends HttpServlet {

    NewProductServiceImpl newProductService = new NewProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    saveProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        Category category = categoryService.findById(Integer.parseInt(request.getParameter("category")));
        newProductService.add(new NewProduct(0, name, price, category));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showListProduct(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cates", categoryService.findAll());
        request.getRequestDispatcher("demoAdd.jsp").forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewProduct> productList = newProductService.findAll();
        request.setAttribute("ds", productList);
        request.getRequestDispatcher("demo.jsp").forward(request, response);
    }
}
