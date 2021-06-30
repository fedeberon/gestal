<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title"> Crear Nueva Evaluaci&oacute;n</h4>
                    </div>
                    <div class="card-body m-auto">
                        <c:url var="actionUrl" value="/evaluacion/"/>
                        <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                            <div class="row mt-5">
                                <div class="col-md-12">
                                    <div class="items-evaluacion-inputs">
                                        <div class="row">
                                            <div class="col-md-3">
                                                <input type="text" id="0" name="items[0].value" placeholder="Nombre del indicador" class="form-control indicador" required>
                                            </div>
                                            <div class="col-md-2">
                                                <select name="items[0].score" id="select_1" class="form-control margin-button">
                                                    <option hidden selected value> Peso del indicador</option>
                                                    <c:forEach var="i" begin="0" end="10">
                                                        <option value="${i}">${i}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-md-3">
                                                <button type="button" class="btn btn-success agregar-item-indicador">Agregar nuevo indicador</button>
                                            </div>
                                            <div class="col-md-12">
                                                <div class="items-consideracion-inputs form-inline" id="0">
                                                    <input type="text" id="0" name="items[0].consideraciones[0].value" placeholder="Descripci&oacute;n de la categor&iacute;a del indicador" class="form-control categoria-indicador w-50 mr-3" required>
                                                    <input name="items[0].invalidaEvaluacion" class="form-check-input required" type="checkbox" id="gridCheck1">
                                                    <label class="form-check-label" for="gridCheck1">
                                                        Invalida la evaluaci&oacute;n
                                                    </label>
                                                    <button type="button" class="btn btn-success agregar-item-consideracion ml-3">Agregar item</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group mt-5">
                                        <label for="inputRole">Seleccionar puesto</label>
                                        <form:select path="puesto.id" cssClass="form-control w-50">
                                            <form:options items="${puestos}" itemValue="id" itemLabel="name"/>
                                        </form:select>
                                    </div>
                                </div>
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