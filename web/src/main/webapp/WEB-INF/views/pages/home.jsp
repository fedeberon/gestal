<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .highcharts-figure, .highcharts-data-table table {
        min-width: 360px;
        max-width: 800px;
        margin: 1em auto;
    }

    .highcharts-data-table table {
        font-family: Verdana, sans-serif;
        border-collapse: collapse;
        border: 1px solid #EBEBEB;
        margin: 10px auto;
        text-align: center;
        width: 100%;
        max-width: 500px;
    }
    .highcharts-data-table caption {
        padding: 1em 0;
        font-size: 1.2em;
        color: #555;
    }
    .highcharts-data-table th {
        font-weight: 600;
        padding: 0.5em;
    }
    .highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
        padding: 0.5em;
    }
    .highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
        background: #f8f8f8;
    }
    .highcharts-data-table tr:hover {
        background: #f1f7ff;
    }
</style>
<div class="content">
    <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="card card-stats">
                <div class="card-body ">
                    <div class="row">
                        <div class="col-5 col-md-4">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-single-copy-04 text-warning"></i>
                            </div>
                        </div>
                        <div class="col-7 col-md-8">
                            <div class="numbers" style="height: 130px">
                                <p class="card-category">Mediciones mes corriente</p>
                                <p class="card-title">${cantidadEvaluacionesMes}<p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6"  style="height: 130px">
            <div class="card card-stats">
                <div class="card-body ">
                    <div class="row">
                        <div class="col-5 col-md-4">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-money-coins text-success"></i>
                            </div>
                        </div>
                        <div class="col-7 col-md-8" style="height: 130px">
                            <div class="numbers">
                                <p class="card-category">Corrales medidos</p>
                                <p class="card-title"><c:out value="${fn:length(cantColaboradoresEvaluados)}" /><p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="card card-stats">
                <div class="card-body" style="height: 130px">
                    <div class="row">
                        <div class="col-5 col-md-4">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-bullet-list-67 text-danger"></i>
                            </div>
                        </div>
                        <div class="col-7 col-md-8" style="height: 130px">
                            <div class="numbers">
                                <p class="card-category">Cantidad de Mediciones</p>
                                <p class="card-title"><c:out value="${fn:length(evaluaciones)}" /><p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="card card-stats">
                <div class="card-body ">
                    <div class="row">
                        <div class="col-5 col-md-4">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-shop text-primary"></i>
                            </div>
                        </div>
                        <div class="col-7 col-md-8" style="height: 130px">
                            <div class="numbers">
                                <p class="card-category">Sucursales</p>
                                <p class="card-title"><c:out value="${fn:length(sucursales)}" /><p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header ">
                    <h5 class="card-title">Desempe&ntilde;o promedio mensual general </h5>
                </div>
                <div class="card-body ">
                    <div id="graficoScoreEvaluacion" style="width:100%; height:280px"></div>

                    <c:forEach items="${evaluaciones}" var="bo" varStatus="status">
                        <ul class="listaScore d-none">
                            <li class="scoreGraph d-none" id="${status.index}">${bo.resultado}</li>
                        </ul>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="card ">
                <div class="card-header ">
                    <h5 class="card-title">Score informaci&oacute;n</h5>
                </div>
                <div class="card-body ">
                    <div class="row">
                        <div class="col-md-4 card-category">Score en 0</div>
                        <div class="col-md-4 card-category">Score entre 1 y 20</div>
                        <div class="col-md-4 card-category">Score mas de 21</div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 mt-3">${cantidadEvaluacionesEnCero}</div>
                        <div class="col-md-4 mt-3">${cantidadEvaluacionesEntreRango}</div>
                        <div class="col-md-4 mt-3">${cantidadEvaluacionesMayor}</div>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-8">
            <div class="card card-chart">
                <div class="card-header">
                    <h5 class="card-title">Desempe&ntilde;o promedio mensual por Empresa</h5>
                </div>
                <div class="card-body">
                    <div id="graficoSucursal" style="height: 370px; width: 100%;"></div>
                    <c:forEach items="${scorePorSucursal}" var="bo" varStatus="status">
                        <ul class="listaScoreSucursal d-none">
                            <li class="scoreSucursalGraph d-none" id="${bo.key.name}">${bo.value}</li>
                        </ul>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
