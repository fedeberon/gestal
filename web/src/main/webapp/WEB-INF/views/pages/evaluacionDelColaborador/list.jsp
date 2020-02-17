<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                <th>Rating</th>
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
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <ul class="list-group">
                                                                    <div class="row">
                                                                        <div class="col-md-12">
                                                                            <c:forEach items="${bo.itemEvaluados}" var="item">
                                                                                <li class="list-group-item">${item.value}</li>
                                                                            </c:forEach>
                                                                        </div>
                                                                    </div>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--Fin de modal-->
                                        </td>
                                        <td>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star checked"></span>
                                            <span class="fa fa-star"></span>
                                            <span class="fa fa-star"></span>
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
    <div class="row mt-5">
        <div class="col-md-12">
            <div class="float-right mt-5 mr-5 my-5">
                <a class="btn btn-success" href="<c:url value='/colaborador/create'/>">Nuevo</a>
            </div>
        </div>
    </div>
</div>