<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutor Application</title>
<%@include file="head.jsp"%>
</head>

<body>
	<%@include file="authheader.jsp"%>
	<div class="home-container">
		<div class="col-md-10 col-md-offset-1 col-sm-12">
			<div class="section">

				<div class="container-fluid page">

					<div class="row">

						<div class="col-lg-10 col-lg-offset-1 col-md-12 col-sm-12">
							<div class="paper-container">
								<div class="paper">

									<form:form method="POST" modelAttribute="tutorApplication"
										class="form-horizontal">

										<div class="paper-title">
											<span class="paper-text-title">Tutor Application</span>
										</div>
										<div class="redline"></div>
										<div class="paper-row">
											<span class="text"><form:input type="hidden" path="id"
													id="id" /> <form:input type="hidden" path="username"
													id="username" value="${loggedinuser}" /></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-4 col-sm-5 col-form-label"
													for="question1">Do you want to be a tutor?</label>
												<div class="col-sm-5">
													<form:input type="text" path="question1" id="question1"
														class="form-control input-sm" placeholder="Answer here" />
													<div class="has-error">
														<form:errors path="question1" class="help-inline" />
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="form-actions">
											<div class="blueline"></div>
											<div class="paper-row">
												<div class="form-group row">
													<label for="Apply"
														class="col-md-4 col-sm-5 col-xs-12 col-form-label">Apply
														now:</label>
													<div class="col-sm-5 col-xs-10">
														<input type="submit"
															class="btn btn-block btn-primary btn-default"
															value="Apply">
													</div>
												</div>
											</div>
											<div class="blueline"></div>
											<div class="paper-row">
												<div class="form-group row">
													<label for="Cancel"
														class="col-md-4 col-sm-5 col-xs-12 col-form-label">Cancel:</label>
													<div class="col-sm-5 col-xs-10">
														<a href="<c:url value = "/auth/login"/>"><input
															type="button"
															class="btn btn-block btn-danger btn-default"
															value="Cancel"></a>
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>

									</form:form>
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