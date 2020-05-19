/*
$(document).ready(function() {
    //prompt("In javasript")
    $('#question_table').DataTable();
} );*/
var api = "webapi/question/getall";
$.get(api, function (questions, status) {
    if (status == "success") {
        var question_data = "";
        for (var i = 0; i < questions.length; i++) {
            //var msg= '<a href="applications.html?offerid=' + offer[i].id +  '">view</a>';
            var date=new Date(questions[i].quesTimeStamp);
            var cell1 = '<th scope="row" class="dx-table-topics">\n' +
                '<a href="single-topic.html?qId='+ questions[i].quesId +'" class="dx-table-default-title" >'+ questions[i].q_sub+'</a>\n' +
                '<div class="dx-table-default-info">' +
                '<p class="mb-0">by <a href="#">'+ questions[i].user.name+'</a> <span class="dib">'+ date.toDateString()+',</span> <span class="dib">'+ date.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true })+'</span></p>\n' +
                '</div>\n' +
                '</th>' ;
            var upvotes = 0;
            var downvotes = 0;
            for(var j=0;j<questions[i].questionVoteList.length;j++){
                if(questions[i].questionVoteList[j].vote==1){
                    upvotes++;
                }
                if(questions[i].questionVoteList[j].vote==-1){
                    downvotes++;
                }
            }
            var cell2 ='<td>' + upvotes + '</td>';
            var cell3 ='<td>' + downvotes +  '</td>';


/*            var cell4 ='<td class="dx-table-lastPost">\n' +
                '<div class="dx-table-default-info">\n' +
                ' <p class="mb-0">by <a href="#">Joseph Harper</a> <span class="dib">24 Feb 2018,</span> <span class="dib">09:00 am</span></p>\n' +
                ' </div>\n' +
                ' </td>';*/
            var tags='';
            for(var j=0;j<questions[i].questionTags.length;j++){
                tags +=questions[i].questionTags[j].tagName +",";
            }
            tags=tags.substring(0,tags.length-1);
            var cell4 ='<td class="dx-table-lastPost">\n' +
                '<div class="dx-table-default-info">\n' +
                ' <p class="mb-0">'+ tags+'</p>\n' +
                ' </div>\n' +
                ' </td>';




            question_data += '<tr>'+cell1+cell2+cell3+cell4+'</tr>';
        }
        $('#question_table tbody').html(question_data);
    }
    $('#question_table').DataTable();
});

/*
<tr>
                                        <th scope="row" class="dx-table-topics">
                                            <a href="single-topic.html" class="dx-table-default-title">How to choose Best Web Design C...</a>
                                            <div class="dx-table-default-info">
                                                <p class="mb-0">by <a href="#">Admin</a> <span class="dib">24 Feb 2018,</span> <span class="dib">09:00 am</span></p>
                                            </div>
                                        </th>
                                        <td>45</td>
                                        <td>12058</td>
                                        <td class="dx-table-lastPost">
                                            <div class="dx-table-default-info">
                                                <p class="mb-0">by <a href="#">Joseph Harper</a> <span class="dib">24 Feb 2018,</span> <span class="dib">09:00 am</span></p>
                                            </div>
                                        </td>
</tr>

 */