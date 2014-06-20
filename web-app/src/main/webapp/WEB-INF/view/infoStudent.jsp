<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/17/2014
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="layout.jsp" %>
<div class="adding_student_information">
    <div class="container row">
        <div class="col-lg-2">
            <a href="/"><h3>Main page</h3></a>
        </div>

        <div class="col-lg-1">
            <a href="/students"><h3>Back</h3></a>
        </div>

        <div class="col-lg-9">
            <h3>Displayed next student achievement</h3>
        </div>
    </div>

    <div class="info_student_content">
        <div class="info_student_table">
            <table id="students" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr bgcolor="#f0f8ff">
                    <th>Surname</th>
                    <th>Name</th>
                    <th>Group</th>
                    <th>Date</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td id="lastName">${studentInfo.lastName}</td>
                    <td id="firstName">${studentInfo.firstName}</td>
                    <td id="studentGroup">${studentInfo.studentGroup}</td>
                    <td id="dateEntering">${studentInfo.dateEntering}</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="info_subjects_content">
            <div class="row">
                <div class="col-lg-5">
                    <table class="table table-bordered subject_table" cellspacing="0" width="100%">
                        <thead>
                        <tr bgcolor="#f0f8ff">
                            <th>Subject</th>
                            <th>Mark</th>
                        </tr>
                        </thead>
                        <tbody id="tbodySubjects">
                        <c:forEach items="${subjects}" var="subject">
                            <tr>
                                <td>${subject.semester.subjectByIdSubject.name}</td>
                                <td align="center">${subject.studentMark}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-7">
                    <div class="select_semestr">
                        <div class="col-lg-4">
                            <label><h4>Choose semester</h4></label>
                        </div>

                        <div class="col-lg-5">
                            <select name="semester" id="semester" class="form-control">
                                <c:forEach var="semester" items="${semesters}">
                                    <option value="${semester}">Semester ${semester}</option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="col-lg-3">
                            <button id="semesterButton" type="button" class=" btn btn-info">
                                Select semester
                            </button>
                        </div>

                        <div class="row">
                            <div class="average col-lg-12">
                                <h3 id="average">Average per semester: ${average}</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#semesterButton').on("click",event,  function () {
        $.ajax({
            type: "GET",
            url: "/getTeaching",
            cache: false,
            data: {idStudent: ${studentInfo.idStudent}, semester: $("#semester").val()},
            success: function (response) {
                var obj = JSON.parse(response);
                var sum = 0.0;
                $("#tbodySubjects").html("");
                $.each(obj, function( index, value ) {
                    console.log(value.semester.subjectByIdSubject.name + ": " + value.studentMark);
                    sum += value.studentMark;
                    $("#tbodySubjects").append("<tr><td>" + value.semester.subjectByIdSubject.name + "</td><td>" + value.studentMark + "</td></tr>");
                });
                var avg = sum / obj.length;
                $("#average").html("Average per semester: " + avg + ".0");
                console.log(obj);
            },
            error: function (jqXhr, textStatus, errorThrown) {
                alert(textStatus);
            }
        })
    });
</script>
</body>
</html>
