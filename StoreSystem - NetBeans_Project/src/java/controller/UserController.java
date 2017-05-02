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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 *
 * @author Oscar Michel Herrera
 */
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
         String action = request.getParameter("action");
         ServletContext servletContext = request.getServletContext();
         if("logout".equals(action)){
             //HttpSession session = request.getSession();
             servletContext.removeAttribute("usuario");
             response.sendRedirect(request.getContextPath() + "/homepage");
             return;
             
         }
         
        // Recibimos parametros del formulario de login
        String userParam = request.getParameter("user");
        String passParam = request.getParameter("pass");
        String msg = "";
        // Recuperamos una instancia del objeto HttpSession
        //HttpSession session = request.getSession();

        DbConnection conn = new DbConnection();
        UserDao usuarioDao = new UserDao(conn);
        // Verificamos en la BD, si es un usuario correcto.
        User usuario = usuarioDao.login(userParam, passParam);
        conn.disconnect();

        RequestDispatcher rd;
        if (usuario.getId() > 0) {
            // Creamos una variable de session, con el registro de usuario (Bean)
            // Verificar en el administrador de aplicaciones de tomcat.
            //session.setAttribute("usuario", usuario);
            //session.setMaxInactiveInterval(30*60);
            servletContext.setAttribute("usuario", usuario);
            rd = request.getRequestDispatcher("/homepage");
            rd.forward(request, response);

        } else {
            msg = "Usuario y/o password incorrectos";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

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
