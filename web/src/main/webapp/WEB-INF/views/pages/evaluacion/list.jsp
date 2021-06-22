<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Evaluaciones</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th width="10%" class="text-center">ID</th>
                                <th width="20%" class="text-center">Puesto</th>
                                <th width="10%" class="text-center">Estado</th>
                                <th width="20%" class="text-center">Dar de alta/baja</th>
                                <th width="20%" class="text-center">Items</th>
                            </thead>
                            <tbody>
                            <c:set var = "evaluaciones" scope = "session" value = "${evaluaciones}"/>
                            <c:choose>
                                <c:when test="${empty evaluaciones}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay evaluaciones para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${evaluaciones}" var="bo">
                                        <c:choose>
                                        <c:when test="${bo.state =='ACTIVE'}">
                                        <tr>
                                            <td class="text-center">${bo.id}</td>
                                            <td class="text-center">${bo.puesto.name}</td>
                                            <td class="text-center">

                                                <c:choose>
                                                    <c:when test="${bo.state =='ACTIVE'}">
                                                        <span class="badge badge-success">${bo.state}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="badge badge-danger">${bo.state}</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td class="text-center">
                                                <div class="row">
                                                    <div class="col-md-6 col-3">
                                                        <a type="button" class="btn btn-sm btn-outline-success btn-round btn-icon float-right" href="<c:url value='/evaluacion/activar?id=${bo.id}'/>" title="Dar de baja"><i class="nc-icon nc-simple-add"></i></a>
                                                    </div>

                                                    <div class="col-md-6 col-3">
                                                        <a type="button" class="btn btn-sm btn-outline-danger btn-round btn-icon float-left" href="<c:url value='/evaluacion/desactivar?id=${bo.id}'/>" title="Dar de alta"><i class="nc-icon nc-simple-delete"></i></a>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="text-center">
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".modal-${bo.id}">Items </button>

                                                <!--Comienzo de modal-->
                                                <div class="modal fade modal-${bo.id}">
                                                    <div class="modal-dialog  modal-lg">
                                                        <div class="modal-content p-3">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title">Items</h5>
                                                            </div>
                                                            <table class="table">
                                                                <thead class="thead-light">
                                                                    <tr>
                                                                        <th scope="col text-center">Nombre</th>
                                                                        <th scope="col text-center">Peso del indicador</th>
                                                                        <th scope="col text-center">Invalida evaluaci&oacute;n</th>
                                                                        <th colspan="3" scope="col">Categor&iacute;a de indicador</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <c:forEach items="${bo.items}" var="item">
                                                                    <tr>
                                                                        <td class="p-4">${item.value}</td>
                                                                        <td class="p-4">${item.score}</td>
                                                                        <td class="p-4">
                                                                            <c:choose>
                                                                                <c:when test = "${item.invalidaEvaluacion == true}">
                                                                                    <span class="badge badge-danger">${item.invalidaEvaluacion = 'Si'}</span>
                                                                                </c:when>

                                                                                <c:otherwise>
                                                                                    <span class="badge badge-success">${item.invalidaEvaluacion = 'No'}</span>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </td>
                                                                        <td class="p-4">
                                                                            <!-- Collapse button -->
                                                                            <div>
                                                                                <button class="btn btn-primary btn-sm" type="button" data-toggle="collapse" data-target="#consideraciones-${item.id}"
                                                                                        aria-expanded="false" aria-controls="collapseExample">
                                                                                    Categor&iacute;as de indicador
                                                                                </button>
                                                                            </div>
                                                                            <!-- Collapsible element -->
                                                                            <div class="collapse" id="consideraciones-${item.id}">
                                                                                <ul class="list-group mt-2">
                                                                                    <c:forEach items="${item.consideraciones}" var="consideracion">
                                                                                    <li class="list-group-item">${consideracion.value}</li>
                                                                                    </c:forEach>
                                                                                </ul>
                                                                            </div>
                                                                        </td>
                                                                    </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                            </table>
                                                            <div class="row">
                                                                <div class="col-md-10">
                                                                    <a href="<c:url value='/evaluacion/update?id=${bo.id}'/>" class="btn btn-secondary float-right my-3" title="Editar item">Editar</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--Fin de modal-->
                                            </td>
                                        </tr>
                                        </c:when>
                                        </c:choose>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer">
                    <hr>
                    <div class="row">
                        <div class="col-md-6">
                            <form name="rol" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-6 mb-4">
                            <%--<jsp:include page="create.jsp"/>--%>
                                <a href="<c:url value='/evaluacion/create'/>" class="btn btn-secondary" title="Editar item">Crear evaluaci&oacute;n</a>
                        </div>
                     </div>
                </div>
            </div>
        </div>
    </div>
</div>