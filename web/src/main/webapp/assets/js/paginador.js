/**
 * Created by Enzo on 21/2/2020.
 */

function pagSiguiente(form){
    $("input[name=page]").val($("input[name=page]").val()*1+1);
    document.forms[form].submit();
}
function pagAnterior(form){
    $("input[name=page]").val($("input[name=page]").val()*1-1);
    document.forms[form].submit();
}

function onSubmit(form) {
    document.forms[form].submit();
}