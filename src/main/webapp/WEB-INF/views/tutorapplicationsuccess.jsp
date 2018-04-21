<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Confirmation Page</title>
<%@include file="head.jsp"%>
</head>
<body>
	<%@include file="authheader.jsp"%>
	<div class="home-container">
		<div class="col-md-10 col-md-offset-1 col-sm-12">
			<div class="section">

				<div class="container-fluid page">

					<div class="row">

						<div class="col-lg-8 col-lg-offset-2 col-md-12 col-sm-12">
							<div class="login-card-container">
								<div class="login-card">


									<div class="login-card-title">
										<div class="alert alert-success lead">${success}</div>
									</div>
									<div class="redline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>
									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>

									<div class="blueline"></div>
									<div class="login-card-row">
										<label for="Home" class="col-sm-4 col-form-label">Home:</label>
										<div class="col-sm-5">
											<a href="<c:url value='/' />"> <input
												type="button" class="btn btn-block btn-primary btn-default"
												value="Home">
											</a>
										</div>
									</div>

									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>
									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>
									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>
									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>
									<div class="blueline"></div>
									<div class="login-card-row">
										<span class="text"></span>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>