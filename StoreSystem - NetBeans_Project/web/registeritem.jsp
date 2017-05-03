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
            <div>
                <div>
                    <h3>Crear Artículo</h3>
                </div>
                <div class="style-1">
                    <form action="producto" method="post">

                        <label for="name">Nombre</label>
                        <input type="text" class="form-control" name="name" required id="name" value="" placeholder="Escriba el nombre de artículo"><br>



                        <label for="quantity">Cantidad</label>
                        <input type="text" class="form-control" name="quantity" required id="quantity" value="" placeholder="Cantidad disponible"><br>


                        <label for="price">Precio</label>
                        <input type="text" class="form-control" name="price" required id="price" value="" placeholder="Escriba el precio"><br>

                        <label for="category">Categoria</label><br>
                        <select name="category" required id="category">
                            <option>Electronicos</option><br>
                            <option>Casa</option><br>
                        </select><br><br>



                        <label for="description">Descripción</label><br>
                        <textarea class="textarea" name="description" id="description" required rows="3" placeholder="Escribe una descripción del producto"></textarea><br>

                        <label for="image_link">Imagen</label><br>
                        <textarea class="textarea" name="image_link" id="image_link" required rows="3" placeholder="Escribe la url del producto"></textarea><br>

                        
                        <button type="submit" class="botonguardar" >Guardar</button>
                    </form>
                </div>
            </div>

            <%@include file="base/footer.jsp" %>

        </div>
    </body>
</html>
