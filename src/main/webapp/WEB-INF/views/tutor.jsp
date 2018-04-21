<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutors</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<!-- This bit of code is from here: https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_tabs_dynamic&stacked=h -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
h1
{
	text-align: center;
}

.tutorSearch
{
	padding:5px;
}
.searchResults 
{
	width: 90%;
    padding:5px;
}

.profileLeft
{
	width:30%;
    margin: left;
}

.profileImage
{
	width: 200px;
    height:200px;
    margin:auto;
    
    border-radius: 50%;
    border: solid black 1px;
    background-image: url("tutorHead.png");
    background-size: 100% 100%;
    
}

.ratingContainer
{
	width: 75%;
    height: 50px;
    margin:auto;
    border: solid black 1px;
    
    display:flex;
}

.onePen, .twoPen, .threePen, .fourPen, .fivePen
{
	flex-grow:5;
    
    background-image: url('tutorHead.png');
    background-size: 100% 100%;
}
</style>

</head>

<body>
	<ul class="nav nav-tabs">
    	<li class="active"><a data-toggle="tab" href="#dash">Dashboard</a></li>
    	<li><a data-toggle="tab" href="#tutor">Tutor Search</a></li>
    	<li><a data-toggle="tab" href="#profile">Profile</a></li>
  	</ul>
  	
  	
  	<div class="tab-content">
  	
  		<!-- This is the Dashboard Tab -->
  		<div id="dash" class="tab-pan fade in active">
  			<h1>Dashboard</h1>
  			<table>
  				<thead>
  					<tr>
	  					<th>Read</th>
	  					<th colspan=2>Sender</th>
  					</tr>
  				</thead>
  			
  				<tbody>
  					<!-- I am putting these buttons at the top -->
  					<tr>
  						<td><button type=button>New Message</button>
  						<td><button type=button>Upcoming Meetings</button>
  					</tr>
  					
  					<!-- To be populated later when database is created-->
  					
  				</tbody>
  			</table>
  		
  		</div>
  		
  		<!-- This is the Tutor tab -->
  		<div id="tutor" class="tab-pane fade">
  			<h1>Tutor Search</h1>
			<table class="tutorSearch">
				<tbody>
					<tr>
						<td>Tutor Search</td>
						<td>First Name: <input type="text" name="firstName"></td>
						<td>Last Name: <input type="text" name="lastName"></td>
						<td>Subject 
							<select name="subject" size=2 multiple>
							<!-- To be populated by the database when created -->
								<option>Information Technology</option>
								<option>Math</option>
								<option>Biology</option>
								<option>Chemistry</option>
								<option>U.S History</option>
								<option>World History</option>
								<option>Mythology/Religion</option>
							</select>
						</td>
                        <td>Rating: 
                        	<select name="rateSearch" size=1 multiple>
                            	<option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </td>
                        <td>Availibility: 
                        	<select name="" size=1 multiple>
                            	<option>AM</option>
                                <option>PM</option>
                            </select>
                        </td>
						<!-- This will be the button to finalize the search -->
						<td><button type="button">Search for Tutor</button> </td>
					</tr>
				</tbody>
			</table>
		
			<div class="generic-container">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="lead">List of Tutors</span>
					</div>
					
					<table class="searchResults">
						<thead>
							<tr>
								<th>Image</th>
								<th>Name</th>
								<th>Subject(s)</th>
								<th>Short Bio</th>
							</tr>
						</thead>
						
						<tbody>
							<tr>
								<td>ImageHere</td>
								<td>Cat Windham</td>
								<td>Biology, Mythology</td>
								<td>Hi. I am Cat the creator of this particular table.</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
        <!--This is the Profile Tab-->
        <div id="profile" class="tab-pane fade">
        	<h1>Profile</h1>
            <div class="profileLeft">
            	<h1>Teacher Name</h1>
                <div class="profileImage"></div>
                <div class="ratingContainer">
                	<div class="onePen">
                    </div>
                    <div class="twoPen">
                    </div>
                    <div class="threePen">
                    </div>
                    <div class="fourPen">
                    </div>
                    <div class="fivePen">
                    </div>
                </div>
                <table>
                	<tbody>
                    	<tr>
                        	<td href="">LinkedIn Profile</td>
                        </tr>
                        <tr>
                        	<td href="">Availability</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            
            <div class="profileRight"> <!--This div is for the right side of the profile page-->
            	<div></div>
            </div>
        </div>
        
	</div>
</body>
</html>
