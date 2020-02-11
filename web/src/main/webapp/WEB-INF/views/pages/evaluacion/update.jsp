<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">--%>
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style>
    * {
    .border-radius(0) !important;
    }

    #field {
        margin-bottom: 20px;
        width: 800px;
    }
    #field1{
        width: 75%;
    }
</style>
<script>
    $(document).ready(function(){
        var next = 1;
        $(".add-more").click(function(e){
            e.preventDefault();
            var addto = "#field" + next;
            var addRemove = "#field" + (next);
            next = next + 1;
            var newIn = '<input autocomplete="off" class="input" id="field' + next + '" name="items[' + next + '].value" type="text" style="width: 75%">';
            var newInput = $(newIn);
            var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me ml-3" >-</button></div><div id="field">';
            var removeButton = $(removeBtn);
            $(addto).after(newInput);
            $(addRemove).after(removeButton);
            $("#field" + next).attr('data-source',$(addto).attr('data-source'));
            $("#count").val(next);

            $('.remove-me').click(function(e){
                e.preventDefault();
                var fieldNum = this.id.charAt(this.id.length-1);
                var fieldID = "#field" + fieldNum;
                $(this).remove();
                $(fieldID).remove();
            });
        });
    });
</script>
<div class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title"> Agregar evaluaci&oacute;n</h4>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="container">
                            <div class="row">
                                <input type="hidden" name="count" value="1" />
                                <c:url var="actionUrl" value="/evaluacion/" />
                                <form:form modelAttribute="evaluacion" action="${actionUrl}" method="POST">

                                    <div class="control-group" id="fields">
                                        <div class="controls" id="profs">
                                            <label class="control-label" for="field1">Descripci&oacute;n de la evaluaci&oacute;n</label>
                                            <div id="field">
                                                <input autocomplete="off" class="input" id="field1" name="items[0].value" type="text" placeholder="Agregar evaluaci&oacute;n" data-items="8" required="true"/>
                                                    <%--<form:input path="value" required="required" autocomplete="off" class="input" id="field1" name="prof1" type="text" placeholder="Agregar evaluaci&oacute;n" data-items="8"/>--%>
                                                <button id="b1" class="btn add-more ml-3" type="button">+</button>
                                            </div>
                                            <small>Presiona + para agregar la evaluaci&oacute;n</small>
                                            <br>

                                            <form:select  path="rol.id" cssClass="form-control mt-3 w-50">
                                                <form:option value="Seleccionar rol" required="true"/>
                                                <form:options items="${roles}" itemValue="id" itemLabel="name"/>
                                            </form:select>
                                            <br>
                                            <button type="submit" class="btn btn-primary mt-5">Guardar</button>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>