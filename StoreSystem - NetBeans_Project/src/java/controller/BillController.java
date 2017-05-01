package controller;

import dao.BillDao;
import dao.DbConnection;
import dao.ProductDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.Product;

public class BillController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DbConnection conn = new DbConnection();
        BillDao billDao = new BillDao(conn);

        Bill factura = billDao.getById(0);
        conn.disconnect();

        System.out.println("Factura temporal: " + factura);

        List<Product> productos = factura.getProducts();
        List<Integer> quantities = factura.getQuantities();

        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");

        if ("agregar".equals(action)) {
            this.agregarProducto(request, response, productos, quantities);
        } else if ("eliminar".equals(action)) {
            this.vaciarCarrito(request, response, true);
        } else if ("ver".equals(action)) {
            this.verDetalle(request, response, productos, quantities);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Conexion a la bd
        DbConnection conn = new DbConnection();
        BillDao billDao = new BillDao(conn);

        List<Product> productos = billDao.getById(0).getProducts();
        List<Integer> cantidades = billDao.getById(0).getQuantities();

        //Se vacia el carrito tras la compra
        this.vaciarCarrito(request, response, false);

        Bill factura = new Bill(1);
        factura.setProducts(productos);
        factura.setQuantities(cantidades);

        //Obtenemos el total del costo de los productos
        float total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += ((productos.get(i).getPrice()) * cantidades.get(i));
        }

        factura.setTotal(total);

        // Procesamos los datos. Guardar en BD
        boolean status = billDao.insert(factura);
        //Una vez almacenada la lista se vacia para una nueva factura
        productos.clear();
        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "La factura fue guardada correctamente.";
        } else {
            msg = "Ocurrio un error. La factura no fue guardada.";
        }
        conn.disconnect();
        RequestDispatcher rd;
        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        request.setAttribute("message", msg);
        // Enviarmos respuesta. Renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje_admin.jsp");
        rd.forward(request, response);

    }

    protected void agregarProducto(HttpServletRequest request, HttpServletResponse response, List<Product> productos, List<Integer> cantidades) throws ServletException, IOException {

        // Recibimos id del producto qque agregaremos
        int idProducto = Integer.parseInt(request.getParameter("id"));
        int iCantidad = Integer.parseInt(request.getParameter("quantity"));

        DbConnection conn = new DbConnection();
        ProductDao productoDao = new ProductDao(conn);

        Product producto = productoDao.getById(idProducto);
        System.out.println(producto);

        productos.add(producto);

        //Actualizar la factura temporal
        BillDao billDao = new BillDao(conn);
        String ids = "";
        String quantities = "";
        for (int i = 0; i < productos.size(); i++) {
            ids += productos.get(i).getId();
            ids += " ";
        }

        for (int i = 0; i < cantidades.size(); i++) {
            quantities += Integer.toString(cantidades.get(i));
            quantities += " ";
        }

        quantities += Integer.toString(iCantidad);

        billDao.modifyProductsById(ids, quantities, 0);

        boolean status = true;

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

    protected void verDetalle(HttpServletRequest request, HttpServletResponse response, List<Product> productos, List<Integer> cantidades) throws ServletException, IOException {

        // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
        LinkedHashMap<Integer, Product> shuffle = new LinkedHashMap<Integer, Product>();

        //Calculo del total
        float total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += ((productos.get(i).getPrice()) * cantidades.get(i));

            shuffle.put(cantidades.get(i), productos.get(i));
        }

        request.setAttribute("facturas", shuffle);
        request.setAttribute("total", total);

        RequestDispatcher rd;

        // Enviarmos respuesta. Renderizamos la vista detalle.jsp
        rd = request.getRequestDispatcher("/billdetails.jsp");
        rd.forward(request, response);
    }

    protected void vaciarCarrito(HttpServletRequest request, HttpServletResponse response, boolean confirmacion) throws ServletException, IOException {

        DbConnection conn = new DbConnection();
        BillDao billDao = new BillDao(conn);

        billDao.modifyProductsById(" ", " ", 0);
        // Preparamos un mensaje para el usuario
        String msg = "";
        if (confirmacion) {
            msg = "El carrito se ha vaciado correctamente.";
            RequestDispatcher rd;
            // Compartimos la variable msg, para poder accederla desde la vista con Expression Language
            request.setAttribute("message", msg);
            // Enviarmos respuesta. Renderizamos la vista mensaje.jsp
            rd = request.getRequestDispatcher("/mensaje_admin.jsp");
            rd.forward(request, response);

        }

    }

}
