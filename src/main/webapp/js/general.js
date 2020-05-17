
function  addQuestion() {
    // Create an FormData object
    var fdata = new FormData($('#question_form')[0]);

    //fdata.append("key","value");
    var quill = new Quill('#q_desc',{
    });
    var delta=quill.getContents();
    var stringdata=JSON.stringify(delta);
    prompt(stringdata);
    fdata.append("q_desc",stringdata);


    /*$('#saveDelta').click(function () {
        var delta=quill.getContents();
        var stringdata=JSON.stringify(delta);
        prompt(stringdata);
        var delta2=JSON.parse(stringdata);
        quill2.setContents(delta2);
        //prompt(delta);

    });*/
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "webapi/question/add",
        async: false,
        data: fdata,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            //$("#result").text(data);
           // alert("Added Success");
            console.log("SUCCESS : ", data);

        },
        error: function (e) {
            //alert("error "+e);
            console.log("ERROR : ", e.responseText);

        }
    });

}
function add_json(){
    var op1=document.getElementById("op1").value;
    var op2=document.getElementById("op2").value;

}