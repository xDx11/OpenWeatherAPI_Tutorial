<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header">      				
		<title>Weather App</title>
    </jsp:attribute>

	<jsp:attribute name="footer">
      
    </jsp:attribute>

	<jsp:body>
					<br>
			<div style="text-align:center">
				<h2>
					<a href="<c:url value="/database/add"/>"> Add form! </a>
				</h2>
			</div>
			<hr>
			<br>
			<br>
			<br>
			
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>City</th>
						<th>Main</th>
						<th>Description</th>
						<th>Temp</th>
						<th>Pressure</th>
						<th>Humidity</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="object" items="${weatherObjects}">  											
						<tr>
							<td>${object.id}</td>
							<td>${object.city}</td>
							<td>${object.main}</td>
							<td>${object.description}</td>
							<td>${object.temp}</td>
							<td>${object.pressure}</td>
							<td>${object.humidity}</td>
							<td><button type="button" onclick="location.href='update/${object.id}'" class="btn btn-warning">Edit</button></td>
							<td><button type="button" onclick="location.href='delete/${object.id}'" class="btn btn-danger">Delete</button></td>							
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
			
			
    </jsp:body>
</t:template>