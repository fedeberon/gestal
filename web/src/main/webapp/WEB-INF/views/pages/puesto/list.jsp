<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Tipo de Establecimiento</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>Nombre</th>
                                <th>Editar</th>
                            </thead>
                            <tbody>
                            <c:set var = "puestos" scope = "session" value = "${puestos}"/>
                            <c:choose>
                                <c:when test="${empty puestos}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay establecimentos para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${puestos}" var="bo">
                                        <tr>
                                            <td>${bo.name}</td>
                                            <td>
                                                <a href="<c:url value='/puesto/update?id=${bo.id}'/>" class="btn btn-secondary">Editar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>


                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer mt-4">
                    <hr>
                    <div class="row">
                        <div class="col-md-4">
                            <form name="puesto" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="<c:url value='/puesto/create'/>" title="Agregar puesto">Agregar
                                Nuevo Tipo</a>
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="<c:url value='/colaborador/create'/>" title="Agregar colaborador">Agregar
                                Corral</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>