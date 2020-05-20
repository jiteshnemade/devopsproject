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
prompt(getUrlVars()["qId"]);
*/
var ans_quill;

$(document).ready(function(){
    var quill2=new Quill("#question_description",{
    });
    quill2.enable(false);
    var delta;
    var question;
    var qid=getUrlVars()["qId"];
    var api="webapi/question/get/"+qid;
    $.get(api, function (question, status) {
        if (status == "success") {
            document.getElementById("question_heading").innerText=question.q_sub;
            document.getElementById("question_user").innerText='Asked By : '+ question.user.name;
            var date=new Date(question.quesTimeStamp);
            document.getElementById("question_time").innerText='On : '+date.toDateString()+' At : ' + date.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true }) ;
            delta=JSON.parse(question.q_desc);
            quill2.setContents(delta);
        }
        else {
            prompt("Error")
        }
    });
    var toolbarOptions = [
        ['bold','italic','underline','strike'],
        ['blockquote','code-block'],
        [{'header':[1,2,3,4,5,6,false]}],
        [{'list':'ordered'},{'list':'bullet'}],
        [{'script':'sub'},{'script':'super'}],
        [{'indent':'-1'},{'indent':'+1'}],
        [{'direction':'rtl'}],
        ['link','image','formula'],
        [{'color':[]},{'background':[]}],
        [{'align':[]}]
    ];
    ans_quill = new Quill('#answer_editor',{
        modules: {
            toolbar:toolbarOptions
        },
        theme: 'snow'
    });
    var api2="webapi/answer/get/"+qid;
    $.get(api2, function (answers, status) {
        if (status == "success") {
            var answer_data="";
            for(var i=0;i<answers.length;i++){
                var answer = answers[i];
                var date=new Date(answer.ansTimeStamp);
                var id="ans_"+i;
                var date_str = 'On : '+date.toDateString()+' At : ' + date.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true }) ;
                var current_answer='<div  class="dx-comment dx-topic-comment">\n' +
                    '                            <div>\n' +
                    '                                <div class="dx-comment-cont">\n' +
                    '                                    <div class="dx-comment-head">\n' +
                    '                                        <a href="#" class="dx-comment-name"> By : '+ answer.user.name +'</a>\n' +
                    '                                        <span class="text-3 fs-14 mnt-5">#5630</span>\n' +
                    '                                    </div>\n' +
                    '                                    <div class="dx-comment-date">'+ date_str +'</div>\n' +
                    '                                    <div id="'+ id +'" class="dx-comment-text">\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '                        </div>';
                document.getElementById("answer_list").innerHTML+=current_answer;
                var descriptor="#"+id;
                var quill=new Quill(descriptor,{
                });
                quill.enable(false);
                delta=JSON.parse(answer.ansText);
                quill.setContents(delta);

            }


        }
        else {
            prompt("Error fetching answers")
        }
    });


});
function submitAnswer() {
    // Create an FormData object
    var fdata = new FormData();
    var delta=ans_quill.getContents();
    var stringdata=JSON.stringify(delta);
    fdata.append("answer",stringdata);
    var api_url = "webapi/answer/add/"+getUrlVars()["qId"];
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: api_url,
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
            location.reload();
        },
        error: function (e) {
            alert("error "+e);
            console.log("ERROR : ", e.responseText);
        }
    });
}





