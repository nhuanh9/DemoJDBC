package service.impl;

import model.Customer;
import model.Product;
import service.ProductService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    public ProductServiceImpl() {
    }

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
    public void add(Product product) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int categoryId = Integer.parseInt(rs.getString("categoryId"));
                product = new Product(id, name, price, categoryId);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int categoryId = Integer.parseInt(rs.getString("categoryId"));
                products.add(new Product(id, name, price, categoryId));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");) {
            preparedStatement.setString(1, key);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = Integer.parseInt(rs.getString("price"));
                int categoryId = Integer.parseInt(rs.getString("categoryId"));
                products.add(new Product(id, name, price, categoryId));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public List<Product> findAllOrderByAge() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }
}
