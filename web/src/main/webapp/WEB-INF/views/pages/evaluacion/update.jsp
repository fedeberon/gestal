<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title"> Editar evaluaci&oacute;n</h4>
                    </div>
                    <div class="card-body">
                    <input type="hidden" name="count" value="1"/>
                    <c:url var="actionUrl" value="/evaluacion/saveAndUpdate"/>
                    <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
<%--                    <form:hidden path="id" value='${evaluacion.id}'/>--%>
                        <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">
                            <input type="hidden" class="posicion-indicador" value="${status.index}">
                            <div class="contenedor-indicador">
                                <h6 class="mt-5">Indicador</h6>
                                <div class="row">
                                    <div class="col">
<%--                                        <form:hidden path="items" value='${bo.id}'/>--%>
                                        <form:input path="items[${status.index}].value" cssClass="form-control mt-3" required="true" id="inputSuccess1"/>
                                    </div>
                                    <div class="col">
                                        <button class="btn btn-outline-danger" id="borrar-indicador" type="button">Borrar</button>
                                        <button class="btn btn-outline-success" id="agregar-indicador" type="button">Agregar</button>
                                    </div>
                                </div>

                                <h6 class="mt-5">Categor&iacute;as del indicador</h6>
                                <c:forEach items="${bo.consideraciones}" var="consideracion" varStatus="statusConsideracion">
                                    <input type="hidden" class="categoria-indicador" value="${statusConsideracion.index}">
                                    <div class="item-consideraciones">
                                        <div class="row">
                                            <div class="col">
                                                <form:hidden path="items[${status.index}].consideraciones[${statusConsideracion.index}].id" value='${consideracion.id}'/>
                                                <form:input path="items[${status.index}].consideraciones[${statusConsideracion.index}].value" size="30" cssClass="form-control mt-2 consideracion" required="true"/>
                                            </div>
                                            <div class="col">
                                                <button class="btn btn-outline-danger" id="borrar-categoria-indicador" type="button">Borrar</button>
                                                <button class="btn btn-outline-success" id="agregar-categoria-indicador" type="button">Agregar</button>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                        <div class="row">
                            <div class="col-md-12">
                                <h6 class="mt-3">Seleccionar puesto</h6>
                                <form:select path="puesto.id" cssClass="form-control mt-3 w-75">
                                    <form:options items="${puestos}" itemValue="id" itemLabel="name"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary mt-5">Guardar</button>
                            </div>
                        </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
