<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutors List</title>
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

									<div class="paper-title">
										<span class="paper-text-title">List of Tutors</span>
									</div>
									<div class="redline"></div>

										<ul id=paper-table>
											<li id="listitem" class="clearfix header">
												<div class="paper-row">
													<div class="listitem-firstname">Firstname</div>
													<div class="listitem-lastname">Lastname</div>
													<div class="listitem-email">Email</div>
													<div class="listitem-username">USERNAME</div>

												</div>
											</li>
											<div class="blueline"></div>

											<c:forEach items="${users}" var="user">
												<li id="${user.username}" class="clearfix">
													<div class="paper-row">
														<div class="listitem-firstname">${user.firstName}</div>
														<div class="listitem-lastname">${user.lastName}</div>
														<div class="listitem-email">${user.email}</div>
														<div class="listitem-username">${user.username}</div>
													</div>
												</li>
												<div class="blueline"></div>
												<li id="${user.username}" class="clearfix">
													<div class="paper-row">
														<sec:authorize
															access="hasRole('ADMIN') or hasRole('TUTOR') or hasRole('STUDENT')">
															<div class="listitem-sendmail">
																<a href="mailto:${user.email}"
																	class="btn btn-primary custom-width" target="_blank">Email</a>
															</div>
														</sec:authorize>
														<sec:authorize access="hasRole('ADMIN')">
															<div class="listitem-edit">
																<a
																	href="<c:url value='/auth/edit-tutor-${user.username}' />"
																	class="btn btn-success custom-width">edit</a>
															</div>
														</sec:authorize>
														<sec:authorize access="hasRole('ADMIN')">
															<div class="listitem-delete">
																<a
																	href="<c:url value='/auth/delete-tutor-${user.username}' />"
																	class="btn btn-danger custom-width">delete</a>
															</div>
														</sec:authorize>
													</div>
												</li>
												<div class="blueline"></div>
												<div class="paper-row">
													<span class="text"></span>
												</div>
												<div class="blueline"></div>
											</c:forEach>


										</ul>
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