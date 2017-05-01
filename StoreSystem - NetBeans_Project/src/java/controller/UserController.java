/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DbConnection;
import dao.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 *
 * @author Oscar Michel Herrera
 */
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User usuario = new User(1);
        usuario.setEmail(email);
        usuario.setPassword(password);

        usuario.setRole(role);
        usuario.setStatus("activo");

        // Procesamos los datos. Guardar en BD
        DbConnection conn = new DbConnection();
        UserDao userDao = new UserDao(conn);
        boolean status = userDao.insert(usuario);

        // Preparamos un mensaje para el usuario
        String msg = "";
        if (status) {
            msg = "EL usuario fue guardado correctamente.";
        } else {
            msg = "Ocurrio un error. El usuario no fue guardado.";
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
