<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

</head>
<body>





   
   <table border=1px; >
      <tr>
         <th>Profile</th>
         <th>Id</th>
         <th>Name</th>
         <th>Email</th>
         <th>Action</th>
      </tr>

  <c:forEach items="${kk}" var="e">
      <tr>
       <td><img src="images/${e.profilename}" width=100px; height=100px;></img></td>
         <td>${e.id}</td>
         <td>${e.name}</td>
         <td>${e.email}</td>
         <td>
         <a href="edit${e.id}">Edit</a>
         
          <a href="del/${e.id}">Delete</a>
         
         </td>
      </tr>
      </c:forEach>
      

     
   </table>
  







</body>
</html>