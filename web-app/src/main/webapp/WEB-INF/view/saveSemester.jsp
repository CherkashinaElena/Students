<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/18/2014
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save semester</title>
</head>
<body>
<%@include file="layout.jsp"%>
<div class="adding_student_information">
    <div class="container row">
        <div class="col-lg-2">
            <a href="/"><h3>Main page</h3></a>
        </div>

        <div class="col-lg-1">
            <a href="/students"><h3>Back</h3></a>
        </div>

        <div class="col-lg-9">
            <h3>To create a semester fill out all fields and click <q>Save semester</q></h3>
        </div>
    </div>

    <div class="studentFormStyle">
        <div class="container row">
            <div class="col-sm-offset-3 col-sm-7">
                <div class="form-horizontal">

                    <div class="row">
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="semester">Semester</label>

                            <div class="col-md-7">
                                <input name="semester" id="semester" class="form-control" value="${semesterModel.semester}" required="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label" for="duration">Duration</label>

                            <div class="col-md-7">
                                <input name="duration" id="duration" class="form-control" value="${semesterModel.duration}" required="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label" for="subject">Subjects</label>

                            <div class="col-md-7">
                                <select id="subject" multiple="multiple" class="form-control" required="true">
                                    <c:forEach var="subject" items="${subjectList}">
                                        <option value="${subject.idSubject}">${subject.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button class="btn btn-danger" type="reset">Clear</button>
                                <button class="btn btn-success" id="saveSemesterButton">Save semester</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var semester = {};
    $("#subject").change(function(){
        semester.subjectList = [];
        $("#subject option:selected" ).each(function() {
            var subject = {};
            subject.idSubject = $(this).val();
            subject.name = $(this).text();
            semester.subjectList.push(subject);
        });
        console.log(semester);
    });
    $('#saveSemesterButton').on("click",event,  function () {
        semester.semester = $('#semester').val();
        semester.duration = $('#duration').val();
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/saveSemester",
            contentType: "application/json",
            data: JSON.stringify(semester),
            success: function(responce) {
                document.location.href = '/semesters';
            },
            error: function (jqXhr, textStatus) {
                alert(textStatus);
            }
        });
    });
    $(document).ready(function() {
        var idSemester = $('#semester').val();
        var subjectsofSemester = [];
        $.ajax({
            type: "GET",
            url: "/getSubjects",
            contentType: "application/json",
            data: {semester : idSemester},
            success: function(responce) {
                subjectsofSemester = JSON.parse(responce);
                console.log(subjectsofSemester);
                $("#subject option").each(function() {
                    for (var i = 0; i < subjectsofSemester.length; i++) {
                        if (subjectsofSemester[i].idSubject == $(this).val()){
                            $(this).attr("selected", "selected");
                            console.log(subjectsofSemester[i]);
                            console.log($(this).val());
                        }
                    }
                });
            }
        });

    });
</script>
</body>
</html>
