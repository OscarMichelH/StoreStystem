<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>Sistema de ventas y control de inventarios - Store.inc</title>

        <link href="css/grid.css" rel="stylesheet">
        <link href="css/base.css" rel="stylesheet">

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="jumbotron">
                <h3 class="text-center">Store System</h3>
                <nav class="nav">
                    <ul>
                        <li><a href="#" >Inicio</a></li>
                        <li><a href="#">Administración</a></li>
                        <li><a href="#">Acerca</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Formulario para la busqueda. El formulario es enviado por POST al BusquedaController -->
            <form  class="text-left" method ="post" action="#" >
                <div>
                    <input type="text" name="query" required placeholder="Buscar oferta...">
                </div>
                <button type="submit" class="btn">Buscar</button>
            </form>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <h2>¡ENCUENTRA CUALQUIER ARTÍCULO!</h2>
                <!--
                <h4>ESTAMOS CONTRATANDO</h4>
                -->
                <p>Bienvenido a Store System, aquí podrás encontrar ofertas de articulos
                    que sean de gusto para ti.
                    Es muy fácil de usar, solo haz clic en un artículo, ingresa para ver los detalles y envíala solicitud
                    de tu pedido. Nosotros revisaremos tu pedido y posteriormente te contactaremos.<br><br>

                <p><a class="btn" href="producto?action=lista" role="button">Ver más Artículos</a></p>
            </div>

            <h1>Artículos recientes</h1>

            <!-- Example row of columns -->
            <div class="row">
                <c:forEach items="${ultimas}" var="producto" varStatus="status">
                    <div class="col-4">

                        <h3>Producto [${producto.id}]</h3>
                        <p>${producto.name}</p>
                        <p>${producto.description}</p>
                        <p><a href="producto?action=ver&id=${producto.id}" role="button">Ver Detalles&raquo;</a></p>
                    </div>
                </c:forEach>
            </div>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; 2017 My Company, Inc.</p>
            </footer>

        </div> <!-- /container -->

    </body>
</html>
