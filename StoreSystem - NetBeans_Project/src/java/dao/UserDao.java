package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

public class UserDao {

    DbConnection conn;

    public UserDao(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insert(User usuario) {

        String sql = "INSERT INTO users VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRole());
            ps.setString(5, usuario.getStatus());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public User login(String email, String pass) {

        try {
            String sql = "select * from users where email=? and password = ? and status='activo' limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            User usuario = new User(0);
            while (rs.next()) {
                // Create an object for the user
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRole(rs.getString("role"));
                usuario.setStatus(rs.getString("status"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.login: " + e.getMessage());
            return null;
        }
    }

}
