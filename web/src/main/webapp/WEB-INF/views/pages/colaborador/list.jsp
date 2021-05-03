<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-6">
                            <h4 class="card-title"> Colaboradores</h4>
                        </div>
                        <div class="col-md-6">
                            <form class="form-inline" action="<c:url value="/colaborador/search"/> ">
                                <input class="form-control mr-sm-2 w-50" name="value" type="search" placeholder="Buscar colaboradores" aria-label="Search">
                                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="table-responsive-sm">
                        <table class="table">
                            <thead class=" text-primary">

                                <th class="text-center">Nombre completo</th>
                                <th class="text-center">Mail</th>
                                <th class="text-center">Puesto</th>
                                <th class="text-center">Sucursal</th>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Evaluar</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">Dar de alta/baja</th>
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
                                            <c:choose>
                                                <c:when test="${bo.state =='ACTIVE'}">
                                                    <tr>
                                                        <td class="text-center">${bo.name}</td>
                                                        <td class="text-center">${bo.email}</td>
                                                        <td class="text-center">${bo.puesto.name}</td>
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
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td class="text-center">
                                                            <a href="<c:url value='/colaborador/update?id=${bo.id}'/>"
                                                               class="btn btn-secondary">Editar</a>
                                                        </td>
                                                        <td class="text-center">
                                                            <a class="btn btn-success"
                                                               href="<c:url value='../evaluacionDelColaborador/create?id=${bo.id}'/>"
                                                               title="Agregar evaluaci&oacute;n">Evaluar</a>
                                                        </td>
                                                        <td class="text-center">
                                                            <c:choose>
                                                                <c:when test="${bo.state =='ACTIVE'}">
                                                                    <span class="badge badge-success">${bo.state.displayName}</span>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span class="badge badge-danger">${bo.state.displayName}</span>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </td>
                                                        </td>
                                                        <td class="text-center">
                                                            <div class="row">
                                                                <div class="col-md-6 col-3">
                                                                    <a type="button" class="btn btn-sm btn-outline-success btn-round btn-icon float-right" href="<c:url value='/colaborador/alta?id=${bo.id}'/>" title="Dar de alta"><i class="nc-icon nc-simple-add"></i></a>
                                                                </div>

                                                                <div class="col-md-6 col-3">
                                                                    <a type="button" class="btn btn-sm btn-outline-danger btn-round btn-icon float-left" href="<c:url value='/colaborador/baja?id=${bo.id}'/>" title="Dar de baja"><i class="nc-icon nc-simple-delete"></i></a>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:when>
                                                <c:otherwise>
                                                </c:otherwise>
                                            </c:choose>
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
                        <div class="col-md-3">
                            <form name="colaborador" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-3">
                            <a class="btn btn-success" href="<c:url value='/colaborador/create'/>" title="Agregar colaborador">Agregar colaborador</a>
                        </div>
                        <div class="col-md-3">
                            <a class="btn btn-success" href="<c:url value='/colaborador/list'/>" title="Agregar sucursal">Lista completa</a>
                        </div>

                        <div class="col-md-3">
                            <%--<a class="btn btn-primary" href="<c:url value='/colaborador/list'/>" title="Agregar sucursal">Colaboradores inactivos</a>--%>
                            <!-- Large modal -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Colaboradores inactivos</button>

                            <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content p-3">
                                        <table class="table">
                                            <thead class=" text-primary">
                                                <th class="text-center">Nombre completo</th>
                                                <th class="text-center">Puesto</th>
                                                <th class="text-center">Sucursal</th>
                                                <th class="text-center">Estado</th>
                                                <th class="text-center">Dar de alta</th>
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
                                                        <c:choose>
                                                            <c:when test="${bo.state =='INACTIVE'}">
                                                                <tr>
                                                                    <td class="text-center">${bo.name}</td>
                                                                    <td class="text-center">${bo.puesto.name}</td>
                                                                    <td class="text-center">${bo.sucursal.name}</td>
                                                                    <td class="text-center">
                                                                        <c:choose>
                                                                            <c:when test="${bo.state =='ACTIVE'}">
                                                                                <span class="badge badge-success">${bo.state.displayName}</span>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <span class="badge badge-danger">${bo.state.displayName}</span>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </td>
                                                                    </td>
                                                                    <td class="text-center">
                                                                        <div class="row">
                                                                            <div class="col-md-6 col-3">
                                                                                <a type="button" class="btn btn-sm btn-outline-success btn-round btn-icon float-right" href="<c:url value='/colaborador/alta?id=${bo.id}'/>" title="Dar de alta"><i class="nc-icon nc-simple-add"></i></a>
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
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
</div>