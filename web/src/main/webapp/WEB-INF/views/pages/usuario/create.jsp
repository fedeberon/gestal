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
                                <label class="form-control-label">Email:</label>
                                <form:input path="mail" cssClass="form-control" size="50"/>
                                <form:errors path="mail" cssClass="error" size="50"/>
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


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Button trigger modal -->
<button type="button" class="btn btn-success mx-5 my-3 float-right" data-toggle="modal"
        data-target="#exampleModalCenter">Crear nueva evaluaci&oacute;n
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Agregar usuario</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card" data-spy="scroll">
                                <div class="card-body">
                                    <div class="form-group">
                                        <div class="container">
                                            <div class="row">
                                                <input type="hidden" name="count" value="1"/>
                                                <c:url var="actionUrl" value="/usuario/save"/>
                                                <form:form modelAttribute="usuario" action="${actionUrl}" method="POST">
                                                    <div class="form-style-8">
                                                        <input type="hidden" name="usuario.id" value="${usuario.id}"/>

                                                        <p>
                                                            <label>Usuario:</label>
                                                            <form:input path="username" required="required"/>
                                                        </p>

                                                        <p>
                                                            <label>Password:</label>
                                                            <form:input path="password" required="required"/>
                                                        </p>

                                                        <p>
                                                            <label>Mail:</label>
                                                            <form:input path="mail" required="required"/>
                                                        </p>
                                                        <button type="submit" class="btn btn-primary">Guardar</button>

                                                    </div>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>