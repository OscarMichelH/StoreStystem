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
        <title>Lista de todas los artículos</title>

        <link href="css/grid.css" rel="stylesheet">
        <link href="css/base.css" rel="stylesheet">

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">


        <style>
            table, th, td {
                border: 1px solid #efeeee;
                text-align: center;
            }
        </style>
    </head>


    <body>

        <div>

            <%@include file="base/navbar_admin.jsp" %>

            <%@include file="base/buscador.jsp" %>

            <div>
                <div>
                    <h3><b>Lista de Articulos</b></h3>
                </div>
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Producto</th>
                                <th>Categoría</th>
                                <th>Stock</th>
                                <th>Publicado</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody align="right">
                            <c:forEach items="${productos}" var="producto" varStatus="status">
                                <tr>
                                    <td>${producto.id}</td>
                                    <td>${producto.name}</td>
                                    <td>${producto.category}</td>
                                    <td>${producto.stock}</td>

                                    <td>${producto.date}</td>
                                    <td>${producto.description}</td>
                                    <td>${producto.price}</td>
                                    <td> <a href="producto?action=ver&id=${producto.id}" role="button">Ver Detalles&raquo;</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

            <!-- Site footer -->
            <%@include file="base/footer.jsp" %>

        </div> <!-- /container -->

    </body>
</html>
