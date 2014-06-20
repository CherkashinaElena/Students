<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/18/2014
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Subjects</title>
</head>
<body>
<%@include file="layout.jsp" %>
<div class="container row">
    <div class="col-lg-9">
        <div class="students_table">
            <h3>Subjects list</h3>
            <form:form action="/deleteSubjects" method="post" commandName="commandDeleteSubjects">
            <table id="subjects" class="table table-bordered" cellspacing="0" width="100%">
                <thead>
                <tr bgcolor="#f0f8ff">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <th style="padding: 50px 20px !important"></th>
                    </sec:authorize>
                    <th style="padding: 50px 20px !important">Subject</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjectList}" var="subject">
                    <tr>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td align="center" style="padding: 50px 20px !important">
                                <input id="subjectCheck" type="checkbox" value="${subject.idSubject}"/>
                            </td>
                        </sec:authorize>
                        <td id="nameSubject" style="padding: 50px 20px !important">${subject.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-lg-3">
        <div class="subject_buttons">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a href="/subjectSavePage">
                    <button type="button" class="btn btn-success col-lg-12">
                        Create subject
                    </button>
                </a>
                <a href="" id="editHref">
                    <button type="button" class="btn btn-warning col-lg-12">
                        Modify the selected subject
                    </button>
                </a>
                <button id="deleteButton" type="submit" class="btn btn-danger col-lg-12">
                    Delete selected subjects
                </button>
            </sec:authorize>
            </form:form>
        </div>
    </div>
</div>
<script>
    var subjectList = [];
    $('input[type=checkbox]').change(function () {
        var parent = $(this).parent().parent();
        var subject = {};
        subject.idSubject = $(this).val();
        subject.name = parent.children("#nameSubject").text();

        if (this.checked == "1") {
            $('a#editHref').attr('href', '/editSubject/' + this.value);
            subjectList.push(subject);

            console.log(subjectList);
        } else {
            for (var i = 0; i < subjectList.length; i++) {
                if (subjectList[i].idSubject === subject.idSubject) {
                    subjectList.splice(i, 1);
                }
            }
            $('a#editHref').attr('href', '');
        }
    });
    $('#deleteButton').on("click", event, function () {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "/deleteSubjects",
            contentType: "application/json",
            data: JSON.stringify(subjectList),
            success: function (responce) {
                document.location.href = '/subjects';
            },
            error: function (jqXhr, textStatus) {
                alert(textStatus);
            }
        });
    });
</script>
</body>
</html>
