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
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title"> Estad&iacute;sticas mensuales</h4>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive-md">
                            <table class="table">
                                <thead class=" text-primary">
                                <th>Colaboradores</th>
                                <th>Febrero</th>
                                <th>Marzo</th>
                                <th>Abril</th>
                                <th>Mayo</th>
                                <th>Junio</th>
                                <th>Julio</th>
                                <th>Agosto</th>
                                <th>Septiembre</th>
                                <th>Octubre</th>
                                <th>Noviembre</th>
                                <th>Diciembre</th>
                                </thead>
                                <tbody>
                                <c:set var = "colaboradores" scope = "session" value = "${colaboradores}"/>
                                <c:choose>
                                    <c:when test="${empty colaboradores}">
                                        <tr>
                                            <td colspan="5" class="text-center">
                                                <p class="mt-5">No hay colaboradores para mostrar</p>
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${colaboradores}" var="bo">
                                            <tr>${bo.colaborador.name} ${bo.colaborador.lastName}</tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>


                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer mt-4">
                        <hr>
                        <div class="row">
                            <div class="col-md-4">
                                <form name="rol" action="list" method="get">
                                    <input type="hidden" name="page" value="${page}"/>
                                    <tags:paginador page="${page}" formName="search"/>
                                </form>
                            </div>
                            <div class="col-md-4">
                                <a class="btn btn-success" href="<c:url value='/rol/create'/>" title="Agregar rol">Agregar
                                    rol</a>
                            </div>
                            <div class="col-md-4">
                                <a class="btn btn-success" href="<c:url value='/colaborador/create'/>" title="Agregar colaborador">Agregar
                                    colaborador</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card ">
                <div class="card-header ">
                    <h5 class="card-title">Estad&iacute;sticas anuales</h5>
                </div>
                <div class="card-body ">
                    <div id="ausentismoPorAnioPorColaborador" style="height: 370px; width: 100%;"></div>
                </div>
            </div>
        </div>
    </div>
</div>

