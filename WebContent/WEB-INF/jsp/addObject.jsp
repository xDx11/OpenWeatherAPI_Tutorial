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
			<div style="text-align:left">			
				<form:form class="form-inline" action="add" modelAttribute="weatherObject" method="post">
					<table style="border-collapse:separate; border-spacing:1em; width:100%">
						<tr>
							<td> <form:label path="id">ID: </form:label> </td>
							<td> <form:input path="id" class="form-control" /> </td>
						</tr>
						<tr>
							<td><form:label path="city">City: </form:label></td>
							<td><form:input path="city" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="main">Main: </form:label></td>
							<td><form:input path="main" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="description">Description: </form:label></td>
							<td><form:input path="description" class="form-control" /> </td>
						</tr>
						<tr>
							<td><form:label path="temp">Temp: </form:label></td>
							<td><form:input path="temp" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="pressure">Pressure: </form:label></td>
							<td><form:input path="pressure" class="form-control" /></td>
						</tr>
						<tr>
							<td><form:label path="humidity">ID: </form:label></td>
							<td><form:input path="humidity" class="form-control" />	</td>						
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" value="Submit" class="btn btn-default">Send data!</button></td>
						</tr>
					</table>
				</form:form>
				
			</div>
			
			
    </jsp:body>
</t:template>