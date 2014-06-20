<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/18/2014
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Semesters</title>
</head>
<body>
<%@include file="layout.jsp" %>
<div class="info_semester">
    <div class="select_semestr">
        <div class="col-lg-4">
            <label><h3>Choose semester</h3></label>
        </div>

        <div class="col-lg-5" style="margin-top: 10px">
            <select name="semester" id="semester" class="form-control">
                <c:forEach var="semester" items="${semesterList}">
                    <option value="${semester}">Semester ${semester}</option>
                </c:forEach>
            </select>
        </div>


        <div class="col-lg-3" style="margin-top: 10px">
            <button id="semesterButton" type="button" class=" btn btn-info">
                Select semester
            </button>
        </div>
    </div>
</div>
<div class="duration">
    <h3 id="duration">Duration of the semester: ${duration} weeks</h3>
</div>
<div class="container row">
    <div class="col-lg-9">
        <div class="students_table">
            <h3>Semester list of subjects</h3>
            <table id="subjects" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr bgcolor="#f0f8ff">
                    <th style="padding: 50px 20px !important">Subject</th>
                </tr>
                </thead>
                <tbody id="tbodySubjects">
                <c:forEach items="${subjects}" var="subject">
                    <tr>
                        <td id="nameSubject"
                            style="padding: 50px 20px !important">${subject.subjectByIdSubject.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="subject_buttons">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/semesterSavePage">
                    <button type="button" class="btn btn-success col-lg-12">
                        Create semester
                    </button>
                </a>
                <a href="" id="editHref">
                    <button type="button" class="btn btn-warning col-lg-12">
                        Modify the selected semester
                    </button>
                </a>
                <a href="" id="deleteHref">
                    <button id="deleteButton" type="submit" class="btn btn-danger col-lg-12">
                        Delete selected semester
                    </button>
                </a>
            </sec:authorize>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('a#editHref').attr('href', '/editSemester/1');
        $('a#deleteHref').attr('href', '/deleteSemester/1');
        $('#semester').change(function () {
            $('a#editHref').attr('href', '/editSemester/' + this.value);
            $('a#deleteHref').attr('href', '/deleteSemester/' + this.value);
        });
    });
    $('#semesterButton').on("click", event, function () {
        $.ajax({
            type: "GET",
            url: "/getSubjects",
            cache: false,
            data: {semester: $("#semester").val()},
            success: function (response) {
                var obj = JSON.parse(response);
                $("#tbodySubjects").html("");
                $.each(obj, function (index, value) {
                    console.log(value.subjectByIdSubject.name);
                    $("#tbodySubjects").append("<tr><td>" + value.subjectByIdSubject.name + "</td></tr>");
                    $("#duration").html("Duration of the semester: " + value.duration + " weeks");
                });
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
