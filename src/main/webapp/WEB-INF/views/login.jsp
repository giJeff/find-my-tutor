<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
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

									<form name="loginform" action="<c:url value='/auth/login' />"
										method="post" class="form-horizontal">
										<c:if test="${param.error != null}">
											<div class="alert alert-danger">
												<p>Invalid username and password.</p>
											</div>
										</c:if>
										<c:if test="${param.logout != null}">
											<div class="alert alert-success">
												<p>You have been logged out successfully.</p>
											</div>
										</c:if>
										<div class="login-card-title">
											<span class="text-title">Login Form</span>
										</div>
										<div class="redline"></div>
										<div class="login-card-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>


										<div class="login-card-row">
											<div class="form-group row">
												<label for="username" class="col-sm-4 col-form-label">Username:</label>
												<div class="col-sm-5">
													<input type="text" class="form-control" id="username"
														name="username" placeholder="Enter Username" required>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="login-card-row">
											<div class="form-group row">
												<label for="password" class="col-sm-4 col-form-label">Password:</label>
												<div class="col-sm-5">
													<input type="password" class="form-control" id="password"
														name="password" placeholder="Enter Password" required>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="login-card-row">
											<div class="form-group row">
												<label for="rememberme" class="col-sm-4 col-form-label">Remember
													Me:</label>
												<div class="col-sm-5">
													<input type="checkbox" id="rememberme" name="remember-me">
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="login-card-row">
											<span class="text"><input type="hidden"
												name="${_csrf.parameterName}" value="${_csrf.token}" /></span>
										</div>

										<div class="form-actions">
											<div class="blueline"></div>
											<div class="login-card-row">
												<div class="form-group row">
													<label for="submit" class="col-sm-4 col-form-label">Login:</label>
													<div class="col-sm-5">
														<input type="submit"
															class="btn btn-block btn-primary btn-default"
															value="Log in">
													</div>
												</div>
											</div>
											<div class="blueline"></div>
											<div class="login-card-row">
												<div class="form-group row">
													<label for="Register" class="col-sm-4 col-form-label">Register:</label>
													<div class="col-sm-5">
														<a href="<c:url value = "/auth/newuser"/>"><input
															type="button"
															class="btn btn-block btn-danger btn-default"
															value="Register"></a>
													</div>
												</div>
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
									</form>

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
