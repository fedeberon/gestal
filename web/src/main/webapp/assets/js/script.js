console.log("en funcion")
//Agregar evaluacion modal
$(document).ready(function () {
    var next = 1;
    $(".add-more").click(function (e) {
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;

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

        var ckeckInvalida = $("#check-invalida-evaluiacion-to-clone").clone();
        ckeckInvalida.attr("name", "items[" + next + "].invalidaEvaluacion");
        ckeckInvalida.attr("id", "item_" + next);
        ckeckInvalida.attr("class", "col-1 d-inline mt-2");
        // $(addto).after(ckeckInvalida);
        $(divContainer).append(ckeckInvalida);

            var html = '';
            html += '<button type="button" class="btn btn-primary " data-toggle="modal" data-target="#exampleModalLong-to-clone_'+next+'" id="modal_'+next+'" style=""> Consideraciones </button>';
            html += '<div class="modal fade modal_consideraciones" id="exampleModalLong-to-clone_'+next+'" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">';
            html +=     '<div class="modal-dialog" role="document">';
            html +=         '<div class="modal-content">';
            html +=             '<div class="modal-header">';
            html +=                 '<h5 class="modal-title" id="exampleModalLongTitle">Consideraciones</h5>';
            html +=                 '<button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>';
            html +=             '</div>';
            html +=             '<div class="modal-body">';
            html +=                 '<input type="hidden" name="count-consideracion" value="1"/>';
            html +=                     '<div class="input-group" id="fields-consideracion">';
            html +=                         '<div id="profs-consideracion" style="width: 100%">';
            html +=                             '<div id="field-consideracion">';
            html +=                                 '<label for="field1">Items de la evaluaci&oacute;n</label>';
            html +=                                 '<div class="input-group">';
            html +=                                     '<input required="required" autocomplete="off" class="col-10" id="field-consideracion'+next+'" name="items['+next+'].consideraciones[0].value" type="text" placeholder="Descripcion de la consideraci&oacute;n"/>';
            html +=                                     '<div class="col-1">';
            html +=                                         '<button id="b2" class="btn btn-primary add-consideracion" type="button">+ </button>';
            html +=                                     '</div>';
            html +=                                 '</div>';
            html +=                             '</div>';
            html +=                             '<br>';
            html +=                         '</div>';
            html +=                     '</div>';
            html +=                 '</div>';
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
            var divToRemove = $("#"+ fieldNum)
            $(divToRemove).remove();

            // var fieldNum = this.id.charAt(this.id.length - 1);
            // var fieldID = "#field" + fieldNum;
            // $(this).remove();
            // $(fieldID).remove();
            //
            // var selectNum = this.id.charAt(this.id.length - 1);
            // var selectId = "#select_" + selectNum;
            // $(selectId).remove();
            //
            // var itemNum = this.id.charAt(this.id.length - 1);
            // var itemId = "#item_" + itemNum;
            // $(itemId).remove();
        });
    });
});

//Agregar evaluacion edit
$("#addRow").click(function () {
    var html = '';
    var next = 1
    html += '<div id="inputFormRow">';
    html += '<div class="input-group mb-3">';
    html += '<input type="text" name="items[' + next + '].value" class="form-control border border-secondary" placeholder="Enter title" autocomplete="off">';
    html += '<div class="input-group-append ml-3">';
    html += '<button id="removeRow" type="button" class="btn btn-danger">Eliminar</button>';
    html += '</div>';
    html += '</div>';

    $('#newRow').append(html);
});

//Rating
// remove row
$(document).on('click', '#removeRow', function () {
    $(this).closest('#inputFormRow').remove();
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


//Agregar clase active al navegar por el menu
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


$(document).ready(function () {
    var getId = $('.itemField').attr('id');
    var next = 1;
    $(".add-consideracion").click(function (e) {
        e.preventDefault();
        var addto = "#field-consideracion" + next;
        var addRemove = "#field-consideracion" + (next);
        next = next + 1;


        var divContainer = $('<div>', {
            id: next,
        });
        $(divContainer).addClass('input-group');
        var newIn = '<input autocomplete="off" class="input col-10" id="field-consideracion' + next + '" name="items[' + getId + '].consideraciones[' + next + '].value" type="text" placeholder="Descripcion de la consideracion">';
        var newInput = $(newIn);
        // $(addto).after(newInput);
        $(divContainer).append(newInput);

        var removeBtn = '<button id="remove-consideracion' + (next) + '" class="btn btn-danger remove-me ml-3" >-</button></div>';
        var removeButton = $(removeBtn);
        // $(addRemove).after(removeButton);
        $(divContainer).append(removeButton);

        $("#field-consideracion").append(divContainer);

        $("#count-consideracion").val(next);

        $('.remove-me').click(function (e) {
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length - 1);
            var divToRemove = $("#"+ fieldNum)
            $(divToRemove).remove();
        });
    });
});

//Obtengo todos los checkbox de las consideraciones en true y las asigno al atributo value
function getAllCheckSelected() {
var setValue = $(".check-input input:checkbox:checked").length;
    $('#rating-consideracion').attr('value', setValue);
}
