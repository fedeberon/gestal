<!-- Button trigger modal -->
<button type="button" class="btn btn-primary " data-toggle="modal"
        data-target="#exampleModalLong" id="modal_0" style="">
    Consideraciones
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">
                    Consideracioes</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="count-consideracion" value="1"/>
                <div class="input-group" id="fields">
                    <div id="profs" style="width: 100%">

                        <div id="field-consideracion">
                            <label for="field1">Items de la evaluaci&oacute;n</label>
                            <div class="input-group">
                                <input required="required"
                                       autocomplete="off" class="col-5 mx-3"
                                       id="field-consideracion1"
                                       name="items[0].consideraciones[0].value"
                                       type="text"
                                       placeholder="Descripcion de la consideraci&oacute;n"/>

                                <!-- Modal -->
                                <div class="modal fade"
                                     id="exampleModalLong" tabindex="-1"
                                     role="dialog"
                                     aria-labelledby="exampleModalLongTitle"
                                     aria-hidden="true">
                                    <div class="modal-dialog"
                                         role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title"
                                                    id="exampleModalLongTitle">
                                                    Consideracioes</h5>
                                                <button type="button"
                                                        class="close"
                                                        data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <label class="control-label">Descripic&oacute;n</label>
                                                <div class="controls">
                                                    <div class="form">
                                                        <div class="entry input-group col-xs-3">
                                                            <input id="consideracion_0"
                                                                   class="form-control"
                                                                   name="items[0].consideraciones[0].value"
                                                                   type="text"
                                                                   placeholder="Ingrese consideraci&oacute;n">
                                                            <span class="input-group-btn">
                                                                                <button class="btn btn-success btn-add"
                                                                                        type="button">
                                                                                    <span class="glyphicon glyphicon-plus"></span>
                                                                                </button>
                                                							</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-primary">
                                                    Guardar
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-1">
                                    <button id="b2"
                                            class="btn btn-primary add-consideracion"
                                            type="button">+
                                    </button>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Guardar
                </button>
            </div>
        </div>
    </div>
</div>