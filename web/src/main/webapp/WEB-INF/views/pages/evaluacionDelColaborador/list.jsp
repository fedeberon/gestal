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
                    <h4 class="card-title"> Evaluaciones de los colaboradores</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>Nombre completo</th>
                                <th>Rol</th>
                                <th>Fecha de carga</th>
                                <th>Promedio</th>
                                <th>Items</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${evaluaciones}" var="bo">
                                    <tr>
                                        <td>${bo.colaborador.lastName} ${bo.colaborador.name}</td>
                                        <td>${bo.rolEvaluado.name}</td>
                                        <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short"
                                            value="${bo.fechaDeCarga}" />
                                        </td>
                                        <td>

                                        </td>>
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
                                                                                        <th width="70%" class="text-center">Items</th>
                                                                                        <th width="30%" class="text-center">Rating</th>
                                                                                    </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                    <c:forEach items="${bo.itemEvaluados}" var="itemEvaluado">
                                                                                        <tr>
                                                                                            <td class="text-center">
                                                                                                ${itemEvaluado.item.value}
                                                                                            </td>
                                                                                            <td>
                                                                                                <div class="rating-star">
                                                                                                    <ul class="list-inline">
                                                                                                        <li class="list-inline-item">
                                                                                                            <c:set var = "score" scope = "session" value = "${itemEvaluado.rating}"/>
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
                    </div>
                    <div class="col-md-6"></div>
                </div>
            </div>
        </div>
    </div>
</div>