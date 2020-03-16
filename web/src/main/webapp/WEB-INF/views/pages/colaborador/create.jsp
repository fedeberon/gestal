<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title"> Crear un nuevo colaborador</h4>
            </div>
            <div class="card-body m-auto">
                <c:url var="actionUrl" value="/colaborador/save"/>
                <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                    <div class="form-style-8">
                        <input type="hidden" name="colaborador.id" value="${colaborador.id}"/>

                        <div class="form-group mt-4">
                            <label class="form-control-label" for="inputSuccess1">Mail</label>
                            <form:input path="username" size="50" cssClass="form-control" id="inputSuccess1"/>
                            <form:errors path="username" cssClass="error" size="50"/>
                        </div>

                        <div class="form-group mt-4">
                            <label class="form-control-label" for="inputSuccess1">Contrase&ntilde;a</label>
                            <form:password path="password"  size="50" cssClass="form-control" id="inputSuccess1"/>
                            <form:errors path="password" cssClass="error" size="50"/>
                        </div>


                        <div class="form-group mt-4">
                            <label class="form-control-label" for="inputSuccess1">Nombre</label>
                            <form:input path="name" size="50" cssClass="form-control" id="inputSuccess1"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>

                        <div class="form-group mt-4">
                            <label class="form-control-label" for="inputSuccess2">Apellido</label>
                            <form:input path="lastName" size="50" cssClass="form-control" id="inputSuccess2"/>
                            <form:errors path="lastName" cssClass="error"/>
                        </div>

                        <div class="row">

                            <div class="col-md-9">
                                <div class="form-group">
                                    <label class="form-control-label" for="inputSuccess3">Seleccionar rol</label>
                                    <form:select path="rol.id" cssClass="form-control">
                                        <form:options items="${roles}" itemValue="id" itemLabel="name"
                                                      id="inputSuccess3"/>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group mt-4">
                                <a class="btn btn-secondary ml-auto" href="<c:url value='/rol/create'/>">Crear rol</a>
                                <button type="submit" class="btn btn-secondary" id="btnSubmit">Guardar</button>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
