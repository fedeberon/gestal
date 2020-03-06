<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
    .rating-header {
        margin-top: -10px;
        margin-bottom: 10px;
    }

</style>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Crear un nueva evaluaci&oacute;n</h4>
                </div>
                <div class="card-body m-auto">
                    <c:url var="actionUrl" value="/evaluacionDelColaborador/save" />
                    <form:form modelAttribute="evaluacionDelColaborador" action="${actionUrl}" method="POST">
                        <div class="form-style-8">
                            <input type="hidden" name="evaluacionDelColaborador.id" value="${evaluacionDelColaborador.id}"/>

                            <div class="form-group mt-4">
                                <h4 class="form-control-label" for="inputSuccess1">${colaborador.name} ${colaborador.lastName}</h4>
                                <input name="colaborador.id" type="hidden" value="${colaborador.id}">
                                <input name="rolEvaluado.id" type="hidden" value="${colaborador.rol.id}">
                            </div>

                            <c:set var = "item" scope = "session" value = "${evaluacion.items}"/>
                            <c:choose>
                                <c:when test="${empty item}">
                                        <p>No hay items para mostrar</p>
                                </c:when>
                                <c:otherwise>
                                    <div class="form-group mt-4">

                                        <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">

                                            <div class="form-group" id="rating-ability-wrapper">

                                                <label class="control-label my-4" for="rating" style="font-size: 16px">
                                                    <span class="field-label-header">Item a evaluar "<strong>${bo.value}</strong>"</span><br>
                                                    <input type="hidden" id="selected_rating-${bo.id}" name="itemEvaluados[${status.index}].rating" value="" required="required">
                                                    <input type="hidden" name="itemEvaluados[${status.index}].item.id" value="${bo.id}"/>
                                                </label>

                                                <h4 class="bold rating-header" style="">
                                                    <span class="selected-rating-${bo.id}">0</span><small> / 5</small>
                                                </h4>
                                                <c:forEach var = "i" begin = "1" end = "5">
                                                    <button type="button" name="items[${bo.id}].value" data-id="${bo.id}" class="btnrating btn btn-default btn-lg" data-attr="${i}" id="rating-star-${bo.id}${i}">
                                                        <i class="fa fa-star" aria-hidden="true"></i>
                                                    </button>
                                                </c:forEach>

                                            </div>

                                        </c:forEach>

                                    </div>

                                </c:otherwise>
                            </c:choose>
                                <div class="form-group mt-4">
                                    <button type="submit" class="btn btn-default" id="btnSubmit">Guardar</button>
                                </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>