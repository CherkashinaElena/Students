<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/18/2014
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save subject</title>
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
            <h3>To create a subject fill out all fields and click <q>Save subject</q></h3>
        </div>
    </div>

    <div class="studentFormStyle">
        <div class="container row">
            <div class="col-sm-offset-3 col-sm-7">
                <form:form method="post" id="subjectForm" action="/saveSubject" commandName="commandSaveSubject" cssClass="form-horizontal">

                    <div class="row">
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="name">Subject</label>

                            <div class="col-md-7">
                                <form:input path="name" name="name" id="name" cssClass="form-control" required="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button class="btn btn-danger" type="reset">Clear</button>
                                <button class="btn btn-success" type="submit">Save subject</button>
                            </div>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
