package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

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

}
