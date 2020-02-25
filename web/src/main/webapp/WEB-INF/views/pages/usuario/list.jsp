<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Usuarios</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>ID</th>
                                <th>Nombre de usuario</th>
                                <th>Email</th>
                                <th>Acciones</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${usuarios}" var="bo">
                                    <tr>
                                        <td>
                                            <a href="<c:url value='/usuario/show?id=${bo.id}'/>" class="btn btn-primary" title="Perfil de usuario">${bo.id}</a>
                                        </td>
                                        <td>${bo.username}</td>
                                        <td>${bo.mail}</td>
                                        <td>
                                            <div class="row">
                                                <div class="col-md-2 mx-2">
                                                    <a href="<c:url value='/usuario/update?id=${bo.id}'/>" class="btn btn-primary" title="Editar usuario">
                                                        <i class="nc-icon nc-ruler-pencil"></i>
                                                    </a>

                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th>
                                <a class="btn btn-success float-right mr-5 mt-5" href="<c:url value='/usuario/create'/>" title="Agregar usuario">Agregar usuario</a>
                            </th>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>