function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
    //prompt(document.cookie);
}
function checkLoggedIn() {
    if (getUsername()==""){
        return false;
    }
    return true;
}
function getUsername() {
    return getCookie("queryForum_username");
}

function getUserId() {
    return getCookie("queryForum_userid");

}

function getUserEmail() {
    return getCookie("queryForum_useremail");
}

function getName() {
    return getCookie("queryForum_name");
}


