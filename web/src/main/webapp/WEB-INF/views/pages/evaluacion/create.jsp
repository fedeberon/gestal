<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Button trigger modal -->
<button type="button" class="btn btn-success mx-5 my-3 float-right" data-toggle="modal" data-target="#exampleModalCenter">Crear nueva evaluaci&oacute;n</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Agregar evaluaci&oacute;n</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card" data-spy="scroll">
                                <div class="card-body">
                                    <div class="form-group">
                                        <div class="container">
                                            <div class="row">
                                                <input type="hidden" name="count" value="1"/>
                                                <c:url var="actionUrl" value="/evaluacion/"/>
                                                <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">
                                                <div class="control-group" id="fields">
                                                    <div class="controls" id="profs">
                                                        <label class="control-label" for="field1">Descripci&oacute;n de la evaluaci&oacute;n</label>
                                                        <div id="field">
                                                            <input autocomplete="off" class="input" id="field1" name="items[0].value" type="text" placeholder="Agregar evaluaci&oacute;n" required/>
                                                            <button id="b1" class="btn add-more ml-3" type="button">+ </button>
                                                        </div>
                                                        <small>Presiona + para agregar la evaluaci&oacute;n</small>
                                                        <br>

                                                        <form:select path="rol.id" cssClass="form-control mt-3 w-50">
                                                            <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                                        </form:select>
                                                        <br>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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