<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>		
			<meta charset="utf-8">
	    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    	<meta name="viewport" content="width=device-width, initial-scale=1">
	    	<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
	    	<link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
	    	<link href="<c:url value="/resources/css/cover.css"/>" rel="stylesheet">  	    	
			<jsp:invoke fragment="header" />
	</head>
<body>	

	
	<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Test OpenWeather APP</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li ${prom1}><a href="<c:url value="/"/>">Home</a></li>
                  <li ${prom2}><a href="<c:url value="/weather"/>">Weather</a></li>
                  <li ${prom3}><a href="<c:url value="/database/list"/>">Database</a></li>
                  <li ${prom4}><a href="<c:url value="/api"/>">REST API</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
          	<div id="body">
				<jsp:doBody />
			</div>            
          </div>

          <div class="mastfoot">
            <div class="inner">
            	<div id="pagefooter">
					<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
			      		<p id="copyright">Copyright 2017, xdavex</p>
			      	</div>
					<jsp:invoke fragment="footer" />
				</div>              
            </div>
          </div>

        </div>

      </div>

    </div>
   
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="<c:url value="/resources/Skripts/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/Skripts/jquery-1.9.1.min.js"/>"></script>
    <script src="<c:url value="/resources/Skripts/jquery.validate.unobtrusive.min.js"/>"></script>
    <script src="<c:url value="/resources/Skripts/jquery.validate.min.js"/>"></script>   
</body>
</html>