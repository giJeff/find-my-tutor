<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="head.jsp"%>

<title>Tutor Profile</title>
<script>
var date;

function takeData()
{
   date = document.getElementById("appointTime").value;
   console.log(date);
}


</script>

</head>
<body>
<h1>Profile</h1>
<div class="profileLeft">
	<h1>Teacher Name</h1>
	<div class="profileImage"></div>
	<div class="ratingContainer">
		<div class="onePen"></div>
        <div class="twoPen"></div>
        <div class="threePen"></div>
        <div class="fourPen"></div>
        <div class="fivePen"></div>
    </div>
    <table>
      <tbody>
        <tr>
          <td href="" class="tutorProfile">LinkedIn Profile</td>
        </tr>

        <tr>
          <td>
            <details>
              <summary class="tutorProfile" id="availability">Availability</summary>
              <table class="tutorAvail">
              	<thead>
                	<tr>
                    	<th>Time</th>
                    	<th>Sun</th>
                        <th>Mon</th>
                        <th>Tues</th>
                        <th>Wed</th>
                        <th>Thur</th>
                        <th>Fri</th>
                        <th>Sat</th>
                    </tr>
                </thead>
                
                <tbody>
                	<tr>
                    	<td>AM</td>
                        <!--Populate the rest of this row with times or unavailable -->
                    </tr>
                    
                    <tr>
                    	<td>PM</td>
                        <!--Populate the rest of this row with times or unavailable -->
                    </tr>
                </tbody>
              </table>
            </details>
          </td>
        </tr>

        <tr>
          <td>
            <details>
              <summary class="tutorProfile" id="schedule">
                Schedule An Appointment
              </summary>
              <form>
                <input type="datetime-local" name="appointTime" id="appointTime">

                <!--<input type="submit" onclick="confirm('Are you sure?'); takeData();">-->
              </form>
              <button onclick="takeData();">Submit</button>
            </details>
          </td>
      	</tr>
      </tbody>
    </table>
</div>
            
<div class="profileRight"> <!--This div is for the right side of the profile page-->
	<div id="subjectContainer">
    <!--Those notecards would look cute for this -->
    	<p class="tutorProfile">Subjects</p>
        <ol>
        	<li><!--To be populated from the database --></li>
        </ol>
    </div>
    
    <div id="bioContainer">
    	<p class="tutorProfile">Bio</p>
        <!--To be populated from the database -->
        
    </div>
    
    <div id="reviewContainer">
    	<p class="tutorProfile">Reviews</p>
    	<table id="reviews">
        	<thead>
            	<tr>
                  <th>User</th>
                  <th>Review</th>
                  <th>Rating</th>
                </tr>
            </thead>
            
            <tbody>
            	<!--To be populated from the database -->
            </tbody>
        </table>
        
    	<a href="">Submit a Review!</a>
    </div>
</div>

</body>


</html>
