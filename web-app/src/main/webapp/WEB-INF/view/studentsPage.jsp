<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/12/2014
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Students</title>
</head>
<body>
<%@include file="layout.jsp" %>
<div class="button_content_students">
    <div class="container row">
        <div class="col-lg-6">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="" id="infoHref">
                    <button type="button" class="btn btn-info col-lg-12">
                        View performance of selected student
                    </button>
                </a>
                <a href="" id="editHref">
                    <button type="button" class="btn btn-warning col-lg-12">
                        Modify the selected student
                    </button>
                </a>
            </sec:authorize>

        </div>
        <div class="col-lg-6">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/studentSavePage">
                    <button type="button" class="btn btn-success col-lg-12">
                        Create student
                    </button>
                </a>
            </sec:authorize>
            <form:form action="/deleteStudents" method="post" commandName="commandDeleteStudents">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <button id="deleteButton" type="submit" class="btn btn-danger col-lg-12">
                    Delete selected students
                </button>
            </sec:authorize>
        </div>
    </div>
</div>
<div class="students_table">
    <h3>Students list</h3>
    <table id="students" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr bgcolor="#f0f8ff">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th></th>
            </sec:authorize>
            <th>Surname</th>
            <th>Name</th>
            <th>Group</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td align="center">
                        <input id="studentCheck" type="checkbox" value="${student.idStudent}"/>
                    </td>
                </sec:authorize>
                <td id="lastName">${student.lastName}</td>
                <td id="firstName">${student.firstName}</td>
                <td id="studentGroup">${student.studentGroup}</td>
                <td id="dateEntering">${student.dateEntering}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </form:form>
</div>
</body>
<script>
    var studentList = [];
    $('input[type=checkbox]').change(function () {
        var parent = $(this).parent().parent();
        var student = {};
        student.idStudent = $(this).val();
        student.lastName = parent.children("#lastName").text();
        student.firstName = parent.children("#firstName").text();
        student.studentGroup = parent.children("#studentGroup").text();
        student.dateEntering = parent.children("#dateEntering").text()

        if (this.checked == "1") {
            $('a#editHref').attr('href', '/editStudent/' + this.value);
            $('a#infoHref').attr('href', '/infoStudent/' + this.value);
            studentList.push(student);

            console.log(studentList);
        } else {
            for (var i = 0; i < studentList.length; i++) {
                if (studentList[i].idStudent === student.idStudent) {
                    studentList.splice(i, 1);
                }
            }
            $('a#editHref').attr('href', '');
            $('a#infoHref').attr('href', '');
        }
    });
    $('#deleteButton').on("click", event, function () {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/deleteStudents",
            contentType: "application/json",
            data: JSON.stringify(studentList),
            success: function (responce) {
                document.location.href = '/students';
            },
            error: function (jqXhr, textStatus) {
                alert(textStatus);
            }
        });
    });
</script>
</html>
