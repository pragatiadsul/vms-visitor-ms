<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">Visitors List</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>

<a  align ="right" href="/delete"><h2>Delete All Students</h2></a>
</th>
</tr>
</table>
<table >
<tr>


  <th>Page No : 
<c:forEach var="count" items="${pageCount}"  varStatus="theCount"> 
<a align="right" href="/viewstudents/${theCount.count}">${theCount.count}</a>   
</c:forEach>  
</th>

</tr>

</table>
   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>name</th><th>email</th>
<th>mobileNo</th><th>address</th>
<th>idProof</th><th>contactPersonName</th><th>contactPersonEmail</th>
<th>reasonForVisit</th><th>contactPersonMobileNo</th>
<th>Edit</th><th>Delete</th></tr>  

   <c:forEach var="visitor" items="${list}"> 
   <tr>  
   <td>${visitor.id}</td>  
   <td>${visitor.name}</td> 
   <td>${visitor.email}</td>  
   <td>${visitor.mobileNo}</td> 
   <td>${visitor.address}</td>  
   <td>${visitor.idProof}</td> 
   <td>${visitor.contactPersonName}</td>  
   <td>${visitor.contactPersonEmail}</td>  
   <td>${visitor.reasonForVisit}</td>  
   <td>${visitor.contactPersonMobileNo}</td>  
   <td><a href="/editstudent/${visitor.id}">Edit</a></td>  
   <td><a href="/deletestudent/${visitor.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>