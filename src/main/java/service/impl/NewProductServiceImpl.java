package service.impl;

import model.NewProduct;
import model.Product;
import service.NewProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewProductServiceImpl implements NewProductService {
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo312?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void add(NewProduct newProduct) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product (name, price, categoryId) values (?,?,?)");) {
            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setInt(2, newProduct.getPrice());
            preparedStatement.setInt(3, newProduct.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public NewProduct findById(int id) {
        return null;
    }

    @Override
    public List<NewProduct> findAll() {
        List<NewProduct> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int categoryId = Integer.parseInt(rs.getString("categoryId"));
                products.add(new NewProduct(id, name, price, categoryService.findById(categoryId)));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<NewProduct> findByName(String name) {
        return null;
    }

    @Override
    public List<NewProduct> findAllOrderByAge() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(NewProduct newProduct) throws SQLException {
        return false;
    }
}
