<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 24/3/20
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Empresas</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                            <th>Nombre</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>Mail</th>
                            <th>Editar</th>
                            <th>Dar de baja</th>
                            </thead>
                            <tbody>
                            <c:set var = "sucursales" scope = "session" value = "${sucursales}"/>
                            <c:choose>
                                <c:when test="${empty sucursales}">
                                    <tr>
                                        <td colspan="7" class="text-center">
                                            <p class="mt-5">No hay sucursales para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${sucursales}" var="bo">
                                        <c:choose>
                                        <c:when test="${bo.state =='ACTIVE'}">
                                            <tr>
                                                <td>${bo.name}</td>
                                                <td>${bo.direction}</td>
                                                <td>${bo.telephone}</td>
                                                <td>${bo.mail}</td>
                                                <td>
                                                    <a href="<c:url value='/sucursal/update?id=${bo.id}'/>" class="btn btn-secondary">Editar</a>
                                                </td>
                                                <td>
                                                    <a type="button" class="btn btn-sm btn-outline-danger btn-round btn-icon float-left" href="<c:url value='/sucursal/desactivar?id=${bo.id}'/>" title="Dar de baja"><i class="nc-icon nc-simple-delete"></i></a>
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
                <div class="card-footer mt-4">
                    <hr>
                    <div class="row">
                        <div class="col-md-4">
                            <form name="rol" action="list" method="get">
                                <input type="hidden" name="page" value="${page}"/>
                                <tags:paginador page="${page}" formName="search"/>
                            </form>
                        </div>
                        <div class="col-md-4">
                            <a class="btn btn-success" href="<c:url value='/sucursal/create'/>" title="Agregar sucursal">Agregar Empresa</a>
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
