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
                    <c:url var="actionUrl" value="/colaborador/saveAndUpdate" />
                    <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${colaborador.id}'/>
                        <div class="form-style-8">

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess1">Nombre de usuario</label>
                                <form:input path="username" size="50" cssClass="form-control" id="inputSuccess1" required="true"/>
                            </div>

                            <div class="form-group mt-4 d-none">
                                <label class="form-control-label">Contrase&ntilde;a:</label>
                                <form:input path="password" cssClass="form-control" size="50"/>
                                <form:errors path="password" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Rol del colaborador:</label>
                                <select name="roles" class="custom-select">
                                    <c:forEach items="${roles}" var="bo" varStatus="status">
                                        <option value="${status.count}">${bo.name}</option>
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
                                <form:input path="email" size="50" cssClass="form-control" id="inputSuccess2" required="true"/>
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