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

        <%@include file="base/rules_navbar.jsp" %> 
            <br>
            <div>
                <div>
                    <h3>Crear Usuario</h3>
                </div>
                <div class="style-1">
                    <form action="user" method="post">

                        <label for="email">Email</label>
                        <input type="email" name="email" required id="email" value="" placeholder="Escriba el correo"><br>



                        <label for="password">Contraseña</label>
                        <input type="password" name="password" required id="password" value="" placeholder="Escriba contraseña"><br>

                        <label for="role">Tipo de usuario</label><br>
                        <select name="role" required id="role">

                            <option>VENDEDOR</option>
                            <option>GERENTE DE INVENTARIO</option>
                            <option>GERENTE DE VENTAS</option>
                            <option>ADMINISTRADOR</option>

                        </select><br><br>


                        <button type="submit" class="botonguardar" >Guardar</button>
                    </form>
                </div>
            </div>

            <!-- footer -->
            <%@include file="base/footer.jsp" %>

        </div>
    </body>
</html>
