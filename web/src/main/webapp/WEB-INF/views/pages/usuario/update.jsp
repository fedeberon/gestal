<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Editar al usuario <span class="badge badge-success">${usuario.username}</span> </h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/usuario/save" />
                    <form:form modelAttribute="usuario" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${usuario.id}'/>

                        <div class="form-style-8">
                            <input type="hidden" name="usuario.id" value="${usuario.id}"/>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess1">Usuario</label>
                                <form:input path="username" required="required" size="50" cssClass="form-control"/>
                                <form:errors path="username" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <div class="form-group mt-4">
                                    <label class="form-control-label" for="inputSuccess1">Contrase&ntilde;a</label>
                                    <form:input path="password" cssClass="form-control" size="50"/>
                                    <form:errors path="password" cssClass="error" size="50"/>
                                </div>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label" for="inputSuccess1">Mail</label>
                                <form:input path="mail" required="required" size="50" cssClass="form-control"/>
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