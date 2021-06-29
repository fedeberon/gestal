<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title"> Crear nueva sucursal</h4>
                    </div>
                    <div class="card-body m-auto">
                        <c:url var="actionUrl" value="/sucursal/save" />
                        <form:form modelAttribute="sucursal" action="${actionUrl}" method="POST">
                            <div class="form-style-8">
                                <input type="hidden" name="sucursal.id" value="${sucursal.id}"/>

                                <div class="form-group mt-4">
                                    <label class="form-control-label" for="inputSuccess1">Nombre</label>
                                    <form:input path="name" size="50" cssClass="form-control" required="true" id="inputSuccess1"/>
                                </div>
                                <div class="form-group mt-4">
                                    <label class="form-control-label" for="inputSuccess1">Direccion</label>
                                    <form:input path="direction" size="50" cssClass="form-control" id="inputSuccess1"/>
                                </div>
                                <div class="form-group mt-4">
                                    <label class="form-control-label" for="inputSuccess1">Telefono</label>
                                    <form:input path="telephone" size="50" cssClass="form-control"  id="inputSuccess1"/>
                                </div>
                                <div class="form-group mt-4">
                                    <label class="form-control-label" for="inputSuccess1">Email</label>
                                    <form:input path="mail" size="50" cssClass="form-control" id="inputSuccess1"/>
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