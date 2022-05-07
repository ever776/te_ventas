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
            
            <h1>Formulario de Ventas</h1>
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas"/>
            </jsp:include>
            <br>
            <form action="VentaControlador" method="post" >
                <input type="hidden" name="id" value="${venta.id}" >
                <div class="mb-3">
                    <label for="nombre" class="form-label">Cliente</label>                    
                    <select name="cliente_id" class="form-label">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_clientes}">                        
                            <option value="${item.id}" 
                                    <c:if test="${venta.cliente_id == item.id}">
                                        selected
                                    </c:if> >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="correo" class="form-label">Producto</label>                    
                    <select name="producto_id" class="form-label">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_productos}">                        
                        <option value="${item.id}" <c:if test="${venta.producto_id == item.id}">
                                        selected
                                    </c:if> >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="celular" class="form-label">Fecha</label>
                    <input type="text" name="fecha" value="${venta.fecha}" class="form-control" id="celular" >
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>
                
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
