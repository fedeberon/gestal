<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Editar certificado </h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/certificado/save" />
                    <form:form modelAttribute="certificado" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${certificado.id}'/>

                        <div class="form-style-8">
                            <div class="form-group mt-4">
                                <label class="form-control-label">Seleccionar tipo de certificado</label>
                                <form:select path="tipoCertificado" cssClass="form-control">
                                    <form:options items="${tipoCertificados}" itemLabel="displayName" />
                                </form:select>
                            </div>

                            <div class="form-group mt-4">
                            <label class="form-control-label" for="inputSuccess5">Seleccionar colaborador</label>
                                <form:select path="colaborador.id" cssClass="form-control">
                                    <form:options items="${colaboradores}" itemValue="id" itemLabel="name"
                                                  id="inputSuccess5"/>
                                </form:select>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Seleccionar fecha de inicio de la licencia</label>
                                <form:input path="fechaInicio" size="50" autocomplete="off" cssClass="form-control" id="fechaInicio"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">Seleccionar fecha de finalizaci&oacute;n de la licencia</label>
                                <form:input path="fechaFinalizacion" size="50" autocomplete="off" cssClass="form-control" id="fechaFin"/>
                            </div>

                            <div class="form-group mt-4">
                                <label class="form-control-label">D&iacute;as de ausentismo</label>
                                <form:input path="ausentismo" size="50" cssClass="form-control"/>
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