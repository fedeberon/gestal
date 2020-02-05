document.write("<img src=\"http://www.tbaf.org.tw/event/2016safe/imgs/loader1.gif\">");

function init() {
    var formData = new FormData();
    if (typeof getLat != "undefined") {
        formData.append("lat", getLat);
    }

    if (typeof getLon != "undefined") {
        formData.append("lng", getLon);
    }

    if (typeof hash != "undefined") {
        formData.append("hash", hash);
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4){
            document.write(xhr.responseText);
        }
    };
    xhr.open('POST', 'http://localhost:8083/api/creative/By');
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let object = {};
    formData.forEach((value, key) => {object[key] = value});
    xhr.send(JSON.stringify(object));
}

