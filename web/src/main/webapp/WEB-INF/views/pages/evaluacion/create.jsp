<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Button trigger modal -->
<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalCenter">Crear nueva evaluaci&oacute;n</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document" style="max-width: 90%">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Agregar evaluaci&oacute;n</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="row">
                        <div class="col-12">
                            <input type="hidden" name="count" value="1"/>
                            <c:url var="actionUrl" value="/evaluacion/"/>
                            <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                            <div class="input-group" id="fields">
                                <div id="profs" style="width: 100%">

                                    <div id="field">
                                        <label for="field1">Items de la evaluaci&oacute;n</label>
                                        <div class="input-group">
                                            <input required="required" autocomplete="off" class="col-5 mx-3 itemField" id="0" name="items[0].value" type="text" placeholder="Descripcion del item"/>
                                            <select name="items[0].score" id="select_1" class="col-2 d-inline">

                                                <c:forEach var="i" begin="0" end="10">
                                                    <option value="${i}">${i}</option>
                                                </c:forEach>

                                            </select>
                                            <input name="items[0].invalidaEvaluacion" class="col-1 mt-2" type="checkbox" id="check-invalida-evaluiacion-to-clone_0" style=""/>

                                            <!-- Button trigger modal -->
                                            <button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong-to-clone_0" id="modal_0" style=""> Consideraciones </button>

                                            <!-- Modal -->
                                            <div class="modal fade modal_consideraciones" id="exampleModalLong-to-clone_0" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLongTitle">Consideraciones</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <input type="hidden" name="count-consideracion" value="1"/>
                                                            <div class="input-group" id="fields-consideracion">
                                                                <div id="profs-consideracion" style="width: 100%">
                                                                    <div id="field-consideracion">
                                                                        <label for="field1">Items de la evaluaci&oacute;n</label>
                                                                        <div class="input-group">
                                                                            <input required="required" autocomplete="off" class="col-10" id="field-consideracion1" name="items[0].consideraciones[0].value" type="text" placeholder="Descripcion de la consideraci&oacute;n"/>
                                                                            <div class="col-1">
                                                                                <button id="b2" class="btn btn-primary add-consideracion" type="button">+ </button>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <br>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-1">
                                                <button id="b1" class="btn btn-primary add-more" type="button">+
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group col-md-4 mt-4">
                                        <label for="inputRole">Seleccionar rol</label>
                                        <form:select path="rol.id" cssClass="form-control">
                                            <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                        </form:select>
                                    </div>

                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <div class="row">
                        <div class="col-md-6">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        </div>
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<select class="col-1" id="select-score-to-clone" style="display: none">

    <c:forEach var="i" begin="0" end="10">
        <option value="${i}">${i}</option>
    </c:forEach>

</select>

<input name="items[0].invalidaEvaluacion" type="checkbox" style="display: none"
       id="check-invalida-evaluiacion-to-clone"/>

<button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong" id="modal-to-clone"
        style="display: none">
    Consideraciones
</button>
