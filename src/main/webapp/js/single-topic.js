

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

/*
Get query params
var number = getUrlVars()["x"];
var mytext = getUrlVars()["text"];
*/

prompt(getUrlVars()["qId"]);