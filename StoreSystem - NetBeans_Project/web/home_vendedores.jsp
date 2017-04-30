<%-- 
    Document   : home_vendedores
    Created on : Apr 29, 2017, 5:26:28 PM
    Author     : bmbrina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedores</title>
        <link href="css/grid.css" rel="stylesheet">
        <link href="css/base.css" rel="stylesheet">

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <script src="https://use.fontawesome.com/7daea4c729.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="js/utils.js"></script>
    </head>
    <body>
        <div class="container">
            <%@include file="base/navbar_vendedor.jsp" %>
            <div id="searchField" style="display:none;">
                
                <p>Búsqueda por:</p>
                <input type="radio" name="param" value="articulo" onClick="toggleSearchType()" checked> Artículo
                <input type="radio" name="param" value="categoria" onClick="toggleSearchType()"> Categoría<br>
                
           
                    <div id="searchBar">
                        <input type="text" name="query" required placeholder="Buscar...">
                    </div>
                    <select id="categories" name="query" style="display:none;">
                        <option value="">Selecciona una categoría</option>
                    </select>
                
                    <button class="btn" onClick="searchProducts()">Buscar</button>
  
                
                
                
                    <br>
                    <br>
                    
                <section>
                    <div id="productsLabel" style="display:none;" >
                        Se encontraron <span id="productCount" >0</span> productos con tu búsqueda
                    </div>
                    
                    <table id="products" style="display:none;">
                    <thead>
                      <th>ID</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Categoría</th>
                    <th>Descripción</th>
                    <th>Imagen</th>  
                    </thead>
                    
                    <tbody id="productsBody">
                        
                    </tbody>
                    
                </table>
                </section>
                
            </div>
        </div>
    </body>
</html>