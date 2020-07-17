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
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Editar</th>
                            </thead>
                            <tbody>
                            <c:set var = "usuario" scope = "session" value = "${usuarios}"/>
                            <c:choose>
                                <c:when test="${empty usuario}">
                                    <tr>
                                        <td colspan="4" class="text-center">
                                            <p class="mt-5">No hay usuarios para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${usuarios}" var="bo">
                                        <tr>
                                            <td>
                                                <a href="<c:url value='/usuario/show?id=${bo.id}'/>" class="btn btn-primary" title="Perfil de usuario">${bo.id}</a>
                                            </td>
                                            <td>${bo.username}</td>
                                            <td>
                                                <a href="<c:url value='/usuario/update?id=${bo.id}'/>" class="btn btn-secondary" title="Editar usuario">
                                                    Editar
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer mt-5">
                    <hr>
                    <div class="row">
                        <div class="col-md-6">
                            <form name="colaborador" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-success" href="<c:url value='/usuario/create'/>" title="Agregar usuario">Agregar usuario</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>