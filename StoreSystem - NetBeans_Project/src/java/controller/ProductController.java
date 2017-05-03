package controller;

import dao.DbConnection;
import dao.ProductDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        System.out.println("Accese al metodo get");

        if ("ver".equals(action)) {
            this.verDetalle(request, response);
        } else if ("lista".equals(action)) {
            this.verTodas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("name");
        String scantidad = request.getParameter("quantity");
        int cantidad = Integer.parseInt(scantidad);
        String sprecio = request.getParameter("price");
        float precio = Float.parseFloat(sprecio);
        String category = request.getParameter("query");
        //String category = "Casa";
        String descripcion = request.getParameter("description");
        String image_ling = request.getParameter("image_link");

        Product articulo = new Product(2);
        articulo.setName(nombre);
        articulo.setStock(cantidad);
        articulo.setPrice(precio);
        articulo.setCategory(category);
        articulo.setDescription(descripcion);
        articulo.setImage_link(image_ling);

        // Procesamos los datos. Guardar en BD
        DbConnection conn = new DbConnection();
        ProductDao itemDao = new ProductDao(conn);
        boolean status = itemDao.insert(articulo);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "El producto fue guardado correctamente.";
        } else {
            msg = "Ocurrio un error. El producto no fue guardado.";
        }
        conn.disconnect();
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta. Renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);

    }

    protected void verDetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recibimos id de la vacante a consultar
        int idProducto = Integer.parseInt(request.getParameter("id"));
        System.out.println(idProducto);
        DbConnection conn = new DbConnection();
        ProductDao productoDao = new ProductDao(conn);
        Product producto = productoDao.getById(idProducto);
        conn.disconnect();

        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("producto", producto);
        RequestDispatcher rd;

        // Enviarmos respuesta. Renderizamos la vista detalle.jsp
        rd = request.getRequestDispatcher("/detail.jsp");
        rd.forward(request, response);
    }

    protected void verTodas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbConnection conn = new DbConnection();
        ProductDao productoDao = new ProductDao(conn);
        List<Product> lista = productoDao.getAll();
        conn.disconnect();
        // Compartimos la variable lista, para poder accederla desde la vista
        HttpSession session = request.getSession();
        request.setAttribute("usuario", session.getAttribute("usuario"));
        
        request.setAttribute("productos", lista);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/productos.jsp");
        rd.forward(request, response);
    }

}
