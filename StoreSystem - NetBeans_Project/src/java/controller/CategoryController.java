package controller;

import com.google.gson.Gson;
import dao.CategoryDao;
import dao.DbConnection;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

public class CategoryController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf8");
        DbConnection conn = new DbConnection();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String query = request.getParameter("q");
        CategoryDao categoryDao = new CategoryDao(conn);
        List<Category> results = categoryDao.getCategories();
        String jsonResults = new Gson().toJson(results);
        out.print(jsonResults);
      
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Se obtinene parametros
        String nombre = request.getParameter("category");
        //String nombre = "Ropa";

        //Se crea el objeto
        Category categoria = new Category(2);
        categoria.setName(nombre);

        // Procesamos los datos. Guardar en BD
        DbConnection conn = new DbConnection();
        CategoryDao categoriaDao = new CategoryDao(conn);
        boolean status = categoriaDao.insert(categoria);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "La categoria fue guardada correctamente.";
        } else {
            msg = "Ocurrio un error. La categoria no fue guardada.";
        }
        conn.disconnect();
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta. Renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);
    }

}
