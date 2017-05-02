/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Prueba {

   
    public static void main(String[] args) {
       DbConnection conn = new DbConnection();
        UserDao usuarioDao = new UserDao(conn);
        // Verificamos en la BD, si es un usuario correcto.
        User usuario = usuarioDao.login("oscarmichelh@gmail.com", "12345");
        System.out.println(usuario);
        conn.disconnect();

    }
    
}
