<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 24/3/20
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Editar Sucursal <span class="badge badge-success">${sucursal.name}</span> </h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/sucursal/save" />
                    <form:form modelAttribute="sucursal" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${sucursal.id}'/>

                        <div class="form-style-8">
                            <input type="hidden" name="usuario.id" value="${sucursal.id}"/>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Nombre:</label>
                                <form:input path="name" size="50" cssClass="form-control text-uppercase"/>
                                <form:errors path="name" cssClass="error" />
                            </div>
                            <div class="form-group mt-4">
                                <label class="form-control-label">Direccion:</label>
                                <form:input path="direction" cssClass="form-control text-uppercase" size="50"/>
                                <form:errors path="direction" cssClass="error" size="50"/>
                            </div>
                            <div class="form-group mt-4">
                                <label class="form-control-label">Telefono:</label>
                                <form:input path="telephone" cssClass="form-control text-uppercase" size="50"/>
                                <form:errors path="telephone" cssClass="error" size="50"/>
                            </div>
                            <div class="form-group mt-4">
                                <label class="form-control-label">Email:</label>
                                <form:input path="mail" cssClass="form-control text-uppercase" size="50"/>
                                <form:errors path="mail" cssClass="error" size="50"/>
                            </div>

                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>