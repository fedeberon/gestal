<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="path/to/font-awesome.min.css">
<style>
    .checked {
        color: orange;
    }

</style>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-6">
                            <h4 class="card-title"> Evaluaciones de los colaboradores</h4>
                        </div>
                        <div class="col-md-6">
                            <form class="form-inline" action="<c:url value="/evaluacionDelColaborador/search"/> ">
                                <input class="form-control mr-sm-2 w-50" name="value" type="search" placeholder="Buscar evaluaci&oacute;nes" aria-label="Search">
                                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>ID</th>
                                <th>Nombre completo</th>
                                <th>Puesto</th>
                                <th>Fecha de carga</th>
                                <th class="text-center">Sucursal</th>
                                <th>Items</th>
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
                                        <tr>
                                            <td>${bo.id}</td>
                                            <td>${bo.colaborador.name}</td>
                                            <td>${bo.rolEvaluado.name}</td>
                                            <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${bo.fechaDeCarga}" /></td>
                                            <td class="text-center">

                                                <!-- Large modal -->
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".modal-${bo.id}">SUCURSAL</button>

                                                <div class="modal fade modal-${bo.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content p-5">
                                                            <table class="table">
                                                                <thead class="thead-light">
                                                                <tr>
                                                                    <th scope="col">Nombre</th>
                                                                    <th scope="col">Direcci&oacute;n</th>
                                                                    <th scope="col">Tel&eacute;fono</th>
                                                                    <th scope="col">Correo Electr&oacute;nico</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr>
                                                                    <th>${bo.colaborador.sucursal.name}</th>
                                                                    <td>${bo.colaborador.sucursal.direction}</td>
                                                                    <td>${bo.colaborador.sucursal.telephone}</td>
                                                                    <td>${bo.colaborador.sucursal.mail}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>

                                            <td>
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".evaluacionDelColaborador-${bo.id}">Items </button>

                                                <!--Comienzo de modal-->
                                                <div class="modal fade evaluacionDelColaborador-${bo.id}">
                                                    <div class="modal-dialog  modal-lg">
                                                        <div class="modal-content">
                                                            <div class="content">
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <div class="card">
                                                                            <div class="card-header">
                                                                                <h4 class="card-title">Evaluaci&oacute;n del colaborador</h4>
                                                                            </div>
                                                                            <div class="card-body">
                                                                                <div class="table-responsive-md">
                                                                                    <table class="table">
                                                                                        <thead class="text-primary">
                                                                                        <tr>
                                                                                            <th class="text-center" width="10%">Items</th>
                                                                                            <%--<th width="15%" class="text-center">Rating Estrellas</th>--%>
                                                                                            <th class="text-center" width="70%">Consideraciones</th>
                                                                                            <th class="text-center" width="20%">Rating</th>
                                                                                        </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                        <c:forEach items="${bo.itemEvaluados}" var="itemEvaluado">

                                                                                            <tr>
                                                                                                <td class="text-center">
                                                                                                    ${itemEvaluado.item.value}
                                                                                                </td>
                                                                                                <%--<td class="text-center">--%>
                                                                                                    <%--<div class="rating-star">--%>
                                                                                                        <%--<ul class="list-inline">--%>
                                                                                                            <%--<li class="list-inline-item">--%>
                                                                                                                <%--<c:set var = "score" scope = "session" value = "${itemEvaluado.rating}"/>--%>
                                                                                                                <%--<c:set var = "resto" scope = "session" value = "${5-score}"/>--%>
                                                                                                                <%--<c:forEach begin="1" end="${score}" varStatus="count">--%>
                                                                                                                    <%--<span id="score" class="fa fa-star checked"></span>--%>
                                                                                                                <%--</c:forEach>--%>
                                                                                                                <%--<c:forEach begin="1" end="${resto}" varStatus="count">--%>
                                                                                                                    <%--<span id="score" class="fa fa-star"></span>--%>
                                                                                                                <%--</c:forEach>--%>


                                                                                                            <%--</li>--%>
                                                                                                        <%--</ul>--%>
                                                                                                    <%--</div>--%>
                                                                                                <%--</td>--%>
                                                                                                <%--<td class="text-center">--%>
                                                                                                <td class="text-center">
                                                                                                    <!-- Collapse buttons -->
                                                                                                    <div>
                                                                                                        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#consideraciones-${itemEvaluado.id}"
                                                                                                                aria-expanded="false" aria-controls="collapseExample">
                                                                                                            Consideraciones
                                                                                                        </button>
                                                                                                    </div>
                                                                                                    <!-- / Collapse buttons -->

                                                                                                    <!-- Collapsible element -->
                                                                                                    <div class="collapse" id="consideraciones-${itemEvaluado.id}">
                                                                                                        <div class="mt-3">
                                                                                                            <table class="table table-striped">
                                                                                                                <thead>
                                                                                                                <tr>
                                                                                                                    <th scope="col">Descripci&oacute;n de la consideraci&oacute;n</th>
                                                                                                                    <th scope="col">Checkeado</th>
                                                                                                                </tr>
                                                                                                                </thead>
                                                                                                                <tbody>

                                                                                                                <c:forEach items="${itemEvaluado.consideracionItemEvaluados}" var="consideracionItemEvaluado">
                                                                                                                    <tr class="table-info">
                                                                                                                        <td class="p-3">${consideracionItemEvaluado.consideracion.value}</td>
                                                                                                                        <td class="p-3">
                                                                                                                            <c:choose>
                                                                                                                                <c:when test = "${consideracionItemEvaluado.checkeado == true}">
                                                                                                                                    <span class="badge badge-success">${consideracionItemEvaluado.checkeado = 'Si'}</span>
                                                                                                                                </c:when>

                                                                                                                                <c:otherwise>
                                                                                                                                    <span class="badge badge-danger">${consideracionItemEvaluado.checkeado = 'No'}</span>
                                                                                                                                </c:otherwise>
                                                                                                                            </c:choose>
                                                                                                                        </td>
                                                                                                                    </tr>
                                                                                                                </c:forEach>
                                                                                                                </tbody>
                                                                                                            </table>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                </td>
                                                                                                <td class="text-center">
                                                                                                    <div class="rating-star">
                                                                                                        <ul class="list-inline">
                                                                                                            <li class="list-inline-item">
                                                                                                                <c:set var = "score" scope = "session" value = "${itemEvaluado.valorConsideracionItemEvaluados}"/>
                                                                                                                <c:set var = "resto" scope = "session" value = "${5-score}"/>
                                                                                                                <c:forEach begin="1" end="${score}" varStatus="count">
                                                                                                                    <span id="score" class="fa fa-star checked"></span>
                                                                                                                </c:forEach>
                                                                                                                <c:forEach begin="1" end="${resto}" varStatus="count">
                                                                                                                    <span id="score" class="fa fa-star"></span>
                                                                                                                </c:forEach>
                                                                                                            </li>
                                                                                                        </ul>
                                                                                                    </div>
                                                                                                </td>
                                                                                            </tr>
                                                                                        </c:forEach>
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>
                                                                            </div>
                                                                            <div class="card-footer">
                                                                                <div class="row">
                                                                                    <div class="col-md-6"></div>
                                                                                    <div class="col-md-6">
                                                                                        <span class="badge badge-secondary text-center text-uppercase float-right">
                                                                                            <%--<c:forEach items="${bo.itemEvaluados}" var="itemEvaluadoo">--%>
                                                                                                <%--<c:if test="${itemEvaluadoo.item.invalidaEvaluacion eq true}">--%>
                                                                                                <%--<continue>--%>
                                                                                                <%--Score: ${bo.resultado * 0}--%>
                                                                                                <%--</c:if>--%>
                                                                                                <%--Score: ${bo.resultado}--%>
                                                                                            <%--</c:forEach>--%>
                                                                                            Score: ${bo.resultado}


                                                                                        </span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--Fin de modal-->
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>

                        </table>
                    </div>
                </div>
                <div class="card-footer">
                    <hr>
                    <div class="row mt-4">
                        <div class="col-md-6">
                            <form name="evaluacionDelColaborador" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-success" href="<c:url value='/evaluacionDelColaborador/list'/>" title="Agregar sucursal">Lista completa</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

