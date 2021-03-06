<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
        <div class="container">
            
            <div class="row">
                <h1>Ejemplo de JdbcTemplate</h1>
                <p>
                    <a href="<c:url value="add" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>E-Mail</th>
                            <th>Teléfono</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}" /></td>
                                <td><c:out value="${dato.nombre}" /></td>
                                <td><c:out value="${dato.correo}" /></td>
                                <td><c:out value="${dato.telefono}" /></td>
                                <td>
                                    <a href="<c:url value="edit?id=${dato.id}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Editar</a>
                                    <a href="<c:url value="delete?id=${dato.id}" />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Borrar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </body>
</html>
<jsp:include page="footer.jsp" />