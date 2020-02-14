<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Evaluaciones</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-condensed">
                            <thead class=" text-primary">
                                <th class="text-center">ID</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Items</th>
                                <th class="text-center">Estado</th>
                                <th>Dar de baja/alta</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${evaluaciones}" var="bo">
                                    <tr>
                                        <td class="text-center">${bo.id}</td>
                                        <td class="text-center">${bo.rol.name}</td>
                                        <td class="text-center">
                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".modal-${bo.id}">Items </button>

                                            <!--Comienzo de modal-->
                                            <div class="modal fade modal-${bo.id}">
                                                <div class="modal-dialog  modal-lg">
                                                    <div class="modal-content">
                                                        <div class="row">
                                                            <div class="col-md-12">
                                                                <ul class="list-group">
                                                                    <div class="row">
                                                                        <div class="col-md-12">
                                                                            <c:forEach items="${bo.items}" var="item">
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
                                                <div class="col-md-2 mx-2">
                                                    <a class="text-success" href="<c:url value='/evaluacion/activar?id=${bo.id}'/>" title="Dar de baja">
                                                        <i class="nc-icon nc-simple-add"></i>
                                                    </a>
                                                </div>
                                                <div class="col-md-2 mx-2">
                                                    <a class="text-danger" href="<c:url value='/evaluacion/desactivar?id=${bo.id}'/>" title="Dar de alta">
                                                        <i class="nc-icon nc-simple-delete"></i>
                                                    </a>

                                                </div>
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
    <div class="row mt-5">
        <div class="col-md-12">
            <div class="float-right mt-5 mr-5 my-5">
                <a class="btn btn-success" href="<c:url value='/evaluacion/create'/>">Nuevo</a>
                <jsp:include page="modal/create.jsp"/>
            </div>
        </div>
    </div>


</div>