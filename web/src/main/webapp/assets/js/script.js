$(document).ready(function(){

    indiceIndicador = 0;
    indiceCategoriaIndicador = 0;

    $(this).on('click', '.agregar-item-indicador', function(){
        indiceIndicador = indiceIndicador + 1;
        indiceCategoriaIndicador = 0;
        let numeroDeCard = indiceIndicador  + 1
        var random = Math.random();
        var green = 0 + Math.floor((207 - 0) * random);

        let html = '<div class="row" style="background-color: #' + green +'; padding-top: 10px; padding-bottom: 10px "><label class="col-12" style="color: #0c0c0c"> # '  + numeroDeCard + ' </label><div class="col-md-6"> <input type="text" name="items['+indiceIndicador+'].value" style="height: 60px" id="0" placeholder="Nombre del indicador" class="form-control" required> </div>'
        html += '<div class="col-md-2"><select  style="height: 60px" id="0" name="items['+indiceIndicador+'].score" id="select_1" class="form-control col-md-3"> <option hidden selected value> Peso</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option><option>6</option><option>7</option><option>8</option><option>9</option><option>10</option></select></div>';
        html += '<div class="col-md-3"><button type="button" class="btn btn-success agregar-item-indicador">Agregar</button><button type="button" class="btn btn-danger remover-item-indicador">Borrar</button></div>';
        html += '<div class="col-md-12"> <div class="items-consideracion-inputs form-inline" id="'+ indiceIndicador +'"><input type="textarea" style="height: 60px; width: 100%" id="'+indiceIndicador+'" name="items['+indiceIndicador+'].consideraciones['+ indiceCategoriaIndicador +'].value" placeholder="Descripci&oacute;n de la categor&iacute;a del indicador" class="form-control d-block mt-3 w-50 mr-3 categoria-indicador col-md-12" required><input name="items['+ indiceIndicador +'].invalidaEvaluacion" class="form-check-input" type="checkbox" id="gridCheck1"><label class="form-check-label" for="gridCheck1"> Envia una alarma al tablero general </label></div></div></div>';
        html += '<hr/>'
        $('.items-evaluacion-inputs').append(html);
    });

    $(this).on('click', '.remover-item-indicador', function(){
        var target_input = $(this).parent().parent();
        target_input.remove()
    });

    $(this).on('click', '.remover-categoria-indicador', function(){
        var target_input = $(this).parent();
        target_input.remove()
    });

    $(this).on('click', '.agregar-item-consideracion', function(){
        indiceCategoriaIndicador = indiceCategoriaIndicador + 1;
        idIndicador = $(this).parent().attr('id');

        var html = '<div class="item-categoria-indicador-container form-inline" style="height: 60px" id="0"><input type="text" id="'+ idIndicador +'" name="items['+idIndicador+'].consideraciones['+indiceCategoriaIndicador+'].value" placeholder="Descripci&oacute;n de la categor&iacute;a del indicador" class="form-control mt-3 categoria-indicador w-50" required><input name="items['+ indiceIndicador +'].invalidaEvaluacion" class="form-check-input required ml-3" type="checkbox" id="gridCheck1"><label class="form-check-label" for="gridCheck1">Invalida la evaluaci&oacute;n</label><button type="button" class="btn btn-danger remover-categoria-indicador ml-2">Borrar</button></div>';
        $(this).parent().parent().append(html);

    });
});


jQuery(document).ready(function($){

    $(".btnrating").on('click',(function(e) {

        var previous_value = $("#selected_rating").val();

        var selected_value = $(this).attr("data-attr");
        $("#selected_rating").val(selected_value);
        $(".selected-rating").empty();
        $(".selected-rating").html(selected_value);

        for (i = 1; i <= selected_value; ++i) {
            $("#rating-star-"+i).toggleClass('btn-warning');
            $("#rating-star-"+i).toggleClass('btn-default');
        }

        for (ix = 1; ix <= previous_value; ++ix) {
            $("#rating-star-"+ix).toggleClass('btn-warning');
            $("#rating-star-"+ix).toggleClass('btn-default');
        }

    }));

});

jQuery(document).ready(function($){

    $(".btnrating").on('click',(function(e) {

        var id  = $(this).attr('data-id');

        var previous_value = $("#selected_rating-" + id).val();

        var selected_value = $(this).attr("data-attr");
        $("#selected_rating-" + id).val(selected_value);

        $(".selected-rating-" + id).empty();
        $(".selected-rating-"+ id).html(selected_value);

        for (i = 1; i <= selected_value; ++i) {
            $("#rating-star-" + id + +i).toggleClass('btn-warning');
            $("#rating-star-"+ id +i).toggleClass('btn-default');
        }

        for (ix = 1; ix <= previous_value; ++ix) {
            $("#rating-star-"+ id +ix).toggleClass('btn-warning');
            $("#rating-star-"+ id +ix).toggleClass('btn-default');
        }

    }));

});

//Agregar clase active a los elementos del menu al navegar por el menu
jQuery(document).ready(function($){

    $(document).ready(function() {
        var str = location.href.toLowerCase();
        $(".sidebar-wrapper ul li a").each(function() {
            if (str.indexOf(this.href.toLowerCase()) > -1) {
                $("li.active").removeClass("active");
                $(this).parent().addClass("active");
            }
        });
    })
});
$(document).on('click', '#removeRow', function () {
    $(this).closest('#inputFormRow').remove();
});

jQuery(document).ready(function($){
    //Grafico score por evaluaciones
    var chart1 = new CanvasJS.Chart("graficoScoreEvaluacion", {
        animationEnabled: true,
        theme: "light2",
        axisY:{
            includeZero: false
        },
        data: [{
            type: "line",
            indexLabelFontSize: 16,
            dataPoints: []
        }]
    });
    chart1.render();

    $( ".listaScore li" ).each(function( index ) {
        chart1.options.data[0].dataPoints.push(
            { y: parseInt($( this ).text()) }
        );
        chart1.render();
    });

    //Grafico score por sucursales
    var chart2 = new CanvasJS.Chart("graficoSucursal", {
        animationEnabled: true,
        theme: "light1", // "light1", "light2", "dark1", "dark2"
        data: [{
            type: "column",
            showInLegend: false,
            dataPoints: []
        }]
    });
    chart2.render();

    $( ".listaScoreSucursal li" ).each(function( index ) {
        chart2.options.data[0].dataPoints.push(
            { y: parseInt($( this ).text()), label: $(this).attr("id") }
        );
        chart2.render();
    });

});

$(document).ready(function(){
    $( "#inp-buscar" ).submit(function() {
        document.forms['buscar'].submit();
    });
});
function closeModal(){
    $("#exampleModalLong-to-clone_0").modal("hide");
}

//DatePicker
$(function(){
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '< Ant',
        nextText: 'Sig >',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };
    $.datepicker.setDefaults($.datepicker.regional['es']);
    $(function () {
        $("#fechaInicio").datepicker();
        $("#fechaFin").datepicker();
    });
});

function checkPasswordMatch(fieldConfirmPassword){
    if (fieldConfirmPassword.value != $("#password").val()){
        fieldConfirmPassword.setCustomValidity("Las contrasenas no coinciden");
    }else{
        fieldConfirmPassword.setCustomValidity("");
    }
}