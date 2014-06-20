<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 6/13/2014
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save student</title>
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
            <h3>To create a student fill out all fields and click <q>Save student</q></h3>
        </div>
    </div>

    <div class="studentFormStyle">
        <div class="container row">
            <div class="col-sm-offset-3 col-sm-7">
                <form:form method="post" id="studentForm" action="/saveStudent" commandName="commandSaveStudent" cssClass="form-horizontal">

                <div class="row">
                    <div class="form-group">
                        <label class="col-md-3 control-label" for="lastName">Last name</label>

                        <div class="col-md-7">
                            <form:input path="lastName" name="lastName" id="lastName" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="firstName">First name</label>

                        <div class="col-md-7">
                            <form:input path="firstName" name="firstName" id="firstName" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="group">Group</label>

                        <div class="col-md-7">
                            <form:input path="studentGroup" name="group" id="group" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-3 control-label" for="date">Date</label>

                        <div class="col-md-7">
                            <form:input path="dateEntering" name="date" data-field="date" id="date" cssClass="form-control" required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button class="btn btn-danger" type="reset">Clear</button>
                            <button class="btn btn-success" type="submit">Save student</button>
                        </div>
                    </div>

                </div>
                <div id="dtBox"></div>
            </form:form>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#dtBox").DateTimePicker();

    });
</script>
</body>
</html>
