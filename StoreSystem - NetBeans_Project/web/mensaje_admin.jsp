<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>Administración del Sistema</title>

        <link href="css/base.min.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/grid.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

        <%@include file="base/rules_navbar.jsp" %> 

            <div>
                <div>
                    <h3>Sistema</h3>
                </div>
                <div class="panel-body">
                    <h4>${message}</h4>
                </div>
            </div>

            <!-- Footer -->
            <%@include file="base/footer.jsp" %>

        </div> <!-- /container -->

    </body>
</html>
