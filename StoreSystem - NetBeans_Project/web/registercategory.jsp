<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="favicon.ico">
        <title>Departamento de Recursos Humanos - My Company</title>

        <link href="css/base.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/grid.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
        <script type="text/javascript" src="jquery-1.6.2.min.js"></script>

    </head>

    <body>

        <div class="container">

            <%@include file="base/navbar_admin.jsp" %>


            <br>
            <div>
                <div>
                    <h3>Crear Categoría</h3>
                </div>
                <div class="style-1">
                    <form action="categoria" method="post">

                        <label for="name">Nombre de la caegoria</label>
                        <input type="text" name="category" required id="category" value="" placeholder="Escriba el nombre de la categoría"><br>

                        <button type="submit" class="botonguardar" >Guardar</button>
                    </form>
                </div>
            </div>

            <!-- footer -->
            <%@include file="base/footer.jsp" %>


        </div>
    </body>
</html>
