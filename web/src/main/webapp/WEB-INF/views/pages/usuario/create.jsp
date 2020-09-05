<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .errorUser{
        color: red;
    }
</style>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear un nuevo usuario</h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/usuario/save"/>
                    <form:form modelAttribute="usuario" action="${actionUrl}" method="POST">

                        <div class="form-style-8">
                            <input type="hidden" name="usuario.id" value="${usuario.id}"/>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Usuario:</label>
                                <form:input path="username" cssClass="form-control" size="50"/>
                                <form:errors path="username" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Contrase&ntilde;a:</label>
                                <form:password path="password" cssClass="form-control" size="50"/>
                                <form:errors path="password" cssClass="error" size="50"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Rol del usuario:</label>
                                <select name="roles" class="custom-select">
                                    <c:forEach items="${roles}" var="bo" varStatus="status">
                                        <option value="${status.count}">${bo.name}</option>
                                    </c:forEach>
                                </select>
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