<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Editar puesto</h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/puesto/save" />
                    <form:form modelAttribute="puesto" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${puesto.id}'/>

                        <div class="form-style-8">
                            <input type="hidden" name="puesto.id" value="${puesto.id}"/>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess1">Nombre</label>
                                <form:input path="name" size="30" cssClass="form-control" id="inputSuccess1"/>
                                <form:errors path="name" cssClass="error" />
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