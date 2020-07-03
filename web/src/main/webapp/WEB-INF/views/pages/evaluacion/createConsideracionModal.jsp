<!-- Button trigger modal -->
<button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong-to-clone_0" id="modal_0" style=""> Categor&iacute;as del indicador </button>

<!-- Modal -->
<div  class="modal fade modal_consideraciones" id="exampleModalLong-to-clone_0" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Categor&iacute;as del indicador</h5>
                <button type="button" class="close"> <span aria-hidden="true" onclick="closeModal()">&times;</span> </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">

                        <div id="newRow-0">
                            <div id="inputFormRow">
                                <div class="input-group mb-3">
                                    <input type="text" name="items[0].consideraciones[0].value" class="form-control border border-secondary" autocomplete="off">
                                    <%--<div class="input-group-append ml-3">--%>
                                    <%--<button id="removeRow" type="button" class="btn btn-danger">Eliminar</button>--%>
                                    <%--</div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="row">
                    <div class="col-md-6">
                        <button id="addRow" type="button" class="btn btn-info">Agregar item</button>
                    </div>
                    <div class="col-md-6">
                        <input type="button" id="btnClosePopup" value="Cerrar" class="btn btn-danger" onclick="closeModal()" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>