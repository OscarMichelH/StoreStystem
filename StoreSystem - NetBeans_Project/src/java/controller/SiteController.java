package controller;

import dao.DbConnection;
import dao.ProductDao;
import dao.UserDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.User;

public class SiteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        RequestDispatcher rd;
        DbConnection conn = new DbConnection();
        ProductDao productoDao = new ProductDao(conn);
        

        List<Product> lista = productoDao.getUltimas();
        conn.disconnect();
        request.setAttribute("ultimas", lista);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
