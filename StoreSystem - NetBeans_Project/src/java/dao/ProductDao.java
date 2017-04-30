package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDao {

    DbConnection conn;

    public ProductDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(Product articulo) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String sql = "INSERT INTO products VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, articulo.getId());
            ps.setString(2, articulo.getName());
            ps.setString(3, format.format(articulo.getDate()));
            ps.setInt(4, articulo.getStock());
            ps.setFloat(5, articulo.getPrice());
            ps.setString(6, articulo.getCategory());
            ps.setString(7, articulo.getDescription());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Product> getUltimas() {

        try {
            String sql = "select * from products order by id desc limit 3";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Product> list = new LinkedList<>();
            Product producto;
            while (rs.next()) {
                producto = new Product(rs.getInt("id"));
                producto.setName(rs.getString("name"));
                producto.setDate(rs.getDate("date"));
                producto.setPrice(rs.getFloat("price"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategory(rs.getString("category"));
                producto.setDescription(rs.getString("description"));

                // Add vacante object to the list
                list.add(producto);
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Error ProductDao.getUltimas: " + e.getMessage());
            return null;
        }
    }

    public Product getById(int idProducto) {
        try {
            String sql = "select * from products where id=? limit 1";
            PreparedStatement preparedStatement = conn.getConnection()
                    .prepareStatement(sql);
            preparedStatement.setInt(1, idProducto); // Set idVacante
            ResultSet rs = preparedStatement.executeQuery();
            Product producto = new Product(0);
            while (rs.next()) {
                // Create an object for the movie
                producto.setId(rs.getInt("id"));
                producto.setDate(rs.getDate("date"));
                producto.setName(rs.getString("name"));
                producto.setDescription(rs.getString("description"));
            }
            return producto;

        } catch (SQLException e) {
            System.out.println("Error ProductDao.getById: " + e.getMessage());
            return null;
        }
    }

    //Metodo que regresa una lista con todos los productos
    public List<Product> getAll() {

        try {
            String sql = "select * from products order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Product> list = new LinkedList<>();
            Product producto;
            while (rs.next()) {
                producto = new Product(rs.getInt("id"));
                producto.setDate(rs.getDate("date"));
                producto.setName(rs.getString("name"));
                producto.setDescription(rs.getString("description"));
                // Add vacante object to the list
                list.add(producto);
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Error ProductDao.getAll: " + e.getMessage());
            return null;
        }
    }

}
