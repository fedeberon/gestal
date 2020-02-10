<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear un nuevo colaborador</h4>
                </div>
                <div class="card-body">
                    <c:url var="actionUrl" value="/colaborador/save" />
                    <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                        <div class="form-style-8">
                            <input type="hidden" name="colaborador.id" value="${colaborador.id}"/>
                            <p>
                                <label>Nombre:</label>
                                <form:input path="name" required="required"/>
                            </p>

                            <p>
                                <label>Apellido:</label>
                                <form:input path="lastName"/>
                            </p>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>