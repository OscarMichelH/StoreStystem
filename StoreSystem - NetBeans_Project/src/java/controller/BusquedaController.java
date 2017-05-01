package controller;

import dao.DbConnection;
import dao.ProductDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(name = "BusquedaController", urlPatterns = {"/buscar"})
public class BusquedaController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // Recibimos la cadena de busqueda del usuario
        String q = request.getParameter("query");
        List<Product> lista = null;
        DbConnection conn = new DbConnection();
        // Con nuestro objeto DAO, hacemos la busqueda de vacantes del usaurio
        ProductDao productoDao = new ProductDao(conn);
        lista = productoDao.getByQuery(q);
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("productos", lista);
        rd = request.getRequestDispatcher("/productos.jsp");
        rd.forward(request, response);
    }

}
