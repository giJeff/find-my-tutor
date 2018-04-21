<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="authbar">



	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-toggle collapsed" data-target="#navbar"
					data-toggle="collapse"> <i
					class="fa fa-chevron-down faa-vertical animated"></i>
				</a> <a href="<c:url value="/" />" tabindex="0"
					class="navbar-brand faa-pulse animated"> <i
					class="fa fa-search"></i> <i class="fa fa-lg">F</i> <i
					class="fa fa-lg">i</i> <i class="fa fa-lg">n</i> <i
					class="fa fa-lg">d</i> <i class="fa fa-lg"> </i> <i
					class="fa fa-lg">M</i> <i class="fa fa-lg">y</i> <i
					class="fa fa-lg"> </i> <i class="fa fa-lg">T</i> <i
					class="fa fa-lg">u</i> <i class="fa fa-lg">t</i> <i
					class="fa fa-lg">o</i> <i class="fa fa-lg">r</i>

				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/" />"
						class="faa-parent animated-hover"> <i
							class="fa fa-fw fa-lg fa-home faa-tada"></i>Home
					</a></li>
					<li><a href="<c:url value="/tutorlist" />"
						class="faa-parent animated-hover"> <i
							class="fa fa-fw fa-lg fa-list-ol faa-tada"></i>Tutor List
					</a></li>

					<li><a href="<c:url value="/tutor/newtutor"/>"
						class="faa-parent animated-hover"> <i
							class="fa fa-fw fa-lg fa-graduation-cap faa-tada"></i>Become A
							Tutor
					</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="<c:url value="/tutor/listapplications" />"
							class="faa-parent animated-hover"> <i
								class="fa fa-fw fa-lg fa-check-circle faa-tada"></i>Tutor
								Applications
						</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
						<li><a href="<c:url value="/list" />"
							class="faa-parent animated-hover"> <i
								class="fa fa-fw fa-lg fa-user-secret faa-tada"></i>List All
								Users
						</a></li>
					</sec:authorize>
					<li><a href="<c:url value="/auth/logout" />"
						class="faa-parent animated-hover"> <i
							class="fa fa-fw fa-lg fa-sign-in faa-tada"></i>Logout
					</a></li>
				</ul>
			</div>
		</div>
	</nav>



</div>
