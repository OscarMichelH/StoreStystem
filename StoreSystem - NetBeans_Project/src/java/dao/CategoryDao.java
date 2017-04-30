package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

public class CategoryDao {

    DbConnection conn;

    public CategoryDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(Category categoria) {

        String sql = "INSERT INTO categories VALUES (?,?)";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, categoria.getId());
            ps.setString(2, categoria.getName());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Category> getCategories() {

        try {
            String sql = "select * from categories";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Category> list = new LinkedList<>();
            Category categoria;
            while (rs.next()) {
                categoria = new Category(rs.getInt("id"));
                categoria.setName(rs.getString("name"));

                // Add vacante object to the list
                list.add(categoria);
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Error CategoryDao.getByQuery: " + e.getMessage());
            return null;
        }
    }

}
