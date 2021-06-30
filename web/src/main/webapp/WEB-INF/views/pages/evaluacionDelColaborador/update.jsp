<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
    .rating-header {
        margin-top: -10px;
        margin-bottom: 10px;
    }
    /* The switch - the box around the slider */
    .switch {
        position: relative;
        display: inline-block;
        width: 60px;
        height: 34px;
    }

    /* Hide default HTML checkbox */
    .switch input {
        opacity: 0;
        width: 0;
        height: 0;
    }

    /* The slider */
    .slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
    }

    .slider:before {
        position: absolute;
        content: "";
        height: 26px;
        width: 26px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
    }

    input:checked + .slider {
        background-color: #2196F3;
    }

    input:focus + .slider {
        box-shadow: 0 0 1px #2196F3;
    }

    input:checked + .slider:before {
        -webkit-transform: translateX(26px);
        -ms-transform: translateX(26px);
        transform: translateX(26px);
    }

    /* Rounded sliders */
    .slider.round {
        border-radius: 34px;
    }

    .slider.round:before {
        border-radius: 50%;
    }
    @media (max-width: 400px) {
        .slider-check {
            width: 66px;
        }
    }

    @media (max-width: 1000px) {
        .slider-check {
            width: 66px;
        }
    }

    @media (max-width: 1400px) {
        .slider-check {
            width: 66px;
        }
    }

    @media (max-width: 1800px) {
        .slider-check {
            width: 66px;
        }
    }


</style>
    <div class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="card m-auto">
                    <div class="card-body">
                        <c:url var="actionUrl" value="/evaluacionDelColaborador/saveAndUpdate" />
                        <form:form modelAttribute="evaluacionDelColaborador" action="${actionUrl}" method="POST">
                            <form:hidden path="id" value='${evaluacionDelColaborador.id}'/>
                            <form:hidden path="colaborador.id" value='${evaluacionDelColaborador.colaborador.id}'/>
                            <form:hidden path="colaborador.puesto.id" value='${evaluacionDelColaborador.colaborador.puesto.id}'/>
                        <div class="form-style-8">
                                <div class="form-group mt-4">
                                    <h4 class="form-control-label" for="inputSuccess1">${evaluacionDelColaborador.colaborador.name}</h4>
                                </div>

                                <c:set var = "item" scope = "session" value = "${evaluacionDelColaborador.itemEvaluados}"/>
                                <c:choose>
                                    <c:when test="${empty item}">
                                        <p>No hay items para mostrar en el puesto ${colaborador.puesto.name}</p>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-group mt-4">

                                            <c:forEach items="${evaluacion.items}" var="bo" varStatus="status">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="card border-dark mt-5">
                                                            <div class="card-body">
                                                                <h5 class="card-title">
                                                                    <span class="field-label-header">Item a evaluar "<strong>${bo.value}</strong>"</span><br>
                                                                    <input type="hidden" name="itemEvaluados[${status.index}].item.id" value="${bo.id}"/>
                                                                    <input type="hidden" name="itemEvaluados[${status.index}].item.score" value="${bo.score}"/>
                                                                </h5>
                                                                <div class="form-group" id="rating-ability-wrapper">
                                                                    <c:forEach items="${bo.consideraciones}" var="consideracion" varStatus="statusConsideracion">
                                                                        <input type="hidden" name="itemEvaluados[${status.index}].consideracionItemEvaluados[${statusConsideracion.index}].id"/>
                                                                        <input type="hidden" name="itemEvaluados[${status.index}].consideracionItemEvaluados[${statusConsideracion.index}].consideracion.id" value="${consideracion.id}"/>
                                                                    </c:forEach>
                                                                    <c:set var = "itemEvaluado" scope = "session" value = "${evaluacionDelColaborador.itemEvaluados[0]}"/>
                                                                    <c:forEach items="${itemEvaluado.consideracionItemEvaluados}" var="consideracionItemEvaluados" varStatus="">
                                                                        <div class="row">
                                                                            <div class="col-md-6">
                                                                                <label class="control-label my-4" for="rating" style="font-size: 16px">
                                                                                    <span class="field-label-header">Consideracion a evaluar "<strong>${consideracionItemEvaluados.consideracion.value}</strong>"</span><br>
                                                                                </label>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <c:choose>
                                                                                    <c:when test="${consideracionItemEvaluados.checkeado == 'true'}">
                                                                                        <div class="p-4 check-input">

                                                                                            <label class="switch col-1 mt-2">
                                                                                                <input name="itemEvaluados[${itemEvaluado.item.id}].consideracionItemEvaluados[${consideracionItemEvaluados.consideracion.id}].checkeado" class="selected-rating-consideracion${bo.id}" id="getClass${bo.id}" type="checkbox" onclick="getChecked(${bo.id});" checked>
                                                                                                <span class="slider round slider-check"></span>
                                                                                            </label>
                                                                                        </div>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <div class="p-4 check-input">

                                                                                            <label class="switch col-1 mt-2">
                                                                                                <input name="itemEvaluados[${itemEvaluado.item.id}].consideracionItemEvaluados[${consideracionItemEvaluados.consideracion.id}].checkeado" class="selected-rating-consideracion${bo.id}" id="getClass${bo.id}" type="checkbox" onclick="getChecked(${bo.id});">
                                                                                                <span class="slider round slider-check"></span>
                                                                                            </label>
                                                                                        </div>
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </div>
                                                                        </div>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <div class="form-group mt-4">
                                <c:if test="${!empty item}">
                                    <button type="submit" class="btn btn-default" id="btnSubmit">Finalizar Evaluaci&oacute;n</button>
                                </c:if>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>