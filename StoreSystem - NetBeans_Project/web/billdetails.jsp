
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>Detalle de la factura</title>

        <link href="css/grid.css" rel="stylesheet">
        <link href="css/base.css" rel="stylesheet">

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">

        <style>
            #botoneliminar {
                background-color: #d95050;
                padding: 8px;
                color: white;
                text-decoration: none;
                font-weight: bold;
                border: 1px solid rgba(12,151,0,1);
                border-radius: 6px;
            }
        </style>
    </head>



    <body>

        <div class="container">

            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->

        <%@include file="base/rules_navbar.jsp" %> 
            
            <h2>Artículos en la factura</h2>

            <div>
                <table>
                    <thead>
                        <tr>
                            <th class="left">Qty</th>
                            <th class="left">ID</th>
                            <th>Producto</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${facturas}" var="producto" varStatus="status">
                            <tr>
                                <td>${producto.getKey()}</td>
                                <td >${producto.getValue().id}</td>
                                <td>${producto.getValue().name}</td>
                                <td>${producto.getValue().description}</td>
                                <td>${producto.getValue().price}</td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
                <label>Total: ${total}</label><br><br>
            </div>

            <div class="row">
                <form action="bill" method="post">
                    <button type="submit" class="botonguardar" >Comprar</button>
                    <a id="botoneliminar" href="bill?action=eliminar">Vaciar Carrito</a>
                </form>

                <!-- Site footer -->
                <%@include file="base/footer.jsp" %>
            </div>
        </div> <!-- /container -->

    </body>
</html>
