<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

        <title>Punto de Venta</title>
    </head>
    <body>
        <div class="container" >
            <h1>Clientes</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <a href="ClienteControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br><br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Celular</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${clientes}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.correo}</td>
                    <td>${item.celular}</td>
                    <td><a href="ClienteControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="ClienteControlador?action=delete&id=${item.id}"><i class="fa-solid fa-trash"></i></a></td>
                </tr>
                </c:forEach>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>