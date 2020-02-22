<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear un nuevo colaborador</h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/colaborador/save" />
                    <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                        <div class="form-style-8">
                            <input type="hidden" name="colaborador.id" value="${colaborador.id}"/>
                            <p>
                                <label>Nombre:</label>
                                <form:errors path="name" cssClass="error" />
                                <form:input path="name" size="30"/>
                            </p>

                            <p>
                                <label>Apellido:</label>
                                <form:errors path="lastName" cssClass="error"/>
                                <form:input path="lastName" size="30"/>
                            </p>

                            <p>
                                <form:select  path="rol.id" cssClass="form-control mt-3 w-50">
                                    <form:option value="Seleccionar rol" required="true"/>
                                    <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                </form:select>
                            </p>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>