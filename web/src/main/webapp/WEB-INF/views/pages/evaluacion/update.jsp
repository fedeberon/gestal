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

                            <div class="control-group" id="fields">
                                <div class="controls" id="profs">
                                    <label class="control-label" for="field1">Descripci&oacute;n de la evaluaci&oacute;n</label>
                                    <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">
                                        <form:hidden path="items" value='${bo.id}'/>

                                        <div id="field">
                                            <input autocomplete="off" class="input" id="field1" name="items[${status.index}].value" type="text"
                                                       placeholder="Agregar evaluaci&oacute;n" data-items="8" required value="${bo.value}"/>
                                                <button id="b1" class="btn add-more ml-3" type="button">+</button>
                                            </div>
                                    </c:forEach>

                                    <small>Presiona + para agregar la evaluaci&oacute;n</small>
                                    <br>
                                    <form:select path="rol.id" cssClass="form-control mt-3 w-25">
                                        <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                    <br>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>




