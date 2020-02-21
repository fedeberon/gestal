<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

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
                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <th>Nombre completo</th>
                                <th>Rol</th>
                                <th>Items</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${evaluaciones}" var="bo">
                                    <tr>
                                        <td>${bo.colaborador.lastName} ${bo.colaborador.name}</td>
                                        <td>${bo.rolEvaluado.name}</td>
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
                                                                                            <th width="70%">Items</th>
                                                                                            <th width="30%">Rating</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <td>
                                                                                                <c:forEach items="${bo.itemEvaluados}" var="item">
                                                                                                    <li class="list-group-item">${item.value}</li>
                                                                                                </c:forEach>
                                                                                            </td>
                                                                                            <td>
                                                                                                <div class="rating-star">
                                                                                                    <ul class="list-inline">

                                                                                                        <li class="list-inline-item">
                                                                                                            <span class="fa fa-star checked" id="one"></span>
                                                                                                        </li>

                                                                                                        <li class="list-inline-item">
                                                                                                            <span class="fa fa-star checked" id="two"></span>
                                                                                                        </li>

                                                                                                        <li class="list-inline-item">
                                                                                                            <span class="fa fa-star checked" id="three"></span>
                                                                                                        </li>

                                                                                                        <li class="list-inline-item">
                                                                                                            <span class="fa fa-star" id="four"></span>
                                                                                                        </li>

                                                                                                        <li class="list-inline-item">
                                                                                                            <span class="fa fa-star" id="five"></span>
                                                                                                        </li>

                                                                                                    </ul>
                                                                                                </div>
                                                                                            </td>
                                                                                        </tr>
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
                            <tfoot>
                            <tr>
                                <th>
                                    <div class="mt-5">
                                        <form name="evaluacionDelColaborador" action="list" method="get">
                                            <input type="hidden" name="page" value="${page}"/>
                                            <tags:paginador page="${page}" formName="search"/>
                                        </form>
                                    </div>
                                </th>
                                <th></th>
                                <th></th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>