<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Visitor Registration Form</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Visitor Registration Form</h1>
 	
	
	 <form:form action="save" modelAttribute="visitor">

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>


<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email">email</label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="mobileNo">mobileNo</label>
				<div class="col-md-7">
					<form:input type="text" path="mobileNo" id="mobileNo" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="address">address</label>
				<div class="col-md-7">
					<form:input type="text" path="address" id="address" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="idProof">idProof</label>
				<div class="col-md-7">
					<form:input type="text" path="idProof" id="idProof" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonName">contactPersonName</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonName" id="contactPersonName" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonEmail">contactPersonEmail</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonEmail" id="contactPersonEmail" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="reasonForVisit">reasonForVisit</label>
				<div class="col-md-7">
					<form:input type="text" path="reasonForVisit" id="reasonForVisit" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="contactPersonMobileNo">contactPersonMobileNo</label>
				<div class="col-md-7">
					<form:input type="text" path="contactPersonMobileNo" id="contactPersonMobileNo" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>



<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
			
	</form:form>
	</div>
</body>
</html>