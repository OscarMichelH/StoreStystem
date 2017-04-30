<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>Detalle del articulo - ${producto.name}</title>

        <link href="css/grid.css" rel="stylesheet">
        <link href="css/base.css" rel="stylesheet">

        <link href="css/signin.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->

            <%@include file="base/navbar_admin.jsp" %>
            <%@include file="base/buscador.jsp" %>

            <div class="panel panel-primary">
                <h3> Nombre:     ${producto.name} </h3>
                <div class="panel-heading">
                    <h3 class="panel-title">ID: ${producto.id}</h3>
                </div>
                <div class="panel-body">
                    <h5><b>Vacante</b>: ${producto.name}</h5>
                    <h5><b>Publicado</b>: ${producto.date}</h5>
                    <b>Descripción:</b><br>
                    <p class="text-justify">${producto.description}</p>

                    <p><a title="Agregrar a la factura." href="producto?action=enviarCV&id=${producto.id}" role="button">Agregar al carrito</a></p>
                </div>

            </div>
            <!-- Site footer -->
            <%@include file="base/footer.jsp" %>

        </div> <!-- /container -->

    </body>
</html>
