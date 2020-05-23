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
            var upvotes=0;
            var downvotes=0;
            for(var j=0;j<question.questionVoteList.length;j++){
                if(question.questionVoteList[j].vote==1){
                    upvotes++;
                }
                if(question.questionVoteList[j].vote==-1){
                    downvotes++;
                }
            }
            document.getElementById("question_heading").innerText=question.q_sub;
            document.getElementById("question_user").innerText='Asked By : '+ question.user.name;
            document.getElementById("question_upvote").innerText= 'Upvotes : '+ upvotes;
            document.getElementById("question_downvote").innerText= 'Downvotes : '+downvotes;
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
                var ansupvotes=0;
                var ansdownvotes=0;
                for(var j=0;j<answer.answerVoteList.length;j++){
                    if(answer.answerVoteList[j].vote ==1){
                        ansupvotes++;
                    }
                    else if(answer.answerVoteList[j].vote == -1 ){
                        ansdownvotes++;
                    }
                }
                var date_str = 'On : '+date.toDateString()+' At : ' + date.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true }) ;
                var current_answer='<div  class="dx-comment dx-topic-comment">\n' +
                    '                            <div>\n' +
                    '                                <div class="dx-comment-cont">\n' +
                    '                                    <div class="dx-comment-head">\n' +
                    '                                        <a href="#" class="dx-comment-name"> By : '+ answer.user.name +'</a>\n' +
                    '                                    </div>\n' +
                    '                                    <div class="dx-comment-date">'+ date_str +'</div>\n' +
                    '                                    <div id="'+ id +'" class="dx-comment-text">\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '<br>\n' +
                    '                            <div>\n' +
                    '                                <button id="'+ "upvote"+ answer.ansId +'" class="dx-btn dx-btn-lg" type="button"  onclick="answerUpvote(this.id)"> Upvotes : '+ ansupvotes+ '</button>\n' +
                    '                                <button id="'+ "downvote"+answer.ansId + '" class="dx-btn dx-btn-lg" type="button" style="background-color: #a14a4f" onclick="answerDownvote(this.id)" > Downvotes : '+ ansdownvotes +'</button>\n' +
                    '\n' +
                    '                            </div>'+
                    '                       </div>';
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
            prompt("No Answers present")
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

function questionUpvote() {
    var qid=getUrlVars()["qId"];
    var api="webapi/questionvote/upvote/"+qid;
    $.get(api, function (data, status) {
        if (status == "success") {
            location.reload();

        } else {
            prompt("Error")
        }
    });
}

function questionDownvote() {
    var qid=getUrlVars()["qId"];
    var api="webapi/questionvote/downvote/"+qid;
    $.get(api, function (data, status) {
        if (status == "success") {
            location.reload();

        } else {
            prompt("Error")
        }
    });
}

function answerUpvote(id) {
    var aid=id.substring(6,id.length);
    var api="webapi/answervote/upvote/"+aid;
    $.get(api, function (data, status) {
        if (status == "success") {
            location.reload();

        } else {
            prompt("Error")
        }
    });
}
function answerDownvote(id) {
    var aid=id.substring(8,id.length);
    var api="webapi/answervote/downvote/"+aid;
    $.get(api, function (data, status) {
        if (status == "success") {
            location.reload();

        } else {
            prompt("Error")
        }
    });
}