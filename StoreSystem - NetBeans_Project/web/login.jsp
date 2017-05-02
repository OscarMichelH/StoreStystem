<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Ingresar</title>


        <link href="css/base.min.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/grid.css" rel="stylesheet">

    </head>
    
    <style>
        #rcorners1 {
    border-radius: 25px;
    border: 2px solid #73AD21;
    padding: 20px; 
    width: 250px;
    height: 320px; 
        }
    </style>

    <body>
        <div class="row">
            <div class="col-4"><p></p></div>
            <div class="col-4">
                <center>
                    <img src="images/lock.png"><br>
                    <h3>Store System</h3>

                    <form class="form-signin" method="get" action="user">
                        <h2 class="form-signin">Ingreso al sistema</h2>
                        <label for="user">Email</label>
                        <input type="text" id="user" name="user" class="form-control" placeholder="Escriba nombre de usuario" required autofocus><br>
                        <label for="pass">Password</label>
                        <input type="password" id="pass" name="pass" class="form-control" placeholder="Escriba su password" required>
                        <p class="">${message}</p>
                        <button class="botonguardar" type="submit">Login</button>
                    </form>
                        <br>
                        <div id="rcorners1">
                    <h5>Administrador: administrador@mail.com</h5>
                    <h5>Vendedor: vendedor@mail.com</h5>
                    <h5>Gerente de ventas: gerentedeventas@mail.com</h5>
                    <h5>Gerente de inventario: gerentedeinventario@mail.com</h5>
                    <h5>Pass: 12345</h5>
                    
                    </div>
                </center>
            </div> <!-- /container -->
        </div>
    </body>
</html>