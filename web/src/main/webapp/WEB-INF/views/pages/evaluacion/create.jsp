<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value='/assets/css/createEvaluacion.css' />" rel="stylesheet">
<script src="<c:url value='/MDB/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/assets/js/createEvaluacion.js'/>"></script>

<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Agregar evaluaci&oacute;n</h4>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <form role="form">
                            <input type="text" class="form-control " placeholder="Agregar evaluaci&oacute;n" name="task">
                        </form>
                        <button type="button" class="btn btn btn-primary">Agregar</button>
                    </div>
                    <div></div>
                    <ul class="list-unstyled" id="todo"></ul>
                </div>
            </div>
        </div>
    </div>
</div>