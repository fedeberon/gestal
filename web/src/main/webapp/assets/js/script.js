
//Agregar evaluacion modal
    var next = 0;
    $(".add-more").click(function (e) {
        next = next + 1;
        nextConsideracion = 1;
        console.log(next);
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        var getItemId = $(".getItemId").attr("id", next);
        var divContainer = $('<div>', {
            id: next,
        });
        $(divContainer).addClass('input-group');
        var newIn = '<input autocomplete="off" class="input col-5 mx-3 itemField " id="' + next + '" name="items[' + next + '].value" type="text" placeholder="Descripcion del item">';
        var newInput = $(newIn);
        // $(addto).after(newInput);

        $(divContainer).append(newInput);

        var selectScore = $("#select-score-to-clone").clone();
        selectScore.attr("name", "items[" + next + "].score");
        selectScore.attr("id", "select_" + next);
        selectScore.attr("class", "col-2 d-inline");
        // $(addto).after(selectScore);
        $(divContainer).append(selectScore);

        var getItemId = $(".getItemId").clone();
        getItemId.attr("id", next);
        // $(addto).after(selectScore);
        $(divContainer).append(getItemId);

        var ckeckInvalida = $("#check-invalida-evaluiacion-to-clone").clone();
        ckeckInvalida.attr("name", "items[" + next + "].invalidaEvaluacion");
        ckeckInvalida.attr("id", "item_" + next);
        ckeckInvalida.attr("class", "col-1 d-inline mt-2");
        // $(addto).after(ckeckInvalida);
        $(divContainer).append(ckeckInvalida);

        var checkInvalidaLabelToClone = $("#check-invalida-label-to-clone").clone();
        checkInvalidaLabelToClone.attr("class", "col-1 d-inline mt-1");
        $(divContainer).append(checkInvalidaLabelToClone);


        var html = '';
        html += '<button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong-to-clone_'+next+'" id="modal_'+next+'" style=""> Categor&iacute;as del indicador </button>';
        html += '<div class="modal fade modal_consideraciones" id="exampleModalLong-to-clone_'+next+'" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">';
        html +=     '<div class="modal-dialog" role="document">';
        html +=         '<div class="modal-content">';
        html +=             '<div class="modal-header">';
        html +=                 '<h5 class="modal-title" id="exampleModalLongTitle">Categor&iacute;as del indicador</h5>';
        html +=                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>';
        html +=             '</div>';
        html +=             '<div class="modal-body">';
        html +=                     '<div class="row">';
        html +=                         '<div class="col-lg-12">';
        html +=                             '<div id="inputFormRow">';
        html +=                                 '<div class="input-group mb-3">';
        html +=                                 '<input type="text" name="items['+next+'].consideraciones[0].value" class="form-control border border-secondary" autocomplete="off">';
        // html +=                                     '<div class="input-group-append">';
        // html +=                                     '<button id="removeRow" type="button" class="btn btn-danger">Eliminar</button>';
        // html +=                                         '</div>';
        // html +=                                     '</div>';
        html +=                                 '</div>';
        html +=                             '<div id="newRow-'+next+'"></div>';
        html +=                             '<button id="addRow" type="button" class="btn btn-info">AGREGAR ITEM</button>';
        html +=                         '</div>';
        html +=                     '</div>';
        html +=             '</div>';
        html +=         '</div>';
        html +=     '</div>';

        $(divContainer).append(html);

        var removeBtn = '<button id="remove' + (next) + '" class="btn btn-danger remove-me ml-3" >-</button></div>';
        var removeButton = $(removeBtn);
        // $(addRemove).after(removeButton);
        $(divContainer).append(removeButton);

        $("#field").append(divContainer);

        $("#count").val(next);

        $('.remove-me').click(function (e) {
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length - 1);
            // var divToRemove = $("#"+ fieldNum)
            // $(divToRemove).remove();
            $(this).parent().remove();
        });
    });

//Agregar consideraciones
var maxFields = 5;
var nextConsideracion = 1;
$(document).on('click', '#addRow', function (e) {
    var html = '';
        nextConsideracion++;
        html += '<div id="inputFormRow">';
        html += '<div class="input-group mb-3">';
        html += '<input type="text" id="'+nextConsideracion+'" name="items[' + next + '].consideraciones[' + nextConsideracion + '].value" id="'+ nextConsideracion +'" class="form-control border border-secondary consideraciones-input" autocomplete="off">';
        // html += '<div class="input-group-append ml-3">';
        // html += '<button id="removeRow" type="button" class="btn btn-danger">Eliminar</button>';
        // html += '</div>';
        html += '</div>';
        $('#newRow-'+next+'').append(html);
    });

$(document).on('click', '#removeRow', function (e) {
    e.preventDefault();
    $(this).closest('#inputFormRow').remove();
    nextConsideracion = nextConsideracion - 1;
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

// window.onload = function() {
//
//         var chart = new CanvasJS.Chart("chartContainer", {
//             theme: "light2", // "light1", "light2", "dark1", "dark2"
//             exportEnabled: true,
//             animationEnabled: true,
//             data: [{
//                 type: "pie",
//                 startAngle: 25,
//                 toolTipContent: "<b>{label}</b>: {y}%",
//                 showInLegend: "true",
//                 legendText: "{label}",
//                 indexLabelFontSize: 16,
//                 indexLabel: "{label} - {y}%",
//                 dataPoints: [
//                     { y: 51.08, label: "Chrome" },
//                     { y: 27.34, label: "Internet Explorer" },
//                     { y: 10.62, label: "Firefox" },
//                     { y: 5.02, label: "Microsoft Edge" },
//                     { y: 4.07, label: "Safari" },
//                     { y: 1.22, label: "Opera" },
//                     { y: 0.44, label: "Others" }
//                 ]
//             }]
//         });
//         chart.render();
//
//     };
