<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Evaluaciones</h4>
                </div>
                <div class="card-body">
                    <input type="hidden" name="count" value="1"/>
                    <c:url var="actionUrl" value="/evaluacion/"/>
                    <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                        <form:hidden path="id" value='${evaluacion.id}'/>
                        <div class="form-style-8"></div>

                            <div class="form-group mt-4">
                                <div class="control-group" id="fields">
                                        <%--<div id="field">--%>
                                            <%--<input autocomplete="off" class="input" id="field1"--%>
                                                   <%--name="items[${status.index}].value" type="text"--%>
                                                   <%--placeholder="Agregar evaluaci&oacute;n" data-items="8" required--%>
                                                   <%--value="${bo.value}"/>--%>
                                            <%--<button id="b1" class="btn add-more ml-3" type="button">+</button>--%>
                                        <%--</div>--%>

                                        <div class="container"style="max-width: 700px;">

                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div id="inputFormRow">
                                                            <label class="control-label" for="field1"><h4>Descripci&oacute;n de la evaluaci&oacute;n</h4></label>

                                                                <div class="input-group mb-3">
                                                                    <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">
                                                                    <form:hidden path="items" value='${bo.id}'/>
                                                                        <input type="text" name="items[${status.index}].value" class="form-control border border-secondary" placeholder="Enter title" autocomplete="off" value="${bo.value}">
                                                                        <div class="input-group-append ml-3">
                                                                            <button id="removeRow" type="button" class="btn btn-danger">Eliminar</button>
                                                                        </div>
                                                                    </c:forEach>
                                                                </div>

                                                        </div>

                                                        <div id="newRow"></div>
                                                        <button id="addRow" type="button" class="btn btn-info">Agregar item</button>
                                                    </div>
                                                </div>
                                        </div>

                                    <small>Presiona + para agregar la evaluaci&oacute;n</small>
                                    <br>
                                </div>
                            </div>
                    <div class="form-group mt-4">

                                <form:select path="rol.id" cssClass="form-control mt-3 w-25">
                                    <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                </form:select>
                                <br>
                            </div>
                            <div class="form-group mt-4">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>




