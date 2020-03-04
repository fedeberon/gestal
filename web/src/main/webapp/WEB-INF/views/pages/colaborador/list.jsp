<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Colaboradores</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">

                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Mail</th>
                                <th>Editar</th>
                                <th>Rol</th>

                            </thead>
                            <tbody>

                                <c:forEach items="${colaboradores}" var="bo">
                                    <tr>
                                        <td>${bo.name}</td>
                                        <td>${bo.lastName}</td>
                                        <td>${bo.username}</td>
                                        <td>
                                            <a href="<c:url value='/colaborador/update?id=${bo.id}'/>"
                                               class="btn btn-success">Editar</a>
                                        </td>
                                        <td>${bo.rol.name}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer mt-4">
                    <hr>
                    <div class="row">
                        <div class="col-md-6">
                            <form name="colaborador" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-success" href="<c:url value='/colaborador/create'/>"
                               title="Agregar colaborador">Agregar colaborador</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>