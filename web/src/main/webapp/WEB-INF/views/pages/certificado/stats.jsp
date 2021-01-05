<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="col-md-6 col-sm-6">
            <div class="card card-stats">
                <div class="card-body ">
                    <div class="row">
                        <div class="col-5 col-md-3">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-single-copy-04 text-warning"></i>
                            </div>
                        </div>
                        <div class="col-3 col-md-9">
                            <div class="numbers">
                                <p class="card-category text-left mt-3">Cantidad de Ausencias en el mes</p>
                            </div>
                        </div>
                        <div class="col-12 col-md-12">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Colaborador</th>
                                            <th>Fecha Inicio</th>
                                            <th>Fecha Finalizaci&oacute;n</th>
                                            <th>Detalles</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${obtenerRegistrosMesActual}" var="bo">
                                        <tr>
                                            <td>${bo.colaborador.name}</td>
                                            <td>${bo.fechaInicio}</td>
                                            <td>${bo.fechaFinalizacion}</td>
                                            <td>

                                                <!-- Large modal -->
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".datosColaboradorDelMes-${bo.id}">Detalles</button>

                                                <div class="modal fade datosColaboradorDelMes-${bo.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content" style="width: 150% !important; padding: 4%">
                                                            <table class="table">
                                                                <thead>
                                                                <tr>
                                                                    <th class="text-center">ID</th>
                                                                    <th class="text-center">Colaborador</th>
                                                                    <th class="text-center">Motivo</th>
                                                                    <th class="text-center">Sucursal</th>
                                                                    <th class="text-center">Puesto</th>
                                                                    <th class="text-center">Fecha Inicio</th>
                                                                    <th class="text-center">Fecha Finalizaci&oacute;n</th>
                                                                    <th class="text-center">Cantidad de dias de ausentismo</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr class="text-center">
                                                                    <th>${bo.id}</th>
                                                                    <td>${bo.colaborador.name}</td>
                                                                    <td>${bo.tipoCertificado.displayName}</td>
                                                                    <td>${bo.colaborador.sucursal.name}</td>
                                                                    <td>${bo.colaborador.puesto.name}</td>
                                                                    <td>${bo.fechaInicio}</td>
                                                                    <td>${bo.fechaFinalizacion}</td>
                                                                    <td>${bo.ausentismo}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-sm-6">
            <div class="card card-stats">
                <div class="card-body ">
                    <div class="row">
                        <div class="col-5 col-md-3">
                            <div class="icon-big text-center icon-warning">
                                <i class="nc-icon nc-money-coins text-success"></i>
                            </div>
                        </div>
                        <div class="col-3 col-md-9">
                            <div class="numbers">
                                <p class="card-category text-left mt-3">Cantidad de ausencias en el a&ntilde;o</p>
                            </div>
                        </div>
                        <div class="col-12 col-md-12">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Colaborador</th>
                                        <th>Fecha Inicio</th>
                                        <th>Fecha Finalizaci&oacute;n</th>
                                        <th>Detalles</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${obtenerRegistrosAnoActual}" var="bo">
                                        <tr>
                                            <td>${bo.colaborador.name}</td>
                                            <td>${bo.fechaInicio}</td>
                                            <td>${bo.fechaFinalizacion}</td>
                                            <td>

                                                <!-- Large modal -->
                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".datosColaboradorDelAno-${bo.id}">Detalles</button>

                                                <div class="modal fade datosColaboradorDelAno-${bo.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content" style="width: 150% !important; padding: 4%">
                                                            <table class="table">
                                                                <thead>
                                                                <tr>
                                                                    <th class="text-center">ID</th>
                                                                    <th class="text-center">Colaborador</th>
                                                                    <th class="text-center">Motivo</th>
                                                                    <th class="text-center">Sucursal</th>
                                                                    <th class="text-center">Puesto</th>
                                                                    <th class="text-center">Fecha Inicio</th>
                                                                    <th class="text-center">Fecha Finalizaci&oacute;n</th>
                                                                    <th class="text-center">Cantidad de dias de ausentismo</th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <tr class="text-center">
                                                                    <th>${bo.id}</th>
                                                                    <td>${bo.colaborador.name}</td>
                                                                    <td>${bo.tipoCertificado.displayName}</td>
                                                                    <td>${bo.colaborador.sucursal.name}</td>
                                                                    <td>${bo.colaborador.puesto.name}</td>
                                                                    <td>${bo.fechaInicio}</td>
                                                                    <td>${bo.fechaFinalizacion}</td>
                                                                    <td>${bo.ausentismo}</td>
                                                                </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Cantidad de ausencias por meses (d&iacute;as)</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive-md">
                        <table class="table">
                            <thead class=" text-primary">
<%--                                <th class="text-center">Enero</th>--%>
<%--                                <th class="text-center">Febrero</th>--%>
<%--                                <th class="text-center">Marzo</th>--%>
<%--                                <th class="text-center">Abril</th>--%>
<%--                                <th class="text-center">Mayo</th>--%>
<%--                                <th class="text-center">Junio</th>--%>
<%--                                <th class="text-center">Julio</th>--%>
<%--                                <th class="text-center">Agosto</th>--%>
<%--                                <th class="text-center">Septiembre</th>--%>
<%--                                <th class="text-center">Octubre</th>--%>
<%--                                <th class="text-center">Noviembre</th>--%>
<%--                                <th class="text-center">Diciembre</th>--%>
                            </thead>
                            <tbody>
                            <%--<c:set var = "certificados" scope = "session" value = "${certificados}"/>
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
                                            <td class="text-center">${findByAusentismoEnero}</td>
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
                            </c:choose>--%>
                            <tr>
                                <c:forEach items="${data}" var="bo">
                                <tr>
                                    <th>${bo.key}</th>
                                    <td>${bo.value}</td>
                                </tr>
                                </c:forEach>
                            </tr>

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
                <form action="<c:url value='/certificado/buscarColaboradorPorFecha'/>" method="post">
                    <div class="form-row">
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de inicio</label>
                            <input name="fechaInicio" size="50" autocomplete="off" class="form-control ml-1" id="datepickerColaboradorInicio" placeholder="${fechaInicio}" required/>
                        </div>
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de fin</label>
                            <input name="fechaFin" size="50" autocomplete="off" class="form-control ml-1" id="datepickerColaboradorFin" placeholder="${fechaFin}" required/>
                        </div>
                        <div class="col">
                            <input type="submit" class="btn btn-success mt-3" value="Filtrar">
                        </div>
                    </div>
                </form>

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
                <form action="<c:url value='/certificado/buscarSucursalPorFecha'/>" method="post">
                    <div class="form-row">
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de inicio</label>
                            <input name="fechaInicio" size="50" autocomplete="off" class="form-control ml-1" id="datepickerSucursalInicio" required/>
                        </div>
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de fin</label>
                            <input name="fechaFin" size="50" autocomplete="off" class="form-control ml-1" id="datepickerSucursalFin" required/>
                        </div>
                        <div class="col">
                            <input type="submit" class="btn btn-success mt-3" value="Filtrar">
                        </div>
                    </div>
                </form>
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
                <form action="<c:url value='/certificado/buscarMotivoPorFecha'/>" method="post">
                    <div class="form-row">
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de inicio</label>
                            <input name="fechaInicio" size="50" autocomplete="off" class="form-control ml-1" id="datepickerMotivoInicio" required/>
                        </div>
                        <div class="col">
                            <label class="form-control-label">Seleccionar fecha de fin</label>
                            <input name="fechaFin" size="50" autocomplete="off" class="form-control ml-1" id="datepickerMotivoFin" required/>
                        </div>
                        <div class="col">
                            <input type="submit" class="btn btn-success mt-3" value="Filtrar">
                        </div>
                    </div>
                </form>
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
    <%--<div class="row">--%>
        <%--<div class="col-md-12">--%>
            <%--<div class="card">--%>
                <%--<div class="card-header">--%>
                    <%--<h4 class="card-title"> Cantidad de ausencias por meses (d&iacute;as)</h4>--%>
                <%--</div>--%>
                <%--<div class="card-body">--%>
                    <%--<div class="table-responsive-md">--%>
                        <%--<table class="table">--%>
                            <%--<thead class=" text-primary">--%>
                            <%--<c:forEach items="${findByAusentismoPrueba}" var="bo">--%>
                                <%--<th width="50%">${bo.key}</th>--%>
                            <%--</c:forEach>--%>
                            <%--</thead>--%>
                            <%--<tbody>--%>
                            <%--<c:set var = "certificados" scope = "session" value = "${certificados}"/>--%>
                            <%--<c:choose>--%>
                                <%--<c:when test="${empty colaboradores}">--%>
                                    <%--<tr>--%>
                                        <%--<td colspan="5" class="text-center">--%>
                                            <%--<p class="mt-5">No hay certificados para mostrar</p>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                    <%--<tr>--%>
                                    <%--<c:forEach items="${findByAusentismoPrueba}" var="bo">--%>
                                        <%--<td>${bo.value}</td>--%>
                                    <%--</c:forEach>--%>
                                    <%--</tr>--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                            <%--</tbody>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
</div>

