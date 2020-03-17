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
            id: next
        });

        var newIn = '<input autocomplete="off" class="input col-7 mx-3" id="field' + next + '" name="items[' + next + '].value" type="text">';
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
        ckeckInvalida.attr("class", "col-1 mx-3 d-inline");
        // $(addto).after(ckeckInvalida);
        $(divContainer).append(ckeckInvalida);

        var removeBtn = '<button id="remove' + (next) + '" class="btn btn-danger remove-me col-1" >-</button></div>';
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

