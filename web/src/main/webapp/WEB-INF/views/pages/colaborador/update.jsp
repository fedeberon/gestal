<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Editar datos del Colaborador</h4>
                </div>
                <div class="card-body m-auto">
                    <ul class="nav justify-content-center">
                        <li class="nav-item">
                            <a href="<c:url value='/colaborador/update?id=${colaborador.id}'/>" class="nav-link">Editar</a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value='/colaborador/updateUsername?id=${colaborador.id}'/>" class="nav-link">Editar usuario</a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value='/colaborador/updateEmail?id=${colaborador.id}'/>" class="nav-link">Editar mail</a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value='/colaborador/updatePassword?id=${colaborador.id}'/>" class="nav-link">Editar contrase&ntilde;a</a>
                        </li>
                    </ul>

                    <c:url var="actionUrl" value="/colaborador/saveAndUpdate" />
                    <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${colaborador.id}'/>
                        <div class="form-style-8">

                            <div class="form-group mt-4 d-none">
                                <form:input path="password" size="50" cssClass="form-control d-none" id="inputSuccess2" />
                            </div>

                            <div class="form-group mt-4 d-none">
                                <label class="form-control-label" for="inputSuccess1">Nombre de usuario</label>
                                <form:input path="username" size="50" cssClass="form-control" id="inputSuccess1" required="true"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Rol del colaborador:</label>
                                <select name="roles" class="custom-select">
                                    <c:forEach items="${roles}" var="bo" varStatus="status">
                                        <c:choose>
                                            <c:when test="${rolDelColaborador eq 'COLABORADOR'}">
                                                <option value="${bo.id}" selected="true">${bo.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${bo.id}">${bo.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess1">Nombre Completo</label>
                                <form:input path="name" size="50" cssClass="form-control" id="inputSuccess1" required="true"/>
                                <form:errors path="name" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess2">Correo electr&oacute;nico</label>
                                <form:input path="email" size="50" cssClass="form-control" id="inputSuccess2"/>
                                <form:errors path="email" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess3">Seleccionar puesto</label>
                                <form:select  path="puesto.id" cssClass="form-control">
                                    <form:options items="${puestos}" itemValue="id" itemLabel="name" id="inputSuccess3"/>
                                </form:select>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess6">Seleccionar sucursal</label>
                                <form:select path="sucursal.id" cssClass="form-control">
                                    <form:options items="${sucursales}" itemValue="id" itemLabel="name" id="inputSuccess6"/>
                                </form:select>
                            </div>

                            <div class="form-group mt-4">
                                <button type="submit" class="btn btn-secondary" id="btnSubmit">Guardar</button>
                            </div>

                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>