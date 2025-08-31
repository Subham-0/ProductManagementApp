package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection con = null;

    public ProductDB() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Run@0");
            System.out.println("Driver connect successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProduct(Product p) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into subham.products(name,type,place,warranty) values(?,?,?,?)");
            pst.setString(1, p.getName());
            pst.setString(2, p.getType());
            pst.setString(3, p.getPlace());
            pst.setInt(4, p.getWarranty());
            pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery("select * from subham.products");
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public Product productByName(String s) {
        Product p = new Product();
        try {
            PreparedStatement pst = con.prepareStatement("select * from subham.products where name = ?");
            pst.setString(1, s);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public List<Product> productByText(String s) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM subham.products WHERE name  ILIKE ? OR type  ILIKE ? OR place ILIKE ?");
            pst.setString(1, "%" + s + "%");
            pst.setString(2, "%" + s + "%");
            pst.setString(3, "%" + s + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public List<Product> productByPlace(String s) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM subham.products WHERE  place ILIKE ?");
            pst.setString(1, "%" + s + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public List<Product> productsOutOfWarranty(int year) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM subham.products WHERE  warranty < ?");
            pst.setInt(1, year);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
