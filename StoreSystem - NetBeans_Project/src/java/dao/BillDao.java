package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.Product;

public class BillDao {

    DbConnection conn;

    public BillDao(DbConnection conn) {
        this.conn = conn;
    }

    public BillDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean insert(Bill factura) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");

        String sql = "INSERT INTO bills VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            ps.setInt(1, factura.getId());
            ps.setString(2, format.format(factura.getDate()));
            ps.setString(3, formatTime.format(factura.getTime().getTime()));
            ps.setString(4, factura.getIdProducts());
            ps.setString(5, factura.getQuantityProducts());
            ps.setFloat(6, factura.getTotal());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Bill getById(int idFactura) {
        try {
            String sql = "select * from bills where id=? limit 1";
            PreparedStatement preparedStatement = conn.getConnection()
                    .prepareStatement(sql);
            preparedStatement.setInt(1, idFactura); // Set idVacante
            ResultSet rs = preparedStatement.executeQuery();
            Bill factura = new Bill(1);
            System.out.println("Query by Id succesfull");
            while (rs.next()) {
                // Create an object for the movie
                factura.setId(rs.getInt("id"));
                factura.setDate(rs.getDate("date"));

                //Formato en horas
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getTime("time"));

                factura.setTime(cal);

                //Procesamiento del string de IDs de la base de datos para recuperar
                //los productos en una lista de objetos del mismo
                String ids = rs.getString("products");

                String[] idProductos = ids.split("\\s+");

                Product producto;
                DbConnection con = new DbConnection();
                ProductDao productoDao = new ProductDao(con);
                List<Product> listaProductos = new ArrayList<Product>();

                for (int i = 0; i < idProductos.length; i++) {

                    producto = new Product(Integer.parseInt(idProductos[i]));

                    producto = productoDao.getById(producto.getId());
                    //System.out.println(producto);

                    listaProductos.add(producto);
                }

                factura.setProducts(listaProductos);

                //
                String cantidades = rs.getString("quantities");

                String[] quantities = cantidades.split("\\s+");

                List<Integer> listaCantidades = new ArrayList<Integer>();
                for (int i = 0; i < quantities.length; i++) {
                    listaCantidades.add(Integer.parseInt(quantities[i]));

                }

                factura.setQuantities(listaCantidades);

            }
            return factura;

        } catch (SQLException e) {
            System.out.println("Error ProductDao.getById: " + e.getMessage());
            return null;
        }
    }

    public void modifyProductsById(String idProductos, String cantidades, int idFactura) {
        try {
            String sql = "UPDATE bills SET products = ? , quantities = ? WHERE ID = ?";
            PreparedStatement preparedStatement = conn.getConnection()
                    .prepareStatement(sql);

            preparedStatement.setString(1, idProductos);
            preparedStatement.setString(2, cantidades);
            preparedStatement.setInt(3, idFactura);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error BillDao.modifyProductsById: " + e.getMessage());
        }
    }

        public Bill getUltimo() {
        try {
            String sql = "select * from products order by id desc limit 1";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
 
            ResultSet rs = preparedStatement.executeQuery();
            Bill factura = new Bill(rs.getInt("id"));
            System.out.println("Query by Id succesfull");
            while (rs.next()) {
                // Create an object for the movie
                factura.setId(rs.getInt("id"));
                factura.setDate(rs.getDate("date"));

                //Formato en horas
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getTime("time"));

                factura.setTime(cal);

                //Procesamiento del string de IDs de la base de datos para recuperar
                //los productos en una lista de objetos del mismo
                String ids = rs.getString("products");

                String[] idProductos = ids.split("\\s+");

                Product producto;
                DbConnection con = new DbConnection();
                ProductDao productoDao = new ProductDao(con);
                List<Product> listaProductos = new ArrayList<Product>();

                for (int i = 0; i < idProductos.length; i++) {

                    producto = new Product(Integer.parseInt(idProductos[i]));

                    producto = productoDao.getById(producto.getId());
                    //System.out.println(producto);

                    listaProductos.add(producto);
                }

                factura.setProducts(listaProductos);

                //
                String cantidades = rs.getString("quantities");

                String[] quantities = cantidades.split("\\s+");

                List<Integer> listaCantidades = new ArrayList<Integer>();
                for (int i = 0; i < quantities.length; i++) {
                    listaCantidades.add(Integer.parseInt(quantities[i]));

                }

                factura.setQuantities(listaCantidades);

            }
            return factura;

        } catch (SQLException e) {
            System.out.println("Error ProductDao.getById: " + e.getMessage());
            return null;
        }
    }
    
}
