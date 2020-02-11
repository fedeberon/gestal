<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Editar a ${colaborador.name}</h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/colaborador/save" />
                    <form:form modelAttribute="colaborador" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${colaborador.id}'/>

                        <div class="form-style-8">
                            <input type="hidden" name="colaborador.id" value="${colaborador.id}"/>
                            <p>
                                <label>Nombre:</label>
                                <form:input path="name" required="required" value="name"/>
                            </p>

                            <p>
                                <label>Apellido:</label>
                                <form:input path="lastName" value="lastName"/>
                            </p>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>