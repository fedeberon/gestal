<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-md-6">
                            <h4 class="card-title"> Certificados m&eacute;dicos</h4>
                        </div>
                        <div class="col-md-4">
                            <form class="form-inline" action="<c:url value="/certificado/search"/> ">
                                <input class="form-control mr-sm-2 w-50" name="value" type="search" placeholder="Buscar certificado" aria-label="Search">
                                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Buscar</button>

                            </form>
                        </div>
                    </div>
                    </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                            <th>Motivo</th>
                            <th>Nombre del Colaborador</th>
                            <th>Sucursal</th>
                            <th>Fecha de carga</th>
                            <th>Certificados</th>
                            </thead>
                            <tbody>
                            <c:set var = "roles" scope = "session" value = "${certificados}"/>
                            <c:choose>
                                <c:when test="${empty roles}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay certificados para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${certificados}" var="bo">
                                        <tr>
                                            <td>${bo.tipoCertificado.displayName}</td>
                                            <td>${bo.colaborador.name}</td>
                                            <td>${bo.colaborador.sucursal.name}</td>
                                            <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${bo.fechaDeCarga}" /></td>
                                            <td>
                                                <a href="<c:url value='/certificado/show?id=${bo.id}'/>" class="btn btn-secondary" id="on-display-image">Imagenes</a>
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
                            <form name="certificado" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="<c:url value='/certificado/create'/>" title="Agregar rol">Agregar
                                certificado</a>
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="<c:url value='/certificado/list'/>" title="Agregar sucursal">Lista completa</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>