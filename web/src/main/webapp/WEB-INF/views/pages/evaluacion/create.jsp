<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear Nueva Medici&oacute;n</h4>
                    <hr/>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/evaluacion/"/>
                    <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="inputRole">Seleccionar puesto</label>
                                    <form:select path="puesto.id" cssClass="form-control w-50" style="height: 60px">
                                        <form:options items="${puestos}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="items-evaluacion-inputs">
                                    <div class="row">
                                        <label class="col-12"> # 1 </label>
                                        <div class="col-md-6">
                                            <input type="text" style="height: 60px" id="0" name="items[0].value" placeholder="Nombre del indicador" class="form-control indicador" required>
                                        </div>
                                        <div class="col-md-3">
                                            <select name="items[0].score" id="select_1" class="form-control" style="margin-top: 0px; height: 60px">
                                                <option hidden selected value> Peso </option>
                                                <c:forEach var="i" begin="0" end="10">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-3">
                                            <button type="button" style="height: 60px" class="btn btn-success agregar-item-indicador mt-0">Agregar</button>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="items-consideracion-inputs form-inline" id="0">
                                                <input type="textarea"  style="height: 60px; width: 100%" id="0" name="items[0].consideraciones[0].value" placeholder="Descripci&oacute;n de la categor&iacute;a del indicador" class="form-control categoria-indicador mt-0" required>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-inline">
                                            <input name="items[0].invalidaEvaluacion" class="form-check-input required  mt-2 mr-3" type="checkbox" id="gridCheck1">
                                            <label class="form-check-label" for="gridCheck1">
                                                Envia una alarma al tablero general
                                            </label>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-secondary mt-5 ml-5" id="btnSubmit">Guardar</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


