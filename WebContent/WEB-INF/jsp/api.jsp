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
			<h1>REST API</h1>
			<div style="text-align: left">
				<h2>JSON</h2>
				<ul>
					<li>Get all weather objects:</li>
					<li style="list-style-type: none">
						<ul>
							<li> <a href="http://localhost:8080/SpringMVCturotial/api/json/weatherAll">http://localhost:8080/SpringMVCturotial/api/json/weatherAll</a></li>
						</ul>					
					</li>
					<li>Get weather object with id:</li>
					<li style="list-style-type: none">
						<ul>
							<li> <a href="http://localhost:8080/SpringMVCturotial/api/json/weather/1">http://localhost:8080/SpringMVCturotial/api/json/weather/id</a></li>
						</ul>					
					</li>
				</ul>				
			</div>
			<br>
			<div style="text-align: left">
				<h2>XML</h2>
				<ul>
					<li>Get all weather objects:</li>
					<li style="list-style-type: none">
						<ul>
							<li> <a href="http://localhost:8080/SpringMVCturotial/api/xml/weatherAll">http://localhost:8080/SpringMVCturotial/api/xml/weatherAll</a></li>
						</ul>					
					</li>
					<li>Get weather object with id:</li>
					<li style="list-style-type: none">
						<ul>
							<li> <a href="http://localhost:8080/SpringMVCturotial/api/xml/weather/1">http://localhost:8080/SpringMVCturotial/api/xml/weather/id</a></li>
						</ul>					
					</li>
				</ul>
			</div>
			
    </jsp:body>
</t:template>