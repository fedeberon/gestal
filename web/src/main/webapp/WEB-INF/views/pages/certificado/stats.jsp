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
                            <div class="numbers">
                                <p class="card-category">Cantidad de Ausencias en el mes</p>
                                <p class="card-title">${findByAusentismoFechaActual}<p>
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
                                <i class="nc-icon nc-money-coins text-success"></i>
                            </div>
                        </div>
                        <div class="col-7 col-md-8">
                            <div class="numbers">
                                <p class="card-category">Cantidad de ausencias en el a&ntilde;o</p>
                                <p class="card-title">${findByAusentismoAnioActual}<p>
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
                <div class="card-header">
                    <h4 class="card-title"> Cantidad de ausencias por meses (d&iacute;as)</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th class="text-center">Enero</th>
                                <th class="text-center">Febrero</th>
                                <th class="text-center">Marzo</th>
                                <th class="text-center">Abril</th>
                                <th class="text-center">Mayo</th>
                                <th class="text-center">Junio</th>
                                <th class="text-center">Julio</th>
                                <th class="text-center">Agosto</th>
                                <th class="text-center">Septiembre</th>
                                <th class="text-center">Octubre</th>
                                <th class="text-center">Noviembre</th>
                                <th class="text-center">Diciembre</th>
                            </thead>
                            <tbody>
                            <c:set var = "certificados" scope = "session" value = "${certificados}"/>
                            <c:choose>
                                <c:when test="${empty colaboradores}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay certificados para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                        <tr>
                                            <c:choose>
                                                <c:when test="${empty findByAusentismoEnero}">
                                                    <td class="text-center">No hay registros</td>

                                                </c:when>
                                                <c:otherwise>
                                                    <td class="text-center">${findByAusentismoEnero}</td>
                                                </c:otherwise>
                                            </c:choose>

                                            <td class="text-center">${findByAusentismoFebrero}</td>
                                            <td class="text-center">${findByAusentismoMarzo}</td>
                                            <td class="text-center">${findByAusentismoAbril}</td>
                                            <td class="text-center">${findByAusentismoMayo}</td>
                                            <td class="text-center">${findByAusentismoJunio}</td>
                                            <td class="text-center">${findByAusentismoJulio}</td>
                                            <td class="text-center">${findByAusentismoAgosto}</td>
                                            <td class="text-center">${findByAusentismoSeptiembre}</td>
                                            <td class="text-center">${findByAusentismoOctubre}</td>
                                            <td class="text-center">${findByAusentismoNoviembre}</td>
                                            <td class="text-center">${findByAusentismoDiciembre}</td>
                                        </tr>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Cantidad de ausencias por colaborador (d&iacute;as)</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th width="50%">Nombre del colaborador</th>
                                <th width="50%" class="text-center">Cantidad de ausencias</th>
                            </thead>
                            <tbody>
                            <c:set var = "certificados" scope = "session" value = "${certificados}"/>
                            <c:choose>
                                <c:when test="${empty colaboradores}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay certificados para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${findByAusentismoColaborador}" var="bo">
                                        <tr>
                                            <td>${bo.key.name}</td>
                                            <td class="text-center">${bo.value}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Cantidad de ausencias por sucursal (d&iacute;as)</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                                <th width="50%">Nombre de la sucursal</th>
                                <th width="50%" class="text-center">Cantidad de ausencias</th>
                            </thead>
                            <tbody>
                            <c:set var = "certificados" scope = "session" value = "${colaboradores}"/>
                            <c:choose>
                                <c:when test="${empty certificados}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay certificados para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${findByAusentismoSucursal}" var="bo">
                                        <tr>
                                            <td>${bo.key.name}</td>
                                            <td class="text-center">${bo.value}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Motivos predominantes</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
                            <th width="50%">Nombre del motivo</th>
                            <th width="50%" class="text-center">Cantidad de ausencias</th>
                            </thead>
                            <tbody>
                            <c:set var = "certificados" scope = "session" value = "${certificados}"/>
                            <c:choose>
                                <c:when test="${empty certificados}">
                                    <tr>
                                        <td colspan="5" class="text-center">
                                            <p class="mt-5">No hay certificados para mostrar</p>
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${findByAusentismoMotivo}" var="bo">
                                        <tr>
                                            <td>${bo.key.displayName}</td>
                                            <td class="text-center">${bo.value}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

