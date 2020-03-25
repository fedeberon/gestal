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
                    <div class="table-responsive-sm">
                        <table class="table">
                            <thead class=" text-primary">

                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Mail</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Sucursal</th>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Evaluar</th>

                            </thead>
                            <tbody>
                                <c:set var = "colaborador" scope = "session" value = "${colaboradores}"/>
                                <c:choose>
                                    <c:when test="${empty colaborador}">
                                        <tr>
                                            <td colspan="7" class="text-center">
                                                <p class="mt-5">No hay colaboradores para mostrar</p>
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${colaboradores}" var="bo">
                                            <tr>
                                                <td class="text-center">${bo.name}</td>
                                                <td class="text-center">${bo.lastName}</td>
                                                <td class="text-center">${bo.username}</td>
                                                <td class="text-center">${bo.rol.name}</td>
                                                <td class="text-center">

                                                    <button type="button" class="btn btn-primary" data-toggle="modal"
                                                            data-target=".modal-${bo.id}">SUCURSAL
                                                    </button>

                                                    <!--Comienzo de modal-->
                                                    <div class="modal fade modal-${bo.id}">
                                                        <div class="modal-dialog  modal-lg">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title">Datos de la sucursal</h5>
                                                                </div>
                                                                <div class="row">
                                                                    <div class="col-md-12">
                                                                        <div class="row">
                                                                            <div class="col-md-3 my-3">
                                                                                <strong>Nombre</strong>
                                                                            </div>
                                                                            <div class="col-md-3 my-3">
                                                                                <strong>Direcci&oacute;n</strong>
                                                                            </div>
                                                                            <div class="col-md-3 my-3">
                                                                                <strong>Tel&eacute;fono</strong>
                                                                            </div>
                                                                            <div class="col-md-3 my-3">
                                                                                <strong>mail</strong>
                                                                            </div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-3 my-3">${bo.sucursal.name}</div>
                                                                            <div class="col-md-3 my-3">${bo.sucursal.direction}</div>
                                                                            <div class="col-md-3 my-3">${bo.sucursal.telephone}</div>
                                                                            <div class="col-md-3 my-3">${bo.sucursal.mail}</div>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-10">
                                                                                <a href="<c:url value='/evaluacion/update?id=${bo.id}'/>"
                                                                                   class="btn btn-success float-right my-3"
                                                                                   title="Editar item">Editar</a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-center">
                                                    <a href="<c:url value='/colaborador/update?id=${bo.id}'/>"
                                                       class="btn btn-success">Editar</a>
                                                </td>
                                                <td class="text-center">
                                                    <a class="btn btn-success"
                                                       href="<c:url value='../evaluacionDelColaborador/create?id=${bo.id}'/>"
                                                       title="Agregar evaluaci&oacute;n">Evaluar</a>
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
                        <div class="col-md-6">
                            <form name="colaborador" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-success" href="<c:url value='/colaborador/create'/>" title="Agregar colaborador">Agregar colaborador</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>