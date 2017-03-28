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
			<h3 style="text-align: center;">POST method - @ModelAttribute("city")</h3>
			<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
				<form:form class="form-inline" action="weather" modelAttribute="city" method="post">
					<label for="inputCity">City: </label>
					<input id="inputCity" type="text" class="form-control" name="name" placeholder="Praha" value="${cityName}">
					<button type="submit" value="Submit" class="btn btn-default">Send data!</button>
				</form:form>
			</div>
			<br>
			<h3 style="text-align: center;">POST method - @RequestParam("name")</h3>
			<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
				<form:form class="form-inline" action="weatherActionPostPara" modelAttribute="city" method="post" value="${cityName}">
					<label for="inputCity">City: </label>
					<input id="inputCity" type="text" class="form-control" name="name" placeholder="Praha">
					<button type="submit" value="Submit" class="btn btn-default">Send data!</button>
				</form:form>
			</div>
		
			<br>
			<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
				<p>${error}</p>
			</div>
			<br>
		
			<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
				<table class="table">
					<thead>
						<tr>
							<td>Parametr:</td>
							<td>Hodnota:</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>City:</td>
							<td>${cityName}</td>
						</tr>
						<tr>
							<td>weather.main</td>
							<td>${object.main}</td>
						</tr>
						<tr>
							<td>weather.description</td>
							<td>${object.description}</td>
						</tr>
						<tr>
							<td>main.temp</td>
							<td>${object.temp}</td>
						</tr>
						<tr>
							<td>main.pressure</td>
							<td>${object.pressure}</td>
						</tr>
						<tr>
							<td>main.humidity</td>
							<td>${object.humidity}</td>
						</tr>
		
					</tbody>
				</table>
				<p></p>
				<p></p>
				<p></p>
				<p></p>
				<p></p>
				<hr>
				<p>
					<a href="weatherTest.html"> Static test data </a>
				</p>				
			</div>
    </jsp:body>
</t:template>