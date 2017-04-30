/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.DbConnection;
import dao.ProductDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.json.simple.JSONObject;

import model.Product;

/**
 *
 * @author bmbrina
 */
public class SearchController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf8");
       DbConnection conn = new DbConnection();
       response.setContentType("application/json");
       PrintWriter out = response.getWriter();
       String query = request.getParameter("q");
       String searchType = request.getParameter("searchType");
       
       ProductDao productoDao = new ProductDao(conn);
       
       List<Product> results; 
       
       if("articulo".equals(searchType)){
         results = productoDao.getByQuery(query);
       } else {
         results = productoDao.getByCategory(query);
       }
       
       String jsonResults = new Gson().toJson(results);
       out.print(jsonResults);

    }
    

}
