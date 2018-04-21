<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<%@include file="head.jsp"%>

</head>

<body>

	<%@include file="authheader.jsp"%>
	<div class="home-container">
		<div class="col-md-10 col-md-offset-1 col-sm-12">
			<div class="section">
				<%@include file="title.jsp"%>

				<div class="container-fluid page">

					<div class="row">

						<a href="<c:url value="tutorlist" />">
							<div class="col-lg-6 col-md-12 col-sm-12">
								<div class="card-container">
									<div class="card">
										<div class="card-title">
											<span class="text-title">Find A Tutor</span>
										</div>
										<div class="redline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>Browse: </strong>All
												Tutors
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>Communication: </strong>Email
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
									</div>
								</div>
							</div>
						</a> <a href="<c:url value="tutor/newtutor" />">
							<div class="col-lg-6 col-md-12 col-sm-12">
								<div class="card-container">
									<div class="card">
										<div class="card-title">
											<span class="text-title">Become A Tutor</span>
										</div>
										<div class="redline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>First: </strong>You must
												be registered
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>Then: </strong>An admin
												will approve the application
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
									</div>
								</div>
							</div>
						</a> <a href="<c:url value="auth/login" />">
							<div class="col-lg-6 col-md-12 col-sm-12">
								<div class="card-container-half">
									<div class="card-half">
										<div class="card-title">
											<span class="text-title">Login</span>
										</div>
										<div class="redline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>Login: </strong>With your
												user name/password
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
									</div>
								</div>
							</div>
						</a> <a href="<c:url value="auth/newuser" />">
							<div class="col-lg-6 col-md-12 col-sm-12">
								<div class="card-container-half">
									<div class="card-half">
										<div class="card-title">
											<span class="text-title">Register</span>
										</div>
										<div class="redline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"> <strong>Create: </strong>A new
												student login
											</span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="card-row">
											<span class="text"></span>
										</div>
									</div>
								</div>
							</div>
						</a>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>