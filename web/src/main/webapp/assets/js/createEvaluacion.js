$(document).ready(function () {
    var next = 1;
    $(".add-more").click(function (e) {
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;
        var newIn = '<input autocomplete="off" class="input" id="field' + next + '" name="items[' + next + '].value" type="text" style="width: 40%">';
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me ml-3" >-</button></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#field" + next).attr('data-source', $(addto).attr('data-source'));
        $("#count").val(next);

        $('.remove-me').click(function (e) {
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length - 1);
            var fieldID = "#field" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        });
    });
});


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