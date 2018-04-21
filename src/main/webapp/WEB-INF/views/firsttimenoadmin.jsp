<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>No Admin</title>
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

									<form:form method="POST" modelAttribute="user"
										class="form-horizontal">

										<div class="paper-title">
											<span class="paper-text-title">Registration</span>
										</div>
										<div class="redline"></div>
										<div class="paper-row">
											<span class="text"><form:input type="hidden" path="id"
													id="id" /> </span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="firstName">First Name</label>
												<div class="col-sm-5">
													<form:input type="text" path="firstName" id="firstName"
														class="form-control input-sm"
														placeholder="Enter First Name" />
													<div class="has-error">
														<form:errors path="firstName" class="help-inline" />
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="lastName">Last Name</label>
												<div class="col-sm-5">
													<form:input type="text" path="lastName" id="lastName"
														class="form-control input-sm"
														placeholder="Enter Last Name" />
													<div class="has-error">
														<form:errors path="lastName" class="help-inline" />
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="username">USERNAME</label>
												<div class="col-sm-5">
													<c:choose>
														<c:when test="${edit}">
															<form:input type="text" path="username" id="username"
																class="form-control input-sm" disabled="true" />
														</c:when>
														<c:otherwise>
															<form:input type="text" path="username" id="username"
																class="form-control input-sm"
																placeholder="Enter USERNAME" />
															<div class="has-error">
																<form:errors path="username" class="help-inline" />
															</div>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="password">Password</label>
												<div class="col-sm-5">
													<form:input type="password" path="password" id="password"
														class="form-control input-sm" placeholder="Enter Password" />
													<div class="has-error">
														<form:errors path="password" class="help-inline" />
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="email">Email</label>
												<div class="col-sm-5">
													<form:input type="text" path="email" id="email"
														class="form-control input-sm" placeholder="Enter Email" />
													<div class="has-error">
														<form:errors path="email" class="help-inline" />
													</div>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<div class="form-group row">
												<label
													class="col-md-3 col-md-offset-2 col-sm-5 col-form-label"
													for="roleProfiles">Roles</label>
												<div class="col-sm-5">
													<form:select path="roleProfiles" items="${roles}"
														multiple="false" itemValue="id" itemLabel="type"
														class="form-control input-sm" />
													<div class="has-error">
														<form:errors path="roleProfiles" class="help-inline" />
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
													<c:choose>
														<c:when test="${edit}">
															<label for="Update"
																class="col-md-3 col-md-offset-2 col-sm-5 col-xs-12 col-form-label">Update:</label>
															<div class="col-sm-5 col-xs-10">
																<input type="submit"
																	class="btn btn-block btn-primary btn-default"
																	value="Update">
															</div>
														</c:when>
														<c:otherwise>
															<label for="Register"
																class="col-md-3 col-md-offset-2 col-sm-5 col-xs-12 col-form-label">Register:</label>
															<div class="col-sm-5 col-xs-10">
																<input type="submit"
																	class="btn btn-block btn-primary btn-default"
																	value="Register">
															</div>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
											<div class="blueline"></div>
											<div class="paper-row">
												<div class="form-group row">
													<c:choose>
														<c:when test="${edit}">
															<label for="Back"
																class="col-md-3 col-md-offset-2 col-sm-5 col-xs-12 col-form-label">Back:</label>
															<div class="col-sm-5 col-xs-10">
																<a href="<c:url value='/list' />"> <input
																	type="button"
																	class="btn btn-block btn-danger btn-default"
																	value="Back">
																</a>
															</div>
														</c:when>
														<c:otherwise>
															<label for="Cancel"
																class="col-md-3 col-md-offset-2 col-sm-5 col-xs-12 col-form-label">Cancel:</label>
															<div class="col-sm-5 col-xs-10">
																<a href="<c:url value='/auth/login' />"> <input
																	type="button"
																	class="btn btn-block btn-danger btn-default"
																	value="Cancel">
																</a>
															</div>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
										<div class="paper-row">
											<span class="text"></span>
										</div>
										<div class="blueline"></div>
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